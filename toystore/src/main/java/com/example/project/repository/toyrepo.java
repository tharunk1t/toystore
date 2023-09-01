package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.toymodel;

public interface toyrepo extends JpaRepository<toymodel, Integer> {
	

}
