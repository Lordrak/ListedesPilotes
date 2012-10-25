
public class Pilote {
	private int numP;
	private String nomP;
	private String prenomP;
	private Brevet sonBrevet;
	
	public Pilote(int unNum, String unNom, String unPrenom, Brevet unBrevet){
		numP = unNum;
		nomP = unNom;
		prenomP = unPrenom;
		sonBrevet = unBrevet;
	
	}

	public int getNumP() {
		return numP;
	}

	public String getNomP() {
		return nomP;
	}

	public String getPrenomP() {
		return prenomP;
	}

	public Brevet getSonBrevet() {
		return sonBrevet;
	}

	public String toString(){
		return "id: "+numP+" nom: "+nomP+" Prenom: "+prenomP+" Brevet: "+sonBrevet;
	}

	public void setSonBrevet(Brevet sonBrevet) {
		this.sonBrevet = sonBrevet;
	}

	public void setNumP(int numP) {
		this.numP = numP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}

}
