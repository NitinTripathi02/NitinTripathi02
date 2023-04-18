package com.nitin.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitin.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
