package br.com.cadastro_projeto.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// EXEMPLO DE AUDITORIA DE COOKIE:
@WebFilter(urlPatterns="/*")
public class FiltroAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// REALIZA O CAS PARA O REQUEST E RESPONSE APROPRIADO:
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// PEGA A URI ACESSADA ATUAL:
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		// VERIFICA SE A URI È PROTEGIDA:
		if(uri.equals("/cadastro-projeto/projetos.html"))
		{
			
			try{
				Cookies auxiliarCookies = new Cookies(req.getCookies());
				Cookie c = auxiliarCookies.buscaUsuario();
				chain.doFilter(request, response);
			}
			catch (Exception e) {
				
				// redirecionamento:
				resp.sendRedirect("acesso-negado.html");
			}
			
		}
		else
		{
			chain.doFilter(request, response);
		}
			
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
