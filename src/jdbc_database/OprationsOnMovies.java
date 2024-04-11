package jdbc_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OprationsOnMovies 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement st = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			st = con.createStatement();
			int r = st.executeUpdate("insert into movie values(1 , 'Pushpa' , 'Arjun' , 'Ritika')");
			System.out.println(r+" row inserted");
			
			
			int r1 = st.executeUpdate("insert into movie values(2 , 'KGF' , 'Yash' , 'Shrinidhi')");
			System.out.println(r1+" row inserted");
			ResultSet rs = st.executeQuery("select * from movie");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
		    int r2 = st.executeUpdate("delete from movie");
			System.out.println(r2+" Records deleted");
			int r3 = st.executeUpdate("update movie set heroine='Rashmika' where heroine='Ritika'");
			System.out.println(r3+" Record Updated");
			ResultSet rs1 = st.executeQuery("select * from movie");
			while(rs1.next())
			{
				System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.cancel();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
