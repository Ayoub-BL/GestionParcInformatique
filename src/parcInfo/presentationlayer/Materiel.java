package parcInfo.presentationlayer;

public class Materiel {
	private int IdMat;
	private String categorieMat;
	private String marque;
	private String serial;
	private String nomSE;
	private String logiciels;
	//private ArrayList<Panne> consermer = new ArrayList<Panne>();
	//private Salle situer;
	
	public Materiel() {
		super();
	}
	public Materiel(int IdMat,String categorieMat, String marque,
			String serial, String nomSE, String logiciels
			/*ArrayList<Panne> consermer, Salle situer*/) {
		super();
		this.IdMat = IdMat;
		this.categorieMat = categorieMat;
		this.marque = marque;
		this.serial = serial;
		this.nomSE = nomSE;
		this.logiciels = logiciels;
		//this.consermer = consermer;
		//this.situer = situer;
	}

	public int getIdMat() {
		return IdMat;
	}
	public void setIdMat(int IdMat) {
		this.IdMat = IdMat;
	}
	public String getCategorieMat() {
		return categorieMat;
	}
	public void setCategorieMat(String categorieMat) {
		this.categorieMat = categorieMat;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getNomSE() {
		return nomSE;
	}
	public void setNomSE(String nomSE) {
		this.nomSE = nomSE;
	}
	public String getLogiciels() {
		return logiciels;
	}
	public void setLogiciels(String logiciels) {
		this.logiciels = logiciels;
	}
	/*public ArrayList<Panne> getConsermer() {
		return consermer;
	}
	public void setConsermer(ArrayList<Panne> consermer) {
		this.consermer = consermer;
	}
	public Salle getSituer() {
		return situer;
	}
	public void setSituer(Salle situer) {
		this.situer = situer;
	}*/
	
	@Override
	public String toString() {
		return "Materiel [IdMat=" + IdMat + ", categorieMat=" + categorieMat + ", marque=" + marque + ", serial="
				+ serial + ", nomSE=" + nomSE + ", logiciels=" + logiciels;
	}

	
	
	
}