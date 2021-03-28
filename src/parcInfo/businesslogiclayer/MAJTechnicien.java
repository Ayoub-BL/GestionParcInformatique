package parcInfo.businesslogiclayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parcInfo.persistencelayer.entity.ConnectionMySQL;
import parcInfo.presentationlayer.Technicien;

public class MAJTechnicien {

		private Connection con;
		private PreparedStatement ps;
		
		//centraliser le code SQL à cet endroit
		//private static String  findByNom = "SELECT * FROM Technicien WHERE NomTechnicien=?";
		private static String  findByIdTechnicien = "SELECT * FROM Technicien WHERE IdTechnicien=?";
		private static String  findAll = "SELECT * FROM Technicien";
		private static String  create = "INSERT INTO Technicien (IdTechnicien, NomTechnicien,PrenomTechnicien,AdresseTechnicien,GSMTechnicien,Emailtechnicien, SpecialiteTechnicien) VALUES(?,?,?,?,?,?,?)";
		private static String  remove = "DElETE FROM Technicien WHERE IdTechnicien=?";
		
		public MAJTechnicien(){
		con = ConnectionMySQL.getConnection();	
		}
		
		
		public MAJTechnicien (Connection con){
			this.con= con;
			}
		
		public List<Technicien> findAll(){
			try {
				ps = con.prepareStatement(MAJTechnicien.findAll);
				ResultSet rs = ps.executeQuery();
				List<Technicien> ListTech = new ArrayList<Technicien>();
				Technicien Tech = null;
				while (rs.next()){
					Tech = new Technicien();
					Tech.setIdTechnicien(rs.getInt("IdTechnicien"));
					Tech.setNomTechnicien(rs.getString("NomTechnicien"));
					Tech.setPrenomTechnicien(rs.getString("PrenomTechnicien"));
					Tech.setAdresseTechnicien(rs.getString("AdresseTechnicien"));
					Tech.setGsmTechnicien(rs.getString("GsmTechnicien"));
					Tech.setEmailTechnicien(rs.getString("EmailTechnicien"));
					Tech.setSpecialiteTechnicien(rs.getString("SpecialiteTechnicien"));


					ListTech.add(Tech);
				}
				return ListTech;	
		}	
		
		
			catch (Exception e){
				System.out.println("Erreur !! "+ e.toString());	
				return null;
			}
		}
		
		public Technicien findByIdTeTechnicien (int IdTechnicien ){
			Technicien Tech = null;
			 try{
				 ps = con.prepareStatement(findByIdTechnicien);
				 ps.setInt(1, IdTechnicien);
				 ResultSet rs = ps.executeQuery();
				 if (rs.next()){
					 Tech = new Technicien();
						Tech.setIdTechnicien(rs.getInt("IdTechnicien"));
						Tech.setNomTechnicien(rs.getString("NomTechnicien"));
						Tech.setPrenomTechnicien(rs.getString("PrenomTechnicien"));
						Tech.setAdresseTechnicien(rs.getString("AdresseTechnicien"));
						Tech.setGsmTechnicien(rs.getString("GsmTechnicien"));
						Tech.setEmailTechnicien(rs.getString("EmailTechnicien"));
						Tech.setSpecialiteTechnicien(rs.getString("SpecialiteTechnicien"));

				 }
				 return Tech;
				} catch (SQLException ex) {
					System.out.println("Erreur " +ex.getMessage());						
					return null;
				}
			}
			 
		
		public void remove(int IdTechnicien){
			try {
				ps = con.prepareStatement(MAJTechnicien.remove);
				ps.setInt(1, IdTechnicien);
				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}	
			}
		
		public void create (Technicien Tech){
			try {
				ps = con.prepareStatement(MAJTechnicien.create);
				ps.setInt(1, Tech.getIdTechnicien());
				ps.setString(2, Tech.getNomTechnicien());
				ps.setString(3, Tech.getPrenomTechnicien());
				ps.setString(4,  Tech.getAdresseTechnicien());
				ps.setString(5, Tech.getGsmTechnicien());
				ps.setString(6, Tech.getEmailTechnicien());
				ps.setString(7, Tech.getSpecialiteTechnicien());
				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
		/*public List<Technicien> findByNom (String NomTechnicien){
			try{
				ps = con.prepareStatement(MAJTechnicien.findByNom);
				ps.setString(1, NomTechnicien);
				ResultSet rs = ps.executeQuery();
				List<Panne> ListPanne = new ArrayList<Panne>();
				Panne P = null;
				while (rs.next()){
					P = new Panne();
					P.setIdPanne(rs.getInt("IdPanne"));
					P.setTitre(rs.getString("Titre"));
					P.setCommentaire(rs.getString("Commnentaire".trim()));
					P.setTypePanne(rs.getString("TypePanne"));
					//P.setDatePanne(rs.getDate(""));
					ListPanne.add(P);
				}
				return ListPanne;	
				
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
			return null;
		}
		*/
		/*public void update(Technicien Tech,int IdTechnicien) throws SQLException{
			PreparedStatement ps=con.prepareStatement("UPDATE Technicien SET NomTechnicien=?,PrenomTechnicien=?,AdresseTechnicien=?,GSMTechnicien=?,Emailtechnicien=?, SpecialiteTechnicien=? where IdTechnicien=?");
			ps.setString(1, Tech.getNomTechnicien());
			ps.setString(2, Tech.getPrenomTechnicien());
			ps.setString(3, Tech.getAdresseTechnicien());
			ps.setString(4, Tech.getGsmTechnicien());
			ps.setString(5, Tech.getEmailTechnicien());
			ps.setString(6, Tech.getSpecialiteTechnicien());
			ps.setInt(7, IdTechnicien);
			ps.executeUpdate();
		}*/


		public void update(Technicien Tech) throws SQLException {
			PreparedStatement ps=con.prepareStatement("UPDATE Technicien SET NomTechnicien=?,PrenomTechnicien=?,AdresseTechnicien=?,GSMTechnicien=?,Emailtechnicien=?, SpecialiteTechnicien=? where IdTechnicien=?");
			ps.setString(1, Tech.getNomTechnicien());
			ps.setString(2, Tech.getPrenomTechnicien());
			ps.setString(3, Tech.getAdresseTechnicien());
			ps.setString(4, Tech.getGsmTechnicien());
			ps.setString(5, Tech.getEmailTechnicien());
			ps.setString(6, Tech.getSpecialiteTechnicien());
			ps.setInt(7, Tech.getIdTechnicien());
			ps.executeUpdate();
			
		}


	

		
}