package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
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

import functions.Functions;
import functions.Session;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StudentHome extends Person{

	public JFrame frmHome;
	private JTable table;
	private int RollNo;
	private String Username;
	private String Password;
	private String Gender;
	private String DOB;
	private String Mail;
	private int Phone;
	private String Clas;
	private String Address;
	private String Branch;
	private String Program;
	private String DOE;
	private String Status;
	private JLabel name;
	private JLabel user;
	private JLabel clas;
	private JLabel roll;
	private JLabel name1;
	private JLabel addr;
	private JLabel phone;
	private JLabel mail_1;
	private JLabel gender;
	private JLabel pic;
	private JComboBox comboBox;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome window = new StudentHome();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentHome(String Name,String Gender,String Dob,String mail,int Phone,String Address,String Doe,String status,String username,String password,int id,String prog,String branch,String Class) {
		super(Name,Gender,Dob,mail, Phone, Address, Doe,status);
		this.Username=username;
		this.Password=password;
		this.RollNo=id;
		this.Program=prog;
		this.Clas=Class;
		this.Branch=branch;
		initialize();
	}
	public void SetLables()  {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
		Statement stmt=con.createStatement();
		String str="SELECT * FROM Student WHERE Username='"+Session.username+"' AND Password='"+Session.password+"';";
		
		ResultSet rs=stmt.executeQuery(str);
		 	rs.next();
		 	name.setText(rs.getString("FullName"));
			user.setText(rs.getString("Username"));
			roll.setText(rs.getString("RollNo"));
			clas.setText(rs.getString("Class"));
			gender.setText(rs.getString("Gender"));
			mail_1.setText(rs.getString("Mail"));
			addr.setText(rs.getString("Address"));
			phone.setText(rs.getString("Phone"));
			name1.setText(rs.getString("FullName"));
			pic.setIcon(new ImageIcon(rs.getString("pic")));


		}
		catch(Exception e){
			System.out.println(e);}
		
		
	}
	public StudentHome() {
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Student Details", null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.YELLOW);
		
		pic = new JLabel("New label");
		
		
		JLabel lblName = new JLabel("Name:");
		
		name = new JLabel("New label");
		
		JLabel lblUsername = new JLabel("Username:");
		
		user = new JLabel("New label");
		
		JLabel lblRollNumber = new JLabel("Roll Number:");
		
		roll = new JLabel("New label");
		
		JLabel lblNewLabel_4 = new JLabel("Gender:");
		
		JLabel lblMail = new JLabel("Mail:");
		
		JLabel lblPhoneNember = new JLabel("Phone Nember:");
		
		JLabel lblAddress = new JLabel("Address:");
		
		gender = new JLabel("New label");
		
		mail_1 = new JLabel("New label");
		
		phone = new JLabel("New label");
		
		addr = new JLabel("New label");
		
		JButton btnSettings = new JButton("Settings");
		
		JLabel lblClass = new JLabel("Class:");
		
		clas = new JLabel("New label");
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.dispose();
				Functions.logout();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnSettings)
									.addGap(77)
									.addComponent(btnLogout)
									.addGap(149))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblName)
														.addComponent(lblClass))
													.addGap(82)
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(clas)
														.addComponent(user, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
														.addComponent(name, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
												.addComponent(lblUsername))
											.addGap(161))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblRollNumber)
												.addComponent(lblNewLabel_4)
												.addComponent(lblMail)
												.addComponent(lblPhoneNember)
												.addComponent(lblAddress))
											.addGap(18)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(addr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(phone)
												.addComponent(mail_1)
												.addComponent(gender)
												.addComponent(roll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(297)))
									.addGap(265)))
							.addGap(186))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(pic, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(name))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername)
								.addComponent(user))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(clas)
								.addComponent(lblClass))
							.addGap(52)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblRollNumber)
										.addComponent(roll))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(gender))
									.addGap(51)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblMail)
										.addComponent(mail_1))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPhoneNember)
										.addComponent(phone))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAddress)
										.addComponent(addr, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(269)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSettings)
										.addComponent(btnLogout)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(pic, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Attendance", null, panel_2, null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Hindi", "Maths", "Science", "Social Studies"}));
		
		JLabel Att = new JLabel("90%");
		Att.setFont(new Font("Dialog", Font.BOLD, 64));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sub=comboBox.getSelectedItem().toString();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
					Statement stmt=con.createStatement();
					String st="SELECT * FROM Student WHERE Username='"+Session.username+"';";
					ResultSet rs=stmt.executeQuery(st);
					int ro=rs.getInt("RollNo");
					String ss="SELECT FROM "+Sub+"Att"+" WHERE RollNo='"+ro+"';";
					int f=stmt.executeUpdate(ss);
					Att.setText(f+"");
					}
					catch(Exception e1){
						System.out.println(e1);}
				}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(29)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(672, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(282, Short.MAX_VALUE)
					.addComponent(Att, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(709, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(134))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(Att, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Acadamic Details", null, panel_1, null);
		
		JLabel lblNewLabel_12 = new JLabel("Total CGPA:");
		
		JLabel lblNewLabel_13 = new JLabel("9");
		String[] columns= {"Subject", "Semester1", "Semister2", "Results"};
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 870, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_12)
							.addGap(18)
							.addComponent(lblNewLabel_13)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_12)
						.addComponent(lblNewLabel_13))
					.addGap(76)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		table.setName("Acadadmic Scores");
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		try {
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
				Statement stmt=con.createStatement();
				String s="SELECT RollNo FROM Student WHERE Username='"+Session.username+"'";
				Statement st=con.createStatement();
				ResultSet r=st.executeQuery(s);
				r.next();				
				String Math="SELECT * FROM Maths WHERE SudentID='"+r.getInt("RollNo")+"'";
				ResultSet Mathrs= stmt.executeQuery(Math);
				Mathrs.next();
				int mar[]=new int[2];
				mar[0]=((Mathrs.getInt("Sa1Internal")+(Mathrs.getInt("Sa1Final")))/2);
				mar[1]=(((Mathrs.getInt("Sa2Internal"))+(Mathrs.getInt("Sa2Final")))/2);
				
				
				String Social="SELECT * FROM Social WHERE SudentID='"+r.getInt("RollNo")+"'";
				ResultSet Socialrs= stmt.executeQuery(Social);
				Socialrs.next();
				String  Hindi="SELECT * FROM Hindi WHERE SudentID='"+r.getInt("RollNo")+"'";
				ResultSet Hindirs= stmt.executeQuery(Hindi);
				Hindirs.next();
				String English="SELECT * FROM English WHERE SudentID='"+r.getInt("RollNo")+"'";
				ResultSet Englishrs= stmt.executeQuery(English);
				Englishrs.next();
				String Science="SELECT * FROM Science WHERE SudentID='"+r.getInt("RollNo")+"'";
				ResultSet Sciencers= stmt.executeQuery(Science);
				Sciencers.next();
				int sar[]=Functions.Total(Social);
				int scar[]=Functions.Total(Science);
				int har[]=Functions.Total(Hindi);
				int ear[]=Functions.Total(English);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"English", ear[0], ear[1], Functions.AVG(ear)},
				{"Hindi", har[0], har[1], Functions.AVG(har)},
				{"Maths", mar[0], mar[1], Functions.AVG(mar)},
				{"Science", scar[0], scar[1], Functions.AVG(scar)},
				{"Social Studies", sar[0],sar[1], Functions.AVG(sar)},
			},
			new String[] {
				"Subject", "Semester1", "Semister2", "Results"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		}
		
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(112);
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(87);
		table.getColumnModel().getColumn(3).setPreferredWidth(83);
		}
		catch(Exception e){
			System.out.println(e);}

		panel_1.setLayout(gl_panel_1);
		
		name1 = new JLabel("New label");
		name1.setBounds(838, 12, 70, 15);
		desktopPane.add(name1);
		frmHome.getContentPane().setLayout(groupLayout);
	}
	
}
