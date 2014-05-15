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
import javax.swing.JList;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;

public class FacultyMain extends JFrame 
{
	
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField zipCodeField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField landlineField;
	private JTextField mobileField;
	private JTable table;
	private JTable table_1;
	private JCalendar birthdayCalendar;

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
		lblFirstName.setBounds(10, 37, 72, 18);
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
		lblLastName.setBounds(10, 107, 72, 14);
		addAgent.add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(108, 105, 166, 20);
		addAgent.add(lastNameField);
		lastNameField.setColumns(10);
		
		JComboBox genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderComboBox.setBounds(402, 37, 59, 20);
		addAgent.add(genderComboBox);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblGender.setBounds(320, 39, 60, 14);
		addAgent.add(lblGender);
		
		JLabel lblCurrentDate = new JLabel("Select Date Today:");
		lblCurrentDate.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCurrentDate.setBounds(26, 326, 129, 14);
		addAgent.add(lblCurrentDate);
		
		JButton currDateCalendar = new JButton("Show Calendar");
		currDateCalendar.setBounds(26, 351, 119, 28);
		addAgent.add(currDateCalendar);
		
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
		
		zipCodeField = new JTextField();
		zipCodeField.setBounds(81, 194, 59, 20);
		addAgent.add(zipCodeField);
		zipCodeField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblStreet.setBounds(154, 196, 51, 14);
		addAgent.add(lblStreet);
		
		streetField = new JTextField();
		streetField.setBounds(203, 194, 119, 20);
		addAgent.add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCity.setBounds(332, 194, 39, 18);
		addAgent.add(lblCity);
		
		cityField = new JTextField();
		cityField.setBounds(377, 194, 105, 20);
		addAgent.add(cityField);
		cityField.setColumns(10);
		
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
		
		landlineField = new JTextField();
		landlineField.setBounds(137, 272, 104, 20);
		addAgent.add(landlineField);
		landlineField.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMobile.setBounds(279, 274, 59, 14);
		addAgent.add(lblMobile);
		
		mobileField = new JTextField();
		mobileField.setBounds(357, 272, 104, 20);
		addAgent.add(mobileField);
		mobileField.setColumns(10);
		
		JButton btnAddAgent = new JButton("Add Agent");
		btnAddAgent.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddAgent.setBounds(377, 345, 104, 38);
		addAgent.add(btnAddAgent);
		
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBounds(320, 85, 201, 156);
		addAgent.add(calendarPanel);
		
		birthdayCalendar= new JCalendar();
		calendarPanel.add(birthdayCalendar);
		
		JPanel viewAgent = new JPanel();
		tabbedPane.addTab("View/Edit Agent", null, viewAgent, null);
		viewAgent.setLayout(null);
		
		table = new JTable();
		table.setBounds(25, 72, 338, 307);
		viewAgent.add(table);
		
		JLabel lblListOfAgents = new JLabel("Agent Selected:");
		lblListOfAgents.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblListOfAgents.setBounds(25, 28, 121, 20);
		viewAgent.add(lblListOfAgents);
		
		JButton btnEditAgentData = new JButton("Edit Agent");
		btnEditAgentData.setBounds(400, 138, 99, 49);
		viewAgent.add(btnEditAgentData);
		
		JButton btnViewAgentData = new JButton("View Agent");
		btnViewAgentData.setBounds(400, 236, 99, 49);
		viewAgent.add(btnViewAgentData);
		
		JLabel lblManageAgentName = new JLabel("Last Name, First Name");
		lblManageAgentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblManageAgentName.setBounds(156, 31, 275, 14);
		viewAgent.add(lblManageAgentName);
		
		JPanel agentRequest = new JPanel();
		tabbedPane.addTab("Agent Request", null, agentRequest, null);
		agentRequest.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(10, 61, 493, 283);
		agentRequest.add(table_1);
		
		JLabel lblSelectAnAgent = new JLabel("Select an Agent Request you want to Resolve");
		lblSelectAnAgent.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSelectAnAgent.setBounds(95, 22, 327, 20);
		agentRequest.add(lblSelectAnAgent);
		
		JButton btnViewAgentRequest = new JButton("View Agent Request");
		btnViewAgentRequest.setBounds(188, 355, 160, 38);
		agentRequest.add(btnViewAgentRequest);
	}
}
