package DGI.App;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class RenameFiles{
 
   public RenameFiles() throws Exception{
    
    	//something here
   }
   
   public void doRename(){
	// change file names in 'Directory':
       String absolutePath = App.catchPath;
       File dir = new File(absolutePath);
       File[] filesInDir = dir.listFiles();
       int i = 0;

       
      
    
       
       //Sort then NUMERICALY before Rename it ascendant
       Arrays.sort(filesInDir, new Comparator<File>() {
    	    public int compare(File f1, File f2) {

    	        try {
    	        	   
        	           int i1 = Integer.parseInt(f1.getName().replaceFirst("^[A-z]*.(.+?)\\.pdf", "$1"));
        	           int i2 = Integer.parseInt(f2.getName().replaceFirst("^[A-z]*.(.+?)\\.pdf", "$1"));
        	           
        	           return i1 - i2;
        	           
        	           
        	        } catch(AssertionError e) {
        	        	
        	            throw new AssertionError(e);
        	           
        	            
        	        } 
        	    }
        	});
     
       //Rename the mfs
       for(File file:filesInDir) {
           i++;
           String newName = i + ".pdf";
           String newPath = absolutePath + "\\" + newName;
           file.renameTo(new File(newPath));
          
       }
       //Dialog for success
       JOptionPane.showMessageDialog(null, "Files from your path were renamed!!");
    
       
       
       
  }
}
