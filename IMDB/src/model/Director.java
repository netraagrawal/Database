package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

public class Director extends Observable {

	ActorAndDirector ad;
	Connection con = null;
	static ResultSet resultDirector = null;
	ArrayList<String> directorSelectedList = new ArrayList<>();
	DefaultListModel<String> DirectorList = new DefaultListModel<>();
	String prevQuery;
	ConnectionToDb cd = new ConnectionToDb();
	static PreparedStatement ps = null;
	static PreparedStatement psView = null;
	String pGQuery;

	public static ResultSet getResultDirector() {
		return resultDirector;
	}

	public static void setResultDirector(ResultSet resultDirector) {
		Director.resultDirector = resultDirector;
	}

	public ArrayList<String> getDirectorSelectedList() {
		return directorSelectedList;
	}

	public void setDirectorSelectedList(ArrayList<String> directorSelectedList) {
		this.directorSelectedList = directorSelectedList;

		setChanged();
		// notify Observers that model has changed
		notifyObservers();
	}

	public DefaultListModel<String> getDirectorList() {
		return DirectorList;
	}

	public void setDirectorList(DefaultListModel<String> directorList) {
		DirectorList = directorList;
	}

	public String getPrevQuery() {
		return prevQuery;
	}

	public void setPrevQuery(String prevQuery) {
		this.prevQuery = prevQuery;
	}

	public String getQueryStatmentDirector() {
		return queryStatmentDirector;
	}

	public void setQueryStatmentDirector(String queryStatmentDirector) {
		this.queryStatmentDirector = queryStatmentDirector;
	}

	public Director(ActorAndDirector a) {

		ad = a;
		try {
			con = cd.openConnection();
			prevQuery = ad.getQueryStatmentActor1();
			pGQuery = ad.getQueryStatment();
			resultDirector = executeQuery(con);
			DirectorList = createDirectorList(resultDirector);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			cd.closeConnection(con);
		}

	}

	private DefaultListModel<String> createDirectorList(ResultSet resultDirector2) {

		DirectorList.addElement("ALL");
		try {
			while (resultDirector2.next()) {

				DirectorList.addElement(resultDirector2.getString("DIRECTORNAME"));
			}

			// System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return DirectorList;

	}

	String queryStatmentDirector = "";
	String queryStatmentDirectorMid = "";

	public String getQueryStatmentDirectorMid() {
		return queryStatmentDirectorMid;
	}

	public void setQueryStatmentDirectorMid(String queryStatmentDirectorMid) {
		this.queryStatmentDirectorMid = queryStatmentDirectorMid;
	}

	String queryStatmentIntDirector = "";
	String queryStatmentIntDirectorMID = "";

	private ResultSet executeQuery(Connection con2) {

		if (ad.getSelectedActorList1().get(0) == "ALL") {

			queryStatmentDirector += "SELECT DISTINCT D.DIRECTORNAME \n FROM MOVIE_DIRECTORS D\n WHERE D.MID IN ( "
					+ prevQuery + " )";

			queryStatmentDirectorMid += "SELECT D.MID \n FROM MOVIE_DIRECTORS D\n WHERE D.MID IN ( " + prevQuery + " )";

			// -----------------------------------------------------mid-------------------------------------------------------
			queryStatmentIntDirectorMID += "SELECT D.MID , D.DIRECTORNAME \n FROM MOVIE_DIRECTORS D\n WHERE D.MID IN ( "
					+ prevQuery + " )";

			System.out.println(
					"---------------------------------Director ALL------------------------------------------------");
			// System.out.println(ad.getAc);
			System.out.println(queryStatmentDirectorMid);
			System.out.println(
					"------------------------------------------------------------------------------------------");
			System.out.println(prevQuery);
		} else {
			int i;
			queryStatmentDirectorMid += ad.getQueryStatment();

			queryStatmentDirectorMid += "\nINTERSECT\n";
			for (i = 0; i < ad.getSelectedActorList1().size() - 1; i++) {

				

				queryStatmentDirectorMid += "SELECT A.MID \n FROM MOVIE_ACTOR A\n WHERE A.ACTORNAME ='"
						+ ad.getSelectedActorList1().get(i) + "' \n" + GlobalVariables.betweenAttribute + "\n";

			}

			queryStatmentDirectorMid += "SELECT A.MID \n FROM MOVIE_ACTOR A\n WHERE A.ACTORNAME ='"
					+ ad.getSelectedActorList1().get(i) + "' \n";

			queryStatmentDirector += "SELECT DISTINCT D.DIRECTORNAME \n FROM MOVIE_DIRECTORS D \n WHERE D.MID IN ( "
					+ queryStatmentDirectorMid + " )";

			System.out.println(
					"---------------------------------Director selected------------------------------------------------");
			System.out.println(queryStatmentDirectorMid);
			System.out.println(
					"------------------------------------------------------------------------------------------");

		}
		try {
			ps = con.prepareStatement(queryStatmentDirector);
			/// psView = con.prepareStatement("CREATE OR REPLACE VIEW DIRMID AS
			/// \n" + queryStatmentDirector);
			resultDirector = ps.executeQuery(queryStatmentDirector);
			/// psView.executeQuery("CREATE OR REPLACE VIEW DIRMID AS \n" +
			/// queryStatmentIntDirectorMID);
			// ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return resultDirector;
	}

}
