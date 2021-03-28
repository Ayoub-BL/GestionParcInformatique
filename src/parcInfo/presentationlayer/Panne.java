package parcInfo.presentationlayer;

public class Panne {
	private int idPanne;
	private String titre;
	private String typePanne;
	private String date;
	private String etatPanne;
	private String commentaire;
	//private Materiel Conserner;
	//private ArrayList<Administrateur> reclamer = new ArrayList<Administrateur>();
	//private ArrayList<Technicien> affecter = new ArrayList<Technicien>();
	
	public Panne(){
		super();
	}
	
	
	public Panne(int idPanne, String titre, String typePanne, String date, String etatPanne, String commentaire)/*,
			Materiel conserner, ArrayList<Administrateur> reclamer, ArrayList<Technicien> affecter)*/ {
		super();
		this.idPanne = idPanne;
		this.titre = titre;
		this.typePanne = typePanne;
		this.date = date;
		this.etatPanne = etatPanne;
		this.commentaire = commentaire;
		/*Conserner = conserner;
		this.reclamer = reclamer;
		this.affecter = affecter;*/
	}
	public int getIdPanne() {
		return idPanne;
	}
	public void setIdPanne(int idPanne) {
		this.idPanne = idPanne;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTypePanne() {
		return typePanne;
	}
	public void setTypePanne(String typePanne) {
		this.typePanne = typePanne;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEtatPanne() {
		return etatPanne;
	}
	public void setEtatPanne(String etatPanne) {
		this.etatPanne = etatPanne;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	/*public Materiel getConserner() {
		return Conserner;
	}
	public void setConserner(Materiel conserner) {
		Conserner = conserner;
	}
	public ArrayList<Administrateur> getReclamer() {
		return reclamer;
	}
	public void setReclamer(ArrayList<Administrateur> reclamer) {
		this.reclamer = reclamer;
	}
	public ArrayList<Technicien> getAffecter() {
		return affecter;
	}
	public void setAffecter(ArrayList<Technicien> affecter) {
		this.affecter = affecter;
	}*/
	@Override
	public String toString() {
		return "Panne [idPanne=" + idPanne + ", titre=" + titre + ", typePanne=" + typePanne + ", date=" + date
				+ ", etatPanne=" + etatPanne + ", commentaire=" + commentaire +/* ", Conserner=" + Conserner
				+ ", reclamer=" + reclamer + ", affecter=" + affecter +*/ "]";
	}
}