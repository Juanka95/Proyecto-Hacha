package proyectohacha;


import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JMenu;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class pullapart extends JFrame {
	
	static String path;
	static int partes;
	private JPanel contentPane;
	private JTextField TxtRuta;
	private JSpinner spinner;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner_1 = new JSpinner();
		
		spinner_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		spinner_1.setBounds(278, 240, 171, 20);
		contentPane.add(spinner_1);
		
		JLabel lblNewLabel = new JLabel("Separador");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(233, 29, 233, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ruta de archivo:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(112, 163, 139, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u00BFDonde esta el archivo?");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(89, 106, 184, 14);
		contentPane.add(lblNewLabel_2);
		
		TxtRuta = new JTextField();
		TxtRuta.setToolTipText("Inserta la ruta del fichero de audio");
		TxtRuta.setColumns(10);
		TxtRuta.setBounds(367, 170, 290, 20);
		contentPane.add(TxtRuta);
		
		JButton btnSeleccionar = new JButton("Seleccionar...");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Scanner entrada = null;
				  JFileChooser fileChooser = new JFileChooser();
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
		btnSeleccionar.setBounds(397, 101, 184, 26);
		contentPane.add(btnSeleccionar);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Separar separar = new Separar(path,5);
				
				int valor = (Integer)spinner_1.getValue();
				
			}
		});
		btnNewButton.setBounds(156, 299, 126, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(407, 299, 198, 28);
		contentPane.add(btnNewButton_1);
		
		
	}
}
