package parcInfo.businesslogiclayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;

import parcInfo.businesslogiclayer.converter.ConvertToPdf;
import parcInfo.presentationlayer.Panne;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import javax.swing.ScrollPaneConstants;

public class GestionPanne extends JFrame {
	
	private static final long serialVersionUID = -5321517900129610291L;
	private JPanel contentPane;
	private JTextField IdText;
	private JTextField ComText;
	private JTextField TypeText;
	private JTextField TitreText;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPanne frame = new GestionPanne();
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
	public GestionPanne() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(194, 256, 223, 28);
		contentPane.add(dateChooser);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Déclarer")){
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Déclarer","En cours","Résolue"}));
		comboBox.setBounds(194, 297, 223, 28);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(515, 114, 593, 210);
		
		ComText=new JTextField();
		ComText.setBounds(192, 353, 227, 64);
		contentPane.add(ComText);
	
		
		IdText = new JTextField();
		IdText.setColumns(10);
		IdText.setBounds(194, 140, 223, 29);
		contentPane.add(IdText);
		
		JLabel label = new JLabel("Id:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(12, 149, 83, 14);
		contentPane.add(label);
		
		JLabel lblTitre = new JLabel("Titre:");
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTitre.setBounds(10, 174, 83, 26);
		contentPane.add(lblTitre);
		
		TypeText = new JTextField();
		TypeText.setColumns(10);
		TypeText.setBounds(194, 216, 223, 29);
		contentPane.add(TypeText);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblType.setBounds(10, 217, 83, 20);
		contentPane.add(lblType);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDate.setBounds(10, 260, 83, 14);
		contentPane.add(lblDate);
		
		JLabel lblEtat = new JLabel("Etat:");
		lblEtat.setForeground(Color.WHITE);
		lblEtat.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEtat.setBounds(10, 289, 144, 33);
		contentPane.add(lblEtat);
		
		JLabel lblCommentaire = new JLabel("Commentaire:");
		lblCommentaire.setForeground(Color.WHITE);
		lblCommentaire.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCommentaire.setBounds(10, 371, 144, 33);
		contentPane.add(lblCommentaire);
		
		
		
		TitreText = new JTextField();
		TitreText.setColumns(10);
		TitreText.setBounds(194, 180, 223, 29);
		contentPane.add(TitreText);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\icone jouter.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showMessageDialog(null,"Remplir Les Champs Vide SVP !! ");
				int IdPanne= Integer.parseInt(IdText.getText().trim());
				String Titre=TitreText.getText().trim();
				String TypePanne=TypeText.getText().trim();
				SimpleDateFormat sp=new SimpleDateFormat("yyyy/MM/dd");
				String date=sp.format(dateChooser.getDate());
				String EtatPanne=(String) comboBox.getSelectedItem().toString();
				String Commentaire=ComText.getText();
				
				Panne Panne1=new Panne(IdPanne,Titre,TypePanne,date,EtatPanne,Commentaire);
				 
				 MAJPanne PanneMAJ=new MAJPanne();
				 PanneMAJ.create(Panne1);	
				JOptionPane.showMessageDialog(null,"La Panne à été Ajouter avec Succée");
			}
		});
		button.setFont(new Font("Agency FB", Font.BOLD, 14));
		button.setBounds(47, 428, 46, 53);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\iconeAjouter.jpg"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SimpleDateFormat sp=new SimpleDateFormat("yyyy/MM/dd");

				String date = sp.format(dateChooser.getDate());
				
				Panne P = new Panne(
						Integer.parseInt(IdText.getText()),
						TitreText.getText(),
						TypeText.getText(),
						date,
						comboBox.getSelectedItem().toString(),
						ComText.getText()
						);
				 
				 MAJPanne PanneMAJ=new MAJPanne();
				 try {
					 PanneMAJ.update(P);
					 JOptionPane.showMessageDialog(null,"La Modification a été Effectué");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			}
			
		});
		button_1.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_1.setBounds(125, 428, 46, 53);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\suppicone.jpg"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IdPanne= Integer.parseInt(IdText.getText().trim());
				 MAJPanne PanneMAJ=new MAJPanne();
				 PanneMAJ.remove(IdPanne);	
				 //GestionMateriel.this.dispose();
					JOptionPane.showMessageDialog(null,"La Panne à été Supprimer avec Succée");
			}
		});
		button_2.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_2.setBounds(202, 428, 46, 53);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\Actualiser.jpg"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] columnsNames = {"IdPanne","Titre","TypePanne","Date","EtatPanne","Commentaire"};
				 MAJPanne MAJPanne=new MAJPanne();
				List<Panne> arrayPanne = MAJPanne.findAll();
				DefaultTableModel tableModel = new DefaultTableModel(columnsNames,0);
				//Object[] data = {"IdPanne","Titre","TypePanne","Date","EtatPanne","Commentaire"};
				tableModel.addRow(columnsNames);
				for(int i=0; i < arrayPanne.size(); i++){
					int IdPanne=arrayPanne.get(i).getIdPanne();
					String Titre=arrayPanne.get(i).getTitre();
					String TypePanne=arrayPanne.get(i).getTypePanne();
					//SimpleDateFormat sp=new SimpleDateFormat("yyyy/MM/dd");
					//String date=sp.format(dateChooser.getDate().toString());
					String date=arrayPanne.get(i).getDate();
					String EtatPanne=arrayPanne.get(i).getEtatPanne();
					String Commentaire=arrayPanne.get(i).getCommentaire();
					Object[] data2 = {IdPanne, Titre, TypePanne,date,EtatPanne,Commentaire};
					tableModel.addRow(data2);
				}
				table.setModel(tableModel);
			
			}
		});
		button_3.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_3.setBounds(274, 428, 46, 53);
		contentPane.add(button_3);
		
	
		JLabel label_1 = new JLabel("Rechercher par:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(641, 392, 114, 35);
		contentPane.add(label_1);
		
		final JComboBox<String> cmb = new JComboBox<String>();
		cmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmb.getSelectedItem().equals("idPanne")){
				}
			}
		});
		cmb.setModel(new DefaultComboBoxModel<String>(new String[] {"IdPanne"}));
		cmb.setBounds(766, 347, 190, 35);
		contentPane.add(cmb);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\rechrecher.png"));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cmb.getSelectedItem().equals("IdPanne")){
					try {
						int IdPanne= Integer.parseInt(IdText.getText().trim());
						MAJPanne PanneMAJ=new MAJPanne();
						Panne P = PanneMAJ.findByIdPanne(IdPanne);
						if(P != null){
							 TitreText.setText(P.getTitre());
							 TypeText.setText(P.getTypePanne());
							 ComText.setText(P.getCommentaire());
							 SimpleDateFormat sp=new SimpleDateFormat("yyyy/MM/dd");
							 java.util.Date date;
							try {
								date = sp.parse(P.getDate().toString());
								dateChooser.setDate(date);

							} catch (ParseException e1) {
								e1.printStackTrace();
							}	
							comboBox.setSelectedItem(P.getEtatPanne());
						 }
						 else{
							 JOptionPane.showMessageDialog(null, IdPanne + " n'exist pas !");
						 }
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "ID invalide !");
					}
				}
			}
			
		});
		button_4.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_4.setBounds(854, 407, 26, 20);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_5.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\fermerrr.png"));
		button_5.setBounds(1141, 428, 33, 33);
		contentPane.add(button_5);
		
		table = new JTable();
		table.setEnabled(false);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder((Border) new BevelBorder(BevelBorder.RAISED, null, null, null, null));
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
				"Id", "Titre", "Type", "Date ", "Etat", "Commentaire"
			}
		)
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(56);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(96);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
		table.getColumnModel().getColumn(5).setPreferredWidth(189);
		table.setBounds(516, 115, 593, 210);
		//contentPane.add(table);
		contentPane.add(scrollPane);
		//contentPane.add(scrollBar);
		scrollPane.setViewportView(table);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdText.setText("");
				TitreText.setText("");
				TypeText.setText("");
				dateChooser.setDateFormatString("");
				comboBox.setSelectedItem("");
				ComText.setText("");
				
			}
		});
		button_6.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\vider.jpg"));
		button_6.setFont(new Font("Agency FB", Font.BOLD, 14));
		button_6.setBounds(348, 428, 46, 53);
		contentPane.add(button_6);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\pdf.png"));
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(1128, 192, 46, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\GesPanne.png"));
		lblNewLabel.setBounds(0, 0, 1200, 500);
		contentPane.add(lblNewLabel);
		
		
	}
}
