package jdbc;
import java.sql.*;
import java.util.Scanner;

public class Delete {


	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		java.sql.Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","keerthi","oracle");

		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select * from student");

		System.out.println("Which Record You Want to Delete");
		System.out.println("*******************************");
		while(rs1.next())
		{
			System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + 
				" " + rs1.getString(3));
		}
		System.out.println();
		rs1.close();
		st1.close();

		/**************************************************************/
		System.out.println("\n****************************************\n");

		Scanner s = new Scanner(System.in);
		System.out.print("Enter Student Number : ");
		int sid = s.nextInt();
		System.out.println();

		Statement st2 = con.createStatement();
		boolean b = st2.execute("Delete from Student Where Sid = " + sid);
		
		//System.out.println("\n\nBoolean Value = " + b + "\n\n");
		
		if(!b)
		{
			System.out.println("Record(s) Deleted Successfully...");
		}
		else
		{
			System.out.println("Record(s) Deletion Failed...");
			return;
		}
		System.out.println();
		st2.close();

		/**************************************************/


		/**************************************************/
		System.out.println("\n******************************************\n");
		
		Statement st3 = con.createStatement();
		ResultSet rs3 = st3.executeQuery("select * from student");

		System.out.println("Records in the Table are");
		System.out.println("************************");
		while(rs3.next())
		{
			System.out.println(rs3.getInt(1) + " " + rs3.getString(2) + 
				" " + rs3.getString(3));
		}		
		System.out.println();
		rs3.close();
		st3.close();
		con.close();
	}
}

