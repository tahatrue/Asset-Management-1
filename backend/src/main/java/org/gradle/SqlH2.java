package org.gradle;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//import java.sql.ResultSet;
import java.sql.Statement;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.json.JSONException;
import java.sql.SQLException;
public class SqlH2 {
		
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "org.h2.Driver";
		static final String DB_URL = "jdbc:h2:~/test";

		// Database credentials
		static final String USER = "sa";
		static final String PASS = "";

		Connection conn = null;
		Statement statement = null;
		
		public void initializeConnections() {
			try {
				// STEP 2: Register JDBC driver
				Class.forName("org.h2.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to a selected database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connected database successfully...");
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
		}
		
		public void closeConnections() {
			try {
				if (statement != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // do nothing
			
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}

		public void createNewTable() {
			try {
				// Execute a query
				System.out.println("Creating table in given database...");
				statement = conn.createStatement();
				
				String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE "
						+ "(eid INT NOT NULL auto_increment,"
						+ "ename VARCHAR(255) NOT NULL,"
						+ "email VARCHAR(255) NOT NULL,"
						+ "Age INT NOT NULL,"
						+ "Sex VARCHAR(255) NOT NULL,"
						+ "PRIMARY KEY (eid)) AUTO_INCREMENT=1";
				statement.executeUpdate(sql);
				System.out.println("Created table in given database...");
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			}
		}
		
		public void insertRow(User user) {
			
			  try {
		          //STEP 4: Execute a query
		          System.out.println("Inserting records into the table...");
		          statement = conn.createStatement();

		          String sql = "INSERT INTO EMPLOYEE "
		          		+ "(eid,ename,email,Age,Sex)"
		          		+ "VALUES (" + "'" + user.geteId() +"'"
		          		+ ", " + "'" + user.geteName() +"'"
		          		+ ", " + "'" + user.getEmail() + "'"
		          		+ ", " + "'" + user.getAge() + "'"
		          		+ ", " + "'" + user.getSex() + "'"
		          		+ ")";

		          statement.executeUpdate(sql);

		          System.out.println("Inserted records into the table...");

		      } catch (SQLException se) {
		          //Handle errors for JDBC
		          se.printStackTrace();
		      } catch (Exception e) {
		          //Handle errors for Class.forName
		          e.printStackTrace();
		      }
		}
		public void Retrieve(User user) {
			
			  try {
		          //STEP 4: Execute a query
		          statement = conn.createStatement();

		          String sql = "SELECT * FROM EMPLOYEE";

		          statement.executeQuery(sql);
		          ResultSet rs=statement.executeQuery(sql);
		          ResultSetMetaData rsmd = rs.getMetaData();
		          System.out.println("");
		      
		          int numberOfColumns = rsmd.getColumnCount();

		          while (rs.next()) {
		              for (int i = 1; i <= numberOfColumns; i++) {
		                if (i > 1) System.out.print(",  ");
		                String columnValue = rs.getString(i);
		                System.out.print(columnValue);
		              }
		              System.out.println("");  
		          System.out.println("Retrieved records from the table...");
		          }
		      } catch (SQLException se) {
		          //Handle errors for JDBC
		          se.printStackTrace();
		      } catch (Exception e) {
		          //Handle errors for Class.forName
		          e.printStackTrace();
		      }
		}
		
		}
