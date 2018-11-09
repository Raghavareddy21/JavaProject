package faculty;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

import functions.Functions;
import functions.Session;
import student.Person;
import student.StudentSignup;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultyHome extends Person{

	public JFrame frmHome;
	private JTextField rollno;
	private JPasswordField passwordField;
	private JTable table;
	private String FullName;
	private String Username;
	private String ID;
	private String Gender;
	private String Password;
	private String DOB;
	private String Mail;
	private String Phone;
	private String Qualifications;
	private String Branch;
	private String DOE;
	private String Status;
	private JLabel name;
	private JLabel user;
	private JLabel id_1;
	private JLabel gen;
	private JLabel age;
	private JLabel mail_1;
	private JLabel sub;
	private JLabel addr;
	private JLabel phone;
	private JLabel name1;
	private JComboBox comboBox;
	private JTextField Att;
	private JPanel a;
	private JLabel pic;
	private JTextField Rollnumber;

	public FacultyHome(String Name,String Gender,String Dob,String mail,int Phone,String Address,String Doe,String status,String username,String password,String id,String qual,String branch) throws SQLException {
		super(Name,Gender,Dob,mail, Phone, Address, Doe,status);
		this.Username=username;
		this.Password=password;
		this.ID=id;
		this.Qualifications=qual;
		this.Branch=branch;
		initialize();
		Functions.Setup();
		SetLables();
	}
	public void SetLables()  {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Faculty WHERE Username='"+Session.username+"' AND Password='"+Session.password+"';";
		
		ResultSet rs=stmt.executeQuery(str);
		 	rs.next();
			 name.setText(rs.getString("FullName"));
				user.setText(rs.getString("Username"));
				id_1.setText(rs.getString("IDNumber"));
				gen.setText(rs.getString("Gender"));
				mail_1.setText(rs.getString("Mail"));
				sub.setText(rs.getString("Branch"));
				addr.setText(rs.getString("Address"));
				phone.setText(rs.getString("Phone"));
				name1.setText(rs.getString("FullName"));
				pic.setIcon(new ImageIcon(rs.getString("pic")));
		}
		catch(Exception e){
			System.out.println(e);}
		
		
	}

	


	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyHome window = new FacultyHome();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public FacultyHome() {
		super();
		
		initialize();
		SetLables();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setForeground(Color.WHITE);
		frmHome.setTitle("Home");
		frmHome.setBackground(Color.RED);
		frmHome.getContentPane().setBackground(Color.BLACK);
		frmHome.setBounds(100, 100, 1013, 557);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.CYAN);
		GroupLayout groupLayout = new GroupLayout(frmHome.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 26, 965, 479);
		desktopPane.add(tabbedPane);
		
		a = new JPanel();
		a.setBackground(Color.WHITE);
		tabbedPane.addTab("Faculty Details", null, a, null);
		tabbedPane.setBackgroundAt(0, Color.YELLOW);
		
		JLabel lblName = new JLabel("Name:");
		
		name = new JLabel("New label");
		
		JLabel lblUsername = new JLabel("Username:");
		
		user = new JLabel("New label");
		
		JLabel lblRollNumber = new JLabel("ID Number:");
		
		id_1 = new JLabel("New label");
		
		JLabel lblNewLabel_4 = new JLabel("Gender:");
		
		JLabel lblNewLabel_5 = new JLabel("Age:");
		
		JLabel lblMail = new JLabel("Mail:");
		
		JLabel lblPhoneNember = new JLabel("Phone Nember:");
		
		JLabel lblAddress = new JLabel("Address:");
		
		gen = new JLabel("New label");
		
		age = new JLabel("New label");
		
		mail_1 = new JLabel("New label");
		
		phone = new JLabel("New label");
		
		addr = new JLabel("New label");
		
		JButton btnSettings = new JButton("Settings");
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.dispose();
				Functions.logout();
			}
		});
		
		JLabel lblSubject = new JLabel("Subject:");
		
		sub = new JLabel("New label");
		
		JButton btnStudentSignup = new JButton("Student Signup");
		btnStudentSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSignup ss =new StudentSignup();
				ss.frmStudentSignup.setVisible(true);
				frmHome.dispose();
			}
		});
		
		pic = new JLabel("New label");
		GroupLayout gl_a = new GroupLayout(a);
		gl_a.setHorizontalGroup(
			gl_a.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_a.createSequentialGroup()
					.addGroup(gl_a.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_a.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_a.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblRollNumber)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblMail)
								.addComponent(lblPhoneNember)
								.addComponent(lblAddress)
								.addComponent(lblName))
							.addGap(18)
							.addGroup(gl_a.createParallelGroup(Alignment.LEADING, false)
								.addComponent(addr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(phone)
								.addComponent(mail_1)
								.addComponent(age)
								.addComponent(gen)
								.addComponent(id_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(user, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(name, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
							.addGap(27)
							.addComponent(lblSubject)
							.addGap(18)
							.addComponent(sub)
							.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
							.addComponent(pic, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_a.createSequentialGroup()
							.addContainerGap(596, Short.MAX_VALUE)
							.addComponent(btnStudentSignup)
							.addGap(18)
							.addComponent(btnSettings)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLogout)))
					.addGap(18))
		);
		gl_a.setVerticalGroup(
			gl_a.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_a.createSequentialGroup()
					.addGroup(gl_a.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_a.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
								.addComponent(name)
								.addComponent(lblSubject)
								.addComponent(sub)
								.addComponent(lblName))
							.addGap(18)
							.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername)
								.addComponent(user))
							.addGap(18)
							.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRollNumber)
								.addComponent(id_1))
							.addGap(18)
							.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(gen))
							.addGap(18)
							.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(age))
							.addGap(18)
							.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMail)
								.addComponent(mail_1)))
						.addGroup(gl_a.createSequentialGroup()
							.addGap(44)
							.addComponent(pic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNember)
						.addComponent(phone))
					.addGap(18)
					.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(addr, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_a.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSettings)
						.addComponent(btnLogout)
						.addComponent(btnStudentSignup))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		a.setLayout(gl_a);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Student Attendance Report", null, panel_2, null);
		
		JLabel lblRollNumber_1 = new JLabel("Roll Number:");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
				Statement stmt=con.createStatement();
				String str="SELECT * FROM Student WHERE RollNo='"+Rollnumber.getText()+"';";
					ResultSet rs=stmt.executeQuery(str);
					rs.next();
					String st="SELECT * FROM Faculty WHERE Username='"+Session.username+"';";
					ResultSet r=stmt.executeQuery(st);
					r.next();
					String br=r.getString("Branch");
					String s="INSERT INTO "+br+"Att"+"(RollNo,Attendance) VALUES('"+Integer.parseInt(Rollnumber.getText())+"','"+Integer.parseInt(Att.getText())+"');";
					int k=stmt.executeUpdate(s);
				}
			catch(Exception e1){
				System.out.println(e1);}
			}});
		
		JLabel lblAttendance = new JLabel("Attendance:");
		
		Att = new JTextField();
		Att.setColumns(10);
		
		JLabel lblAttendance_1 = new JLabel("Attendance");
		lblAttendance_1.setFont(new Font("Dialog", Font.BOLD, 24));
		
		Rollnumber = new JTextField();
		Rollnumber.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(301)
							.addComponent(btnSubmit))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAttendance)
								.addComponent(lblRollNumber_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Rollnumber)
								.addComponent(Att, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
					.addContainerGap(576, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(lblAttendance_1, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addGap(191))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(23)
							.addComponent(lblAttendance_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(lblRollNumber_1))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(Rollnumber, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(71)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAttendance)
						.addComponent(Att, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnSubmit)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Student Progress Card", null, panel_1, null);
		
		JLabel lblStudentRollNumber = new JLabel("Student Roll Number:");
		
		rollno = new JTextField();
		rollno.setColumns(10);
		
		JLabel lblFacultyPassword = new JLabel("Faculty Password:");
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_13 = new JLabel("Mark List:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setRowMargin(4);
		table.setRowHeight(50);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"SA-1", null, null, null},
				{"SA-2", null, null, null},
				{"Total", null, null, null},
			},
			new String[] {
				"Divison", "Internals", "Finals", "Total"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
					Statement stmt=con.createStatement();
					Statement stm=con.createStatement();
					String str="SELECT * FROM Faculty WHERE Username='"+Session.username+"' AND Password='"+Session.password+"';";
					ResultSet rs=stmt.executeQuery(str);
					 	rs.next();
					 	
					 	String ss="SELECT * FROM Student WHERE RollNo='"+rollno.getText()+"';";
					 	ResultSet r=stm.executeQuery(ss);
					 	
					 	if(r.next()) {
					 	String pass=passwordField.getText();
					 	String pas=rs.getString("Password");
					 	if(pas.compareTo(pass)==0){
					 	int SI=Integer.parseInt( table.getModel().getValueAt(0, 1).toString());
					 	
					 	int SF=Integer.parseInt( table.getModel().getValueAt(0, 2).toString());
					 	int AI=Integer.parseInt( table.getModel().getValueAt(1, 1).toString());
					 	int AF=Integer.parseInt( table.getModel().getValueAt(1, 2).toString());
					 	System.out.println("in table1");
					 	System.out.println(SF);
					 	int Id=Integer.parseInt(rollno.getText());
					 	System.out.println(rs.getString("Branch"));
					 	String st="INSERT INTO "+rs.getString("Branch")+"(Sa1Internal,Sa1Final,Sa2Internal,Sa2Final,SudentID) VALUES ('"+SI+"','"+SF+"','"+AI+"','"+AF+"','"+Id+"');";
					 	int count= stm.executeUpdate(st);
					}
					 	else{
					 		JOptionPane.showMessageDialog(null, "the password is wrong");}
					 	}
					 	else {
					 		JOptionPane.showMessageDialog(null, "No Student with roll number '"+rollno.getText()+"'");}
					 	}
					 	
					catch(Exception e1){
						System.out.println("shit");
						System.out.println(e1);}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(46)
							.addComponent(lblStudentRollNumber)
							.addGap(18)
							.addComponent(rollno, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(46)
							.addComponent(lblFacultyPassword)
							.addGap(39)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(46)
							.addComponent(lblNewLabel_13))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(109)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(170, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(714, Short.MAX_VALUE)
					.addComponent(btnSubmit_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblStudentRollNumber))
						.addComponent(rollno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblFacultyPassword))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_13)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnSubmit_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		panel_1.setLayout(gl_panel_1);
		
		String[] columns= {"Subject", "Semester1", "Semister2", "Results"};
		
		name1 = new JLabel("New label");
		name1.setBounds(838, 12, 70, 15);
		desktopPane.add(name1);
		frmHome.getContentPane().setLayout(groupLayout);
	
			}
}
