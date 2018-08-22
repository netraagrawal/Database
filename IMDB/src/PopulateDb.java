import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datfile.FileData;

public class PopulateDb {
	
	static Connection con = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    
    public static void main(String args[])
    {
    	PopulateDb pd = new PopulateDb();
    	pd.run();
    }

	private void run() {
		// TODO Auto-generated method stub
		try{
			con = openConnection();
			//insertMovies(con);
			//insertTag(con);
			//insertMovieCountries(con);
			//insertMovieGenre(con);
			//insertMovieDirectors(con);
			//insertActors(con);
			//insertMovieTag(con);
			//insertUserTaggedMovies(con);
			}
		catch(SQLException e)
		{
			System.err.println("Error ocurrs when communicating with the database server" + e.getMessage());
		}
		finally{
			closeConnection(con);
		}
	}
	
	private void insertUserTaggedMovies(Connection con2) {
		// TODO Auto-generated method stub
		array = FileData.readinput("user_taggedmovies.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].split("\\t");
			 
			if(!data[0].equals(null))
			{
				int j=1;
				try
				{
					ps = con.prepareStatement("insert into User_TaggedMovies values(?,?,?,?,?,?)");
					for(int k=0;  k < 6;k++)
					{
						ps.setString(j++, data[k]);
					}
					ps.executeQuery();
					ps.close();
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	private void insertMovieTag(Connection con2) {
		// TODO Auto-generated method stub
		array = FileData.readinput("movie_tags.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].split("\\t");
			 
			if(!data[0].equals(null))
			{
				int j=1;
				try
				{
					ps = con.prepareStatement("insert into Movie_Tags values(?,?,?)");
					for(String temp:data)
					{
						ps.setString(j++, temp);
					}
					ps.executeQuery();
					ps.close();
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	private void insertActors(Connection con2) {
		// TODO Auto-generated method stub
		array = FileData.readinput("movie_actors.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].trim().split("\\t");
			 
			if(!data[0].equals(null))
			{
				int j=1,l=2;
				try
				{
					ps = con.prepareStatement("insert into Movie_Actor values(?,?,?,?)");
//					for(int k=0; k<3 ;k++)
//					{
//						while(k >=2 && l < data.length-1)
//						{
//							data[2] += data[l];
//							l++;
//						}
//						ps.setString(j++, data[k]);
//					}
					for(int k=0;k<data.length;k++)
					{
						ps.setString(j++, data[k]);
					}
					ps.executeQuery();
					ps.close();
				}
				catch(Exception e)
				{
					System.out.println(data[0] + data.length);
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	private void insertMovieDirectors(Connection con2) {
		// TODO Auto-generated method stub
		array = FileData.readinput("movie_directors.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].trim().split("\\t");
			 
			if(!data[0].equals(null))
			{
				int j=1,l=2;
				try
				{
					ps = con.prepareStatement("insert into Movie_Directors values(?,?,?)");
//					for(int k=0; k<3 ;k++)
//					{
//						while(k >=2 && l < data.length)
//						{
//							data[2] += data[l];
//							l++;
//						}
//						ps.setString(j++, data[k]);
//					}
					
					for(int k=0;k<data.length;k++)
					{
						ps.setString(j++,data[k]);
					}
					ps.executeQuery();
					ps.close();
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	private void insertMovieGenre(Connection con2) {
		// TODO Auto-generated method stub
		array = FileData.readinput("movie_genres.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].trim().split("\\t");
			
			if(!data[0].equals(null))
			{
				int j=1;
				try
				{
					ps = con.prepareStatement("insert into Movie_genres values(?,?)");
					for(String temp:data)
					{
						ps.setString(j++, temp);
					}
					ps.executeQuery();
					ps.close();
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	private void insertMovieCountries(Connection con2) {
		// TODO Auto-generated method stub
		
		array = FileData.readinput("movie_countries.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].trim().split("\\t");
			if(data.length >= 3)
				data = convertStringToLength2(data);
			if(data.length == 1)
				System.out.println(data.length);
			if(!data[0].equals(null))
			{
				int j=1;
				try{
					ps = con.prepareStatement("insert into Movie_Countries values(?,?)");
					if(data.length ==1)
					{
						
					}
					else
					{
						for(String temp:data)
						{
								ps.setString(j++, temp);
						}
						ps.executeQuery();
						ps.close();
					}
				}
				catch(SQLException e)
				{
					System.out.println( "value "+data[0]+" len" +data.length);
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		
		}
		
	}

	private String[] convertStringToLength2(String[] data2) {
		// TODO Auto-generated method stub
		String temp = "";
		String[] len2 = new String[2];
		len2[0] = data2[0];
		for(int i=1;i<data2.length;i++)
		{
			temp +=data2[i]+" ";
		}
		temp =temp.trim();
		len2[1] = temp;
		return len2;
	}

	String[] array;
	String data[];
	
	private void insertTag(Connection con2) {
		// TODO Auto-generated method stub
		array = FileData.readinput("tags.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].trim().split("\\t");
			
			if(!data[0].equals(null))
			{
				int j=1;
				try
				{
					ps = con.prepareStatement("insert into tags values(?,?)");
					for(String temp:data)
					{
						ps.setString(j++, temp);
					}
					ps.executeQuery();
					ps.close();
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	private void insertMovies(Connection con2) {
		// TODO Auto-generated method stub
		array = FileData.readinput("movies.dat");
		for(int i=1;i<array.length;i++)
		{
			data = array[i].trim().split("\\t");
			
			if(!data[0].equals(null))
			{
				try{
					ps = con.prepareStatement("insert into movie values(?,?,?,?,?)");
					ps.setString(1, data[0]);
					ps.setString(2, data[1]);
					ps.setString(3, data[5]);
					ps.setString(4, data[18]);
					ps.setString(5, data[19]);
					ps.executeQuery();
					ps.close();
				}
				catch(Exception e)
				{
					try{
					ps.setString(1, data[0]);
					ps.setString(2, data[1]);
					ps.setString(3, data[5]);
					ps.setString(4, null);
					ps.setString(5 , null);
					ps.executeQuery();
					ps.close();
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
			}
		}
	}

	private void closeConnection(Connection con2) {
		// TODO Auto-generated method stub
		try{
			con2.close();
		}catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Cannot close connection " + e.getMessage());
		}
		
	}

	private Connection openConnection() throws SQLException {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		
		String host = "localhost"; 
        String port = "1521"; 
        String dbName = "oracledb"; 
        String userName = "scott"; 
        String password = "tiger"; 
        
        String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;
        return DriverManager.getConnection(dbURL, userName, password);
	}
}
