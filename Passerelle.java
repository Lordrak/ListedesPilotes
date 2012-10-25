import java.sql.*;
import java.util.ArrayList;


public class Passerelle {
	
	
	
public static ArrayList<Brevet> chargerLesBrevets(){
	ArrayList<Brevet> lesBrevets = new ArrayList<Brevet>();
	Brevet unBrevet;
	try { 
	       Class.forName("org.postgresql.Driver") ; 
	       Connection con = DriverManager.getConnection("jdbc:postgresql:dbraffin", "rraffin", "auxerre972");
	       Statement st = con.createStatement();
	       ResultSet  rs = st.executeQuery("SELECT * FROM Brevets");
	       while(rs.next()){
	    	   int numBrevet = rs.getInt("numBrevet");
	    	   String LibelleBrevet = rs.getString("LibelleBrevet");
	    	   String Typecan1 = rs.getString("Typecan1");
	    	   String Typecan2 = rs.getString("Typecan2");
	    	   unBrevet = new Brevet(numBrevet,LibelleBrevet,Typecan1,Typecan2);
	    	   lesBrevets.add(unBrevet);
	    	 
	    	   
	       }
	}
	catch(ClassNotFoundException erreur) { 
	       System.out.println("Driver non chargé !"+erreur); 
	} 
	catch(SQLException erreur) { 
	 System.out.println("erreur de connexion à la Base"+erreur);
	}
	return lesBrevets;
}


public static ArrayList<Pilote> chargerLesPilotes(){

	ArrayList<Pilote> lesPilote = new ArrayList<Pilote>();
	Pilote unPilote;
	try { 
		Class.forName("org.postgresql.Driver") ; 
		Connection con = DriverManager.getConnection("jdbc:postgresql:dbraffin", "rraffin", "auxerre972");
		Statement st = con.createStatement();
		ResultSet  rs = st.executeQuery("SELECT * FROM Pilotes");
		while(rs.next()){
			int numP = rs.getInt("numpilote");
			String nomP = rs.getString("nompilote");
			String prenomP = rs.getString("prenompilote");
			int idBrevet= rs.getInt("idBrevet");
			Brevet sonBrevet = chercherBrevets(idBrevet);
			unPilote = new Pilote(numP,nomP,prenomP,sonBrevet);
			lesPilote.add(unPilote);

		}
	}
	catch(ClassNotFoundException erreur) { 
		System.out.println("Driver non chargé !"+erreur); 
	} 
	catch(SQLException erreur) { 
		System.out.println("erreur de connexion à la Base"+erreur);
	}
	return lesPilote;
}

private static Brevet chercherBrevets(int unId){
	int i=0;
	Brevet unBrevet=null;
	ArrayList<Brevet> lesBrevets = chargerLesBrevets();
	while(i<lesBrevets.size() && unId!= lesBrevets.get(i).getNumB()){
		i++;
	}
	if(i!=lesBrevets.size()){
	unBrevet=lesBrevets.get(i);
	}
	return unBrevet;
}
}

