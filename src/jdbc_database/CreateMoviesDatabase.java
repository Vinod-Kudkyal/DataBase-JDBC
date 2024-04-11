package jdbc_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMoviesDatabase 
{
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "system";
	private static String password = "root";
	
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement st = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url , username , password);
			st = con.createStatement();
			try {
			st.executeUpdate("create table movie1(srno number , movieName varchar(30) , hero varchar(15) , heroine varchar(15) )");
			} catch (SQLException e) {
				System.out.println("Table Already Exists");
			}
			//if(ir == 2) {
			//	System.out.println("Table Create");
			//}
			//else {
			//	System.out.println("Table Already Exists");
			//}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
