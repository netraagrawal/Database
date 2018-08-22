package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

public class Country extends Observable{
	static Connection con = null;
	static ResultSet resultCountry = null;
	static PreparedStatement ps = null;
	static PreparedStatement ps1 = null;
	
	ConnectionToDb cd = new ConnectionToDb();
	Genre genre;
	ArrayList<String> genreList;
	private ArrayList<String> countrySelected = new ArrayList<>();
	DefaultListModel<String> countryList = new DefaultListModel<>();
	String startYear,endYear;
	
	
	
	
	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public ArrayList<String> getGenreList() {
		return genreList;
	}

	public void setGenreList(ArrayList<String> genreList) {
		this.genreList = genreList;
	}

	public ArrayList<String> getCountrySelected() {
		return countrySelected;
	}

	public void setCountrySelected(ArrayList<String> countrySelected) {
		this.countrySelected = countrySelected;
		setChanged();
	     // notify Observers that model has changed
		notifyObservers();	
	}

	public DefaultListModel<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(DefaultListModel<String> countryList) {
		this.countryList = countryList;
	}

	public Country(Genre genre1) {

		try {
			con = cd.openConnection();

			genre = genre1;
			genreList = genre.getGenreSelected();
			startYear = genre.getStartYear();
			endYear = genre.getEndYear();
			resultCountry = executeQuery(con);
			//showMetaDataOfResultSet(resultCountry);
			//genre.showResultSet(resultCountry);
			
			countryList = createCountryList(resultCountry);
			//createCountryList(resultCountry);
			
		} catch (SQLException e) {
			System.err.println("Error ocurrs when communicating with the database server" + e.getMessage());
		} finally {
			cd.closeConnection(con);
		}

	}

//	String queryStatment = "";
//	String queryStatmentMid = "";
	String andOrAttribute = GlobalVariables.betweenAttribute;

	String queryStatmentCountry = "";
	
	String queryCountryMid = "";
	
	public String getQueryCountryMid() {
		return queryCountryMid;
	}

	public void setQueryCountryMid(String queryCountryMid) {
		this.queryCountryMid = queryCountryMid;
	}

	private ResultSet executeQuery(Connection con2) {
		
		int k=0;
		if(genreList.size() != 0)
		{
			for(k=0;k< getGenreList().size()-1;k++)
			{
				queryCountryMid +="SELECT M.MID \n FROM MOVIE_GENRES G, MOVIE_COUNTRIES C, MOVIE M \n WHERE G.GENRES = '"
						+genreList.get(k) + "' AND " + "m.myear >=" + genre.getStartYear() + " AND " + "M.MYEAR <="
						+ genre.getEndYear() + " AND M.MID = G.MID AND M.MID = C.MID \n" + andOrAttribute + " \n";
			}
			
			queryCountryMid +="SELECT M.MID \n FROM MOVIE_GENRES G, MOVIE_COUNTRIES C, MOVIE M \n WHERE G.GENRES = '"
					+genreList.get(k) + "' AND " + "m.myear >=" + genre.getStartYear() + " AND " + "M.MYEAR <="
					+ genre.getEndYear() + " AND M.MID = G.MID AND M.MID = C.MID \n";
			
			
			
			queryStatmentCountry +="SELECT DISTINCT C1.COUNTRY \n FROM MOVIE_COUNTRIES C1 \n WHERE C1.MID IN ( " + queryCountryMid + " )";
			
			System.out.println("-----------------------------country mid list----------------------------------");
			System.out.println(queryCountryMid);
			System.out.println("------------------------------------------------------------------------------");
		}
		
		

		try {
			ps = con2.prepareStatement(queryStatmentCountry);
			resultCountry = ps.executeQuery(queryStatmentCountry);
			//ps1 = con.prepareStatement("create or replace view midofCountry as \n" + "" );
			//ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return resultCountry;
	}

	private DefaultListModel<String> createCountryList(ResultSet result2) {
		
		countryList.addElement("ALL");
		try {
			while (resultCountry.next()) {
				
					countryList.addElement(resultCountry.getString("COUNTRY"));

				
			}

			// System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return countryList;
	}

	 public void showMetaDataOfResultSet(ResultSet resultCountry) throws SQLException { 
         ResultSetMetaData meta = resultCountry.getMetaData(); 
         for (int col = 1; col <= meta.getColumnCount(); col++) { 
             System.out.println("Column: " + meta.getColumnName(col) + 
                                "\t, Type: " + meta.getColumnTypeName(col)); 
         } 
     }
	 
	 public void showResultSet(ResultSet result) throws SQLException { 
	        ResultSetMetaData meta = result.getMetaData(); 
	        int tupleCount = 1; 
	        while (result.next()) { 
	            System.out.print("Tuple " + tupleCount++ + " : "); 
	            for (int col = 1; col <= meta.getColumnCount(); col++) { 
	                System.out.print("\"" + result.getString(col) + "\","); 
	            } 
	            System.out.println(); 
	        } 
	    }
}
