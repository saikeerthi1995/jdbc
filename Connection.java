package jdbc;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Connection {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		java.sql.Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","keerthi","oracle");

		Statement st1 = con.createStatement();



		Scanner s = new Scanner(System.in);

		System.out.print("Enter studentId : ");
		int sid = s.nextInt();
		
		System.out.print("Enter studentname  : ");
		String sname = s.next();

		System.out.print("Enter student course : ");
		String scourse = s.next();
		System.out.println();


		/*
		"insert into student values (106, 'Sree', 'Oracle');"
		"insert into student values ("+Sno+", 'Sree', 'Oracle');"
		"insert into student values ("+Sno+", '"+sname+"', 'Oracle');"
		"insert into student values ("+Sno+", '"+sname+"', '"+course+"');"
		*/

		String query1 = "insert into student values("+sid+",'"+sname+"','"+scourse+"')";

		int i = st1.executeUpdate(query1);

		if(i!=0)
		{
			System.out.println("Record Inserted Successfully...");
		}
		else
		{
			System.out.println("Record Insertion Failed...");
			return;
		}
		System.out.println("\n");
	  st1.close();

		/***************************************************/
		
		Statement st2 = con.createStatement();
		ResultSet rs2 = st2.executeQuery("select * from students");
		
		while(rs2.next())
		{
			System.out.println(rs2.getInt(1) + " " + rs2.getString(2) + 
				" " + rs2.getString(3));
		}
		System.out.println();
		rs2.close();
		st2.close();
		con.close();
	}
}
