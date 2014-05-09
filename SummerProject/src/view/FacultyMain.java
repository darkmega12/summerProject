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

public class FacultyMain extends JFrame 
{

	private JPanel contentPane;

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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 119, 184, 50);
		contentPane.add(btnNewButton);
	}
}
