package com.fresher.web.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.User;

public interface UserService extends JpaRepository<User, Integer>{

}
