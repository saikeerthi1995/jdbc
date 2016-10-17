package jdbc;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		java.sql.Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","keerthi","oracle");

		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select * from student");

		System.out.println("Which Record You Want to Update");
		System.out.println("*******************************");
		while(rs1.next())
		{
			System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
		}
		System.out.println();
		rs1.close();
		st1.close();

		/**************************************************************/

		System.out.println("\n******************************************\n");

		String sname,course;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Student Number : ");
		int sid = s.nextInt();
		System.out.println();

		System.out.println("Select Your Choice");
		System.out.println("******************");
		System.out.println("1. Update Name");
		System.out.println("2. Update Course");
		System.out.println("3. Update Both");
		System.out.println();

		System.out.print("Enter Your Choice : ");
		int i = s.nextInt();
		System.out.println();
		
		Statement st2 = con.createStatement();
		switch(i)
		{
			case 1:
				System.out.print("Enter Student Name : ");
				sname = s.next();
			
				i = st2.executeUpdate("Update Student set sname = '" + sname + 
				"' where sid = " + sid);
			break;

			case 2:
				System.out.print("Enter Student Course : ");
				course = s.next();

				i = st2.executeUpdate("Update Student set course = '" + course + 
				"' where sid = " + sid);
			break;

			case 3:
				System.out.print("Enter Student Name   : ");
				sname = s.next();			
				System.out.print("Enter Student Course : ");
				course = s.next();

				i = st2.executeUpdate("Update Student set sname = '" + sname + 
							"', course = '" + course + "'where sid = " + sid);
			break;

			default: 
				i=0;
				System.out.println("Invalid Choice");
			break;
		}
		System.out.println();

		if(i!=0)
		{
			System.out.println("Record Updated Successfully...");
		}
		else
		{
			System.out.println("Record Updation Failed...");
			return;
		}
		System.out.println();
		st2.close();

		/**************************************************/
		System.out.println("\n******************************************\n");
		
		Statement st3 = con.createStatement();
		ResultSet rs3 = st3.executeQuery("select * from student where sid = " + sid);

		System.out.println("Updated Student Details");
		System.out.println("***********************");
		while(rs3.next())
		{
  		   System.out.println(
				"Student Number : " + rs3.getInt(1) + "\n"+
				"Student Name   : " + rs3.getString(2) + "\n"+
				"Student Course : " + rs3.getString(3));
		}
		System.out.println();
		rs3.close();
		st3.close();
		con.close();
	}
}
