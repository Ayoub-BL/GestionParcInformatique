package parcInfo.presentationlayer;

import java.util.ArrayList;

public class Administrateur {
	private int idAdmin;
	private String nomAdmin;
	private String prenomAdmin;
	private String adresseAdmin;
	private String gsmAdmin;
	private String emailAdmin;
	private ArrayList<Panne> reclamer = new ArrayList<Panne>();
	private ArrayList<Salle> consulter = new ArrayList<Salle>();
	
	public  Administrateur() {
		super();
	}

	public Administrateur(int idAdmin, String nomAdmin, String prenomAdmin, String adresseAdmin, String gsmAdmin,
			String emailAdmin, ArrayList<Panne> reclamer, ArrayList<Salle> consulter) {
		super();
		this.idAdmin = idAdmin;
		this.nomAdmin = nomAdmin;
		this.prenomAdmin = prenomAdmin;
		this.adresseAdmin = adresseAdmin;
		this.gsmAdmin = gsmAdmin;
		this.emailAdmin = emailAdmin;
		this.reclamer = reclamer;
		this.consulter = consulter;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNomAdmin() {
		return nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getPrenomAdmin() {
		return prenomAdmin;
	}

	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}

	public String getAdresseAdmin() {
		return adresseAdmin;
	}

	public void setAdresseAdmin(String adresseAdmin) {
		this.adresseAdmin = adresseAdmin;
	}

	public String getGsmAdmin() {
		return gsmAdmin;
	}

	public void setGsmAdmin(String gsmAdmin) {
		this.gsmAdmin = gsmAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public ArrayList<Panne> getReclamer() {
		return reclamer;
	}

	public void setReclamer(ArrayList<Panne> reclamer) {
		this.reclamer = reclamer;
	}

	public ArrayList<Salle> getConsulter() {
		return consulter;
	}

	public void setConsulter(ArrayList<Salle> consulter) {
		this.consulter = consulter;
	}

	@Override
	public String toString() {
		return "Administrateur [idAdmin=" + idAdmin + ", nomAdmin=" + nomAdmin + ", prenomAdmin=" + prenomAdmin
				+ ", adresseAdmin=" + adresseAdmin + ", gsmAdmin=" + gsmAdmin + ", emailAdmin=" + emailAdmin
				+ ", reclamer=" + reclamer + ", consulter=" + consulter + "]";
	}
	
	
}



