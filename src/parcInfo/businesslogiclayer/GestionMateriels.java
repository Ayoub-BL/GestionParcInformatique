package parcInfo.businesslogiclayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import parcInfo.businesslogiclayer.converter.ConvertToPdf;
import parcInfo.presentationlayer.Materiel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ScrollPaneConstants;

public class GestionMateriels extends JFrame {

	private static final long serialVersionUID = -694480929932414776L;
	private JPanel contentPane;
	private JTextField IdText;
	private JTextField MarqueText;
	private JTextField SerialText;
	private JTable table;
	private JTextField LogiceilText;
	private JTextField CategText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionMateriels frame = new GestionMateriels();
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
	public GestionMateriels() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cmb.getSelectedItem().equals("IdMat")){
					
				}
			}
		});
		cmb.setModel(new DefaultComboBoxModel<String>(new String[] {"IdMat"}));
		//final JComboBox cmb = new JComboBox();*/
		cmb.setBounds(711, 351, 190, 35);
		contentPane.add(cmb);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Windows XP")){
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Pas de Systèmes","Windows XP","Windows 7","Linux","Mandriva","Oracle"}));
		comboBox.setBounds(194, 261, 221, 25);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(469, 114, 639, 200);

		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//JOptionPane.showMessageDialog(null,"Remplir Les Champs Vide SVP !! ");
				int idMat= Integer.parseInt(IdText.getText().trim());
				String CategorieMat=CategText.getText().trim();
				String Marque=MarqueText.getText().trim();
				String serial=SerialText.getText().trim();
				String NomSE=(String) comboBox.getSelectedItem().toString();
				String Logiceils=LogiceilText.getText().trim();
				
				Materiel Materiel1=new Materiel(idMat,CategorieMat,Marque,serial,NomSE,Logiceils);
				 
				 MAJMateriel MaterielMAJ=new MAJMateriel();
				 MaterielMAJ.create(Materiel1);	
				JOptionPane.showMessageDialog(null,"Le Matériel à été Ajouter avec Succée");
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\icone jouter.jpg"));
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnNewButton.setBounds(34, 397, 48, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblRechercherPar = new JLabel("Rechercher par:");
		lblRechercherPar.setForeground(Color.WHITE);
		lblRechercherPar.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblRechercherPar.setBounds(593, 391, 114, 35);
		contentPane.add(lblRechercherPar);
		
		
		JButton btnModifier = new JButton("");
		btnModifier.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\iconeAjouter.jpg"));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Materiel m = new Materiel(
						Integer.parseInt(IdText.getText()),
						CategText.getText(),
						MarqueText.getText(),
						SerialText.getText(),
						comboBox.getSelectedItem().toString(),
						LogiceilText.getText()
						);
				 
				 MAJMateriel MaterielMAJ=new MAJMateriel();
				 try {
					 MaterielMAJ.update(m);
					JOptionPane.showMessageDialog(null,"La Modification a été Effectuer");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnModifier.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnModifier.setBounds(118, 397, 48, 53);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("");
		btnSupprimer.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\suppicone.jpg"));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int IdMat= Integer.parseInt(IdText.getText().trim());
				 MAJMateriel MaterielMAJ=new MAJMateriel();
				 MaterielMAJ.remove(IdMat);	
				 //GestionMateriel.this.dispose();
					JOptionPane.showMessageDialog(null,"Le Matériel à été Supprimer avec Succée");
			}
		});
		btnSupprimer.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSupprimer.setBounds(206, 397, 48, 53);
		contentPane.add(btnSupprimer);
		
		JButton btnActualiser = new JButton("");
		btnActualiser.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\Actualiser.jpg"));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] columnsNames = {"IdMat","Categorie","Marque","Serial","NomSE","Logiceils"};
				 MAJMateriel MaterielMAJ=new MAJMateriel();
				List<Materiel> arrayMate = MaterielMAJ.findAll();
				DefaultTableModel tableModel = new DefaultTableModel(columnsNames,0);
				//Object[] data = {"IdMat", "Categorie", "Marque","Serial","NomSE","Logiceils"};
				tableModel.addRow(columnsNames);
				for(int i=0; i < arrayMate.size(); i++){
					int IdMat=arrayMate.get(i).getIdMat();
					String CategorieMat=arrayMate.get(i).getCategorieMat();
					String Marque=arrayMate.get(i).getMarque();
					String Serial=arrayMate.get(i).getSerial();
					String NomSE=arrayMate.get(i).getNomSE();
					String Logiceils=arrayMate.get(i).getLogiciels();
					Object[] data2 = {IdMat, CategorieMat, Marque,Serial,NomSE,Logiceils};
					tableModel.addRow(data2);
				}
				table.setModel(tableModel);
			}
		});
		btnActualiser.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnActualiser.setBounds(290, 397, 48, 53);
		contentPane.add(btnActualiser);
		
		JButton btnChercher = new JButton("");
		btnChercher.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\rechrecher.png"));
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmb.getSelectedItem().equals("IdMat")){
					try {
						int IdMat= Integer.parseInt(IdText.getText().trim());
						MAJMateriel MaterielMAJ=new MAJMateriel();
						Materiel M = MaterielMAJ.findByIdMat(IdMat);
						if(M != null){
							CategText.setText(M.getCategorieMat());
						 	MarqueText.setText(M.getMarque());
						 	SerialText.setText(M.getSerial());
							LogiceilText.setText(M.getLogiciels());
							comboBox.setSelectedItem(M.getNomSE());
						 }
						 else{
							 JOptionPane.showMessageDialog(null, IdMat + " n'exist pas !");
						 }
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "ID invalide !");
					}
				}
			}
		});
		btnChercher.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnChercher.setBounds(798, 413, 27, 25);
		contentPane.add(btnChercher);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblId.setBounds(12, 113, 83, 14);
		contentPane.add(lblId);
		
		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie:");
		lblCatgorie.setForeground(Color.WHITE);
		lblCatgorie.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCatgorie.setBounds(10, 138, 83, 26);
		contentPane.add(lblCatgorie);
		
		JLabel lblMarque = new JLabel("Marque:");
		lblMarque.setForeground(Color.WHITE);
		lblMarque.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMarque.setBounds(10, 181, 83, 20);
		contentPane.add(lblMarque);
		
		JLabel lblNSrie = new JLabel("Serial :");
		lblNSrie.setForeground(Color.WHITE);
		lblNSrie.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNSrie.setBounds(10, 224, 83, 14);
		contentPane.add(lblNSrie);
		
		JLabel lblSystmeDeploitation = new JLabel("Syst\u00E9me d'eploitation:");
		lblSystmeDeploitation.setForeground(Color.WHITE);
		lblSystmeDeploitation.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSystmeDeploitation.setBounds(10, 253, 144, 33);
		contentPane.add(lblSystmeDeploitation);
		
		JLabel lblLogiciels = new JLabel("Logiciels :");
		lblLogiciels.setForeground(Color.WHITE);
		lblLogiciels.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblLogiciels.setBounds(10, 321, 83, 29);
		contentPane.add(lblLogiciels);
		
		IdText = new JTextField();
		IdText.setBounds(194, 104, 221, 29);
		contentPane.add(IdText);
		IdText.setColumns(10);
		
		MarqueText = new JTextField();
		MarqueText.setBounds(194, 179, 221, 29);
		contentPane.add(MarqueText);
		MarqueText.setColumns(10);
		
		SerialText = new JTextField();
		SerialText.setBounds(194, 219, 221, 29);
		contentPane.add(SerialText);
		SerialText.setColumns(10);
		
		table = new JTable();
		table.setEnabled(false);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"IdMat", "Categorie", "Marque", "Serial ", "NomSE", "Logiceils"
			}
		)
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(56);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(73);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		table.getColumnModel().getColumn(4).setPreferredWidth(151);
		table.getColumnModel().getColumn(5).setPreferredWidth(189);
		table.setBounds(515, 114, 593, 210);
		//contentPane.add(table);
		contentPane.add(scrollPane);
		//scrollPane.setViewportView(scrollBar);
		scrollPane.setViewportView(table);

		
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\fermerrr.png"));
		button.setBounds(1141, 421, 33, 33);
		contentPane.add(button);
		
		LogiceilText = new JTextField();
		LogiceilText.setColumns(10);
		LogiceilText.setBounds(196, 306, 221, 75);
		contentPane.add(LogiceilText);
		
		CategText = new JTextField();
		CategText.setColumns(10);
		CategText.setBounds(194, 143, 221, 29);
		contentPane.add(CategText);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdText.setText("");
				CategText.setText("");
				MarqueText.setText("");
				SerialText.setText("");
				comboBox.setSelectedItem("");
				LogiceilText.setText("");
				
				}
		});
		button_1.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\vider.jpg"));
		button_1.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_1.setBounds(380, 397, 48, 53);
		contentPane.add(button_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
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
		btnNewButton_1.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\pdf.png"));
		btnNewButton_1.setBounds(1126, 181, 48, 53);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\GesMat.png"));
		lblNewLabel.setBounds(0, 0, 1200, 500);
		contentPane.add(lblNewLabel);
		
	
		
	}
}
