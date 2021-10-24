
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

public class fusion extends JDialog {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    String file;
	String ruta=pullapart.path;

	
	public fusion(){
		setBounds(100, 100, 612, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fusion de ficheros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(131, 34, 284, 42);
		contentPanel.add(lblNewLabel);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					leerXml(ruta);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Union con exito");

			}
		});
		Aceptar.setBounds(304, 300, 94, 31);
		contentPanel.add(Aceptar);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipal().setVisible(true);
				
			}
		});
		Cancelar.setBounds(443, 300, 100, 31);
		contentPanel.add(Cancelar);
		
		JButton btnNewButton_1 = new JButton("Fichero");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  File file = null;
				    JFileChooser chooser = new JFileChooser("C:\\");
				    chooser.setMultiSelectionEnabled(true);
				    int returnVal = chooser.showOpenDialog(null);
				    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				      
				      
				      
				    if (returnVal == JFileChooser.APPROVE_OPTION) {
				        file = chooser.getSelectedFile();
				        String ruta = file.getPath();

				        repaint();
				        try {
							unir.leerXml(ruta);
						} catch (ParserConfigurationException | SAXException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        
				    }

				}                                        

				
		});
		btnNewButton_1.setBounds(205, 159, 164, 42);
		contentPanel.add(btnNewButton_1);
	}
		
		
		 public static void leerXml(String rutaXml) throws IOException, ParserConfigurationException, SAXException {
				File xml = new File(rutaXml);
				try {
		            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		            DocumentBuilder db = dbf.newDocumentBuilder();
		            Document document = db.parse(xml);
		            document.getDocumentElement().getNodeName();
		            NodeList nList = document.getElementsByTagName("archivo");
		            System.out.println("----------------------------");
		            for (int temp = 0; temp < nList.getLength(); temp++) {
		                Node nNode = nList.item(temp);
		                nNode.getNodeName();
		                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                    Element eElement = (Element) nNode;
		                    String ruta = null;
		                    String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
		                    int partes = Integer.parseInt(eElement.getElementsByTagName("partes").item(0).getTextContent());
//		                    int bytes = Integer.parseInt(((Document) eElement).getElementsByTagName("bytes").item(0).getTextContent());
		               
		                    Fusionar(partes, ruta, nombre);
		                }
		            }
		        }catch(IOException e) {
		            System.out.println(e);
		        }
		 }


		private static void Fusionar(int partes, String ruta, String nombre) {
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
