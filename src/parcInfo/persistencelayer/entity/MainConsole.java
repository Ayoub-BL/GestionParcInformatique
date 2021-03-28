package parcInfo.persistencelayer.entity;

import parcInfo.businesslogiclayer.Authentification;

public class MainConsole {

	public static void main(String[] args) {
	
	/*	MAJMateriel materiel1 = new MAJMateriel();
		List<Materiel> ListMatAll = materiel1.findAll();	
		
		for (Materiel e:ListMatAll){
		System.out.println("Materiel [idMat=" + e.getIdMat() + ", categorieMat=" +e.getCategorieMat()
				+ ", marque=" +e.getMarque() + ", serial="+ e.getSerial() + ", nomSE=" + e.getNomSE()
				+ ", logiciels=" + e.getLogiciels());
		}*/
		
		Authentification frame = new Authentification();
		frame.setVisible(true);
		
		
	}
}