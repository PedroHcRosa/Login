package com.loginScreenApi.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginScreenApi.demo.Exception.RessposseException;
import com.loginScreenApi.demo.controller.ReqUser;
import com.loginScreenApi.demo.model.Users;
import com.loginScreenApi.demo.model.UsuariosService;
import com.loginScreenApi.demo.utils.CrudUtils;
import com.loginScreenApi.demo.utils.Json;



@RestController
public class Route {
	
	@Autowired
	private UsuariosService usersService;
	
	
	@GetMapping("/")
	public ResponseEntity<?> index() {
		
		Json json = new Json();
		json.put("Status", true);
		return ResponseEntity.ok().body(json.toJson());
		
	}
	
	@PostMapping("v1/cadastro")
	public ResponseEntity<?> cadastro(@RequestBody ReqUser req){
		Json json = new Json();
		Users usuario = new Users(req.getUser(), req.getPassword());
		usersService.insert(usuario);
		List<Users> ressUsers = usersService.findByUsuario(usuario.getUsuario());
		
		try {
			
			CrudUtils.addVerify(ressUsers, "usuario ja cadastrado");
			usersService.insert(usuario);
			json.put("Status", true);
		} catch(RessposseException e) {
			
			json.put("status", e.getMessage());
			
		}
		
			
			
			
		
		
		
		return ResponseEntity.ok().body(json.toJson());
		
	}
	

}



