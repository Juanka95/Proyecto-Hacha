

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.UIManager;

public class pullapart extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String path;
	static String ruta;
	static int partes;
	private JPanel Destino;
	private JTextField TxtRuta;
	Separar separar = new Separar(path,partes,ruta);
	public JTextField destino;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public pullapart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 444);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Open");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu Exit = new JMenu("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(Exit);
		Destino = new JPanel();
		Destino.setToolTipText("");
		Destino.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Destino);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(328, 154, 173, 20);
		
		spinner_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		Destino.setLayout(null);
		Destino.add(spinner_1);
		
		JLabel lblNewLabel = new JLabel("Separador");
		lblNewLabel.setBounds(233, 29, 233, 26);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		Destino.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ruta de archivo:");
		lblNewLabel_1.setBounds(78, 112, 139, 33);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Destino.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u00BFDonde esta el archivo?");
		lblNewLabel_2.setBounds(78, 76, 184, 14);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		Destino.add(lblNewLabel_2);
		
		TxtRuta = new JTextField();
		TxtRuta.setBackground(UIManager.getColor("Button.background"));
		TxtRuta.setBounds(328, 119, 290, 20);
		TxtRuta.setToolTipText("Inserta la ruta del fichero de audio");
		TxtRuta.setColumns(10);
		Destino.add(TxtRuta);
		
		JButton btnSeleccionar = new JButton("Seleccionar...");
		btnSeleccionar.setBounds(328, 71, 184, 26);
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Scanner entrada = null;
				  JFileChooser fileChooser = new JFileChooser("C:\\Users\\alumno\\Desktop");
			        fileChooser.showOpenDialog(fileChooser);
			        try {
			        	
			             path = fileChooser.getSelectedFile().getAbsolutePath();                                        
			            File f = new File(path);
			            entrada = new Scanner(f);
			            while (entrada.hasNext()) {
			                System.out.println(entrada.nextLine());		                
			                
			            }
			            TxtRuta.setText(path);
			        } catch (FileNotFoundException e1) {
			            System.out.println(e1.getMessage());
			        } catch (NullPointerException e1) {
			            System.out.println("No se ha seleccionado ningún fichero");
			        } catch (Exception e1) {
			            System.out.println(e1.getMessage());
			        } finally {
			            if (entrada != null) {
			                entrada.close();
			            }
			        }
			    }
				
				
			
		});
		Destino.add(btnSeleccionar);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(156, 299, 126, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Separar separar = new Separar(path,partes,ruta);
				
				int partes = (Integer)spinner_1.getValue();

				separar.partes(partes);	
				
				 JOptionPane.showMessageDialog(null, "Separado con exito");
			}
		});
		Destino.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(407, 299, 198, 28);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipal().setVisible(true);
			}
		});
		Destino.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u00BFEn cuantas partes?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(78, 156, 156, 14);
		Destino.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Destino");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setToolTipText("Destino");
		lblNewLabel_3.setBounds(78, 191, 156, 26);
		Destino.add(lblNewLabel_3);
		
		JButton elegirdestino = new JButton("Destino...");
		elegirdestino.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
			 JFileChooser fileChooser = new JFileChooser("C:\\Users\\alumno\\Desktop");
			 fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			 int seleccion = fileChooser.showSaveDialog(Destino);
			 if(seleccion == JFileChooser.APPROVE_OPTION)
			 {
				 ruta = fileChooser.getSelectedFile().getAbsolutePath();
				
				 destino.setText(ruta);
			 }
			
			
			}
			
		});
		elegirdestino.setBounds(328, 194, 240, 23);
		Destino.add(elegirdestino);
		
		destino = new JTextField();
		destino.setBackground(UIManager.getColor("Button.background"));
		destino.setBounds(328, 240, 240, 20);
		Destino.add(destino);
		destino.setColumns(10);
		
		
		
	
	}
}
