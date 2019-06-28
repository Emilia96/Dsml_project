
	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
	import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
	import java.util.Iterator;

	import org.jdom2.Document;
	import org.jdom2.Element;
	import org.jdom2.JDOMException;
	import org.jdom2.input.SAXBuilder;

	public class Final_parser {
		
		private SAXBuilder builder;
		private String fileName;
		private Document doc;
		private Element root;
		private Iterable<Element> children;
		private Iterator itr;
		public static String vul;
		
		/*costruttore*/
		public Final_parser(String file) {
			builder = new SAXBuilder();	//inizializzo il builder
			fileName = file;
			try {
				doc = builder.build(fileName);
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			root = doc.getRootElement();	//ottengo la root del doc xml
			children = root.getChildren(); //carico in un iteratore tutti i nodi
										   //del doc xml
			itr = children.iterator();
		}
		
		public ArrayList<Element> findBugInstance() {
			ArrayList<Element> list = new ArrayList<Element>();
			while (itr.hasNext()) {
				Element e = (Element) itr.next();
				if (e.getName() == "BugInstance") {
					list.add(e);
					 vul = e.getAttributeValue("type");
					System.out.println("Tipo di vulnerabilit� = " + e.getAttributeValue("type"));
					
							}			
			}
			return list;
		}
		
		public Element getBugClass(Element e) {
			return e.getChild("Class");
		}
		
		public Element getBugMethod(Element e) {
			return e.getChild("Method");
		}	
		
		public Element getBugSourceLine(Element e) {
			return e.getChild("SourceLine");
		}
		
		public void printBugMethod(String className, String methodName) throws IOException {
			BufferedReader reader = new BufferedReader(new FileReader("src/" + className + ".java"));
			FileWriter out = new FileWriter("foo.txt");
			BufferedWriter writer = new BufferedWriter(out);
			String line = reader.readLine();
			writer.write(vul + "\t;");
		

			while (!line.contains(methodName)) {
				line = reader.readLine();
				writer.write(line);

				}
			System.out.print("[");
			
			while (!line.contains("\t}")) {
			System.out.println(line);
			line = reader.readLine();
			writer.write(line);
			
			}
			
			
			System.out.println(line);
			System.out.println("]");
			reader.close();
			writer.flush();
			
		}
	}


