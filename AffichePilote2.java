import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AffichePilote2 extends JFrame {
	
	private JPanel panel;
	private JLabel lblTypcan2;
	private JLabel lbllibelle;
	private JLabel lblTypcan1 ;
	private JLabel lblnom ;
	private JLabel lblprenom ;
	private JButton btnSuiv;
	private JButton btnPre;
	String nom;
	String prenom ;
	ResultSet rs ;
	Statement st;
	ResultSet rs2 ;
	Statement st2;
	Connection con;

	AffichePilote2(){
	

		this.setTitle("Affiche de Pilote");
		this.setLocation(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setResizable(true);
		btnSuiv = new JButton("Suivant");
		btnPre = new JButton("Précédent");
		String  title[] = {"Nom", "Prénom"};
		int nb = 10;
		int taille=10 ;
		Object[][] data = new Object[taille][2];
		panel = new JPanel();
		      
		       for(Brevet unBrevet: Passerelle.chargerLesBrevets()){
		    	 
		    	   lbllibelle= new JLabel(unBrevet.getLibelleB());
		    	   lblTypcan1 = new JLabel(unBrevet.getTypecan1());
		    	   lblTypcan2 = new JLabel(unBrevet.getTypecan2());
		    	   panel.add(lbllibelle);
		    	   panel.add(lblTypcan1);
		    	   panel.add(lblTypcan2);
		}
		       for(Pilote unPilote: Passerelle.chargerLesPilotes()){
		    	   lblnom = new JLabel(unPilote.getNomP());
		    	   lblprenom = new JLabel(unPilote.getPrenomP());
		    	   panel.add(lblnom);
		    	   panel.add(lblprenom);
		       }
		


		
		this.getContentPane().add(panel);
		this.setVisible(true);
	}

	
}

