package com.wolken.wolkenapp.chocolates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.chocolates.entity.ChocoEntity;
import com.wolken.wolkenapp.chocolates.entity.ResponseEntity;
import com.wolken.wolkenapp.chocolates.service.ChocoService;

@RestController
@Transactional
@RequestMapping("/")
public class ChocoController {
	@Autowired
	ChocoService service;
	
	@GetMapping("/")
	public String index() {
		return "Hello";
	}
	
	@PostMapping("/save")
	public ResponseEntity save(@RequestBody ChocoEntity entity) {
		return service.validateAndAddChoco(entity);
		
	}
	
	@GetMapping("/getall")
	public List<ChocoEntity> getAll(){
		List<ChocoEntity>getAll = service.validateAndGetAll();
		return getAll;
	}
	
	@PutMapping("/updatebybrand")
	public ResponseEntity updateByBrand(@RequestBody ChocoEntity entity) {
		return service.validateAndUpdateByBrand(entity);
	}
	
	@DeleteMapping("/deletebybrand")
	public ResponseEntity deleteByBrand(String chocoBrand) {
		return service.validateAndDeleteByBrand(chocoBrand);
	}
	
	@PostMapping("/saveall")
	public String saveAll(@RequestBody List<ChocoEntity> saveAllList) {
		return service.validateAndSaveAll(saveAllList);
	}
	
	@PutMapping("/updatebycolor")
	public ResponseEntity updateByColor(@RequestBody ChocoEntity entity) {
		return service.validateAndUpdateBychocoColor(entity);
	}
	
	@DeleteMapping("/deletebycolor")
	public ResponseEntity deleteByColor(String chocoColor) {
		return service.validateAndDeleteBychocoColor(chocoColor);
	}
	
	@PutMapping("/updatebyprice")
	public ResponseEntity updateByPrice(@RequestBody ChocoEntity entity) {
		return service.validateAndUpdateByPrice(entity);
	}
	
	@DeleteMapping("/deletebyprice")
	public ResponseEntity deleteByPrice(int chocoPrice) {
		return service.validateAndDeleteByPrice(chocoPrice);
	}

}