package parcInfo.businesslogiclayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JScrollPane;

import parcInfo.businesslogiclayer.converter.ConvertToPdf;
import parcInfo.presentationlayer.Salle;
import javax.swing.ScrollPaneConstants;

public class GestionSalle extends JFrame {

	private static final long serialVersionUID = 4495717269012144744L;
	private JPanel contentPane;
	private JTextField IdText;
	private JTextField LibelleText;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionSalle frame = new GestionSalle();
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
	public GestionSalle() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Id:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Agency FB", Font.BOLD, 18));
		label.setBounds(12, 128, 83, 14);
		contentPane.add(label);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Ordinateur")){
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Ordinateur,videoProjecteur","Router,Cable,Switsh","Imprimante,Ordinateur"}));
		comboBox.setBounds(197, 220, 220, 26);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(515, 114, 593, 210);
		
		JLabel lblLibelle = new JLabel("Libelle :");
		lblLibelle.setForeground(Color.WHITE);
		lblLibelle.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblLibelle.setBounds(12, 159, 83, 26);
		contentPane.add(lblLibelle);
		
		JLabel lblListeDesMatrils = new JLabel("Liste des mat\u00E9ri\u00E9ls:");
		lblListeDesMatrils.setForeground(Color.WHITE);
		lblListeDesMatrils.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblListeDesMatrils.setBounds(12, 226, 154, 20);
		contentPane.add(lblListeDesMatrils);
		
		IdText = new JTextField();
		IdText.setColumns(10);
		IdText.setBounds(196, 119, 221, 29);
		contentPane.add(IdText);
		
		LibelleText = new JTextField();
		LibelleText.setColumns(10);
		LibelleText.setBounds(198, 164, 221, 29);
		contentPane.add(LibelleText);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\fermerrr.png"));
		button.setBounds(1130, 417, 32, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IdSalle= Integer.parseInt(IdText.getText().trim());
				String Libelle=LibelleText.getText().trim();
				String ListeMateriels=(String) comboBox.getSelectedItem().toString();
				Salle Salle1=new Salle(IdSalle,Libelle,ListeMateriels);
				 
				 MAJSalle SalleMAJ=new MAJSalle();
				 SalleMAJ.create(Salle1);	
				JOptionPane.showMessageDialog(null,"Les donnée de la salle à été Ajouter avec Succée");
			}
		});
		button_1.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\icone jouter.jpg"));
		button_1.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_1.setBounds(31, 402, 47, 53);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Salle sl = new Salle(
						Integer.parseInt(IdText.getText()),
						LibelleText.getText(),
						comboBox.getSelectedItem().toString()
						
						);
				 
				 MAJSalle SalleMAJ=new MAJSalle();
				 try {
					 SalleMAJ.update(sl);
					 JOptionPane.showMessageDialog(null,"La Modification a été Effectué");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		button_2.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\iconeAjouter.jpg"));
		button_2.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_2.setBounds(115, 402, 47, 53);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IdSalle= Integer.parseInt(IdText.getText().trim());
				 MAJSalle SalleMAJ=new MAJSalle();
				 SalleMAJ.remove(IdSalle);	
				 //GestionMateriel.this.dispose();
					JOptionPane.showMessageDialog(null,"Les donnée de la salle à été Supprimer avec Succée");
			}
		});
		button_3.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\suppicone.jpg"));
		button_3.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_3.setBounds(194, 402, 47, 53);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] columnsNames = {"IdSalle","Libelle","ListeMateriel"};
				 MAJSalle MAJSalle=new MAJSalle();
				List<Salle> arraySalle = MAJSalle.findAll();
				DefaultTableModel tableModel = new DefaultTableModel(columnsNames,0);
				//Object[] data = {"IdSalle","Libelle","ListeMateriel"};
				tableModel.addRow(columnsNames);
				for(int i=0; i < arraySalle.size(); i++){
					int IdSalle=arraySalle.get(i).getIdSalle();
					String Libelle=arraySalle.get(i).getLibelle();
					String comboBox=arraySalle.get(i).getListeMateriles();
					//String comboBox=(String) ((JComboBox<String>) arraySalle).getSelectedItem();
					Object[] data2 = {IdSalle, Libelle,comboBox};
					tableModel.addRow(data2);
				}
				table.setModel(tableModel);
			
			}
		});
		button_4.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\Actualiser.jpg"));
		button_4.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_4.setBounds(271, 402, 47, 53);
		contentPane.add(button_4);
		
		JLabel label_1 = new JLabel("Rechercher par:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Agency FB", Font.BOLD, 18));
		label_1.setBounds(541, 378, 114, 35);
		contentPane.add(label_1);
		
		final JComboBox<String> cmb = new JComboBox<String>();
		cmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmb.getSelectedItem().equals("idSalle")){
				}
			}
		});
		cmb.setModel(new DefaultComboBoxModel<String>(new String[] {"IdSalle"}));
		cmb.setBounds(651, 346, 190, 35);
		contentPane.add(cmb);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cmb.getSelectedItem().equals("IdSalle")){
					try {
						int IdSalle = Integer.parseInt(IdText.getText().trim());
						MAJSalle SalleMAJ=new MAJSalle();
						Salle S = SalleMAJ.findByIdSalle(IdSalle);
						if(S != null){
							// IdText.setText(m.getIdMat());
							LibelleText.setText(S.getLibelle());
							comboBox.setSelectedItem(S.getListeMateriles());
						}
						else{
							JOptionPane.showMessageDialog(null, IdSalle + " n'exist pas !");
						}
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "ID invalide !");
					}
				}
			}
		});
		button_5.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\rechrecher.png"));
		button_5.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_5.setBounds(741, 402, 26, 26);
		contentPane.add(button_5);
		
		table = new JTable();
		table.setEnabled(false);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"IdSalle", "Libelle", "Materiels"
			}
		)
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(451);

		table.setBounds(447, 109, 579, 215);
		//contentPane.add(table);
		contentPane.add(scrollPane);
		//contentPane.add(scrollBar);
		scrollPane.setViewportView(table);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 IdText.setText("");
				 LibelleText.setText("");
				
			}
		});
		button_6.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\vider.jpg"));
		button_6.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_6.setBounds(355, 402, 47, 53);
		contentPane.add(button_6);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\pdf.png"));
		btnNewButton.setBounds(1084, 193, 47, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\GesSalle.png"));
		lblNewLabel.setBounds(0, 0, 1200, 500);
		contentPane.add(lblNewLabel);
		
		
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 278, -22, -25);
		contentPane.add(scrollPane);*/
	}
}
