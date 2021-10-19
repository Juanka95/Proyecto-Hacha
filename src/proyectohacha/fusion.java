package proyectohacha;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class fusion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			fusion dialog = new fusion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public fusion() {
		setBounds(100, 100, 612, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Unir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Scanner entrada = null;
				  JFileChooser fileChooser = new JFileChooser();
			        fileChooser.showOpenDialog(fileChooser);
			        try {
			            String ruta = fileChooser.getSelectedFile().getAbsolutePath();                                        
			            File f = new File(ruta);
			            entrada = new Scanner(f);
			            while (entrada.hasNext()) {
			                System.out.println(entrada.nextLine());
			            }
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
		btnNewButton.setBounds(203, 199, 164, 42);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Fusion de ficheros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(125, 40, 284, 42);
		contentPanel.add(lblNewLabel);
	}
}
