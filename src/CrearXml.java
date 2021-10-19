import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXml {

	
	
	String path;
	
	
		
	public static void crear(String ruta,int partes, int bytes,String nombre){
		
		
	    try {
	      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	      
	      //Elemento raíz
	      Document doc = docBuilder.newDocument();
	      Element rootElement = doc.createElement("archivo");
	      doc.appendChild(rootElement);
	      
	      //Primer elemento
	      Element part = doc.createElement("partes");
	      rootElement.appendChild(part);
	      part.setTextContent(String.valueOf(partes));
	      
	      //Segundo elemento
	      Element byt = doc.createElement("bytes");
	      rootElement.appendChild(byt);
	      byt.setTextContent(String.valueOf(bytes));
	      
	      //Tercer elemento
	      Element nom = doc.createElement("Nombre");
	      rootElement.appendChild(nom);
	      nom.setTextContent(nombre);
	      
	      //Cuarto elemento
	      Element rut = doc.createElement("ruta");
	      rootElement.appendChild(rut);
	      rut.setTextContent(ruta);
	      
	      
	      //Se escribe el contenido del XML en un archivo
	      TransformerFactory transformerFactory = TransformerFactory.newInstance();
	      Transformer transformer = transformerFactory.newTransformer();
	      DOMSource source = new DOMSource(doc);
	      StreamResult result = new StreamResult(new File( pullapart.path + ".xml"));
	      transformer.transform(source, result);
	      
	    } catch (ParserConfigurationException pce) {
	      pce.printStackTrace();
	    } catch (TransformerException tfe) {
	      tfe.printStackTrace();
	    }
	  }
}
