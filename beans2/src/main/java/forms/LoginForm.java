package forms;

import java.util.Map;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginForm 
{
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	
	private String statusMessage;
	private boolean status;
	private HttpServletRequest request;
	private String login;
	
	public LoginForm(HttpServletRequest request)
	{
		this.request = request;
		this.status = false;
		this.statusMessage = "Echec de la connexion : login et/ou Mot de passe incorrecte !";
	}
	
	public boolean login() {
		this.login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		Utilisateur loggedUser = UtilisateurDao.get(login);
		
		if (loggedUser != null && loggedUser.getPassword().equals(password)) 
		{
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", loggedUser);
			
			return true;
		}
			return false;
	}
	
	public void logout()
	{
		HttpSession session = request.getSession();
		session.invalidate();
		
	}
	
	private String getParameter(String parametre) 
	{
		String valeur = request.getParameter(parametre);
		
		if (valeur == null || valeur.isBlank()) 
		{
			return null;
		}
			return valeur.trim();
	}
	
	public String getStatusMessage()
	{
		return statusMessage;
	}
	
	public boolean isStatus()
	{
		return status;
	}
	
	public String getLogin() {
		return login;
	}
}
