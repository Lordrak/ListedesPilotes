import java.sql.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//SaisirPilote fen = new SaisirPilote();
		//AffichePilote aff = new AffichePilote();
		//Passerelle.chargerLesPilotes();
		for(Pilote unPilote2 :Passerelle.chargerLesPilotes()){
			System.out.println(unPilote2.toString());
		}
		 for(Brevet unBrevet: Passerelle.chargerLesBrevets()){
			 System.out.println(unBrevet.toString());
		 }
		AffichePilote2 aff = new AffichePilote2();


	}

}
