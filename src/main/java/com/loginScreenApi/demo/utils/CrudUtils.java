package com.loginScreenApi.demo.utils;

import java.util.List;

import com.loginScreenApi.demo.Exception.RessposseException;
import com.loginScreenApi.demo.model.Users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class CrudUtils {

	public static void addVerify(List<?> obj, String msg) throws RessposseException {
		
		if(obj.size() != 0) {
			
			throw new RessposseException(msg);
			
		}
		
	}
	
	public static void auth(List<Users> user, String reqUser, String senha, HttpSession sessio) throws RessposseException {
		
		if(user.isEmpty()) {
			
			throw new RessposseException("usuarios não encontrado");
			
		}
		
		
		if(user.get(0).getUsuario().equals(reqUser) && user.get(0).getPassword().equals(senha)) {
			
			sessio.setAttribute("logado", true);
			sessio.setAttribute("nome", user.get(0).getUsuario());
			
			
		} else {
			
			throw new RessposseException("Dados Incorretos");
			
		}
	
		
	}

	public static void isLogado(HttpServletRequest http) throws RessposseException {
		
		HttpSession session = http.getSession();
		
		if(session.getAttribute("Logado") == null) {
			
			throw new RessposseException("Sua sessão expirou, faça login novamente");
			
		}
		
		if(!(boolean)session.getAttribute("logado")) {
			
			
			throw new RessposseException("Sua sessão expirou, faça login novamente");
			
		}
		
	}
	
}
