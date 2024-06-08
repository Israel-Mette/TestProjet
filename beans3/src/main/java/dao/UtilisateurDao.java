package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

import beans.Utilisateur;

public class UtilisateurDao
{
	private static int lastId = 0;
	private final static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	public static ArrayList<Utilisateur> lister() 
	{
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			Connection connexion = ConnexionManager.getConnection();
		    Statement requete = connexion.createStatement();
		    ResultSet resultat = requete.executeQuery("SELECT * FROM utilisateur ");
		    
		  
			int id;
			String nom,prenom,login,password;
			while (resultat.next()) {
				
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				 utilisateurs.add(new Utilisateur(id, nom, prenom, login, password));
			}
			
			resultat.close();
			connexion.close();
			
		} catch (Exception e) {
			    
				System.err.println("Erreur durant la récuperation de la liste des utilisateurs" + e.getMessage());
		}
	return utilisateurs;	
	}
	
	public static boolean ajouter (Utilisateur utilisateur) 
	{
	try 
	{
		Connection connexion = ConnexionManager.getConnection();
		String requete = "INSERT INTO utilisateur(nom,prenom,login,password) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = connexion.prepareStatement(requete);
		preparedStatement.setString(1, utilisateur.getNom());
		preparedStatement.setString(2, utilisateur.getPrenom());
		preparedStatement.setString(3, utilisateur.getLogin());
		preparedStatement.setString(4, utilisateur.getPassword());
		
		int insertedRows = preparedStatement.executeUpdate();
		
		if (insertedRows == 1) 
		{
			return true;
		}
		
		preparedStatement.close();
		connexion.close();
		
	} catch (Exception e) {
		System.err.println("Erreur lors de l'insertion de l'utilisation");
	}
			return false;
	}
	
	public static boolean supprimer(int id) 
	{
		try 
		{
			Connection connexion = ConnexionManager.getConnection();
			String requete = "DELETE FROM utilisateur WHERE id = ?";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete);
			preparedStatement.setInt(1, id);
			
			int deletedRows = preparedStatement.executeUpdate();
			
			if (deletedRows == 1) 
			{
				return true;
			}
			preparedStatement.close();
			connexion.close();
			
			
		} catch (Exception e) {
			System.err.println("Erreur de la suppression de l'utilisation" + id);
		}
				return false;
	}
	
	public static Utilisateur get(int id) {
		Utilisateur utilisateur = null;
		try {
			Connection connexion = ConnexionManager.getConnection();
		    PreparedStatement requete = connexion.prepareStatement("SELECT * FROM utilisateur WHERE id = ?");
		    requete.setInt(1, id);
		    ResultSet resultat = requete.executeQuery();
		    
			String nom,prenom,login,password;
			if (resultat.next()) {
				
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				 utilisateur = new Utilisateur(id, nom, prenom, login, password);
			}
			
			resultat.close();
			connexion.close();
			
		} catch (Exception e) {
			    
				System.err.println("Erreur durant la récuperation de la liste des utilisateurs" + e.getMessage());
		}
	return utilisateur;	
	}

	public static boolean modifier(Utilisateur utilisateur) 
	{
		try 
		{
			Connection connexion = ConnexionManager.getConnection();
			String requete = "UPDATE utilisateur SET nom = ?,prenom = ?,login = ?,password = ? WHERE = ?";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete);
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setInt(5, utilisateur.getId());
			
			int updatedRows = preparedStatement.executeUpdate();
			
			if (updatedRows == 1) 
			{
				return true;
			}
			preparedStatement.close();
			connexion.close();
			
			
		} catch (Exception e) {
			System.err.println("Erreur de la mise à jour de l'utilisation");
		}
				return false;
		
	}
	
}
