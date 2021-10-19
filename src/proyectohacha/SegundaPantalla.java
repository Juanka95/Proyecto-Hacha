	package proyectohacha;
	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.*;
	import javax.swing.*;
	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import javax.swing.JButton;
	import javax.swing.JDialog;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.filechooser.FileNameExtensionFilter;
	
	
public class SegundaPantalla extends JFrame {

			String ruta;
			int partes=3;


		
		    private JPanel contentPane;
		    private JTextField textField;
		    private JTextArea textArea;

		private final JPanel contentPanel = new JPanel();

		
		
		/**
		 * Launch the application.
		 */
		
		

		/**
		 * Create the dialog.
		 */
		public SegundaPantalla() {
			setBounds(100, 100, 740, 426);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setLayout(new FlowLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setBounds(100, 100, 450, 300);
		       
		        contentPane = new JPanel();
		        contentPane.setLayout(null);
		        setContentPane(contentPane);
		 
		        textField = new JTextField();
		        textField.setToolTipText("Inserta la ruta del fichero de audio");
		        textField.setBounds(52, 26, 209, 20);
		        contentPane.add(textField);
		        textField.setColumns(10);
		 
		        JButton btnSeleccionar = new JButton("Seleccionar...");
		        btnSeleccionar.setBounds(288, 25, 109, 23);
		        contentPane.add(btnSeleccionar);
		 
		        textArea = new JTextArea();
		        textArea.setLineWrap(true);
		        textArea.setWrapStyleWord(true);
		        textArea.setBounds(52, 76, 360, 156);
		 
		        JScrollPane scroll=new JScrollPane(textArea);
		        scroll.setBounds(52, 76, 360, 156);
		        contentPane.add(scroll);
		 
		        btnSeleccionar.addActionListener(new ActionListener(){
		            public void actionPerformed (ActionEvent e){
		            	llamadaSeparar();
		            }
		            
		        });
		        
		        JFileChooser fc=new JFileChooser();
		        
		
		      int seleccion=fc.showOpenDialog(contentPane);
		       

		      if(seleccion==JFileChooser.APPROVE_OPTION){
		       
		
		          File fichero=fc.getSelectedFile();
		       

		          textField.setText(fichero.getAbsolutePath());
		       
		          try(FileReader fr=new FileReader(fichero)){
		              String cadena="";
		              int valor=fr.read();
		              while(valor!=-1){
		                  cadena=cadena+(char)valor;
		                  valor=fr.read();
		              }
		              textArea.setText(cadena);
		          } catch (IOException e1) {
		              e1.printStackTrace();
		          }
		      }
		      
		      
		    
		      FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.XML", "xml");
		       
		 
		      fc.setFileFilter(filtro);
		}
		      protected void llamadaSeparar()   {
		  		
		  		try {
		  			ManejoFicheros.dividir(ruta, partes);
		  		} catch (IOException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
		  	
		}
}
