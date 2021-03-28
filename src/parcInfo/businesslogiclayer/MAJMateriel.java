package parcInfo.businesslogiclayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parcInfo.persistencelayer.entity.ConnectionMySQL;
import parcInfo.presentationlayer.Materiel;

public class MAJMateriel {

		private Connection con;
		private PreparedStatement ps;
		
		//centraliser le code SQL à cet endroit
		//private static String  findByCategorie = "SELECT * FROM Materiel WHERE CategorieMat=?";
		private static String  findByIdMat = "SELECT * FROM Materiel WHERE IdMat=?";
		private static String  findAll = "SELECT * FROM Materiel";
		private static String  create = "INSERT INTO Materiel (IdMat, CategorieMat, Marque,Serial,NomSE,Logiceils) VALUES(?,?,?,?,?,?)";
		private static String  remove = "DElETE FROM Materiel WHERE IdMat=?";
		
		public MAJMateriel(){
		con = ConnectionMySQL.getConnection();	
		}
		
		
		public MAJMateriel (Connection con){
			this.con= con;
			}
		
		public List<Materiel> findAll(){
			try {
				ps = con.prepareStatement(MAJMateriel.findAll);
				ResultSet rs = ps.executeQuery();
				List<Materiel> ListMatAll = new ArrayList<Materiel>();
				Materiel e = null;
				while (rs.next()){
					e = new Materiel();
					e.setIdMat(rs.getInt("IdMat"));
					e.setCategorieMat(rs.getString("CategorieMat"));
					e.setMarque(rs.getString("Marque"));
					e.setSerial(rs.getString("Serial"));
					e.setNomSE(rs.getString("NomSE"));
					e.setLogiciels(rs.getString("Logiceils"));
					
					ListMatAll.add(e);
				}
				return ListMatAll;	
		}	
		
		
			catch (Exception e){
				System.out.println("Erreur !! "+ e.toString());	
				return null;
			}
		}
		
		
		public Materiel findByIdMat(int IdMat) {
			Materiel M = null;
			 try{
				 ps = con.prepareStatement(findByIdMat);
				 ps.setInt(1, IdMat);
				 ResultSet rs = ps.executeQuery();
				 if (rs.next()){
					 M = new Materiel();
						M.setIdMat(rs.getInt("IdMat"));
						M.setCategorieMat(rs.getString("CategorieMat"));
						M.setMarque(rs.getString("Marque"));
						M.setSerial(rs.getString("Serial"));
						M.setNomSE(rs.getString("NomSE"));
						M.setLogiciels(rs.getString("Logiceils"));
				 }
				 return M;
				} catch (SQLException ex) {
					System.out.println("Erreur " +ex.getMessage());						
					return null;
				}
			}
			 
//		public void remove(Etudiant e){
//			try {
//				ps = con.prepareStatement(EtudiantDAO.remove);
//				ps.setInt(1, e.getNumEtu());
//				int rowCount = ps.executeUpdate();
//			}
//			catch (SQLException ex){
//				System.out.println(ex.getMessage());
//			}	
//			}
		
		public void remove(int IdMat){
			try {
				ps = con.prepareStatement(MAJMateriel.remove);
				ps.setInt(1, IdMat);
				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}	
			}
		
		public void create (Materiel e){
			try {
				ps = con.prepareStatement(MAJMateriel.create);
				ps.setInt(1, e.getIdMat());
				ps.setString(2, e.getCategorieMat().trim());
				ps.setString(3, e.getMarque().trim());
				ps.setString(4, e.getSerial().trim());
				ps.setString(5, e.getNomSE().trim());
				ps.setString(6, e.getLogiciels().trim());
				
				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
		/*public List<Materiel> findByCategorie (String CategorieMat){
			try{
				ps = con.prepareStatement(MAJMateriel.findByCategorie);
				ps.setString(1, CategorieMat);
				ResultSet rs = ps.executeQuery();
				List<Materiel> ListMat = new ArrayList<Materiel>();
				Materiel e = null;
				while (rs.next()){
					e = new Materiel();
					e.setIdMat(rs.getInt("IdMat"));
					e.setCategorieMat(rs.getString("Categorie"));
					e.setMarque(rs.getString("Marque"));
					e.setSerial(rs.getString("Serial"));
					e.setNomSE(rs.getString("NomSE"));
					e.setLogiciels(rs.getString("Logiceils"));
			
				ListMat.add(e);
				}
				return ListMat;	
				
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
			return null;
		}*/
		
		
		public void update(Materiel M ) throws SQLException{
			PreparedStatement ps=con.prepareStatement("UPDATE Materiel SET CategorieMat=?,Marque=?,Serial=?,NomSE=?,Logiceils=? where IdMat=?");
			ps.setString(1, M.getCategorieMat());
			ps.setString(2, M.getMarque());
			ps.setString(3, M.getSerial());
			ps.setString(4, M.getNomSE());
			ps.setString(5, M.getLogiciels());
			ps.setInt(6, M.getIdMat());
			ps.executeUpdate();
		}
}