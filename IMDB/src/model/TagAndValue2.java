package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class TagAndValue2 {
	
	Director d;
	Connection con =null;
	static PreparedStatement ps = null;
	String prevQuery;
	ArrayList<String> selectedTagList = new ArrayList<>();
	static  ResultSet resultTag = null;
	String pGquery;
	ConnectionToDb cd = new ConnectionToDb();
	
	DefaultListModel<String> tagsAndValueJlist = new DefaultListModel<>();
	
	
	
	
	public String getPrevQuery() {
		return prevQuery;
	}


	public void setPrevQuery(String prevQuery) {
		this.prevQuery = prevQuery;
	}


	public ArrayList<String> getSelectedTagList() {
		return selectedTagList;
	}


	public void setSelectedTagList(ArrayList<String> selectedTagList) {
		this.selectedTagList = selectedTagList;
	}


	public String getpGquery() {
		return pGquery;
	}


	public void setpGquery(String pGquery) {
		this.pGquery = pGquery;
	}


	public DefaultListModel<String> getTagsAndValueJlist() {
		return tagsAndValueJlist;
	}


	public void setTagsAndValueJlist(DefaultListModel<String> tagsAndValueJlist) {
		this.tagsAndValueJlist = tagsAndValueJlist;
	}


	public String getQueryStatmentTag() {
		return QueryStatmentTag;
	}


	public void setQueryStatmentTag(String queryStatmentTag) {
		QueryStatmentTag = queryStatmentTag;
	}


	public TagAndValue2(Director d1) {
		
		d=d1;
		prevQuery = d.getQueryStatmentDirectorMid();
		try {
			con = cd.openConnection();
			resultTag = executeQuery(con);
			 createTagList(resultTag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			cd.closeConnection(con);
		}
		
	}


	private  void createTagList(ResultSet resultTag2) {
		
		tagsAndValueJlist.addElement("ALL");
		try {
			while(resultTag2.next())
			{
				tagsAndValueJlist.addElement(resultTag2.getString("TID") + " " + resultTag2.getString("TVALUE"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	String andOrAttribute = GlobalVariables.betweenAttribute;
	String QueryStatmentTag = "";
	String QueryStatmentTagMid = "";
	
	
	public String getQueryStatmentTagMid() {
		return QueryStatmentTagMid;
	}


	public void setQueryStatmentTagMid(String queryStatmentTagMid) {
		QueryStatmentTagMid = queryStatmentTagMid;
	}


	private ResultSet executeQuery(Connection con2) {
		int k;
	//	QueryStatmentTag += "\nINTERSECT\n";
		if(d.getDirectorSelectedList().get(0) == "ALL")
		{
			for(k=1;k<d.getDirectorList().size() -1 ; k++)
			{
				QueryStatmentTag += "SELECT T.TID , T.TVALUE \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n " + andOrAttribute+ " \n";
				
				///--------------------------------------------------------------------------------------------------------------------
				
				QueryStatmentTagMid += "SELECT MT.MID \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n " + andOrAttribute+ " \n";
				
			}	
			
				QueryStatmentTag += "SELECT T.TID , T.TVALUE \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n ";
				
				QueryStatmentTagMid += "SELECT MT.MID \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n ";
				
				System.out.println("------------------------------tag all----------------------------------------------------------");
				System.out.println(QueryStatmentTag);
				System.out.println("-------------------------------------------------------------------------------------------");
				System.out.println(prevQuery);
		}
		else
		{
			for(k=0;k<d.getDirectorSelectedList().size() -1 ; k++)
			{
				QueryStatmentTag += "SELECT T.TID , T.TVALUE \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorSelectedList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n " +andOrAttribute+ " \n";
				
				QueryStatmentTagMid += "SELECT MT.MID  \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorSelectedList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n " +andOrAttribute+ " \n";
			}	
			
				QueryStatmentTag += "SELECT T.TID , T.TVALUE \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorSelectedList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n ";
				
				QueryStatmentTagMid += "SELECT MT.MID \n FROM ( " + prevQuery
						+ " ) M, MOVIE_DIRECTORS D , MOVIE_TAGS MT, TAGS T \n WHERE M.MID = D.MID AND D.DIRECTORNAME='"
						+ d.getDirectorSelectedList().get(k) + "' AND MT.MID=M.MID AND MT.TID = T.TID \n ";
				
				System.out.println("------------------------------tag selected----------------------------------------------------------");
				System.out.println(QueryStatmentTag);
				System.out.println("-------------------------------------------------------------------------------------------");
		}
		
			
			try {
				ps = con.prepareStatement(QueryStatmentTag);
				resultTag = ps.executeQuery(QueryStatmentTag);
				//ps1 = con.prepareStatement("create or replace view midofCountry as \n" + "" );
				//ps.close();
			} catch (SQLException e) {
				System.out.println("errr");
				System.err.println(e.getMessage());
				e.printStackTrace();
			}

			return resultTag;
	}
	
	

}
