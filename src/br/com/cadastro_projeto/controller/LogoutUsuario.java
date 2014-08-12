package br.com.cadastro_projeto.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout-usuario")
public class LogoutUsuario extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// ENCONTRA USUÁRIO LOGADO:
		Cookies auxiliarCookies = new Cookies(req.getCookies());
		
		Cookie c = auxiliarCookies.buscaUsuario();
		
		PrintWriter w = resp.getWriter();
		
		// VERIFICA SE O USER FOI ENCONTRADO, SE SIM DEIXA SEU TEMPO COMO 0 E APARECE MSG
		// CASO ACONTEÇA ALGUMA EXCEÇÃO EXECUTA O CATCH E DEVOLVE MSG APROPRIADA
		try
		{
			c.setMaxAge(0);
			resp.addCookie(c);
			
			w.println("<html><head><title>Logout</title></head><body><h1>Logout Executado!</h1><p><a href=\"index.html\">inicio</a></p></body></html>");
		}
		catch (Exception e)
		{
			w.println("<html><head><title>Logout</title></head><body><h1>Nenhum usuário logado!</h1><p><a href=\"index.html\">inicio</a></p></body></html>");
		}

	}

}
