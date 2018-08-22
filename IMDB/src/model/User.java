package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class User {

	MainQuery movie;
	Connection con = null;
	static ResultSet resultUser = null;
	static PreparedStatement ps = null;
	ConnectionToDb cd = new ConnectionToDb();
	String prevQuery,userQueryStatemnt;
	DefaultListModel<String> userArrayList = new DefaultListModel<>();

	

	public DefaultListModel<String> getUserArrayList() {
		return userArrayList;
	}


	public void setUserArrayList(DefaultListModel<String> userArrayList) {
		this.userArrayList = userArrayList;
	}


	public User(MainQuery m) {

		movie = m;
		prevQuery = movie.getMainQueryStatement();
		userQueryStatemnt = movie.getMainQueryStatement();
		
		try {
			con = cd.openConnection();
			resultUser = executeQuery(con);
			createUserList(resultUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			cd.closeConnection(con);
		}
	}

	
	private void createUserList(ResultSet resultUser2) {
		
		try {
			while(resultUser2.next())
			{
				userArrayList.addElement(resultUser2.getString("USERID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	String userQueryStatemntMain ="";
	String andOrAttribute = GlobalVariables.betweenAttribute;

	private ResultSet executeQuery(Connection con2) {

		int k = 0;
		userQueryStatemnt += "\n INTERSECT \n";
		for (k = 0; k < movie.getMovieSelectedList().size() - 1; k++) {

			userQueryStatemnt += "SELECT U1.MID \n FROM USER_TAGGEDMOVIES U1 \n WHERE U1.MID='"
					+ movie.getMovieSelectedList().get(k).split("\\s")[0] + "' \n" + andOrAttribute + "\n";
		}
		
		userQueryStatemnt += "SELECT U1.MID \n FROM USER_TAGGEDMOVIES U1 \n WHERE U1.MID='"
				+ movie.getMovieSelectedList().get(k).split("\\s")[0] + "'";
		
		userQueryStatemntMain += "SELECT U.USERID \n FROM USER_TAGGEDMOVIES U WHERE U.MID IN ( " + userQueryStatemnt + " )";
		
		System.out.println("---------------------------------user id----------------------------------------------------");
		System.out.println(userQueryStatemnt);
		System.out.println("---------------------------------------------------------------------------------------------");


		try {
			ps = con.prepareStatement(userQueryStatemntMain);
			resultUser = ps.executeQuery(userQueryStatemntMain);
			// ps1 = con.prepareStatement("create or replace view midofCountry
			// as \n" + "" );
			// ps.close();
		} catch (SQLException e) {
			System.out.println("errr");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return resultUser;
	}
}
