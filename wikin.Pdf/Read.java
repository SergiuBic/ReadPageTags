package wikin.Pdf;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;




public class Read extends PDFTextStripper{
	
	public static File test = new File("res/test.pdf");
	
	public static PDDocument pdf = new PDDocument();
	public static PDPage pagina = new PDPage();
	
	
	//Constructor
	public Read() throws IOException {
		super();
		
		
	}

	
	
	
	public void stripPage(int pagenr) throws IOException{
		int start = 0;
		this.setStartPage(start);
		this.setEndPage(start+1);
		Writer renderer = new OutputStreamWriter(new ByteArrayOutputStream());
		writeText(pdf,renderer);
		
		
	}
	
	
	
	
	
	@Override
	  protected void writeString(String string,List<TextPosition> textPositions) throws IOException {

	        	//Print to the console the entire page with Newline and all the data of separate chars.
	        	//System.out.println("String[" + text.getXDirAdj()+","+text.getYDirAdj()+" fs="+text.getFontSizeInPt()+" xscale="+text.getXScale()+" height="+text.getHeightDir()+" space="+text.getWidthOfSpace()+" width="+text.getWidthDirAdj()+" ] "+text.getUnicode()+"\n");

	        	
	        	/* if(it.hasNext()){
	        		 Float next = it.next().floatValue();
	        		 Float prev = it.next().floatValue();
	        		  
	        		
	        		if(prev >= next){
	        			
	        		xIndex.add(enter);
	        		
	        		System.out.println("X-Corrdonate: " + xIndex);
	        		}
	        		 
	        		
	        	  }*/
	        
	    }
	}
