package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class ActorAndDirector extends Observable {

	Country country;
	Connection con =null;
	static ResultSet resultActor = null;
	static PreparedStatement ps = null;
	static ResultSet resultDirector =null;
	static ResultSet result=null;
	ConnectionToDb cd = new ConnectionToDb();
	ArrayList<String> countrySelected;
	ArrayList<String> genreSelected;
	
	//DefaultComboBoxModel<String> DirectorList = new DefaultComboBoxModel<>();
	ArrayList<String> directorSelectedList;
	
	public ArrayList<String> getDirectorSelectedList() {
		return directorSelectedList;
	}

	public void setDirectorSelectedList(ArrayList<String> directorSelectedList) {
		this.directorSelectedList = directorSelectedList;
		setChanged();
	     // notify Observers that model has changed
		notifyObservers();
	}

	
	
	DefaultListModel<String> actorsList = new DefaultListModel<>();
	DefaultListModel<String> DirectorList = new DefaultListModel<>();
	
	public DefaultListModel<String> getDirectorList() {
		return DirectorList;
	}

	public void setDirectorList(DefaultListModel<String> directorList) {
		DirectorList = directorList;
		setChanged();
	     // notify Observers that model has changed
		notifyObservers();
	}

	public DefaultListModel<String> getActorsList() {
		return actorsList;
	}

	public void setActorsList(DefaultListModel<String> actorsList) {
		this.actorsList = actorsList;
	}

	ArrayList<String> selectedActorList1 = new ArrayList<>();

	

	public ArrayList<String> getSelectedActorList1() {
		return selectedActorList1;
	}

	public void setSelectedActorList1(ArrayList<String> selectedActorList1) {
		this.selectedActorList1 = selectedActorList1;
		setChanged();
	     // notify Observers that model has changed
		notifyObservers();	
	}




	public ActorAndDirector(Country c) {
		try{
			country = c;
			con = cd.openConnection();
			countrySelected =country.getCountrySelected();
			genreSelected = country.getGenreList();
			result =  executeQuery(con);
			resultActor = executeQueryActor();
			createActorList(resultActor);
		}
		catch(SQLException e)
		{
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

//	SELECT M.MID , D.DIRECTORNAME
//	FROM COUNTRYMID M, MOVIE_DIRECTORS D
//	WHERE M.MID = D.MID;
	
	
	String queryStatmentDirector="";
	private ResultSet executeQueryDirector() {
		
		queryStatmentDirector += "SELECT D.DIRECTORNAME \n FROM MOVIE_DIRECTORS D\n WHERE D.MID IN ( " + queryStatment +" )";
		//System.out.println("final query");
		//System.out.println(queryStatmentDirector);


		try {
			ps = con.prepareStatement(queryStatmentDirector);
			resultDirector = ps.executeQuery(queryStatmentDirector);
			//ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		finally{
			cd.closeConnection(con);
		}
		
		return resultDirector;
	}

	private void createActorList(ResultSet resultActor2) {
		
		actorsList.addElement("ALL");
		
		try {
			
			while (resultActor2.next()) {
				
					//System.out.println(resultActor2.getString("ACTORNAME"));
					actorsList.addElement(resultActor2.getString("ACTORNAME"));
					
			}

			// System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(" size " +actorsList.size());
		
	
		
	}

	//	SELECT A.MID , A.ACTORNAME
//	FROM MOVIE_ACTOR A
//	WHERE A.MID IN( SELECT CM.MID
//	                FROM COUNTRYMID CM);
	String queryStatmentActor = "";
	String queryStatmentActor1 = "";
	
	
	public String getQueryStatmentActor1() {
		return queryStatmentActor1;
	}

	public void setQueryStatmentActor1(String queryStatmentActor1) {
		this.queryStatmentActor1 = queryStatmentActor1;
	}

	private ResultSet executeQueryActor() {
		
		
		
		
		queryStatmentActor += "SELECT A.ACTORNAME\n FROM MOVIE_ACTOR A\n WHERE A.MID IN ( " + queryStatment +" )";
		queryStatmentActor1 = "SELECT A.MID\n FROM MOVIE_ACTOR A\n WHERE A.MID IN ( " + queryStatment +" )";
//		System.out.println("--------------final query actor---------------------------------------------------");
//		System.out.println(queryStatmentActor1);
//		System.out.println("-----------------------------------------------------------------------------------");

		try {
			ps = con.prepareStatement(queryStatmentActor);
			resultActor = ps.executeQuery(queryStatmentActor);
			//ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return resultActor;
	}

	String queryStatment = "";
	public String getQueryStatment() {
		return queryStatment;
	}

	public void setQueryStatment(String queryStatment) {
		this.queryStatment = queryStatment;
	}

	String andOrAttribute = GlobalVariables.betweenAttribute;
	
	
	private ResultSet executeQuery(Connection con2) {
		
		int i = 0;
		
		queryStatment += country.getQueryCountryMid();
		
		if(countrySelected.get(0) == "ALL")
		{
			DefaultListModel<String> all = country.getCountryList();
			queryStatment += "\nINTERSECT\n";
	 		   
	 		   for(i=1;i<all.size() -1;i++)
	 		   {
	 			   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY like '%"+ all.get(i)+ "%' \n" + andOrAttribute + "\n";
	 		   }
	 		   
	 		   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY like '%"+ all.get(i)+"%'";
			
//			
//			 for(i=1;i<all.size() -1;i++)
//	 		   {
//	 			   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY like '%"+"' \n" + andOrAttribute + "\n";
//	 		   }
//	 		   
//	 		   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY like '%"+"'";
		}
		else
		if(countrySelected.size()!=0)
 	   {
 		   queryStatment += "\nINTERSECT\n";
 		   
 		   for(i=0;i<countrySelected.size() -1;i++)
 		   {
 			   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY like '%"+countrySelected.get(i)+"%' \n" + andOrAttribute + "\n";
 		   }
 		   
 		   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY like '%"+countrySelected.get(i)+"%'";
 	   }
		
		//System.out.println("ActorAndDirector");
		System.out.println("------------------------- actor mid pre query----------------");
		System.out.println(queryStatment);
		System.out.println("--------------------------------------------------------------------");
		
//		try {
//			ps = con.prepareStatement(queryStatment);
//			result = ps.executeQuery(queryStatment);
//			//ps.close();
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//		}

		
		return result;
	}
	
	
}
