import java.util.*;


public class Brevet {
	private int numB;
	private String libelleB;
	private String Typecan1;
	private String Typecan2;
	private ArrayList<Pilote> lesPilotes;
	public Brevet(int numB, String libelleB, String typecan1, String typecan2
			) {
		this.numB = numB;
		this.libelleB = libelleB;
		Typecan1 = typecan1;
		Typecan2 = typecan2;
		this.lesPilotes = new ArrayList<Pilote>();
	}
	public int getNumB() {
		return numB;
	}
	public String getLibelleB() {
		return libelleB;
	}
	public String getTypecan1() {
		return Typecan1;
	}
	public String getTypecan2() {
		return Typecan2;
	}
	public ArrayList<Pilote> getLesPilotes() {
		return lesPilotes;
	}
	public void setNumB(int numB) {
		this.numB = numB;
	}
	public void setLibelleB(String libelleB) {
		this.libelleB = libelleB;
	}
	public void setTypecan1(String typecan1) {
		Typecan1 = typecan1;
	}
	public void setTypecan2(String typecan2) {
		Typecan2 = typecan2;
	}
	public void setLesPilotes(ArrayList<Pilote> lesPilotes) {
		this.lesPilotes = lesPilotes;
	}
	public String toString(){
		return "id: "+numB+" Libelle Brevet: "+libelleB+" Type can1: "+Typecan1+" Type can2: "+Typecan2;
	}
}
