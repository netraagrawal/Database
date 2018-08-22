package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

public class Genre extends Observable {
	
	static Connection con = null;
    static ResultSet result = null;
    static PreparedStatement ps = null;
    private ArrayList<String> genreSelected;
    String startYear = "2008",endYear = "2016";
    
    
   
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

	public ArrayList<String> getGenreSelected() {
		return genreSelected;
	}

	public void setGenreSelected(ArrayList<String> genreSelected) {
		this.genreSelected = genreSelected;		
			setChanged();
	      // notify Observers that model has changed
			notifyObservers();	
	}

	
	DefaultListModel<String> genreList = new DefaultListModel<>();
	
    public DefaultListModel<String> getGenreList() {
		return genreList;
	}

	public void setGenreList(DefaultListModel<String> genreList) {
		this.genreList = genreList;
		
	}
	
	

	ConnectionToDb cd = new ConnectionToDb();
    
	public Genre()
	{
		try{
			con = cd.openConnection();
			result = executeQuery(con);
			genreList = createGenreList(result);
			//showResultSet(result);
			showMetaDataOfResultSet(result);
			}
		catch(SQLException e)
		{
			System.err.println("Error ocurrs when communicating with the database server" + e.getMessage());
		}
		finally{
			cd.closeConnection(con);
		}
	}

	private DefaultListModel<String> createGenreList(ResultSet result2) {
		
		try {
			while(result2.next())
			{
			    if(!genreList.contains(result2.getString("Genres")))
			    {
			        genreList.addElement(result2.getString("Genres"));
			        
			    }
			}
			
			//System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genreList;
	}

	private ResultSet executeQuery(Connection con2) {

		String GetGenre = "SELECT DISTINCT MG.Genres FROM Movie_Genres MG ORDER BY MG.GENRES\n";
		try{
			ps=con.prepareStatement(GetGenre);
            result = ps.executeQuery(GetGenre);
           // ps.close();
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return result;
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
	
	 public void showMetaDataOfResultSet(ResultSet result) throws SQLException { 
         ResultSetMetaData meta = result.getMetaData(); 
         for (int col = 1; col <= meta.getColumnCount(); col++) { 
             System.out.println("Column: " + meta.getColumnName(col) + 
                                "\t, Type: " + meta.getColumnTypeName(col)); 
         } 
     } 

}
