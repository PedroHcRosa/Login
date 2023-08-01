package com.loginScreenApi.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginScreenApi.demo.repository.MsgRepository;

@Service
public class MsgService {

	
	@Autowired
	private MsgRepository msgRepository;
	
	public void insert(Msg obj) {
		
		msgRepository.save(obj);
		
	}
	
	public List<Msg> findBytitulo(String Titulo) {
		
		return msgRepository.findByTitulo(Titulo);
		
	}
	
	
	
}
