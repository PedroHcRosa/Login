package com.loginScreenApi.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginScreenApi.msgcontroller.ReqUser;
import com.loginScreenApi.utils.Json;



@RestController
public class Route {
	
	
	@GetMapping("/")
	public ResponseEntity<?> index() {
		
		Json json = new Json();
		json.put("Status", true);
		return ResponseEntity.ok().body(json.toJson());
		
	}
	
	@PostMapping("v1/cadastro")
	public ResponseEntity<?> cadastro(@RequestBody ReqUser req){
		
		Json json = new Json();
		json.put("nome", req.getUser());
		json.put("senha", req.getPassword());
		
		return ResponseEntity.ok().body(json.toJson());
		
	}
	

}



