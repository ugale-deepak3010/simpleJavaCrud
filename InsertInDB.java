import java.sql.*;
import java.util.Scanner;
import java.lang.*;

//only for displaying ..
public class InsertInDB
{
	public static void main(String args[])
	{
		/*
		// if different credentials remove multiline comments..
		String JDBC_DRIVER="";
		String DB_URL="";
		String DB_USER="";
		String DB_PASS="";
		*/
		Scanner sc=new Scanner(System.in);
		
		String My_sql_command;//storing user query..
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//only D capital for mysql
			
			
			System.out.println("Connecting Database...");
			Connection conDB=DriverManager.getConnection("jdbc:mysql://localhost:3306/java2","root","");
			//create object,, path,user,password..
			
			System.out.println("creating statement...");
			Statement stmtDB=conDB.createStatement();
			
			
			
			System.out.println("please enter Query \n SELECT id, first, last, age FROM Employees; \n >>");
			 My_sql_command=sc.nextLine();//i will check difference later..
			//here are fault......
			//next() not accept space after value..
			
			//My_sql_command="SELECT id, first, last, age FROM Employees";
			
			
			
			
			ResultSet rs=stmtDB.executeQuery(My_sql_command);
			
			while(rs.next())//whenever value is present checking..
			{
				//getting value
				int id=rs.getInt("id");//column name
				int age=rs.getInt("age");
				String firstName=rs.getString("first");
				String lastName=rs.getString("last");
				//displaying value
				System.out.println("id=="+id);
				System.out.println("age=="+age);
				System.out.println("firstName=="+firstName);
				System.out.println("lastName=="+lastName);
				System.out.println("\n");
			}
			
			//closing all objects..
			sc.close();
			
			conDB.close();
			stmtDB.close();
			rs.close();
			
		}
		catch(SQLException se)
		{
			System.out.println("errrrorr="+se);
		}
		catch(Exception e)//always Exception calling last position catch because it hold all types Exception and
		//later defined catch block not accept...
		{
			System.out.println("Exceptionnnnnnnnnnnn="+e);
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Goodbye!");
		}
	}
}