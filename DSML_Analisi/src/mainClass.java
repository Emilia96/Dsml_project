

	import java.io.FileWriter;
	import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import org.jdom2.Element;
	import com.opencsv.CSVWriter;
	

	public class mainClass {

		public static void main(String[] args) throws IOException {
			Final_parser parser = new Final_parser("src/bug.xml");
			ArrayList<Element> bugList = parser.findBugInstance();	
			for (Element e: bugList) {
				String className = parser.getBugClass(e).getAttributeValue("classname");
				String methodName = parser.getBugMethod(e).getAttributeValue("name");
				parser.printBugMethod(className, methodName);
	
		
			final Path path = Paths.get("C:\\Users\\Emilia\\eclipse-workspace\\DSML_Analisi");
			final Path txt = path.resolve("foo.txt");
		    final Path csv = path.resolve("myFile3.csv");
		    final Charset utf8 = Charset.forName("UTF-8");
		    try (
		            final Scanner scanner = new Scanner(Files.newBufferedReader(txt, utf8));
		            final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, utf8, StandardOpenOption.CREATE_NEW))) {
		    		while (scanner.hasNextLine()) {
		            pw.println(scanner.nextLine().replace('|', ','));
		        }
		    }
			 
			
			
				
				//csv.writeDataLineByLine(path,className, l);
			}

		}
		
	}

