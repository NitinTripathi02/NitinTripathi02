package com.nitin.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
@NoArgsConstructor

public class Category {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer categoryId;
	private String CategoryTitle;
	private String categoryDescription;
}
