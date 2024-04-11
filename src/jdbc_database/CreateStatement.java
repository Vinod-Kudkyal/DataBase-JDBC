package jdbc_database;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {
	public static void main(String[] args) {
		try {
			Connection con = null;
			Statement st = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			st = con.createStatement();
			//rs = st.executeUpdate("create table army(id number , name varchar(20) , addr varchar(25) )");
			//if(rs == 1)
			//{
			//	System.out.println("Table Created");
			//}
			//else
			//{
			//	System.out.println("The Table Already Exist");
			//}
			int r = st.executeUpdate("insert into army values(2,'sonu','solapur')");
			System.out.println(r+" Record Inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
