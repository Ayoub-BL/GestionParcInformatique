package parcInfo.businesslogiclayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apropos extends JFrame {

	private static final long serialVersionUID = -7762883922525660021L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apropos frame = new Apropos();
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
	public Apropos() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Apropos du L'application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("R\u00E9aliser Par : ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblNewLabel.setBounds(45, 32, 223, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ayoub BOULAHYA");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 14));
		lblNewLabel_1.setBounds(126, 74, 110, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Said Soufane");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 14));
		lblNewLabel_2.setBounds(136, 108, 100, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BahaeAddine Zraraâ");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.BOLD, 14));
		lblNewLabel_3.setBounds(146, 142, 200, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblmeAnne = new JLabel("4 \u00E8me Anne Ing\u00E9nieurie des Syst\u00E8mes d'informatique");
		lblmeAnne.setForeground(Color.BLUE);
		lblmeAnne.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblmeAnne.setBounds(65, 184, 303, 31);
		contentPane.add(lblmeAnne);
		
		JLabel lblCopyright = new JLabel("CopyRight @ 2017");
		lblCopyright.setForeground(new Color(255, 0, 51));
		lblCopyright.setFont(new Font("Agency FB", Font.BOLD, 14));
		lblCopyright.setBounds(162, 226, 123, 25);
		contentPane.add(lblCopyright);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\47144.png"));
		btnNewButton.setBounds(84, 66, 32, 31);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\47144.png"));
		button.setBounds(94, 108, 32, 31);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\47144.png"));
		button_1.setBounds(104, 144, 32, 31);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\logo.png"));
		lblNewLabel_4.setBounds(283, 74, 141, 93);
		contentPane.add(lblNewLabel_4);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\fermerrr.png"));
		button_2.setBounds(392, 226, 32, 31);
		contentPane.add(button_2);
	}

}
