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
import com.loginScreenApi.demo.controller.Reqmsg;
import com.loginScreenApi.demo.model.Msg;
import com.loginScreenApi.demo.model.MsgService;
import com.loginScreenApi.demo.model.Users;
import com.loginScreenApi.demo.model.UsuariosService;
import com.loginScreenApi.demo.utils.CrudUtils;
import com.loginScreenApi.demo.utils.Json;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@RestController
public class Route {
	
	
	
	@Autowired
	private UsuariosService usersService;
	
	@Autowired
	private MsgService msgService;
	
	
	@GetMapping("/")
	public ResponseEntity<?> index(HttpServletRequest http) {
		HttpSession session = http.getSession();
		Json json = new Json();
		json.put("Status", session.getAttribute("Logado"));
		return ResponseEntity.ok().body(json.toJson());
		
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logOut(HttpServletRequest http) {
		HttpSession session = http.getSession();
		Json json = new Json();
		session.invalidate();
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
	
	@PostMapping("v1/sendmsg")
	public ResponseEntity<?> sendmsg(@RequestBody Reqmsg req, HttpServletRequest http) {
		Json json = new Json();
		HttpSession session = http.getSession();
		try {
			
			CrudUtils.isLogado(http);
			List<Msg> ress = msgService.findBytitulo(req.getTitulo());
			CrudUtils.addVerify(ress, "msg ja cadastrada");
			Msg msg = new Msg(session.getAttribute("nome").toString(), req.getTitulo(), req.getPost());
			MsgService msgService2 = new MsgService();
			msgService2.insert(msg);
			json.put("Status", true);
		
		} catch (Exception e) {
			
			json.put("status", e.getMessage());
			
		}
		
		return ResponseEntity.ok().body(json.toJson());
	}



	@PostMapping("v1/login")
	public ResponseEntity<?> login(@RequestBody ReqUser req, HttpServletRequest http) {
		
		HttpSession session = http.getSession();
		List<Users> ressUsers = usersService.findByUsuario(req.getUser());
		Json json = new Json();
		
		try {
			CrudUtils.auth(ressUsers, req.getUser(), req.getPassword(), session);
			json.put("Status", true);
			json.put("Logado", true);
		
		} catch (Exception e) {
			
			json.put("Status", e.getMessage());
			
		}
		
		return ResponseEntity.ok().body(json.toJson());
	}

}




