 package br.com.cadastro_projeto.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;

// REALIZA O LOGIN DO USUÁRIO:
@WebServlet(urlPatterns="/login-usuario")
public class LoginUsuario extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String Login= req.getParameter("login");
		String Senha= req.getParameter("senha");
		
		if(Login.equals("admin") && Senha.equals("admin"))
		{
			// CRIA COOKIE NO BROWSER DO CLIENTE:
			Cookie cookie= new Cookie ("usuario","admin");
			
			/*tempo maximo de vida do cookie*/
			cookie.setMaxAge(10*60);
			
			// DEVOLVE PELO RESPONSE PARA O CLIENTE
			resp.addCookie(cookie);			
			
			/*redirecionamento simples com Java STATUS CODE 302*/
			resp.sendRedirect("projetos.html");
		}
		else
		{
			PrintWriter w=resp.getWriter();
			w.println("<html><body><h1>login=" + Login + " e senha="+Senha+" inválidos!</h1></body></html>");
		}
		
	}

}
