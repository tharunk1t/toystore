package com.example.project.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.toymodel;
import com.example.project.service.toyservice;

@RestController
public class 

{

	@Autowired
	public toyservice aserv;
	
	//post mapping
	
	@PostMapping("/posttoy")
	public String posttoy(@RequestBody toymodel hr)
	{
		aserv.savetoy(hr);
		return "Data is saved to the Database";
	}
	
	//get mapping
	
	@GetMapping("/gettoy")
	public List<toymodel> gettoyInfo()
	{
		return aserv.gettoy();
	}
	
	//put mapping
	
	@PutMapping("/updatetoy")
	public toymodel updatetoyInfo(@RequestBody toymodel ha)
	{
		return aserv.updatetoy(ha);
	}
	
	//Delete Mapping
	
	@DeleteMapping("/deletetoyif/{id}")g
	public ResponseEntity<String> deletetoyInfo(@PathVariable int id)
	{
		boolean deleted = aserv.deletetoyif(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("toy with ID " + id + " deleted successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("toy with ID " + id + " not found");
		}
	}
	
	//Delete Mapping using path variable
	
	@DeleteMapping("/Deletetoy/{id}")
	public String removetoy(@PathVariable("id") int hid)
	{
		aserv.deletetoy(hid);
		return "toy with Id "+hid+" id deleted";
	}
	
	//delete mapping using request parm
	

	@DeleteMapping("/byReqParm")
	public String removeByRequestParm(@RequestParam("id") int id)
	{
		aserv.deletetoy(id);
		return "toy with Id "+id+" id deleted";
	}
	
	//getUserById
	
	@GetMapping("/users/(userId)")
	public ResponseEntity<?> getUserbyId(@PathVariable int userId)
	{
		Optional<toymodel> toy = aserv.getUserId(userId);
		if(toy != null)
		{
			return ResponseEntity.ok(toy);
		}
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
	}
	
}