package faculty;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import functions.Functions;
import student.Login;
import student.StudentSignup;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	public JFrame frame;
	private String Username;
	private String Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPrincipal.setForeground(Color.WHITE);
		lblPrincipal.setBackground(Color.WHITE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Functions.logout();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(55, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogout)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 855, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrincipal))
					.addGap(88))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addComponent(lblPrincipal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogout)
					.addGap(35))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Registrations", null, panel_1, null);
		
		JButton sts = new JButton("Student Signup");
		sts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSignup SS = new StudentSignup();
				SS.frmStudentSignup.setVisible(true);
				frame.dispose();
			}
		});
		sts.setFont(new Font("Dialog", Font.BOLD, 30));
		
		JButton fas = new JButton("Faculty Signup");
		fas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultySignup SS = new FacultySignup();
				SS.frmFacultySignup.setVisible(true);
				frame.dispose();
			}
		});
		fas.setFont(new Font("Dialog", Font.BOLD, 30));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(fas, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE)
						.addComponent(sts, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(73)
					.addComponent(sts, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(fas, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 998, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
