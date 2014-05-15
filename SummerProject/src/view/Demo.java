package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.toedter.calendar.*;

import model.DatabaseConnector;

public class Demo {

	/**
	 * @param args
	 */
	private static JPanel contentPane;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JCalendarDemo demo = new JCalendarDemo();
		JFrame frame = new JFrame();
		frame.setBounds(100,100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.add(demo);
		
	}

}
