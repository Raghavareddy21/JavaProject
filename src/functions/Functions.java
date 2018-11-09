package functions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import student.Login;

public class Functions {
public static ResultSet rs;
	public Functions() {
		// TODO Auto-generated constructor stub
	}
	public static boolean checkStudentLogin() {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Student WHERE Username='"+Session.username+"' AND Password='"+Session.password+"'";
		ResultSet rs=stmt.executeQuery(str);
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
		}
		catch(Exception e){ System.out.println(e);return false;}
	
	}
	public static boolean CheckFacultyLogin() {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Faculty WHERE Username='"+Session.username+"' AND Password='"+Session.password+"'";
		ResultSet rs=stmt.executeQuery(str);
		
		if(rs.next()) {
			return true;
		}
		else {
			return false;
			
		}
		}
		catch(Exception e){ System.out.println(e);return false;}
		
	}
	public static void logout() {
		Session.username=null;
		Session.password=null;
		Login l=new Login();
		l.frmLoginForm.setVisible(true);
		}
	public static ResultSet Setup() {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Student WHERE Username='"+Session.username+"' AND Password='"+Session.password+"'";
		return rs=stmt.executeQuery(str);
		
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}

	}
	public static int AVG(int[] arr) {
		return(arr[1]+arr[0])/2;
	}
	public static int[] Total(String str) {
		int arr[]=new int[2];
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
			Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(str);
		rs.next();
		arr[0]=((rs.getInt("Sa1Internal")+(rs.getInt("Sa1Final")))/2);
		arr[1]=(((rs.getInt("Sa2Internal"))+(rs.getInt("Sa2Final")))/2);
		return arr;
		}
		catch(Exception e){
			System.out.println(e);
			return arr;}
	}
}

