import java.sql.Connection; 
    import java.sql.DriverManager; 
    import java.sql.SQLException;
    import java.sql.*;
     
    /** 
     * This is a simple example that demonstrates how to open a database 
     * connection before we are trying to execute SQL statements, and 
     * close a database connection when we are done. You can build your 
    * code using this example as a skeleton. 
    */ 
   public class Example1 { 
       public static void main(String args[]) { 
           Example1 example = new Example1(); 
           example.run(); 
       } 
    
       /** 
        * This is the skeleton code of database access 
        */ 
       public void run() { 
           Connection con = null; 
           try { 
               con = openConnection(); 
           } catch (SQLException e) { 
               System.err.println("Errors occurs when communicating with the database server: " + e.getMessage()); 
           } catch (ClassNotFoundException e) { 
               System.err.println("Cannot find the database driver"); 
           } finally { 
               // Never forget to close database connection 
               closeConnection(con); 
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