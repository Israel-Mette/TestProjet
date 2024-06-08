package servlets;

import java.io.IOException;

import javax.security.auth.login.LoginContext;

import forms.LoginForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({"/login", "/logout"})
public class AuthentificationManager extends HttpServlet
{
	
	private static final String VUE_CONNEXION = "/WEB-INF/connexion.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getServletPath())
		{
		case "/login":
		{
			
			getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
			break;
		}
		case "/logout":
		{
			LoginForm form = new LoginForm(request);
			form.logout ();
			response.sendRedirect("login");
		}
		
	}
		
}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginForm form = new LoginForm(request);
		
		if (form.login()) 
		{
			response.sendRedirect("list");
		}
		
		else 
		{
			request.setAttribute("login", form.getLogin());
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}
	}
}
