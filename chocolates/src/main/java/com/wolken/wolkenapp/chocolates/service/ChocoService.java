package com.wolken.wolkenapp.chocolates.service;

import java.util.List;

import com.wolken.wolkenapp.chocolates.entity.ChocoEntity;
import com.wolken.wolkenapp.chocolates.entity.ResponseEntity;

public interface ChocoService {
	public ResponseEntity validateAndAddChoco(ChocoEntity entity);
	public List<ChocoEntity> validateAndGetAll();
	public ResponseEntity validateAndUpdateByBrand(ChocoEntity entity);
	public ResponseEntity validateAndDeleteByBrand(String chocoBrand);
	public String validateAndSaveAll(List<ChocoEntity> chocentity);
	public ResponseEntity validateAndUpdateBychocoColor(ChocoEntity entity);
	public ResponseEntity validateAndDeleteBychocoColor(String chocoColor);
	public ResponseEntity validateAndUpdateByPrice(ChocoEntity entity);
	public ResponseEntity validateAndDeleteByPrice(int chocoPrice);
	

}
