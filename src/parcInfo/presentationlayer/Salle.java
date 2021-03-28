package parcInfo.presentationlayer;

public class Salle {
	private int idSalle;
	private String libelle;
	private String ListeMateriles;
	//private Administrateur consulter;
	//private ArrayList<Materiel> situer = new ArrayList<Materiel>();
	
	public Salle (){
		super();
	
	}
	
	public Salle(int idSalle, String libelle,String ListeMaterielles/*, Administrateur consulter, ArrayList<Materiel> situer*/) {
		super();
		this.idSalle = idSalle;
		this.libelle = libelle;
		this.ListeMateriles = ListeMaterielles;

		//this.consulter = consulter;
		//this.situer = situer;
	}


	public int getIdSalle() {
		return idSalle;
	}


	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	/*public Administrateur getConsulter() {
		return consulter;
	}


	public void setConsulter(Administrateur consulter) {
		this.consulter = consulter;
	}


	public ArrayList<Materiel> getSituer() {
		return situer;
	}


	public void setSituer(ArrayList<Materiel> situer) {
		this.situer = situer;
	}
*/

	public String getListeMateriles() {
		return ListeMateriles;
	}

	public void setListeMateriles(String listeMateriles) {
		ListeMateriles = listeMateriles;
	}

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", libelle=" + libelle +",ListeMateriels="+ ListeMateriles+/*", consulter=" + consulter + ", situer=" + situer
				+*/ "]";
	}
	
	
	
}