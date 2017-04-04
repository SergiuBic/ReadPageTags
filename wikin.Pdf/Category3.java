package wikin.Pdf;

import wikin.App.*;
import java.awt.geom.Rectangle2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripperByArea;


public class Category3 {
	
	static public String path = "D:" + File.separator + "ReadPageTags" + File.separator + "GeneratedList" + File.separator + "brutePDF.txt";
	static public String finished = "D:" + File.separator + "ReadPageTags" + File.separator + "GeneratedList" + File.separator + "brutetext.txt";
	static public String searched = "D:" + File.separator + "ReadPageTags" + File.separator + "GeneratedList" + File.separator + "Category3.txt";
	static public PDPage pag = new PDPage();
	
	static public String[] dirListing = null;
	public static // Use relative path for Unix systems
	File f = new File(path);
	public static
	File finish = new File(finished);
	public static
	File searchedTemp = new File(searched);
	public static
	File ffpath = new File(App.catchPath);
	public static 
	File[] fArray = ffpath.listFiles();
	public static
	int[] indexfiles = null;
	public static
	LinkedList<String> w3 = new LinkedList<String>();
	public static Thread BP = new Thread();
	

	
	public static  Matcher m = null;
	public static boolean result;
	
	//D:\WorkW\JPROJECTS\ReadPageTagsv1\res
	
	
	
	public static void itFolder() throws IOException{
		BP.start();

		int iterate=0;
		
		
		try(Stream<Path> paths = Files.walk(Paths.get(App.catchPath))) {
			
	
			paths.forEach(filePath -> {
				
		        if (Files.isRegularFile(filePath)) {
		        
		            
		        }
		    });
			
			Arrays.sort(fArray, new Comparator<File>() {
			    public int compare(File f1, File f2) {
			        try {
			            int i1 = Integer.parseInt(f1.getName().replaceFirst(".pdf", ""));
			            int i2 = Integer.parseInt(f2.getName().replaceFirst(".pdf", ""));
	        
			            return i1 - i2;
			            
			        } catch(NumberFormatException e) {
			            throw new AssertionError(e);
			        }
			    }
			});
			//System.out.println(Arrays.deepToString(fArray));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
	
		for(iterate=0;iterate<fArray.length;iterate++){
			
			PDDocument temp = PDDocument.load(fArray[iterate].getAbsoluteFile());
			
			
			
	      //Check the folder with files
	   
		//fArray[iterate].getAbsoluteFile();
			
			
			
			PDFTextStripperByArea stripArea = null;
			PDFTextStripperByArea searchArea = null;
			try {
				stripArea = new PDFTextStripperByArea();
				searchArea = new PDFTextStripperByArea();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			   
			Rectangle2D region = new Rectangle2D.Double(-100, -50, 700, 500);
			String regionName = "region";
			
			
			Rectangle2D ftwords = new Rectangle2D.Double(10, 60, 280, 50);
			
			Rectangle2D ftwordsUrgent = new Rectangle2D.Double(30, 100, 140, 10);
			String searchRegion = "search";
			String searchRegionUrgent = "urgent";
			
			

		   
			
				
			
				
				
		    
			try {
				pag = temp.getDocumentCatalog().getPages().get(0);
				String tempo = null;
				Read showme = null;
				Read showme2 = null;
			    
					
					try {
						showme = new Read();
						showme2 = new Read();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					   stripArea.addRegion(regionName, region);
					   stripArea.extractRegions(pag);
					   stripArea.setSortByPosition(true);
					   showme.setSortByPosition(true);
					   showme.stripPage(1);
					   
					   
					   searchArea.addRegion(searchRegion, ftwords);
					  
					   //I changed from " " (empty) to  "\n" (12:45PM 29/03/2017)
					  // searchArea.setLineSeparator("\n");
					   
					   searchArea.extractRegions(pag);
					   
					   searchArea.setSortByPosition(true);
				
					 
					   showme2.setSortByPosition(true);
	 
					   showme2.stripPage(1);
					  
					   String parsed2Text = null;
					   String parsed3Words = null;
					   //Load the file & Text from the first page * show him.
					   parsed2Text = stripArea.getTextForRegion(regionName);
					   
					   parsed3Words = searchArea.getTextForRegion(searchRegion);
					   
					   //old pattern   (\\w+.\\W.\\w+.\\W.\\w+.\\W.)
					   String pattern = "(.+?.\\W+.\\w+.\\W+.\\w+)";
					   Pattern r = Pattern.compile(pattern);
					  
					   
					   tempo = searchArea.getTextForRegion(searchRegion);
					   
					   m = r.matcher(tempo);
					   
					  
			   
					   //Search the first 3 words of each page
					   Frame.area.append(parsed2Text);
					   if(m.find()){
					   Frame.area2.append(m.group(1) + "\r\n");      
					   }
			} catch (InvalidPasswordException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 			
			
		
            
			
			temp.addPage(pag);
			
			
			finish.getParentFile().mkdirs();
			searchedTemp.getParentFile().mkdirs();
			
			try {
				finish.createNewFile();
				searchedTemp.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (finish.exists()) {
				finish.delete();
			    }
			if(searchedTemp.exists()){
				searchedTemp.delete();
			}
			
			try {
				BufferedWriter machine = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(finish.getAbsoluteFile()), "UTF-8"));
				Frame.area.write(machine);
				machine.close();
				
				BufferedWriter machine2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(searchedTemp.getAbsoluteFile()), "UTF-8"));
				Frame.area2.write(machine2);
				machine2.close();
				
				
				//print out each file who is Iterated by the machine.
				
				
				App.dragndrop.append("Processing: " +  fArray[iterate].getName() + "\n");
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		           if (temp!=null) {
		               try {
		            	   
		                   temp.close();
		                  
		                   
		                   
		               } catch (IOException e) {
                             e.printStackTrace();
		               }
		           }
		       } 
		}
		

	}
	
	
	
	
	public static Matcher getM() {
		return m;
	}

	public static File getthebrute(){
		return f.getAbsoluteFile();
	}
	

}
