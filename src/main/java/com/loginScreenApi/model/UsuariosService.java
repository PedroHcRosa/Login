package com.loginScreenApi.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.loginScreenApi.repository.UsersRepository;

public class UsuariosService {

	@Autowired
	private UsersRepository usersRepository;
	
}
