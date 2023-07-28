package com.loginScreenApi.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.loginScreenApi.demo.repository.UsersRepository;

public class UsuariosService {

	@Autowired
	private UsersRepository usersRepository;
	
}
