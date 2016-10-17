package jdbc;

import java.sql.*;
public class Create {

java.sql.Connection con;
Create()
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","keerthi","oracle");
PreparedStatement ps=con.prepareStatement("create table student(sId int primary key,sName VARCHAR(30) not null,course varchar2(10) not null )");
int count=ps.executeUpdate();//returns 0
System.out.println(count);
}catch(Exception e)
{
e.printStackTrace();
}
}
public static void main(String s[])
{
new Create();
}
}