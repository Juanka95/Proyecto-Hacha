
import java.io.*;
import java.nio.file.Files;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class unir {
	


    public static void leerXml(String rutaXml) throws ParserConfigurationException, SAXException{
		File xml = new File(rutaXml);
		try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(xml);
            document.getDocumentElement().getNodeName();
            NodeList nList = document.getElementsByTagName("archivo");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nodo = nList.item(temp);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nodo;
                   
                    String ruta = eElement.getElementsByTagName("ruta").item(0).getTextContent();
                    String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                    
                    int partes = Integer.parseInt(eElement.getElementsByTagName("partes").item(0).getTextContent());
//                    int bytes = Integer.parseInt(((Document) element).getElementsByTagName("bytes").item(0).getTextContent());
                   
                   
                    Fusionar(partes, ruta, nombre);
                }
            }
        }catch(IOException e) {
            System.out.println(e);
        }} 
	

    
    
    public static void Fusionar(int partes, String ruta, String nombre) {
		//Conseguir la extension del archivo
    	
    	String extension = "";
    	extension = nombre.replace("^.*\\.(.)$","$1");
		try {
			String directorio;
			if (ruta.indexOf(".") > 0) {
				directorio = ruta.substring(0, ruta.lastIndexOf("."));
			} else {
				directorio= ruta;
			}			
			
			File dirFusion= new File(directorio);
			
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dirFusion+ "\\Fusion."+ extension));

			for(int i=1; i<=partes; i++) {

								
			File f = new File(nombre + "\\" + i +"."+extension);
			RandomAccessFile raf = new RandomAccessFile(f, "r");

			if(f.exists()) {
			//readWrite(raf, bos, tamanyoCopia);
				//El de arriba y este, ambos escriben en archivos. Mas facil este--->
				Files.copy(f.toPath(), bos);//Me pasa los a
			} else {
			
			}
			raf.close();
			}
			bos.close();
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 	
	}
    
}
    
    


