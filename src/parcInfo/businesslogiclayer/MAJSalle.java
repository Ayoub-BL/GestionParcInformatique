package parcInfo.businesslogiclayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parcInfo.persistencelayer.entity.ConnectionMySQL;
import parcInfo.presentationlayer.Salle;

public class MAJSalle {

		private Connection con;
		private PreparedStatement ps;
		
		//centraliser le code SQL à cet endroit
		//private static String  findByLibelle = "SELECT * FROM Panne WHERE Libelle=?";
		private static String  findByIdSalle = "SELECT * FROM Salle WHERE IdSalle=?";
		private static String  findAll = "SELECT * FROM Salle";
		private static String  create = "INSERT INTO Salle (IdSalle,Libelle,ListeMateriel) VALUES(?,?,?)";
		private static String  remove = "DElETE FROM Salle WHERE IdSalle=?";
		
		public MAJSalle(){
		con = ConnectionMySQL.getConnection();	
		}
		
		
		public MAJSalle (Connection con){
			this.con= con;
			}
		
		public List<Salle> findAll(){
			try {
				ps = con.prepareStatement(MAJSalle.findAll);
				ResultSet rs = ps.executeQuery();
				List<Salle> ListSalle = new ArrayList<Salle>();
				Salle P = null;
				while (rs.next()){
					P = new Salle();
					P.setIdSalle(rs.getInt("IdSalle"));
					P.setLibelle(rs.getString("Libelle"));
					P.setListeMateriles(rs.getString("ListeMateriel"));

					


					ListSalle.add(P);
				}
				return ListSalle;	
		}	
		
		
			catch (Exception e){
				System.out.println("Erreur !! "+ e.toString());	
				return null;
			}
		}
		
		public Salle findByIdSalle (int IdSalle ){
			Salle S = null;
			 try{
				 ps = con.prepareStatement(findByIdSalle);
				 ps.setInt(1, IdSalle);
				 ResultSet rs = ps.executeQuery();
				 if (rs.next()){
					 S = new Salle();
						S.setIdSalle(rs.getInt("IdSalle"));
						S.setLibelle(rs.getString("Libelle"));
						S.setListeMateriles(rs.getString("ListeMateriel"));

					

				 }
				 return S;
				} catch (SQLException ex) {
					System.out.println("Erreur " +ex.getMessage());						
					return null;
				}
			}
			 
		
		public void remove(int IdSalle){
			try {
				ps = con.prepareStatement(MAJSalle.remove);
				ps.setInt(1, IdSalle);
				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}	
			}
		
		public void create (Salle S){
			try {
				ps = con.prepareStatement(MAJSalle.create);
				ps.setInt(1, S.getIdSalle());
				ps.setString(2, S.getLibelle());
				ps.setString(3,S.getListeMateriles());
				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
		/*public List<Panne> findByTitre (String Titre){
			try{
				ps = con.prepareStatement(MAJSalle.findByLibelle);
				ps.setString(1, Titre);
				ResultSet rs = ps.executeQuery();
				List<Panne> ListPanne = new ArrayList<Panne>();
				Panne P = null;
				while (rs.next()){
				//	P = new Panne();
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
		}*/

		public void update(Salle sl) throws SQLException {
			PreparedStatement ps=con.prepareStatement("UPDATE Salle SET Libelle=?,ListeMateriel=? where IdSalle=?");
			ps.setString(1, sl.getLibelle());
			ps.setString(2, sl.getListeMateriles());
			ps.setInt(3, sl.getIdSalle());
			
			ps.executeUpdate();
			
		}

		
}