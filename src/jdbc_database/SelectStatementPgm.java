package jdbc_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatementPgm {
	public static void main(String[] args)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		if(con!=null) {
			System.out.println("Connection created succesfully");
		}else {
			System.out.println("Connection is not done");
		}
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee30");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		int r = st.executeUpdate("insert into employee30 values(2,'sonu','solapur','leader')");
		System.out.println(r+" Record Inserted");
		
		int r1 = st.executeUpdate("insert into employee30 values(3,'kanna','hydr','employee')");
		System.out.println(r1+" Record Inserted");
		
		//int r = st.executeUpdate("update ");
		//System.out.println(r+" Record Inserted");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
