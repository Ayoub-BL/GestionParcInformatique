package parcInfo.businesslogiclayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class PageAcceuil extends JFrame {

	private static final long serialVersionUID = 3377098430126422091L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageAcceuil frame = new PageAcceuil();
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
	public PageAcceuil() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Gestion de Parc Informatique\\Icone\\gestion-parc.png"));
		setTitle("Page d'Acceuil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 946, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestionDesPannes = new JButton("Gestion des pannes");
		btnGestionDesPannes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionPanne frame=new GestionPanne();
				frame.setVisible(true);
			}
		});
		btnGestionDesPannes.setBackground(Color.LIGHT_GRAY);
		btnGestionDesPannes.setForeground(Color.RED);
		btnGestionDesPannes.setFont(new Font("Agency FB", Font.BOLD, 13));
		btnGestionDesPannes.setBounds(249, 415, 140, 32);
		contentPane.add(btnGestionDesPannes);
		
		JButton btnGestionDesTechnicien = new JButton("Gestion des Techniciens");
		btnGestionDesTechnicien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionTechnicien frame=new GestionTechnicien();
				frame.setVisible(true);
			}
		});
		btnGestionDesTechnicien.setForeground(Color.RED);
		btnGestionDesTechnicien.setFont(new Font("Agency FB", Font.BOLD, 13));
		btnGestionDesTechnicien.setBackground(Color.LIGHT_GRAY);
		btnGestionDesTechnicien.setBounds(595, 415, 182, 32);
		contentPane.add(btnGestionDesTechnicien);
		
		JButton btnGestionDesSalles = new JButton("Gestion des Salles");
		btnGestionDesSalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionSalle frame=new GestionSalle();
				frame.setVisible(true);
			}
		});
		btnGestionDesSalles.setForeground(Color.RED);
		btnGestionDesSalles.setFont(new Font("Agency FB", Font.BOLD, 13));
		btnGestionDesSalles.setBackground(Color.LIGHT_GRAY);
		btnGestionDesSalles.setBounds(150, 507, 129, 32);
		contentPane.add(btnGestionDesSalles);
		
		JButton button = new JButton("Gestion des Matériels");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionMateriels frame = new GestionMateriels();
				frame.setVisible(true);
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Agency FB", Font.BOLD, 13));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(662, 511, 147, 32);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\Sans titre-3P.png"));
		lblNewLabel.setBounds(0, 0, 946, 643);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 930, 21);
		contentPane.add(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Voulez-Vous Quitter L'application ... !");
				System.exit(0);
				
			}
		});
		mnFichier.add(mntmQuitter);
		
		JMenu mnEddition = new JMenu("Eddition");
		menuBar.add(mnEddition);
		
		JMenuItem mntmGestionMateriels = new JMenuItem("Gestion Materiels");
		mntmGestionMateriels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionMateriels frame = new GestionMateriels();
				frame.setVisible(true);
			}
		});
		mnEddition.add(mntmGestionMateriels);
		
		JMenuItem mntmGestionPanne = new JMenuItem("Gestion Panne");
		mntmGestionPanne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionPanne frame = new GestionPanne();
				frame.setVisible(true);
			}
		});
		
		mnEddition.add(mntmGestionPanne);
		
		JMenuItem mntmGestionSalle = new JMenuItem("Gestion Salle");
		mntmGestionSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionSalle frame = new GestionSalle();
				frame.setVisible(true);
			}
		});
		mnEddition.add(mntmGestionSalle);
		
		JMenuItem mntmGestionTechnicien = new JMenuItem("Gestion Technicien");
		mntmGestionTechnicien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionTechnicien frame=new GestionTechnicien();
				frame.setVisible(true);
			}
		});
		mnEddition.add(mntmGestionTechnicien);
		
		JMenu menu = new JMenu("?");
		menuBar.add(menu);
		
		JMenuItem mntmApropos = new JMenuItem("Apropos");
		mntmApropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Apropos frame = new Apropos();
				frame.setVisible(true);
			}
		});
		menu.add(mntmApropos);
		
		JMenuItem mntmAfficherLaide = new JMenuItem("Afficher L'aide");
		mntmAfficherLaide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime r = Runtime.getRuntime();
				 
			    try{
			        r.exec("cmd /c start http://www.iga-fes.ma/");
			        //System.out.println("Ouverture réussi");
			    }
			 
			    catch (IOException ex){
			        ex.printStackTrace();
			       // System.out.println("Ouverture échoué");
			    }
				
			}
		});
		menu.add(mntmAfficherLaide);
	}
}
