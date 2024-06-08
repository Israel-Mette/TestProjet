package dao;

import java.util.ArrayList;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

import beans.Utilisateur;

public class UtilisateurDao
{
	private static int lastId = 0;
	private final static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	static 
	{
		utilisateurs.add(new Utilisateur("Super", "User", "admin", "passer"));
	}
	
	public static ArrayList<Utilisateur> lister() 
	{
	return utilisateurs;	
	}
	
	public static boolean ajouter (Utilisateur utilisateur) 
	{
	lastId++;
	utilisateur.setId(lastId);
	utilisateurs.add(utilisateur);
	
	return true;
	}
	
	public static boolean supprimer(int id) 
	{
		for (Utilisateur utilisateur : utilisateurs) {
			
			if (utilisateur.getId() == id) 
			{
				utilisateurs.remove(utilisateur);
				return true;
			}
		}
		return false;
	}
	
	public static Utilisateur get(String login) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getLogin().equals(login))
			{
				return utilisateur;
			} 
		}
			return null;
	}
	
	 public static Utilisateur get(int id) {
	        for (Utilisateur utilisateur : utilisateurs) {
	            if (utilisateur.getId() == id) {
	                return utilisateur;
	            }
	        }
	        return null;
	    }

	public static boolean modifier(Utilisateur user) 
	{
		for (Utilisateur utilisateur : utilisateurs) 
		{
			if (utilisateur.getId() == user.getId()) 
			{
				utilisateur.setNom(user.getNom());
				utilisateur.setPrenom(user.getPrenom());
				utilisateur.setLogin(user.getLogin());
				utilisateur.setPassword(user.getPassword());
				
				return true;
			}
		}
		
		return false;
		
	}
	
}
