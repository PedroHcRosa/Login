package com.loginScreenApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginScreenApi.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByUsers(String Users);


}
