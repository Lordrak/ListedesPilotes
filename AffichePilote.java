import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AffichePilote extends JFrame {
	
	private JPanel panel;
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
		panel = new JPanel();

		this.setTitle("Affiche de Pilote");
		this.setLocation(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setResizable(false);
		btnSuiv = new JButton("Suivant");
		btnPre = new JButton("Précédent");
		String  title[] = {"Nom", "Prénom"};
		Object[][] data2 = null;

		
		try { 
		       Class.forName("org.postgresql.Driver") ; 
		       con = DriverManager.getConnection("jdbc:postgresql:dbraffin", "rraffin", "auxerre972"); 
		       st = con.createStatement();
		       rs = st.executeQuery("SELECT * FROM pilotes");
		    // Pour accéder à chacun des tuples du résultat de la requête : 
		       while(rs.next()){
		    	   Object[][] data = new Object[rs.getFetchSize()][2];
		    	   String nom = rs.getString("nompilote");
		    	   String prenom = rs.getString("prenompilote");
		    	   
		    	   lblnom = new JLabel(nom);
		    	   lblprenom = new JLabel(prenom);
		    	   System.out.println(nom+"  "+prenom+" "+rs.getFetchSize()) ;
		    	   data[rs.getFetchSize()][1] = nom;
		    	   data[rs.getFetchSize()][2] = prenom;
		    	   panel.setLayout(new GridLayout(rs.getFetchSize(),2));
		    	   data2=data;
		       }
		    rs.close() ; 
		    
		    JTable tableau = new JTable(data2, title);
		    this.getContentPane().add(new JScrollPane(tableau));
		}
		catch(ClassNotFoundException erreur) { 
		       System.out.println("Driver non chargé !"+erreur); 
		} 
		catch(SQLException erreur) { 
		 System.out.println("erreur de connexion à la Base"+erreur);
		}
		


		
		this.getContentPane().add(panel);
		this.setVisible(true);
	}

	
}
