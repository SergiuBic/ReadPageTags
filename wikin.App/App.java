package wikin.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import wikin.Pdf.*;




//Main method JFRAME
public class App extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame win64 = new JFrame();
	public static ArrayList list = new ArrayList<>();
	public static JScrollPane scrollV = new JScrollPane(Frame.area);
	public static JScrollPane scrollV2 = new JScrollPane(Frame.area2);
	private static final String content = "\n\n\n\nDrag & Drop" + System.lineSeparator() + "the PATH to your PDFSPlits here!\n"
										+ "(!) PDFs should have ascendant numbers by name (!)\n";
	public static String catchPath;
	public static JPanel upperPanel = new JPanel();
	public static JPanel lowerPanel = new JPanel();
	public static JButton StartButton = new JButton("Start the program!");
	public static JButton Info = new JButton("info");
	public static JTextArea dragndrop = new JTextArea(content,12,20);
	public static Thread principal;
	

	public static void main(String[] args) throws InvalidPasswordException, IOException {
		
        //Shut down the LOG4J messages.
		java.util.logging.Logger.getLogger("org.apache.pdfbox").setLevel(java.util.logging.Level.OFF);
		
		
	   //Calling the Window
       win64 = Frame.getFrame();
       win64.setTitle(Frame.getTitle());
       win64.setSize(Frame.getWIN_H(),Frame.getWIN_W());
       
       win64.setVisible(true);
	  
	   win64.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	   scrollV2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	   Frame.pane.add(scrollV);
	   Frame.pane2.add(scrollV2);
	   win64.add(Frame.pane, BorderLayout.WEST);
	   win64.add(Frame.pane2, BorderLayout.EAST);
	   
	   win64.setLayout(new BorderLayout());
	   //StartButton.setLayout(null);
	  
	   StartButton.setBackground(Color.WHITE);
	   StartButton.setSize(new Dimension(5,5));
	   StartButton.setVisible(false);
	   
	   lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
	   lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));
   	   lowerPanel.add(dragndrop);
   	   
   	   
   	   dragndrop.setAlignmentX(Component.LEFT_ALIGNMENT);
   	   
   	   //Start Button ActionListener
   	dragndrop.setFont(new Font("Arial Black", Font.BOLD, 15));
   	dragndrop.setEditable(false);
   
       //DragNDropArea
   	dragndrop.setDropTarget(new DropTarget() {
           /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public synchronized void drop(DropTargetDropEvent evt) {
               try {
                   evt.acceptDrop(DnDConstants.ACTION_COPY);
                   List<File> droppedFiles = (List<File>) evt
                           .getTransferable().getTransferData(
                                   DataFlavor.javaFileListFlavor);
                   for (File file : droppedFiles) {
                       /*
                        * NOTE:
                        *  When I change this to a println,
                        *  it prints the correct path
                        */
                   	if(droppedFiles.size() > 1){
                   	 JOptionPane.showMessageDialog(null, "Drag\'n\'Drop only 1 Path here!");
                   	return;
                   	}else{
                   	catchPath = file.getAbsolutePath();
                   	
                   	}
                   }
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
       });
   	
   	   
   	   
   	   
   	 
   	   String[] choices = { "Category1","Category2", "Category3"};

       final JComboBox<String> cb = new JComboBox<String>(choices);
       
       cb.setVisible(true);
       ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
           @Override
           public void actionPerformed(ActionEvent e) {

               String s = (String) cb.getSelectedItem();

               switch (s) {//check for a match
                   case "Category1":
                	   StartButton.setVisible(true);
                	   dragndrop.setEditable(true);
                	   dragndrop.append("[RPT-SYS]  You chosed Category1\n");
                	   dragndrop.setEditable(false);
                       
                       break;
                   case "Category2":
                	   StartButton.setVisible(true);
                	   dragndrop.setEditable(true);
                	   dragndrop.append("[RPT-SYS]  You chosed Category2\n");
                	   dragndrop.setEditable(false);
                	
                	   break;
                   case "Category3":
                	   StartButton.setVisible(true);
                	   dragndrop.setEditable(true);
                	   dragndrop.append("[RPT-SYS] You chosed Category3\n");
                	   dragndrop.setEditable(false);
                	   
                	   break;
                   default:
                	   StartButton.setVisible(false);
                       //System.out.println("Wrong choose");
                       break;
               }
           }
       };

    cb.addActionListener(cbActionListener);
   	upperPanel.add(cb);
   	
    ActionListener StartButtonActionListener = new ActionListener() {//add actionlistner to listen for change
        @Override
        public void actionPerformed(ActionEvent e) {

            String s = (String) cb.getSelectedItem();
        
            switch (s) {//check for a match
                case "Category2":
               if(catchPath != null){
                dragndrop.setEditable(true);
                dragndrop.setFont(new Font("Arial Black", Font.BOLD, 10));
				try {
				
						
					for(int i = 0; i < 2; i++) { 
						principal = new Thread();
						principal.start();
						
					    try {
					    	Category2.itFolder();
					    	Category2.BK.join();
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}    // Wait for it to finish.
					}
		
					
					
					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					dragndrop.setEditable(false);
					JOptionPane.showMessageDialog(null, "Finished!\n"
							+ "The file Cat2.txt is generated in :\n"
							+ "D:\\ReadPageTags\\GeneratedList!");
					System.exit(0);
				}
                    
               }else{
           		JOptionPane.showMessageDialog(null, "[RPT-SYS] ERROR:\n\n"
           				+ "1.Please drag a valid path to the white area!"
           				+ "\n2.Please name-number the PDFs in ascendant order!");
           		return;}
                   break;
                   
                   
                case "Category1":
                    if(catchPath != null)
                    {
                        dragndrop.setEditable(true);
                        dragndrop.setFont(new Font("Arial Black", Font.BOLD, 10));
        				try {
        				
        						
        					for(int i = 0; i < 2; i++) { 
        						principal = new Thread();
        						principal.start();
        						
        					    try {
        					    	Category1.itFolder();
        					    	Category1.BDTV.join();
        							
        						} catch (InterruptedException e1) {
        							// TODO Auto-generated catch block
        							e1.printStackTrace();
        						}    // Wait for it to finish.
        					}
        		
        					
        					
        					
        					
        				} catch (IOException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}finally{
        					dragndrop.setEditable(false);
        					JOptionPane.showMessageDialog(null, "Finished!\n"
        							+ "The file Cat1.txt is generated in :\n"
        							+ "D:\\ReadPageTags\\GeneratedList!");
        					System.exit(0);
        				}
                            
                       }else{
                   		JOptionPane.showMessageDialog(null, "[RPT-SYS] ERROR:\n\n"
                   				+ "1.Please drag a valid path to the white area!"
                   				+ "\n2.Please name-number the PDFs in ascendant order!");
                   		return;}
                           break;
             	   
                case "Category3":
                	
                	if(catchPath != null)
                     {
                         dragndrop.setEditable(true);
                         dragndrop.setFont(new Font("Arial Black", Font.BOLD, 10));
         				try {
         				
         						
         					for(int i = 0; i < 2; i++) { 
         						principal = new Thread();
         						principal.start();
         						
         					    try {
         					    	Category3.itFolder();
         					    	Category3.BP.join();
         							
         						} catch (InterruptedException e1) {
         							// TODO Auto-generated catch block
         							e1.printStackTrace();
         						}    // Wait for it to finish.
         					}
         		
         					
         					
         				} catch (IOException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}finally{
        					dragndrop.setEditable(false);
        					JOptionPane.showMessageDialog(null, "Finished!\n"
        							+ "The file Cat1.txt is generated in :\n"
        							+ "D:\\ReadPageTags\\GeneratedList!");
        					System.exit(0);
        				}
                            
                       }else{
                   		JOptionPane.showMessageDialog(null, "[RPT-SYS] ERROR:\n\n"
                   				+ "1.Please drag a valid path to the white area!"
                   				+ "\n2.Please name-number the PDFs in ascendant order!");
                   		return;}
                           break;
             
                default:
                    /*
                     * Nothing to see here ^_^
                     */
                    break;
            }
   
	
        }
    	
    };
    
    StartButton.addActionListener(StartButtonActionListener);
    lowerPanel.add(StartButton);
	StartButton.setAlignmentX(Component.LEFT_ALIGNMENT);
    lowerPanel.add(Info);
    Info.setAlignmentX(Component.LEFT_ALIGNMENT);
   
    
       
   	win64.getContentPane().add(upperPanel, "North");
   	win64.getContentPane().add(lowerPanel, "South");
   	win64.setLocationRelativeTo(null);
    win64.pack();
   	win64.setResizable(false);
   	win64.setVisible(true);
	 
   	
   	/*
   	 * 
   	 * UI Functions Buttons
   	 * 
   	 */  
   	 
   	 Info.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	 JOptionPane.showMessageDialog(null,
        	 		"\n*****"+Frame.getTitle()+"*****\n"
        	 		+ "(c) 2017 closed-beta,\n"
        	 		+ "Info/Bugs/Injuries at developer sergiuadrian.bic@gmail.com");
         }
     });
   	 
   	 if(!StartButton.isVisible()){
   		JOptionPane.showMessageDialog(null, "Choose your desired Category \nfrom you want to Extract the first 3 words by page!");
   	 }
	   
	   /*
		  * 
		   UI Functions Buttons
	   	*/
	}

  
}
