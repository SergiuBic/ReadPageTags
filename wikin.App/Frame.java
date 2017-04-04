package wikin.App;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Frame extends JPanel{

	//private declarations
	private static int WIN_H = 500;
	private static int WIN_W = 500;
	private static final String title = "ReadPageTags v1.0.0.0-OpenBeta";
	public static JFrame frame = new JFrame();
	public static JTextArea area = new JTextArea(5,20);
	public static JTextArea area2 = new JTextArea(5,20);
	public static JPanel pane = new JPanel(new BorderLayout());
	public static JPanel pane2 = new JPanel(new BorderLayout());
	
	
	
	
	
	Frame(){
	
	
		
		frame.setSize(getWIN_H(), getWIN_W());
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	   
		

		
		
		
	}
	
	
	
	
	
	public static String getTitle(){
		return title;
	}


	public static JFrame getFrame() {
		return frame;
	}


	public static int getWIN_W() {
		return WIN_W;
	}


	public static void setWIN_W(int wIN_W) {
		WIN_W = wIN_W;
	}


	public static int getWIN_H() {
		return WIN_H;
	}


	public static void setWIN_H(int wIN_H) {
		WIN_H = wIN_H;
	}





	public static JPanel getPane() {
		return pane;
	}





	public static void setPane(JPanel pane) {
		Frame.pane = pane;
	}


	
	
}
