package student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import functions.Session;
 
class JDBCTest {
	
	public static void main(String args[]){

		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT FullName FROM Faculty WHERE Username = 'raghava' AND Password = 'raghava';";
		 ResultSet rs=stmt.executeQuery(str);
		 if(rs.next()) {
			 System.out.println(rs.getString("FullName"));
			
		 }else {
			 System.out.println("null");
		 }
			System.out.println(rs.getString("FullName"));

		}
		catch(Exception e){
			System.out.println(e);}
	}
}
