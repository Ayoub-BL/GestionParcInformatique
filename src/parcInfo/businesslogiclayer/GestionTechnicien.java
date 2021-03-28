package parcInfo.businesslogiclayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ImageIcon;

import parcInfo.businesslogiclayer.converter.ConvertToPdf;
import parcInfo.presentationlayer.Technicien;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ScrollPaneConstants;

public class GestionTechnicien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8108987206548539601L;
	private JPanel contentPane;
	private JTextField IdText;
	private JTextField NomText;
	private JTextField PrenomText;
	private JTextField AdresseText;
	private JTextField GSMText;
	private JTextField EmailText;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionTechnicien frame = new GestionTechnicien();
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
	public GestionTechnicien() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Réseau")){
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Réseau","Déveleppement","Maintenance"}));
		comboBox.setBounds(201, 346, 256, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(515, 114, 593, 210);
		
		JLabel label = new JLabel("Id:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Agency FB", Font.BOLD, 18));
		label.setBounds(34, 105, 83, 14);
		contentPane.add(label);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblNom.setBounds(34, 130, 83, 26);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		lblPrnom.setForeground(Color.WHITE);
		lblPrnom.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblPrnom.setBounds(34, 173, 83, 20);
		contentPane.add(lblPrnom);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setForeground(Color.WHITE);
		lblAdresse.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblAdresse.setBounds(34, 220, 83, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblGsm = new JLabel("GSM:");
		lblGsm.setForeground(Color.WHITE);
		lblGsm.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblGsm.setBounds(32, 257, 144, 33);
		contentPane.add(lblGsm);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblEmail.setBounds(34, 301, 83, 29);
		contentPane.add(lblEmail);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\Actualiser.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] columnsNames = {"Id","Nom","Prenom","Adresse","GSM","Email","Specialite"};
				 MAJTechnicien MAJTechnicein=new MAJTechnicien();
				List<Technicien> arraytech = MAJTechnicein.findAll();
				DefaultTableModel tableModel = new DefaultTableModel(columnsNames,0);
				//Object[] data = {"IdTechnicein","NomTechnicien","PrenomTechnicien","AdresseTechnicien","GSMTechnicien","EmailTechnicien","Specialite"};
				tableModel.addRow(columnsNames);
				for(int i=0; i < arraytech.size(); i++){
					int IdTechnicien=arraytech.get(i).getIdTechnicien();
					String Nom=arraytech.get(i).getNomTechnicien();
					String Prenom=arraytech.get(i).getPrenomTechnicien();
					String Adresse=arraytech.get(i).getAdresseTechnicien();
					String GSM=arraytech.get(i).getGsmTechnicien();
					String Email=arraytech.get(i).getEmailTechnicien();
					String comboBox=arraytech.get(i).getSpecialiteTechnicien();

					//String Specialite=arraytech.get(i).getSpecialiteTechnicien();
					Object[] data2 = {IdTechnicien, Nom, Prenom,Adresse,GSM,Email,comboBox};
					tableModel.addRow(data2);
				}
				table.setModel(tableModel);
			
			}
		});
		button.setFont(new Font("Agency FB", Font.BOLD, 14));
		button.setBounds(331, 397, 47, 53);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\suppicone.jpg"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int IdPanne= Integer.parseInt(IdText.getText().trim());
				 MAJTechnicien TechnicienMAJ=new MAJTechnicien();
				 TechnicienMAJ.remove(IdPanne);	
				 //GestionMateriel.this.dispose();
					JOptionPane.showMessageDialog(null,"Les donnée du technicien à été Supprimer avec Succée");
			}
		});
		button_1.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_1.setBounds(240, 397, 47, 53);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\iconeAjouter.jpg"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Technicien tech = new Technicien(
						Integer.parseInt(IdText.getText()),
						NomText.getText(),
						PrenomText.getText(),
						AdresseText.getText(),
						GSMText.getText(),
						EmailText.getText(),
						comboBox.getSelectedItem().toString()
						);
				 
				 MAJTechnicien TechnicienMAJ=new MAJTechnicien();
				 try {
					TechnicienMAJ.update(tech);
					JOptionPane.showMessageDialog(null,"La Modification a été Effectuer");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
		});
		button_2.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_2.setBounds(154, 397, 47, 53);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\icone jouter.jpg"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int IdTechnicien= Integer.parseInt(IdText.getText().trim());
				String NomTechnicien=NomText.getText().trim();
				String PrenomTechnicien=PrenomText.getText().trim();
				String AdresseTechnicien=AdresseText.getText().trim();
				String GSMTechnicien=GSMText.getText();
				String EmailTechnicien=EmailText.getText();
				String SpecialiteTechnicien=(String) comboBox.getSelectedItem().toString();

				
				Technicien tech1=new Technicien(IdTechnicien,NomTechnicien,PrenomTechnicien,AdresseTechnicien,GSMTechnicien,EmailTechnicien,SpecialiteTechnicien);
				 
				 MAJTechnicien TechnicienMAJ=new MAJTechnicien();
				 TechnicienMAJ.create(tech1);	
				JOptionPane.showMessageDialog(null,"Les donnée du technicien à été Ajouter avec Succée");
			}
		});
		button_3.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_3.setBounds(60, 397, 47, 53);
		contentPane.add(button_3);
		
		JLabel lblSpcialit = new JLabel("Sp\u00E9cialit\u00E9:");
		lblSpcialit.setForeground(Color.WHITE);
		lblSpcialit.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblSpcialit.setBounds(34, 339, 83, 29);
		contentPane.add(lblSpcialit);
		
		IdText = new JTextField();
		IdText.setBounds(202, 105, 255, 20);
		contentPane.add(IdText);
		IdText.setColumns(10);
		
		NomText = new JTextField();
		NomText.setColumns(10);
		NomText.setBounds(202, 136, 255, 20);
		contentPane.add(NomText);
		
		PrenomText = new JTextField();
		PrenomText.setColumns(10);
		PrenomText.setBounds(202, 176, 255, 20);
		contentPane.add(PrenomText);
		
		AdresseText = new JTextField();
		AdresseText.setColumns(10);
		AdresseText.setBounds(202, 220, 255, 20);
		contentPane.add(AdresseText);
		
		GSMText = new JTextField();
		GSMText.setColumns(10);
		GSMText.setBounds(202, 266, 255, 20);
		contentPane.add(GSMText);
		
		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(202, 308, 255, 20);
		contentPane.add(EmailText);
		
		JLabel label_1 = new JLabel("Rechercher par:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Agency FB", Font.BOLD, 18));
		label_1.setBounds(683, 378, 114, 35);
		contentPane.add(label_1);
		
		
		final JComboBox<String> cmb = new JComboBox<String>();
		cmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmb.getSelectedItem().equals("IdTechnicein")){
				}
			}
		});
		cmb.setModel(new DefaultComboBoxModel<String>(new String[] {"IdTechnicien"}));
		cmb.setBounds(793, 346, 190, 35);
		contentPane.add(cmb);
		
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\rechrecher.png"));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmb.getSelectedItem().equals("IdTechnicien")){
					try {
						int IdTechnicien= Integer.parseInt(IdText.getText().trim());
						MAJTechnicien technicienMAJ=new MAJTechnicien();
						Technicien tech = technicienMAJ.findByIdTeTechnicien(IdTechnicien);
						if(tech != null){
							NomText.setText(tech.getNomTechnicien());
						 	PrenomText.setText(tech.getPrenomTechnicien());
						 	AdresseText.setText(tech.getAdresseTechnicien());
							GSMText.setText(tech.getGsmTechnicien());
							EmailText.setText(tech.getEmailTechnicien());
							comboBox.setSelectedItem(tech.getSpecialiteTechnicien());
						 }
						 else{
							 JOptionPane.showMessageDialog(null, IdTechnicien + " n'exist pas !");
						 }
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "ID invalide !");
					}
				}
			}
		});
		button_4.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_4.setBounds(865, 397, 26, 29);
		contentPane.add(button_4);
		table = new JTable();
		table.setEnabled(false);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder((Border) new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"IdTech", "Nom", "Prenom", "Adresse ", "GSM", "EMail", "Specialite"
			}
		)
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		table.getColumnModel().getColumn(3).setPreferredWidth(118);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(101);
		table.setBounds(517, 107, 593, 210);
		//scrollpanne.setViewportView(table);
		//contentPane.add(table);
		//scrollpanne.add(table);
		contentPane.add(scrollPane);
		//contentPane.add(scrollBar);
		scrollPane.setViewportView(table);
	
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\fermerrr.png"));
		btnNewButton.setBounds(1128, 415, 33, 33);
		contentPane.add(btnNewButton);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 IdText.setText("");
				 NomText.setText("");
				 PrenomText.setText("");
				 AdresseText.setText("");
				 GSMText.setText("");
				 EmailText.setText("");
				 comboBox.setSelectedItem("");
			}
		});
		button_5.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\vider.jpg"));
		button_5.setBounds(418, 397, 47, 53);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConvertToPdf top=new ConvertToPdf();
				 JFileChooser fc = new JFileChooser();
	                int option = fc.showSaveDialog(table);
	                if(option == JFileChooser.APPROVE_OPTION){
	                    String filename = fc.getSelectedFile().getName(); 
	                    String path = fc.getSelectedFile().getParentFile().getPath();

						int len = filename.length();
						String ext = "";
						String file = "";

						if(len > 4){
							ext = filename.substring(len-4, len);
						}

						if(ext.equals(".pdf")){
							file = path + "\\" + filename; 
						}else{
							file = path + "\\" + filename + ".pdf"; 
						}
						top.toPDF(table, new File(file));
	                }
			}
		});
		button_6.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\pdf.png"));
		button_6.setBounds(1130, 194, 47, 53);
		contentPane.add(button_6);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\Gestech.png"));
		lblNewLabel.setBounds(0, 0, 1200, 500);
		contentPane.add(lblNewLabel);
	}
}
