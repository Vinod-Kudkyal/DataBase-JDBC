package jdbc_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ComboCrudOprations 
{
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "system";
	private static String password = "root";
	
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			start:
			while(true) 
			{
				System.out.println("***********   CRUD Opration   ***********");
				System.out.println("1. Creat Table \n2. Insert Record \n3.Update Record \n4.Displya Record \n5 Delete Record");
				System.out.println("Enter Your Choice :-");
				int choice = sc.nextInt();
			
				switch(choice) 
				{
					case 1:
						try {
						st.executeUpdate("Create table (Rno number Primary Key , name varchar(20) Not Null , addr varchar(30) , branch varchar(20))");
						System.out.println("Table Created");
					} catch (SQLException e) {
						System.out.println("Table Is Already Created");
					}
					break;
					
					case 2:
						try {
							int r = st.executeUpdate("insert into GPSIF values(1 , 'ABC' , 'solapur' , 'IF')");
							System.out.println(r+" Record Inserted");
						} catch(SQLException e) {
							e.getMessage();
						}
					break;
					
					case 3:
						try  {
							int r1 = st.executeUpdate("update GPSIF set branch = 'CM' Where Rno = 1");
							System.out.println(r1+" Rercord Updated");
						} catch (SQLException e) {
							e.getMessage();
						}
					break;
					
					case 4:
						try {
							rs = st.executeQuery("Select * from GPSIF");
							while(rs.next()) {
								System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
							}
						} catch(SQLException e) {
							e.getMessage();
						}
					break;
					
					case 5:
						try {
							int r3 = st.executeUpdate("delete from GPSIF where Rno = 1");
							System.out.println(r3+" Record Deleted");
						} catch(SQLException e) {
							e.getMessage();
						}
					break;
					
					default:
						System.out.println("Invalid Choice!! \n Enter Valid Choice");
				}
				System.out.println("Do You Want To Continue (Y/N)");
				String nextOption = sc.next();
				if("N".equalsIgnoreCase(nextOption)) {
					break start;
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
