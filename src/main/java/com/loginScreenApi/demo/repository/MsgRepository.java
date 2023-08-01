package com.loginScreenApi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginScreenApi.demo.model.Msg;

public interface MsgRepository extends JpaRepository<Msg, Long> {
	
	List<Msg> findByTitulo(String titulo);
	List<Msg> findByUsuario(String usuario);

}
