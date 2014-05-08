package view;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;

import model.DatabaseConnector;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JCalendar demo = new JCalendar();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(demo);
	}

}
