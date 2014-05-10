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
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CreateAccounts extends JFrame {

	final static String SELECTION_PANEL = "selection";
	final static String COMPANY_PANEL = "company";
	final static String REGISTRAR_PANEL = "registrar";

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField zipField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField regFirstName;
	private JTextField regMiddleName;
	private JTextField regLastName;
	private JTextField regUserName;
	private JTextField regPassword;
	private JTextField regConfirmPass;
	
	final CardLayout panelLayer;
	final JPanel layerPanel;
	final JLabel lblSelect;

	/**
	 * Launch the application.
	 */
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccounts frame = new CreateAccounts();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CreateAccounts() {
		setTitle("CREATE ACCOUNT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		lblCompanyName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCompanyName.setBounds(32, 126, 119, 27);
		crtCompanyPanel.add(lblCompanyName);
		
		nameField = new JTextField();
		nameField.setBounds(161, 128, 254, 27);
		crtCompanyPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact Number: ");
		lblContactNumber.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblContactNumber.setBounds(32, 173, 119, 20);
		crtCompanyPanel.add(lblContactNumber);
		
		numberField = new JTextField();
		numberField.setBounds(161, 166, 254, 27);
		crtCompanyPanel.add(numberField);
		numberField.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblAddress.setBounds(32, 220, 80, 14);
		crtCompanyPanel.add(lblAddress);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblZipCode.setBounds(83, 245, 68, 20);
		crtCompanyPanel.add(lblZipCode);
		
		zipField = new JTextField();
		zipField.setBounds(161, 244, 254, 27);
		crtCompanyPanel.add(zipField);
		zipField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblStreet.setBounds(98, 286, 53, 14);
		crtCompanyPanel.add(lblStreet);
		
		streetField = new JTextField();
		streetField.setBounds(161, 282, 254, 27);
		crtCompanyPanel.add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCity.setBounds(114, 320, 37, 23);
		crtCompanyPanel.add(lblCity);
		
		cityField = new JTextField();
		cityField.setBounds(161, 320, 254, 27);
		crtCompanyPanel.add(cityField);
		cityField.setColumns(10);
		
		JButton btnCrtCompany = new JButton("Create Account");
		btnCrtCompany.setBounds(618, 286, 136, 63);
		crtCompanyPanel.add(btnCrtCompany);
		
		JButton btnBackCompany = new JButton("Back");
		btnBackCompany.setBounds(455, 286, 136, 63);
		crtCompanyPanel.add(btnBackCompany);
		
		JPanel crtRegistrarPanel = new JPanel();
		crtRegistrarPanel.setBackground(new Color(153, 204, 204));
		layerPanel.add(crtRegistrarPanel, REGISTRAR_PANEL);
		crtRegistrarPanel.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(48, 95, 58, 28);
		crtRegistrarPanel.add(lblName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblFirstName.setBounds(22, 134, 83, 28);
		crtRegistrarPanel.add(lblFirstName);
		
		regFirstName = new JTextField();
		regFirstName.setBounds(115, 134, 258, 28);
		crtRegistrarPanel.add(regFirstName);
		regFirstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMiddleName.setBounds(10, 179, 95, 20);
		crtRegistrarPanel.add(lblMiddleName);
		
		regMiddleName = new JTextField();
		regMiddleName.setBounds(115, 179, 258, 28);
		crtRegistrarPanel.add(regMiddleName);
		regMiddleName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblLastName.setBounds(22, 221, 83, 14);
		crtRegistrarPanel.add(lblLastName);
		
		regLastName = new JTextField();
		regLastName.setBounds(115, 218, 258, 28);
		crtRegistrarPanel.add(regLastName);
		regLastName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblUsername.setBounds(410, 139, 83, 19);
		crtRegistrarPanel.add(lblUsername);
		
		regUserName = new JTextField();
		regUserName.setBounds(503, 136, 236, 28);
		crtRegistrarPanel.add(regUserName);
		regUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPassword.setBounds(410, 178, 78, 23);
		crtRegistrarPanel.add(lblPassword);
		
		regPassword = new JTextField();
		regPassword.setBounds(503, 179, 236, 28);
		crtRegistrarPanel.add(regPassword);
		regPassword.setColumns(10);
		
		JLabel lblReenterPassword = new JLabel("<html>Re-enter </br> Password: </html>");
		lblReenterPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblReenterPassword.setBounds(410, 212, 83, 34);
		crtRegistrarPanel.add(lblReenterPassword);
		
		regConfirmPass = new JTextField();
		regConfirmPass.setBounds(503, 221, 236, 28);
		crtRegistrarPanel.add(regConfirmPass);
		regConfirmPass.setColumns(10);
		
		JButton btnBackRegistrar = new JButton("Back");
		btnBackRegistrar.setBounds(164, 301, 162, 61);
		crtRegistrarPanel.add(btnBackRegistrar);
		
		JButton btnCrtRegistrar = new JButton("Create Account");
		btnCrtRegistrar.setBounds(399, 301, 162, 61);
		crtRegistrarPanel.add(btnCrtRegistrar);
		
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
}
