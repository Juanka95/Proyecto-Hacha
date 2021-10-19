package proyectohacha;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Unir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fusion fusion = new fusion();
				fusion.setVisible(true);
		}});
		btnNewButton.setBounds(50, 234, 129, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Separar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pullapart separar = new pullapart();
				separar.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(365, 234, 156, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Proyecto Hacha");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(172, 67, 265, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  System.exit(0);
				
			}
		});
		btnNewButton_2.setBounds(203, 326, 164, 31);
		contentPane.add(btnNewButton_2);
	}
}
