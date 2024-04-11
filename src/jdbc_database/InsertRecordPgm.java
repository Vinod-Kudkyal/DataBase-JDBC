package jdbc_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecordPgm 
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
			
			int r = st.executeUpdate("insert into movie values(1 , 'Pushpa' , 'Arjun' , 'Ritika')");
			System.out.println(r+" row inserted");
			
			int r1 = st.executeUpdate("insert into movie values(2 , 'KGF' , 'Yash' , 'Shrinidhi')");
			System.out.println(r1+" row inserted");
			
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
