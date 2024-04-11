package jdbc_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ComboCrudOprations1
{
	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String userName = "system";
	public static String password = "root";
	public static String createQuery = "create table clinic(tokenNo number Primary Key , pname varchar(30) , age number , problem varchar(20))";
	public static String selectQuery = "select * from clinic";
	
	public static void main(String[] args)
	{
		Connection con = null;
		Statement st = null;
		PreparedStatement pst = null;
		Scanner sc = new Scanner(System.in);
		String sql = null;
		String name , prob;
		int r , token , age ;
		
		while(true) 
		{
			try
			{
				System.out.println("********** Clinic **********");
				System.out.println("1. Create Table \n2. Insert Record \n3. Update Record \n4. Delete Record \n5. Display Record");
				System.out.println("Enter Your Choice -");
				int choice = sc.nextInt();
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, userName, password);
				st = con.createStatement();
				
				switch(choice)
				{
					case 1:
						try
						{
							st.executeUpdate(createQuery);
							System.out.println("Table Created");
						} catch (SQLException e)
						{
							System.out.println("Table Already Exists");
						}
						break;
						
					case 2:
						System.out.println("Enter Token Number");
						token = sc.nextInt();
						System.out.println("Enter Patient Name");
						name = sc.next();
						System.out.println("Enter Patient Age");
						age = sc.nextInt();
						System.out.println("Enter Problem");
						prob = sc.next();
						sql = "insert into clinic values(? , ? , ?)";
						pst = con.prepareStatement(sql);
						pst.setInt(1, token);
						pst.setString(2, name);
						pst.setInt(3, age);
						pst.setString(4, prob);
						r = pst.executeUpdate();
						System.out.println(r+" Record Inserted");
						break;
						
					case 3:
						System.out.println("1. To Change Patient Name \n2. To Change Patient Age\n3. To Change Problem");
						System.out.println("Enter Your Choiec -");
						int c = sc.nextInt();
						
						switch(c)
						{
							case 1:
								System.out.println("Enter Token No. To change Patient Name");
								token = sc.nextInt();
								System.out.println("Enter New Patient Name");
								name = sc.next();
								sql = "update clinic set pname = ? where tokenNo = ?";
								pst = con.prepareStatement(sql);
								pst.setString(1, name);
								pst.setInt(2, token);
								r = pst.executeUpdate();
								System.out.println(r+" Record Updated");
								break;
							case 2:
								System.out.println("Enter Token No. To change Patient Age");
								token = sc.nextInt();
								System.out.println("Enter New Age Of Patient");
								age = sc.nextInt();
								sql = "update clinic set age = ? where tokenNo = ?";
								pst = con.prepareStatement(sql);
								pst.setInt(1, age);
								pst.setInt(2, token);
								r = pst.executeUpdate();
								System.out.println(r+" Record Updated");
								break;
							case 3:
								System.out.println("Enter Token No. To change Patient Problem");
								token = sc.nextInt();
								System.out.println("Enter New Problem Of Patient");
								age = sc.nextInt();
								sql = "update clinic set age = ? where tokenNo = ?";
								pst = con.prepareStatement(sql);
								pst.setInt(1, age);
								pst.setInt(2, token);
								r = pst.executeUpdate();
								System.out.println(r+" Record Updated");
								break;
						}
					break;
					
					case 4:
						System.out.println("Enter Token No. To Delete Patient Record");
						token = sc.nextInt();
						sql = "delete from clinic where tokenNo = ?";
						pst = con.prepareStatement(sql);
						pst.setInt(1, token);
						r = pst.executeUpdate();
						System.out.println(r+" Record Deleted");
					break;
					
					case 5:
						System.out.println("1. Search By Token No.\n2. Search By Patient Name\n3. View Entier Table");
						System.out.println("Enter Your Choiec -");
						int c1 = sc.nextInt();
						switch(c1)
						{
							case 1:
								System.out.println("Enter Token NO");
								token = sc.nextInt();
								sql = "select * from clinic where tokenNo = ?";
								pst = con.prepareStatement(sql);
								pst.setInt(1, token);
								ResultSet rs = pst.executeQuery();
								while(rs.next())
								{
									System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
								}
							break;
							case 2:
								System.out.println("Enter Patient Name");
								name = sc.next();
								sql = "select * from clinic where pname = ?";
								pst = con.prepareStatement(sql);
								pst.setString(1, name);
								ResultSet rs1 = pst.executeQuery();
								while(rs1.next())
								{
									System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getInt(3)+"  "+rs1.getString(4));
								}
							break;
							case 3:
								ResultSet rs2 = st.executeQuery(selectQuery);
								while(rs2.next())
								{
									System.out.println(rs2.getInt(1)+"  "+rs2.getString(2)+"  "+rs2.getInt(3)+"  "+rs2.getString(4));
								}
							break;
						}
						break;
						
						default :
							System.out.println("Invalid Choiec \nEnter Valid Choiec");
				}
			} catch (ClassNotFoundException e) {
				e.getMessage();
			} catch (SQLException e) {
				e.getMessage();
			} catch (Exception e) {
				e.getMessage();
			} finally {
				sc.close();
				
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
			}
		}
	}
}