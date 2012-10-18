import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AffichePilote extends JFrame {
	

	private JLabel lblnom ;
	private JLabel lblprenom ;
	private JButton btnSuiv;
	private JButton btnPre;
	String nom;
	String prenom ;
	ResultSet rs ;
	Statement st;
	Connection con;

	AffichePilote(){
	

		this.setTitle("Affiche de Pilote");
		this.setLocation(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setResizable(false);
		btnSuiv = new JButton("Suivant");
		btnPre = new JButton("Précédent");
		String  title[] = {"Nom", "Prénom"};
		int nb = 10;
		Object[][] data = new Object[nb][2];
		try { 
		       Class.forName("org.postgresql.Driver") ; 
		       con = DriverManager.getConnection("jdbc:postgresql:dbraffin", "rraffin", "auxerre972"); 
		       st = con.createStatement();
		       rs = st.executeQuery("SELECT * FROM pilotes");
		       int i=0;
		      System.out.println(rs.getFetchSize()); 
		       
		       
		    // Pour accéder à chacun des tuples du résultat de la requête : 
		       while(rs.next()){
		    	   
		    	   String nom = rs.getString("nompilote");
		    	   String prenom = rs.getString("prenompilote");
		    	   
		    	   lblnom = new JLabel(nom);
		    	   lblprenom = new JLabel(prenom);
		    	   System.out.println(nom+" "+prenom) ;
		    	   data[i][0] = nom;
		    	   data[i][1] = prenom;
		    	   
		    	   
		    	   i++;
		       }
		    rs.close() ; 
		    

		}
		catch(ClassNotFoundException erreur) { 
		       System.out.println("Driver non chargé !"+erreur); 
		} 
		catch(SQLException erreur) { 
		 System.out.println("erreur de connexion à la Base"+erreur);
		}
		


		
	    JTable tableau = new JTable(data, title);
	    this.getContentPane().add(new JScrollPane(tableau));
		this.setVisible(true);
	}

	
}
