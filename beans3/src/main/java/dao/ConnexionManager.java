package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateur;

public class ConnexionManager {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/tp_javaee", "root", "");
			return connexion;
		}
		catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/tp_javaee", "root", "");
			
		
			Statement statement = connexion.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM utilisateur");
			
			ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
			int id;
			String nom,prenom,login,password;
			while (resultat.next()) {
				
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				 utilisateurs.add(new Utilisateur(nom, prenom, login, password));
			}
			
			resultat.close();
			connexion.close();
			
			System.out.println("Liste des utilisateurs");
			
			for (Utilisateur utilisateur : utilisateurs) {
				System.out.printf("ID      : %d\n", utilisateur.getId());
				System.out.printf("Nom      : %s\n", utilisateur.getNom());
				System.out.printf("PreNom      : %s\n", utilisateur.getPrenom());
				System.out.printf("Login      : %s\n", utilisateur.getLogin());
				System.out.printf("Password      : %s\n", utilisateur.getPassword());
				
				System.out.println("=========================");
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur du chargement de Driver MySQL");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution de la requete" + e.getMessage());
			e.printStackTrace();
		}

	}

}
