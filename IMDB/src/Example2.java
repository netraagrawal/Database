     
    import java.sql.*;
import java.util.ArrayList;

import datfile.FileData; 
     
    /** 
     * This example is based on Example1. 
     */ 
    public class Example2 { 
    	
    	 static Connection con = null;
	     static ResultSet rs = null;
	     static PreparedStatement ps = null;
	     
        public static void main(String args[]) { 
            Example2 example = new Example2(); 
           example.run(); 
       } 
    
       /** 
        * In this method, we divide the whole query process into three functions: 
        * searchAllTuples(), showMetaDataOfResultSet(), showResultSet() for better 
        * understanding the logic of the code. (You can also put all the code 
        * inside one method, of course.) 
        */ 
       private void run() { 
          // Connection con = null; 
           ResultSet result = null; 
           try { 
               con = openConnection(); 
    
               result = executeQuery(con); 
    
               showMetaDataOfResultSet(result); 
    
               showResultSet(result); 
           } catch (SQLException e) { 
               System.err.println("Errors occurs when communicating with the database server: " + e.getMessage()); 
           } catch (ClassNotFoundException e) { 
               System.err.println("Cannot find the database driver"); 
           } finally { 
               // Never forget to close database connection 
               closeConnection(con); 
           } 
       } 
       
       //userID	movieID	tagID	timestamp
    
       private ResultSet searchAllTuples(Connection con) throws SQLException { 
           Statement stmt = con.createStatement(); 
           return stmt.executeQuery("select  m.mid from movie_genres g,movie_countries c,movie m where g.genres = 'Adventure' and m.myear > 2000 and m.myear <= 2010 and m.MID = g.MID and m.MID = c.MID intersect select  m.mid from movie_genres g,movie_countries c,movie m where g.genres = 'Animation' and m.myear > 2000 and m.myear <= 2010 and m.MID = g.MID and m.MID = c.MID");
       } 
       
       
       ArrayList<String> genreList = new ArrayList<>();
       ArrayList<String> selectedCountry = new ArrayList();
       
       private ResultSet executeQuery(Connection con) throws SQLException{
		   
    	   genreList.add("Adventure");
    	   genreList.add("Animation");
    	   //selectedCountry.add("USA");
    	   selectedCountry.add("Canada");
    	   //selectedCountry.add("Canada");
    	   Statement stmt = con.createStatement();
    	   String queryStatment = "";
    	   String startYear = "2000";
    	   String endYear = "2010";	   
    	   String andOrAttribute = "INTERSECT";
    	   
    	   int i=0;
    	   if(genreList.size() !=0)
    	   {
    		   for(i=0;i<genreList.size()-1;i++)
    		   {
    			   queryStatment += "select  m.mid \n from movie_genres g,movie_countries c,movie m \n where g.genres = '"+ genreList.get(i)+"' and "+"m.myear >"+startYear+" and "+"m.myear <="+ endYear +"\n"+" and m.MID = g.MID and m.MID = c.MID \n"+ andOrAttribute + "\n";
    		   }
    		   
    		   queryStatment += "select  m.mid \n from movie_genres g,movie_countries c,movie m \n where g.genres = '"+ genreList.get(i)+"' and "+"m.myear >"+startYear+" and "+"m.myear <="+ endYear + " and m.MID = g.MID and m.MID = c.MID";
    		   //System.out.println(queryStatment);
    	   }
    	   
    	   if(selectedCountry.size()!=0)
    	   {
    		   queryStatment += "\nINTERSECT\n";
    		   
    		   for(i=0;i<selectedCountry.size() -1;i++)
    		   {
    			   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY = '"+selectedCountry.get(i)+"' \n" + andOrAttribute + "\n";
    		   }
    		   
    		   queryStatment +="SELECT MC.Mid\nFROM Movie_Countries MC\nWHERE MC.COUNTRY = '"+selectedCountry.get(i)+"'";
    	   }
    	   
    	   String queryStatment1 = "";
    	   //queryStatment += "\nINTERSECT\n";
    	   queryStatment1 += "SELECT D.MID\n FROM MOVIE_DIRECTORS D\n WHERE D.MID IN ( " + queryStatment +" )";
    	   
    	   String queryStatment2 = "";
    	   
    	   queryStatment2 += "SELECT A.MID\n FROM MOVIE_ACTOR A\n WHERE A.MID IN ( " + queryStatment +" )";
//    	   if()
//    	   {
//    		   
//    	   }
    	   // CAST AND DIRECTORS
    	   
    	   //queryStatment+= ""
    	   System.out.println(queryStatment2);
    	   
    	   return stmt.executeQuery(queryStatment2);
    	   
       }
       
       public static void Insert_Movie_Tags(String data[])
       {
    	     

           if(!data[0].equals(null))
           {
               int i=1;
               try
               {
                   ps = con.prepareStatement("insert into movie_actor values(?,?,?,?)");
                   for(String value:data)
                   {
                       ps.setString(i++, value);
                   }
                   ps.executeUpdate();
                   ps.close();
               }
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
           }
       }

    
       public void showMetaDataOfResultSet(ResultSet result) throws SQLException { 
           ResultSetMetaData meta = result.getMetaData(); 
           for (int col = 1; col <= meta.getColumnCount(); col++) { 
               System.out.println("Column: " + meta.getColumnName(col) + 
                                  "\t, Type: " + meta.getColumnTypeName(col)); 
           } 
       } 
    
       private void showResultSet(ResultSet result) throws SQLException { 
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
    
       /** 
        * 
        * @return a database connection 
        * @throws SQLException when there is an error when trying to connect database 
        * @throws ClassNotFoundException when the database driver is not found. 
        */ 
       private Connection openConnection() throws SQLException, ClassNotFoundException { 
           // Load the Oracle database driver 
           DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
    
           /* 
           Here is the information needed when connecting to a database 
           server. These values are now hard-coded in the program. In 
           general, they should be stored in some configuration file and 
           read at run time. 
           */ 
           String host = "localhost"; 
           String port = "1521"; 
           String dbName = "oracledb"; 
           String userName = "scott"; 
           String password = "tiger"; 
    
           // Construct the JDBC URL 
           String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName; 
           return DriverManager.getConnection(dbURL, userName, password); 
       } 
    
       /** 
        * Close the database connection 
        * @param con 
        */ 
       private void closeConnection(Connection con) { 
           try { 
               con.close(); 
           } catch (SQLException e) { 
              System.err.println("Cannot close connection: " + e.getMessage()); 
          } 
      } 
  }