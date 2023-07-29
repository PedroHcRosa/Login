package com.loginScreenApi.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginScreenApi.demo.repository.UsersRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsersRepository usersRepository;
	
	public void insert(Users usuario) {
		
		usersRepository.save(usuario);
		
	}
	
	public  List<Users> findByUsuario(String usuario) {
		
		return usersRepository.findByUsuario(usuario);
		
	}
	
}
