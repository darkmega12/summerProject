package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.Document;

import com.toedter.calendar.JCalendar;

import controller_createModule.CreateCompanyController;
import controller_createModule.CreateRegistrarController;

import javax.swing.JPasswordField;

import model.CompanyImplement;
import model.RegistrarImplement;

public class CreateAccounts extends JFrame {

	final static String SELECTION_PANEL = "selection";
	final static String COMPANY_PANEL = "company";
	final static String REGISTRAR_PANEL = "registrar";
	
	private CreateRegistrarController pRegistrarController;
	private RegistrarImplement pRegistrarModel;
	private CreateCompanyController pCompanyController;
	private CompanyImplement pCompanyModel;

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField zipField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField regFirstName;
	private JTextField regMiddleName;
	private JTextField regLastName;
	
	final CardLayout panelLayer;
	final JPanel layerPanel;
	final JLabel lblSelect;
	private JPasswordField regPassword;
	private JPasswordField regConfirmPassword;
	private JPasswordField companyPassword;
	private JPasswordField companyConfirmPassword;
	private JCalendar companyCalendar;

	/**
	 * Create the frame.
	 */
	public CreateAccounts() 
	{
		pRegistrarModel= new RegistrarImplement();
		pRegistrarController= new CreateRegistrarController(pRegistrarModel, this);
		pCompanyModel= new CompanyImplement();
		pCompanyController= new CreateCompanyController(pCompanyModel, this);
		
		setTitle("CREATE ACCOUNT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 196, 222));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layerPanel = new JPanel();
		layerPanel.setBounds(10, 153, 764, 398);
		contentPane.add(layerPanel);
		layerPanel.setBackground(new Color(153, 204, 204));
		layerPanel.setLayout(new CardLayout(0, 0));
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBackground(new Color(153, 204, 204));
		layerPanel.add(selectionPanel, SELECTION_PANEL);
		selectionPanel.setLayout(null);
		
		JButton btnCreateCompany = new JButton("Company", new ImageIcon("img/company_img.png"));
		btnCreateCompany.setBounds(169, 134, 185, 172);
		selectionPanel.add(btnCreateCompany);
		btnCreateCompany.setVerticalTextPosition(AbstractButton.BOTTOM);
		btnCreateCompany.setHorizontalTextPosition(AbstractButton.CENTER);
		
		JButton btnCreateRegistrar = new JButton("Registrar");
		btnCreateRegistrar.setBounds(457, 136, 185, 172);
		selectionPanel.add(btnCreateRegistrar);
		
		JPanel crtCompanyPanel = new JPanel();
		crtCompanyPanel.setBackground(new Color(153, 204, 204));
		layerPanel.add(crtCompanyPanel, COMPANY_PANEL);
		crtCompanyPanel.setLayout(null);
		
		JLabel lblCompanyName = new JLabel("Company Name: ");
		lblCompanyName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCompanyName.setBounds(32, 42, 119, 27);
		crtCompanyPanel.add(lblCompanyName);
		
		nameField = new JTextField();
		nameField.setBounds(161, 44, 254, 27);
		crtCompanyPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact Number: ");
		lblContactNumber.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblContactNumber.setBounds(22, 89, 129, 20);
		crtCompanyPanel.add(lblContactNumber);
		
		numberField = new JTextField();
		numberField.setBounds(161, 88, 254, 27);
		crtCompanyPanel.add(numberField);
		numberField.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAddress.setBounds(32, 247, 80, 14);
		crtCompanyPanel.add(lblAddress);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblZipCode.setBounds(83, 272, 68, 20);
		crtCompanyPanel.add(lblZipCode);
		
		zipField = new JTextField();
		zipField.setBounds(161, 271, 254, 27);
		//zipField.setDocument(createTextDocument(4));
		crtCompanyPanel.add(zipField);
		zipField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblStreet.setBounds(98, 313, 53, 14);
		crtCompanyPanel.add(lblStreet);
		
		streetField = new JTextField();
		streetField.setBounds(161, 309, 254, 27);
		crtCompanyPanel.add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCity.setBounds(114, 347, 37, 23);
		crtCompanyPanel.add(lblCity);
		
		cityField = new JTextField();
		cityField.setBounds(161, 347, 254, 27);
		crtCompanyPanel.add(cityField);
		cityField.setColumns(10);
		
		JButton btnCrtCompany = new JButton("Create Account");
		btnCrtCompany.setBounds(606, 304, 136, 63);
		btnCrtCompany.addActionListener(pCompanyController);
		crtCompanyPanel.add(btnCrtCompany);
		
		JButton btnBackCompany = new JButton("Back");
		btnBackCompany.setBounds(446, 304, 136, 63);
		crtCompanyPanel.add(btnBackCompany);
		
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBounds(481, 94, 247, 180);
		calendarPanel.setOpaque(false);
		calendarPanel.setBackground(new Color(0,0,0));
		calendarPanel.setLayout(null);
		companyCalendar= new JCalendar();
		companyCalendar.setBounds(0, 5, 237, 157);
		calendarPanel.add(companyCalendar);
		crtCompanyPanel.add(calendarPanel);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblPassword_1.setBounds(68, 132, 80, 20);
		crtCompanyPanel.add(lblPassword_1);
		
		JLabel lblConfirmpassword = new JLabel("<html>Re-enter </br> Password:</html>");
		lblConfirmpassword.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblConfirmpassword.setBounds(68, 166, 73, 43);
		crtCompanyPanel.add(lblConfirmpassword);
		
		JLabel lblSelectDateToday = new JLabel("Select Date Today");
		lblSelectDateToday.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSelectDateToday.setBounds(536, 56, 129, 27);
		crtCompanyPanel.add(lblSelectDateToday);
		
		companyPassword = new JPasswordField();
		companyPassword.setBounds(161, 134, 254, 27);
		crtCompanyPanel.add(companyPassword);
		
		companyConfirmPassword = new JPasswordField();
		companyConfirmPassword.setBounds(161, 182, 254, 27);
		crtCompanyPanel.add(companyConfirmPassword);
		
		JPanel crtRegistrarPanel = new JPanel();
		crtRegistrarPanel.setBackground(new Color(153, 204, 204));
		layerPanel.add(crtRegistrarPanel, REGISTRAR_PANEL);
		crtRegistrarPanel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblFirstName.setBounds(22, 94, 83, 28);
		crtRegistrarPanel.add(lblFirstName);
		
		regFirstName = new JTextField();
		regFirstName.setBounds(115, 94, 258, 28);
		crtRegistrarPanel.add(regFirstName);
		regFirstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblMiddleName.setBounds(10, 153, 105, 20);
		crtRegistrarPanel.add(lblMiddleName);
		
		regMiddleName = new JTextField();
		regMiddleName.setBounds(115, 151, 258, 28);
		crtRegistrarPanel.add(regMiddleName);
		regMiddleName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblLastName.setBounds(22, 205, 83, 14);
		crtRegistrarPanel.add(lblLastName);
		
		regLastName = new JTextField();
		regLastName.setBounds(115, 202, 258, 28);
		crtRegistrarPanel.add(regLastName);
		regLastName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblPassword.setBounds(410, 126, 78, 23);
		crtRegistrarPanel.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("<html>Re-enter </br> Password: </html>");
		lblReenterPassword.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblReenterPassword.setBounds(410, 179, 83, 34);
		crtRegistrarPanel.add(lblReenterPassword);
		
		JButton btnBackRegistrar = new JButton("Back");
		btnBackRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackRegistrar.setBounds(164, 301, 162, 61);
		crtRegistrarPanel.add(btnBackRegistrar);
		
		JButton btnCrtRegistrar = new JButton("Create Account");
		btnCrtRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCrtRegistrar.setBounds(399, 301, 162, 61);
		btnCrtRegistrar.addActionListener(pRegistrarController);
		crtRegistrarPanel.add(btnCrtRegistrar);
		
		regPassword = new JPasswordField();
		regPassword.setBounds(503, 125, 236, 28);
		crtRegistrarPanel.add(regPassword);
		
		regConfirmPassword = new JPasswordField();
		regConfirmPassword.setBounds(503, 191, 236, 28);
		crtRegistrarPanel.add(regConfirmPassword);
		
		lblSelect = new JLabel("Please select an account to create");
		lblSelect.setBounds(230, 50, 402, 65);
		contentPane.add(lblSelect);
		lblSelect.setForeground(new Color(102, 102, 102));
		lblSelect.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		panelLayer= (CardLayout) layerPanel.getLayout();
		panelLayer.show(layerPanel, SELECTION_PANEL);
		
		btnCreateCompany.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panelLayer.show(layerPanel, COMPANY_PANEL);
				lblSelect.setVisible(false);
			}
		});
		
		btnCreateRegistrar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panelLayer.show(layerPanel, REGISTRAR_PANEL);
				lblSelect.setVisible(false);
			}
		});
		
		btnBackCompany.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panelLayer.show(layerPanel, SELECTION_PANEL);
				lblSelect.setVisible(true);
			}
		});
		
		btnBackRegistrar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panelLayer.show(layerPanel, SELECTION_PANEL);
				lblSelect.setVisible(true);
			}
		});
		
		

	}
	
	public JTextField getRegFirstNameField()
	{
		return regFirstName;
	}
	
	public JTextField getRegMiddleNameField()
	{
		return regMiddleName;
	}
	
	public JTextField getRegLastNameField()
	{
		return regLastName;
	}
	
	public JPasswordField getRegPasswordField()
	{
		return regPassword;
	}
	
	public JPasswordField getRegConfirmPasswordField()
	{
		return regConfirmPassword;
	}
	
	public JTextField getNameField()
	{
		return nameField;
	}
	
	public JTextField getNumberField()
	{
		return numberField;
	}
	
	public JPasswordField getCompanyPassword()
	{
		return companyPassword;
	}
	
	public JPasswordField getCompanyConfirmPassword()
	{
		return companyConfirmPassword;
	}
	
	public JTextField getZipField()
	{
		return zipField;
	}
	
	public JTextField getStreetField()
	{
		return streetField;
	}
	
	public JTextField getCityField()
	{
		return cityField;
	}
	
	public JCalendar getCompanyCalendar()
	{
		return companyCalendar;
	}
	
}
