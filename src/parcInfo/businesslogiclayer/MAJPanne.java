package parcInfo.businesslogiclayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import parcInfo.persistencelayer.entity.ConnectionMySQL;
import parcInfo.presentationlayer.Panne;

public class MAJPanne {

		private Connection con;
		private PreparedStatement ps;
		
		//centraliser le code SQL à cet endroit
		private static String  findByTitre = "SELECT * FROM Panne WHERE Titre=?";
		private static String  findByIdPanne = "SELECT * FROM Panne WHERE IdPanne=?";
		private static String  findAll = "SELECT * FROM Panne";
		private static String  create = "INSERT INTO Panne (IdPanne, Titre,TypePanne,Date,EtatPanne, Commentaire) VALUES(?,?,?,?,?,?)";
		private static String  remove = "DElETE FROM Panne WHERE IdPanne=?";
		
		public MAJPanne(){
		con = ConnectionMySQL.getConnection();	
		}
		
		
		public MAJPanne (Connection con){
			this.con= con;
			}
		
		public List<Panne> findAll(){
			try {
				ps = con.prepareStatement(MAJPanne.findAll);
				ResultSet rs = ps.executeQuery();
				List<Panne> ListPanne = new ArrayList<Panne>();
				Panne P = null;
				while (rs.next()){
					P = new Panne();
					P.setIdPanne(rs.getInt("IdPanne"));
					P.setTitre(rs.getString("Titre"));
					P.setTypePanne(rs.getString("TypePanne"));
					P.setDate(rs.getDate("Date").toString());
					P.setEtatPanne(rs.getString("EtatPanne"));
					P.setCommentaire(rs.getString("Commentaire"));
				//	P.setDatePanne(rs.getDate("DatePanne"));


					ListPanne.add(P);
				}
				return ListPanne;	
		}	
		
		
			catch (Exception e){
				System.out.println("Erreur !! "+ e.toString());	
				return null;
			}
		}
		
		public Panne findByIdPanne (int IdPanne ){
			Panne P = null;
			 try{
				 ps = con.prepareStatement(findByIdPanne);
				 ps.setInt(1, IdPanne);
				 ResultSet rs = ps.executeQuery();
				 SimpleDateFormat sp=new SimpleDateFormat("yyyy/MM/dd");
				 if (rs.next()){
					 P = new Panne();
						P.setIdPanne(rs.getInt("IdPanne"));
						P.setTitre(rs.getString("Titre"));
						P.setTypePanne(rs.getString("TypePanne"));
						P.setEtatPanne(rs.getString("EtatPanne"));
						P.setCommentaire(rs.getString("Commentaire"));
						P.setDate(sp.format(rs.getDate("Date")));

				 }
				 return P;
				} catch (SQLException ex) {
					System.out.println("Erreur " +ex.getMessage());						
					return null;
				}
			}
			 
		
		public void remove(int IdPanne){
			try {
				ps = con.prepareStatement(MAJPanne.remove);
				ps.setInt(1, IdPanne);
				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}	
			}
		
		public void create (Panne P){
			try {
				ps = con.prepareStatement(MAJPanne.create);
				ps.setInt(1, P.getIdPanne());
				ps.setString(2, P.getTitre());
				ps.setString(3, P.getTypePanne());
				ps.setString(4,  P.getDate().toString());
				ps.setString(5, P.getEtatPanne());
				ps.setString(6, P.getCommentaire());

				

				ps.executeUpdate();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
		public List<Panne> findByTitre (String Titre){
			try{
				ps = con.prepareStatement(MAJPanne.findByTitre);
				ps.setString(1, Titre);
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


		/*public List<Panne> findIdPanne() {
			// TODO Auto-generated method stub
			return null;
		}
		*/
		public void update(Panne P) throws SQLException, ParseException {
			SimpleDateFormat sp=new SimpleDateFormat("yyyy/MM/dd");
			Date date = sp.parse(P.getDate());
			java.sql.Date datesql = new java.sql.Date(date.getTime());
			
			PreparedStatement ps=con.prepareStatement("UPDATE Panne SET Titre=?, TypePanne=?, Date=?, EtatPanne=?, Commentaire=? where IdPanne=?");
			ps.setString(1, P.getTitre());
			ps.setString(2, P.getTypePanne());
			ps.setDate(3,  datesql);
			ps.setString(4, P.getEtatPanne());
			ps.setString(5, P.getCommentaire());
			ps.setInt(6, P.getIdPanne());

			ps.executeUpdate();
			
		}
}