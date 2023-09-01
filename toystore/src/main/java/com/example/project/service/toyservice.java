package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.toymodel;
import com.example.project.repository.toyrepo;

@Service
public class toyservice {
	
	@Autowired
	public toyrepo arepo;
	
	//post the data
	public String savetoy(toymodel h)
	{
		arepo.save(h);
		return "Data is saved to database";
	}
	
	//get the data
	
	public List<toymodel> gettoy()
	{
		return arepo.findAll();
	}
	
	//update the data(put)
	
	public toymodel updatetoy(toymodel hm)
	{
		return arepo.saveAndFlush(hm);
	}
	
	//delete if id is present
	
	public boolean deletetoyif(int toyId)
	{
		if(arepo.existsById(toyId))
		{
			arepo.deleteById(toyId);
			return true;
		}
		return false;
	}
	
	//delete the data
	
	public void deletetoy(int toy_id)
	{
		System.out.println("Deleted");
		arepo.deleteById(toy_id);
	}
	
	//get mapping by id
	
	public Optional<toymodel> getUserId(int userId)
	{
		Optional<toymodel> toy=arepo.findById(userId);
		if(toy.isPresent())
		{
			return toy;
		}
		return null;
	}

}