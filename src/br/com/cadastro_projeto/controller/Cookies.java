package br.com.cadastro_projeto.controller;

import javax.servlet.http.Cookie;

// CLASSE AUXILIAR QUE APENAS VARRE E DEVOLVE COOKIE:
public class Cookies {
	private final Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		super();
		this.cookies = cookies;
	}
	
	public Cookie buscaUsuario()
	{
		// VARRE OS COOKIES DA REQUISICAO SE EXISTEM:
		if (cookies.length > 0) {

			for (Cookie c : cookies) {

				// SE ENCONTRAR O COOKIE DESEJADO, MATA PELO TEMPO E DEVOLVE:
				if (c.getName().equals("usuario")) {

					return c;
				}

			}
		}
		
		return null;
	}

}
