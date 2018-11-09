package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.PreparedStatement;

import faculty.FacultyHome;
import faculty.Principal;

import functions.Session;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frmLoginForm;
	private static JTextField user;
	private static JPasswordField pass;
	Connection con = null;
	java.sql.PreparedStatement pst = null;
	ResultSet rs = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginForm.setVisible(true);
					Check(user.getText(),pass.getPassword().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.setTitle("Login Form");
		frmLoginForm.setBounds(100, 100, 450, 300);
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("                 Login                     ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Check(user.getText(),pass.getText().toString())) {
				Principal s=new Principal();
				s.frame.setVisible(true);
				frmLoginForm.dispose();
				}
				else if(CheckFaculty(user.getText(),pass.getText().toString())){				
					FacultyHome FH= new FacultyHome();
					FH.frmHome.setVisible(true);
					frmLoginForm.dispose();
				}
				else if(CheckStudent(user.getText(),pass.getText().toString())){
					StudentHome SH = new StudentHome();
					SH.frmHome.setVisible(true);
					frmLoginForm.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or password wrong");
				}
			}	
		});
		
		JLabel lblNewLabel = new JLabel("Username:");
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		
		JLabel lblLoginForm = new JLabel("Login Form");
		
		user = new JTextField();
		user.setColumns(10);
		
		pass = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frmLoginForm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addComponent(lblLoginForm)
					.addGap(174))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pass, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(61, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(lblLoginForm)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnNewButton)
					.addGap(86))
		);
		frmLoginForm.getContentPane().setLayout(groupLayout);
	}
	private static boolean Check(String name,String password) {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Principal WHERE Username='"+name+"' AND Password='"+password+"'";
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
	private static boolean CheckFaculty(String name,String password) {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Faculty WHERE Username='"+name+"' AND Password='"+password+"'";
		ResultSet rs=stmt.executeQuery(str);
		
		if(rs.next()) {
			Session.Setuser(name,password);
			return true;
		}
		else {
			
			return false;
			
		}
		}
		catch(Exception e){ System.out.println(e);return false;}
		
	}
	private static boolean CheckStudent(String name,String password) {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Student WHERE Username='"+name+"' AND Password='"+password+"'";
		ResultSet rs=stmt.executeQuery(str);
		if(rs.next()) {
				
			Session.username=name;
			Session.password=password;
			return true;
		}
		else {
			
			return false;
		}
		}
		catch(Exception e){ System.out.println(e);return false;}
	}
}
