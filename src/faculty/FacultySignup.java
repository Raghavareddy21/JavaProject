package faculty;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import org.jdatepicker.util.JDatePickerUtil;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.DateModel;
import java.util.Properties;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import functions.Functions;
import student.Login;
import student.StudentHome;

import java.awt.Choice;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JFileChooser;

public class FacultySignup {

	JFrame frmFacultySignup;
	private JTextField user;
	private JTextField name;
	private JTextField id;
	private JPasswordField passwordField;
	private JTextField mail;
	private JTextField phone;
	private JTextField qualifications;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String Label;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JComboBox branch;
	private JComboBox ES;
	private JTextField Addres;
	private JFileChooser fileChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultySignup window = new FacultySignup();
					window.frmFacultySignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FacultySignup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFacultySignup = new JFrame();
		frmFacultySignup.getContentPane().setBackground(Color.DARK_GRAY);
		frmFacultySignup.setBackground(Color.PINK);
		frmFacultySignup.setTitle("Faculty Signup");
		frmFacultySignup.setBounds(100, 100, 658, 541);
		frmFacultySignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFacultySignup.getContentPane().setLayout(null);
		
		JLabel lblFacultySignup = new JLabel("Faculty Signup");
		lblFacultySignup.setForeground(Color.WHITE);
		lblFacultySignup.setBounds(277, 12, 110, 15);
		frmFacultySignup.getContentPane().add(lblFacultySignup);
		lblFacultySignup.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 350, 620, 165);
		frmFacultySignup.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Qualifications");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Joining Year:");
		
		JLabel lblDateOfEnrollment = new JLabel("Date Of Enrollment:");
		
		dateChooser_1 = new JDateChooser();
		
		JYearChooser yearChooser = new JYearChooser();
		
		JLabel lblEnrollmentStatus = new JLabel("Enrollment Status:");
		
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
				signup();
				frmFacultySignup.dispose();
				Functions.logout();
			}
		});
		
		JLabel lblBranch = new JLabel("Branch:");
		
		branch = new JComboBox();
		branch.setModel(new DefaultComboBoxModel(new String[] {"Maths", "Science", "Social", "Hindi", "English"}));
		
		qualifications = new JTextField();
		qualifications.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Functions.checkStudentLogin()) {
					StudentHome st=new StudentHome();
					st.frmHome.setVisible(true);
					frmFacultySignup.dispose();
				}
				else if(Functions.CheckFacultyLogin()) {
					FacultyHome st;
					st = new FacultyHome();
					st.frmHome.setVisible(true);
					frmFacultySignup.dispose();
					
				}
				else {
					Principal p=new Principal();
					p.frame.setVisible(true);
					frmFacultySignup.dispose();
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
						.addComponent(ES, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(qualifications)
								.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(yearChooser, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
							.addGap(41)
							.addComponent(lblBranch)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(branch, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(424, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addGap(36))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblBranch)
								.addComponent(branch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(qualifications, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDateOfEnrollment)
								.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnrollmentStatus)
								.addComponent(ES, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap(102, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSubmit)
								.addComponent(btnBack))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(253))
		);
		panel_1.setLayout(gl_panel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 24, 634, 305);
		frmFacultySignup.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Details", null, panel, null);
		panel.setBackground(Color.WHITE);
		
		JLabel lblName = new JLabel("Username:");
		
		JLabel lblRollNo = new JLabel("ID No:");
		
		JLabel lblNewLabel = new JLabel("Gender:");
		
		JLabel lblNewLabel_1 = new JLabel("Date Of Birth");
		
		user = new JTextField();
		user.setColumns(10);
		
		JLabel lblLastName = new JLabel("Full Name:");
		
		name = new JTextField();
		name.setColumns(10);
		
		id = new JTextField();
		id.setColumns(10);
		
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
		
		mail = new JTextField();
		mail.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		
		phone = new JTextField();
		phone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		
		Addres = new JTextField();
		Addres.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRollNo)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(id)
										.addComponent(user, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
									.addGap(30)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblLastName)
										.addComponent(lblPassword))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(12)
											.addComponent(name, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(Addres, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(Male)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(Female)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(Other))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
									.addComponent(lblAddress)
									.addGap(218))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhoneNumber)
								.addComponent(lblGmailId))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(mail)
								.addComponent(phone, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 280, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRollNo)
								.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAddress)))
							.addGap(50)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGmailId)
								.addComponent(mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhoneNumber)
								.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(48, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addComponent(Addres, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(94))))
		);
		panel.setLayout(gl_panel);
		
		fileChooser = new JFileChooser();
		tabbedPane.addTab("picture", null, fileChooser, null);
	}
	public void signup() {
		 String FullName=name.getText();
		 String Username=user.getText();
		 int ID=Integer.parseInt(id.getText());
		 String Gender=Label;
		 String Password=passwordField.getText();
		 String DOB=dateChooser.getDate().toString();
		 String Mail=mail.getText();
		 String Address=Addres.getText();
		 int Phone=Integer.parseInt(phone.getText());
		 String Qualifications=qualifications.getText();
		 String Branch=branch.getSelectedItem().toString();
		 String DOE=dateChooser_1.getDate().toString();
		 String Status=ES.getSelectedItem().toString();
		 int r = fileChooser.showOpenDialog(null);
		 String s = fileChooser.getSelectedFile().getAbsolutePath();
		    
		 try {
			 
				Connection con = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/Student_data","raghav","Rag@1234"); 
				Statement stmt=con.createStatement();
				String str="INSERT INTO Faculty (FullName,Username,IDNumber,Gender,Password,DOB,Mail,Phone,Qualifications,Branch,DOE,Status,Address,pic) "
						+ "VALUES ('"+FullName+"','"+Username+"','"+ID+"','"+Gender+"','"+Password+"','"+DOB+"','"+Mail+"','"+Phone+"','"+Qualifications+"','"+Branch+"','"+DOE+"','"+Status+"','"+Address+"','"+s+"')";
				stmt.executeUpdate(str);
				
				
				}
				catch(Exception e){ System.out.println(e);}
	}
}
