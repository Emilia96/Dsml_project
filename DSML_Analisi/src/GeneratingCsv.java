import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class GeneratingCsv {
	
	public static void writeDataLineByLine(String filePath, String s1, String s2) throws IOException {
	    // first create file object for file placed at location 
	    // specified by filepath 
	    File file = new File(filePath); 
	    try { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	        String[] header = { "Vulnerabilità", "Metodo buggato" }; 
	        writer.writeNext(header); 
	        String[] data1 = {s1, s2};
	        writer.writeNext(data1); 
	        writer.close();

	    }
	   catch(IOException e){
			e.printStackTrace();
		}

	}
	}