package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import org.jdatepicker.util.JDatePickerUtil;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.DateModel;
import java.util.Properties;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.demo.DateChooserPanelBeanInfo;

import faculty.FacultyHome;
import faculty.Principal;

import functions.Functions;
import functions.Session;

import java.awt.Choice;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class StudentSignup {

	public JFrame frmStudentSignup;
	private JTextField username;
	private JTextField fullname;
	private JTextField roll;
	private JPasswordField passwordField;
	private JTextField mailid;
	private JTextField phone;
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private String Label;
	private JDateChooser dateChooser;
	private JTextField Addres;
	private JComboBox box1;
	private JComboBox AP;
	private JComboBox ES;
	private JComboBox box2;
	private JDateChooser DOE_1;
	private JFileChooser fileChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSignup window = new StudentSignup();
					window.frmStudentSignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentSignup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentSignup = new JFrame();
		frmStudentSignup.getContentPane().setBackground(Color.DARK_GRAY);
		frmStudentSignup.setBackground(Color.PINK);
		frmStudentSignup.setTitle("Student Signup");
		frmStudentSignup.setBounds(100, 100, 660, 626);
		frmStudentSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentSignup.getContentPane().setLayout(null);
		
		JLabel lblStudentSignup = new JLabel("Student Signup");
		lblStudentSignup.setForeground(Color.WHITE);
		lblStudentSignup.setBounds(277, 12, 110, 15);
		frmStudentSignup.getContentPane().add(lblStudentSignup);
		lblStudentSignup.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 400, 620, 165);
		frmStudentSignup.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Acadamic Program:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Joining Year:");
		
		JLabel lblDateOfEnrollment = new JLabel("Date Of Enrollment:");
		
		DOE_1 = new JDateChooser();
		
		JYearChooser Year = new JYearChooser();
		
		JLabel lblEnrollmentStatus = new JLabel("Enrollment Status:");
		
		AP = new JComboBox();
		AP.setModel(new DefaultComboBoxModel(new String[] {"Schooling", "Intermdediate", "B.tech", "Arts and Science", "M.tech"}));
		
		ES = new JComboBox();
		ES.setModel(new DefaultComboBoxModel(new String[] {"Enroled", "Not Enroled"}));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Signup();
				frmStudentSignup.dispose();
				Functions.logout();
			}

			
		});
		
		JLabel lblBranch = new JLabel("Branch:");
		
		box2 = new JComboBox();
		box2.setModel(new DefaultComboBoxModel(new String[] {"CSE", "ECE ", "Mechanical", "EEE"}));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Functions.checkStudentLogin()) {
					StudentHome st=new StudentHome();
					st.frmHome.setVisible(true);
					frmStudentSignup.dispose();
				}
				else if(Functions.CheckFacultyLogin()) {

					FacultyHome st;
					st = new FacultyHome();
					st.frmHome.setVisible(true);
					frmStudentSignup.dispose();
					
				}
				else {
					Principal p=new Principal();
					p.frame.setVisible(true);
					frmStudentSignup.dispose();
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblDateOfEnrollment)
						.addComponent(lblEnrollmentStatus))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(ES, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSubmit))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(AP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblBranch)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(box2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addComponent(DOE_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addComponent(Year, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(AP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBranch)
						.addComponent(box2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(Year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDateOfEnrollment)
						.addComponent(DOE_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnrollmentStatus)
						.addComponent(ES, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnBack))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 308, 5, 7);
		frmStudentSignup.getContentPane().add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(12, 12, 620, 363);
		frmStudentSignup.getContentPane().add(tabbedPane_1);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Student Details", null, panel, null);
		panel.setBackground(Color.WHITE);
		
		JLabel lblName = new JLabel("Username:");
		
		JLabel lblRollNo = new JLabel("Roll No:");
		
		JLabel lblNewLabel = new JLabel("Gender:");
		
		JLabel lblNewLabel_1 = new JLabel("Date Of Birth");
		
		username = new JTextField();
		username.setColumns(10);
		
		JLabel lblLastName = new JLabel("Full Name:");
		
		fullname = new JTextField();
		fullname.setColumns(10);
		
		roll = new JTextField();
		roll.setColumns(10);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Label="Male";
				
			}
		});
		buttonGroup.add(Male);
		
		JRadioButton Female = new JRadioButton("Female");
		Female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Label="Female";
				
			}
		});
		buttonGroup.add(Female);
		
		JRadioButton Other = new JRadioButton("Other");
		Other.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Label="Other";
				
			}
		});
		buttonGroup.add(Other);
		
		dateChooser = new JDateChooser();
		
		JLabel lblPassword = new JLabel("Password:");
		
		passwordField = new JPasswordField();
		
		JLabel lblGmailId = new JLabel("Mail ID:");
		
		mailid = new JTextField();
		mailid.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		
		phone = new JTextField();
		phone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		
		JLabel lblSection = new JLabel("Class:");
		
		box1 = new JComboBox();
		box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		box1.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th"}));
		
		Addres = new JTextField();
		Addres.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRollNo)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblGmailId)
						.addComponent(lblPhoneNumber)
						.addComponent(lblSection))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(roll)
								.addComponent(username, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLastName)
								.addComponent(lblPassword))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(12)
									.addComponent(fullname, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Male)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Female)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Other))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(mailid, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
									.addComponent(phone, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(box1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)))
							.addGap(6)
							.addComponent(lblAddress)
							.addGap(19)
							.addComponent(Addres, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName)
						.addComponent(fullname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRollNo)
								.addComponent(roll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(Male)
								.addComponent(Female)
								.addComponent(Other))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(14)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1)
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblGmailId)
										.addComponent(mailid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPhoneNumber)
										.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(Addres, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAddress))))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSection)
								.addComponent(box1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(82, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Picture", null, panel_2, null);
		
		fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_2.add(fileChooser);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}
	public void Signup() {
		
		 String RollNo=roll.getText();
		 String Fullname=fullname.getText();
		 String Username=username.getText();
		 String Password=passwordField.getText();
		 String Gender=Label;
		 String DOB=dateChooser.getDate().toString();
		 String Mail=mailid.getText();
		 int Phone=Integer.parseInt(phone.getText());
		 String Class=box1.getSelectedItem().toString();
		 String Address=Addres.getText();
		 String Branch=box2.getSelectedItem().toString();
		 String Program=AP.getSelectedItem().toString();
		 String DOE=DOE_1.getDate().toString();
		 String Status=ES.getSelectedItem().toString();
		 int r = fileChooser.showOpenDialog(null);
		 String s;
		
			  s = fileChooser.getSelectedFile().getAbsolutePath();
		    
		 try {
			 
				Connection con = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
				Statement stmt=con.createStatement();
				String str="INSERT INTO Student (RollNo,Username,FullName,Password,Gender,DOB,Mail,Phone,Class,Address,Program,Branch,DOE,Status,pic) VALUES ('"+RollNo+"','"+Username+"','"+Fullname+"','"+Password+"','"+Gender+"','"+DOB+"','"+Mail+"','"+Phone+"','"+Class+"','"+Address+"','"+Program+"','"+Branch+"','"+DOE+"','"+Status+"','"+s+"')";
				stmt.executeUpdate(str);
				
				
				}
				catch(Exception e){ System.out.println(e);}
	}
}
