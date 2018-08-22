package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class MainQuery2 {
	
	
	TagAndValue1 tv;
	Connection con =null;
	static PreparedStatement ps = null;
	String prevQueryFromTag;
	ArrayList<String> selectedTagList;
	static  ResultSet resultMovie = null;
	ConnectionToDb cd = new ConnectionToDb();
	DefaultListModel<String> movieList = new DefaultListModel<>();
	
	
	
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
		MainQuery2.resultMovie = resultMovie;
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

	public MainQuery2(TagAndValue1 t) {
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
		}
		finally{
			cd.closeConnection(con);
		}
	}

	private void createMovieList(ResultSet resultMovie2) {
		
		movieList.addElement("ALL");
		try {
			while(resultMovie2.next())
			{
				movieList.addElement(resultMovie2.getString("MID") + " " + resultMovie2.getString("TITLE") + " " + resultMovie2.getString("MYEAR"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	String mainQueryStatement = "";
	String query1 = "";
	String query2 = "";
	String andOrAttribute = GlobalVariables.betweenAttribute;
	private ResultSet executeQuery(Connection con2) {
		
		if(selectedTagList.get(0) == "ALL")
		{
			
		}
		else
		{
			
			
//			QueryStatmentTagMid += "SELECT MT.MID \n FROM ( " + prevQuery
//					+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
//					+ d.getDirectorList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n T2.TAGWEIGHT " + GlobalVariables.tagLessThanGreater +" " + GlobalVariables.tagValueG + "  " + andOrAttribute+ " \n";
//						querey1();
			
			
			query2();
			mainQueryStatement += "SELECT * \n FROM MOVIE M1 \n WHERE M1.MID IN (" + query1 + "\n INTERSECT \n"+ query2+ " )";
			
			System.out.println("----------------------------final query-------------------------------------------------");
			System.out.println(mainQueryStatement);
			System.out.println("------------------------------------------------------------------------------------------");
			
			
		}
		
		try {
			ps = con.prepareStatement(mainQueryStatement);
			resultMovie = ps.executeQuery(mainQueryStatement);
			//ps1 = con.prepareStatement("create or replace view midofCountry as \n" + "" );
			//ps.close();
		} catch (SQLException e) {
			System.out.println("errr");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		return resultMovie;
	}
	
	
	private void query2() {
		
		query2 += "SELECT T2.MID \n FROM MOVIE_TAGS T2 \n WHERE T2.TAGWEIGHT " +GlobalVariables.tagLessThanGreater +" " + GlobalVariables.tagValueG ;
		
		System.out.println("----------------------------------query 2-------------------------------------------------------");
		System.out.println(query2);
		System.out.println("---------------------------------------------------------------------------------------------------");
		
	}


	private void querey1() {
		int n;
		for(n=0;n<selectedTagList.size() -1 ; n++)
		{
			query1 += "SELECT M2.MID \n FROM ( " + prevQueryFromTag + " ) M2 ,   WHERE M2.TID = '"+selectedTagList.get(n).split("\\s")[0]+"' \n" + andOrAttribute + "\n";
		}
		
			query1 += "SELECT M2.MID \n FROM ( " + prevQueryFromTag + " ) M2 WHERE M2.TID = '"+selectedTagList.get(n).split("\\s")[0]+"' ";
			
			System.out.println("---------------------------------------------query1-----------------------------------------------");
			System.out.println(query1);
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			System.out.println(selectedTagList.size());
	}

}
