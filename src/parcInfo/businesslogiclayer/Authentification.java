package parcInfo.businesslogiclayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;



import java.awt.Color;
import java.awt.Toolkit;

public class Authentification extends JFrame {

	private static final long serialVersionUID = -5487156758830014972L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtpsw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Gestion de Parc Informatique\\Icone\\47144.png"));
		setResizable(false);
		setTitle("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 353);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(115, 104, 151, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtpsw = new JPasswordField();
			
		txtpsw.setBounds(115, 159, 151, 20);
		contentPane.add(txtpsw);
		txtpsw.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 107, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de Passe  : ");
		lblNewLabel_1.setBounds(10, 162, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnconnecte = new JButton("Connectez-Vous");
		btnconnecte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if( txtLogin.getText().equals("Admin") && txtpsw.getText().equals("123456") ){
					PageAcceuil frame = new PageAcceuil();
					frame.setVisible(true);
					dispose();

				} else{
					JOptionPane.showMessageDialog(null,"Login ou Password incorrect !!!");

				}
			}
			
		
		});
		btnconnecte.setBounds(196, 291, 129, 23);
		contentPane.add(btnconnecte);
		
		JButton btnhide = new JButton("Annuler");
		btnhide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		btnhide.setBounds(335, 291, 143, 23);
		contentPane.add(btnhide);
		
		JLabel lblBienvenueAuParcinfo = new JLabel("");
		lblBienvenueAuParcinfo.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\logo.png"));
		lblBienvenueAuParcinfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBienvenueAuParcinfo.setBounds(99, 11, 281, 51);
		contentPane.add(lblBienvenueAuParcinfo);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\1password-login-image-png-1000x600-pixels.png"));
		btnNewButton.setBounds(319, 63, 159, 217);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\images.jpg"));
		btnNewButton_1.setBounds(10, 190, 299, 90);
		contentPane.add(btnNewButton_1);
	}
}
