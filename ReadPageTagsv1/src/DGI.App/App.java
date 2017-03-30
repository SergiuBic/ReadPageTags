package DGI.App;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import DGI.Pdf.WriteOutput;




//Main method JFRAME
public class App extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame win64 = new JFrame();
	private static int p;
	public static ArrayList list = new ArrayList<>();
	public static JScrollPane scrollV = new JScrollPane(Frame.area);
	public static JScrollPane scrollV2 = new JScrollPane(Frame.area2);

   
	

	public static void main(String[] args) throws InvalidPasswordException, IOException {
		
         
		//calling the Window
		
       win64 = Frame.getFrame();
       win64.setSize(Frame.getWIN_H(),Frame.getWIN_W());
       win64.setVisible(true);
	   win64.setTitle(Frame.getTitle());
	   win64.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	   scrollV2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	   Frame.pane.add(scrollV);
	   Frame.pane2.add(scrollV2);
	   win64.add(Frame.pane, BorderLayout.WEST);
	   win64.add(Frame.pane2, BorderLayout.EAST);
	  
	  
	  //Create file bruteArea in the GeneratedList
		WriteOutput.createNewFile();
		//Regex for 3 WORDS	
		  //flamingo.getText(Read.pdf).replaceAll("((?:\\w+).\\W.(?:\\w+).\\W.(?:\\w+).)", "$1 <---merge ");
		    WriteOutput.itFolder();
	   
	
	
			
			

			
			
			
		  
		
		

				
				
				
	  
	

	   //Return the number of Pages
	   // Read.pdf.getDocument();
	   //setP(Read.pdf.getNumberOfPages());
	   
	   
	   //Return the first page

	   
	   //Alert & Area deployment
	   //JOptionPane.showMessageDialog(win64, "Number of pages: " + getP());

	   
	   
		
	}
	

	



	public static int getP() {
		
		return p;
	}




	public static void setP(int p) {
		App.p = p;
	}

}
