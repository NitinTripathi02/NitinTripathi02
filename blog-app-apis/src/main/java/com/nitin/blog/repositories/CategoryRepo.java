package com.nitin.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitin.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
