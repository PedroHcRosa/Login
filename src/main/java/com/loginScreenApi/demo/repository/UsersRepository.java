package com.loginScreenApi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginScreenApi.demo.model.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByUsers(String Users);


}