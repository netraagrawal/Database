package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

public class MainQuery extends Observable {

	TagAndValue1 tv;
	Connection con = null;
	static PreparedStatement ps = null;
	String prevQueryFromTag;
	ArrayList<String> selectedTagList;
	static ResultSet resultMovie = null;
	ConnectionToDb cd = new ConnectionToDb();
	DefaultListModel<String> movieList = new DefaultListModel<>();
	ArrayList<String> movieSelectedList = new ArrayList<>();

	public ArrayList<String> getMovieSelectedList() {
		return movieSelectedList;
	}

	public void setMovieSelectedList(ArrayList<String> movieSelectedList) {
		this.movieSelectedList = movieSelectedList;
	}

	public String getPrevQueryFromTag() {
		return prevQueryFromTag;
	}

	public void setPrevQueryFromTag(String prevQueryFromTag) {
		this.prevQueryFromTag = prevQueryFromTag;
	}

	public ArrayList<String> getSelectedTagList() {
		return selectedTagList;
	}

	public void setSelectedTagList(ArrayList<String> selectedTagList) {
		this.selectedTagList = selectedTagList;
	}

	public static ResultSet getResultMovie() {
		return resultMovie;
	}

	public static void setResultMovie(ResultSet resultMovie) {
		MainQuery.resultMovie = resultMovie;
	}

	public DefaultListModel<String> getMovieList() {
		return movieList;
	}

	public void setMovieList(DefaultListModel<String> movieList) {
		this.movieList = movieList;
	}

	public String getMainQueryStatement() {
		return mainQueryStatement;
	}

	public void setMainQueryStatement(String mainQueryStatement) {
		this.mainQueryStatement = mainQueryStatement;
	}

	public String getQuery1() {
		return query1;
	}

	public void setQuery1(String query1) {
		this.query1 = query1;
	}

	public String getQuery2() {
		return query2;
	}

	public void setQuery2(String query2) {
		this.query2 = query2;
	}

	public MainQuery(TagAndValue1 t) {
		tv = t;

		try {
			con = cd.openConnection();
			selectedTagList = tv.getSelectedTagList();
			prevQueryFromTag = tv.getQueryStatmentTagMid();
			resultMovie = executeQuery(con);
			createMovieList(resultMovie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cd.closeConnection(con);
		}
	}

	private void createMovieList(ResultSet resultMovie2) {

		movieList.addElement("ALL");
		try {
			while (resultMovie2.next()) {
				movieList.addElement(resultMovie2.getString("MID") + " " + resultMovie2.getString("TITLE") + " "
						+ resultMovie2.getString("MYEAR") + " " + resultMovie2.getString("GENRES") + " "
						+ resultMovie2.getString("COUNTRY") + " " + resultMovie2.getString("rtAudienceRating") + " "
						+ resultMovie2.getString("rtAudienceNumRatings"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String mainQueryStatement = "";
	String query1 = "";
	String query2 = "";
	String MovieQueryStatement = "";
	String andOrAttribute = GlobalVariables.betweenAttribute;

	private ResultSet executeQuery(Connection con2) {
		int k = 0;
		if (selectedTagList.get(0) == "ALL") {

		} else {

			mainQueryStatement += prevQueryFromTag;
			mainQueryStatement += "\n INTERSECT \n";
			mainQueryStatement += "SELECT MTT.MID \n FROM MOVIE_TAGS MTT \n WHERE MTT.TAGWEIGHT "
					+ GlobalVariables.tagLessThanGreater + " " + GlobalVariables.tagValueG;

			for (k = 0; k < selectedTagList.size() - 1; k++) {

				query1 += "SELECT MA.MID \n FROM MOVIE MA, MOVIE_TAGS TA,TAGS TS WHERE MA.MID=TA.MID AND TS.TID=TA.TID AND TS.TID = '"
						+ selectedTagList.get(k).split("\\s")[0] + "' AND TA.TAGWEIGHT"
						+ GlobalVariables.tagLessThanGreater + GlobalVariables.tagValueG + " AND MA.MID IN ( "
						+ prevQueryFromTag + " ) \n" + andOrAttribute + "\n";

			}

			query1 += "SELECT MA.MID \n FROM MOVIE MA, MOVIE_TAGS TA,TAGS TS WHERE MA.MID=TA.MID AND TS.TID=TA.TID AND TS.TID = '"
					+ selectedTagList.get(k).split("\\s")[0] + "' AND TA.TAGWEIGHT"
					+ GlobalVariables.tagLessThanGreater + GlobalVariables.tagValueG + " AND MA.MID IN ( "
					+ prevQueryFromTag + " )";


			query2 += "SELECT F.MID , F.TITLE , F.MYEAR , G1.GENRES , C1.COUNTRY , F.rtAudienceRating , F.rtAudienceNumRatings \n"
					+ "" + " FROM MOVIE F , MOVIE_GENRES G1 , MOVIE_COUNTRIES C1 WHERE  F.MID =G1.MID AND F.MID = C1.MID AND F.MID IN ( " + query1 + " )";
			System.out.println(
					"----------------------------final query-------------------------------------------------");
			System.out.println(query2);
			System.out.println(
					"------------------------------------------------------------------------------------------");

		}

		try {
			ps = con.prepareStatement(query2);
			resultMovie = ps.executeQuery(query2);
			// ps1 = con.prepareStatement("create or replace view midofCountry
			// as \n" + "" );
			// ps.close();
		} catch (SQLException e) {
			System.out.println("errr");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return resultMovie;
	}

}
