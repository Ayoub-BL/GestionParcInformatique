package parcInfo.presentationlayer;

public class Technicien {
	private int idTechnicien;
	private String nomTechnicien;
	private String prenomTechnicien;
	private String adresseTechnicien;
	private String gsmTechnicien;
	private String emailTechnicien;
	private String specialiteTechnicien;
	//private ArrayList<Panne> affectuer = new ArrayList<Panne>();
	
	public Technicien(){
		super();
	}
	
	public Technicien(int idTechnicien, String nomTechnicien, String prenomTechnicien, String adresseTechnicien,
			String gsmTechnicien, String emailTechnicien, String specialiteTechnicien//,
			/*ArrayList<parcInfo.presentationlayer.Panne> affectue*/) {
		super();
		this.idTechnicien = idTechnicien;
		this.nomTechnicien = nomTechnicien;
		this.prenomTechnicien = prenomTechnicien;
		this.adresseTechnicien = adresseTechnicien;
		this.gsmTechnicien = gsmTechnicien;
		this.emailTechnicien = emailTechnicien;
		this.specialiteTechnicien = specialiteTechnicien;
		//this.affectuer = affectuer;
	}


	public int getIdTechnicien() {
		return idTechnicien;
	}


	public void setIdTechnicien(int idTechnicien) {
		this.idTechnicien = idTechnicien;
	}


	public String getNomTechnicien() {
		return nomTechnicien;
	}


	public void setNomTechnicien(String nomTechnicien) {
		this.nomTechnicien = nomTechnicien;
	}


	public String getPrenomTechnicien() {
		return prenomTechnicien;
	}


	public void setPrenomTechnicien(String prenomTechnicien) {
		this.prenomTechnicien = prenomTechnicien;
	}


	public String getAdresseTechnicien() {
		return adresseTechnicien;
	}


	public void setAdresseTechnicien(String adresseTechnicien) {
		this.adresseTechnicien = adresseTechnicien;
	}


	public String getGsmTechnicien() {
		return gsmTechnicien;
	}


	public void setGsmTechnicien(String gsmTechnicien) {
		this.gsmTechnicien = gsmTechnicien;
	}


	public String getEmailTechnicien() {
		return emailTechnicien;
	}


	public void setEmailTechnicien(String emailTechnicien) {
		this.emailTechnicien = emailTechnicien;
	}


	public String getSpecialiteTechnicien() {
		return specialiteTechnicien;
	}


	public void setSpecialiteTechnicien(String specialiteTechnicien) {
		this.specialiteTechnicien = specialiteTechnicien;
	}


	/*public ArrayList<Panne> getAffectuer() {
		return affectuer;
	}


	public void setAffectuer(ArrayList<Panne> affectuer) {
		this.affectuer = affectuer;
	}

*/
	@Override
	public String toString() {
		return "Technicien [idTechnicien=" + idTechnicien + ", nomTechnicien=" + nomTechnicien + ", prenomTechnicien="
				+ prenomTechnicien + ", adresseTechnicien=" + adresseTechnicien + ", gsmTechnicien=" + gsmTechnicien
				+ ", emailTechnicien=" + emailTechnicien + ", specialiteTechnicien=" + specialiteTechnicien
				+ /*", affectuer=" + affectuer + */"]";
	}	
}