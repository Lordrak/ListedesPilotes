import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class SaisirPilote extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel lblnom ;
	private JLabel lblprenom ;
	private JTextField jtfnom;
	private JTextField jtfprenom;
	private JButton btnOK;
	
	SaisirPilote(){
		
		panel = new JPanel();
		lblnom = new JLabel("Nom : ");
		lblprenom = new JLabel("Prenom : ");
		jtfnom = new JTextField();
		jtfprenom = new JTextField();
		btnOK = new JButton("Envoyer");
		panel.setLayout(new GridLayout(3,3));
		
		this.setTitle("Saisie de Pilote");
		this.setLocation(450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setResizable(false);
		
		panel.add(lblnom);
		panel.add(jtfnom);
		panel.add(lblprenom);
		panel.add(jtfprenom);
		panel.add(btnOK);
		
		
		btnOK.addActionListener(this);
		this.getContentPane().add(panel);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		  
		try { 
		       Class.forName("org.postgresql.Driver") ; 
		       Connection con = DriverManager.getConnection("jdbc:postgresql:dbraffin", "rraffin", "auxerre972"); 
		       Statement st = con.createStatement();
		       st.executeUpdate("INSERT INTO PILOTES(nompilote, prenompilote) " +
		       "values('"+jtfnom.getText()+"', '"+jtfprenom.getText()+"')");
		       con.close();
		} 
		catch(ClassNotFoundException erreur) { 
		       System.out.println("Driver non chargé !"+erreur); 
		} 
		catch(SQLException erreur) { 
		 System.out.println("erreur de connexion à la Base"+erreur);
		} 
		finally{
			System.out.println("Succes");
		}

		
		
	}
	

	

}
