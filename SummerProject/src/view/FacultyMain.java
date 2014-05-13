package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FacultyMain extends JFrame 
{

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public FacultyMain() 
	{
		setTitle("E-CALL PLACEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacultyHi = new JLabel("HI, ");
		lblFacultyHi.setBounds(56, 25, 67, 43);
		contentPane.add(lblFacultyHi);
		lblFacultyHi.setFont(new Font("SansSerif", Font.PLAIN, 19));
		
		JButton btnManageAgent = new JButton("Manage Agents");
		btnManageAgent.setBounds(10, 119, 184, 50);
		contentPane.add(btnManageAgent);
		
		JPanel panel = new JPanel();
		panel.setBounds(238, 119, 536, 432);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, "name_49494369911695");
		
		JPanel addAgent = new JPanel();
		tabbedPane.addTab("Add Agent", null, addAgent, null);
		addAgent.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblFirstName.setBounds(26, 37, 72, 18);
		addAgent.add(lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(108, 37, 166, 20);
		addAgent.add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMiddleName.setBounds(10, 70, 88, 14);
		addAgent.add(lblMiddleName);
		
		middleNameField = new JTextField();
		middleNameField.setBounds(108, 68, 166, 20);
		addAgent.add(middleNameField);
		middleNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblLastName.setBounds(26, 107, 72, 14);
		addAgent.add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(108, 105, 166, 20);
		addAgent.add(lastNameField);
		lastNameField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(402, 37, 59, 20);
		addAgent.add(comboBox);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblGender.setBounds(320, 39, 60, 14);
		addAgent.add(lblGender);
		
		JLabel lblSelectDateToday = new JLabel("Select Date Today:");
		lblSelectDateToday.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblSelectDateToday.setBounds(26, 326, 129, 14);
		addAgent.add(lblSelectDateToday);
		
		JButton btnShowCalendar = new JButton("Show Calendar");
		btnShowCalendar.setBounds(26, 351, 119, 28);
		addAgent.add(btnShowCalendar);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(29, 12, 46, 14);
		addAgent.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress.setBounds(10, 165, 72, 18);
		addAgent.add(lblAddress);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblZipCode.setBounds(10, 194, 72, 18);
		addAgent.add(lblZipCode);
		
		textField = new JTextField();
		textField.setBounds(81, 194, 59, 20);
		addAgent.add(textField);
		textField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblStreet.setBounds(154, 196, 51, 14);
		addAgent.add(lblStreet);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 194, 119, 20);
		addAgent.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCity.setBounds(332, 194, 39, 18);
		addAgent.add(lblCity);
		
		textField_2 = new JTextField();
		textField_2.setBounds(377, 194, 105, 20);
		addAgent.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblContactNumbers = new JLabel("Contact Numbers");
		lblContactNumbers.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblContactNumbers.setBounds(16, 243, 129, 20);
		addAgent.add(lblContactNumbers);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblBirthday.setBounds(320, 74, 72, 14);
		addAgent.add(lblBirthday);
		
		JLabel lblLandline = new JLabel("Landline:");
		lblLandline.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblLandline.setBounds(29, 274, 69, 14);
		addAgent.add(lblLandline);
		
		JComboBox monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		monthComboBox.setBounds(326, 105, 77, 20);
		addAgent.add(monthComboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(413, 105, 39, 20);
		addAgent.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004"}));
		comboBox_2.setBounds(462, 105, 59, 20);
		addAgent.add(comboBox_2);
		
		JButton btnShowCalendar_1 = new JButton("Show Calendar");
		btnShowCalendar_1.setBounds(393, 70, 105, 24);
		addAgent.add(btnShowCalendar_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 272, 104, 20);
		addAgent.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMobile.setBounds(279, 274, 59, 14);
		addAgent.add(lblMobile);
		
		textField_4 = new JTextField();
		textField_4.setBounds(357, 272, 104, 20);
		addAgent.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddAgent = new JButton("Add Agent");
		btnAddAgent.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddAgent.setBounds(377, 345, 104, 38);
		addAgent.add(btnAddAgent);
		
		JPanel viewAgent = new JPanel();
		tabbedPane.addTab("View Agent", null, viewAgent, null);
		
		JPanel agentRequest = new JPanel();
		tabbedPane.addTab("Agent Request", null, agentRequest, null);
		agentRequest.setLayout(null);
	}
}
