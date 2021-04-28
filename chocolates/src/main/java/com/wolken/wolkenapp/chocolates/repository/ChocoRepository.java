package com.wolken.wolkenapp.chocolates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolken.wolkenapp.chocolates.entity.ChocoEntity;

@Repository
public interface ChocoRepository extends JpaRepository<ChocoEntity ,Integer> {
	public ChocoEntity findByChocoBrand(String chocoBrand);
	public int deleteByChocoBrand(String chocoBrand);
	//public void saveAll(List<ChocoEntity> saveAllList);
	public ChocoEntity findByChocoColor(String chocoColor);
	public int deleteByChocoColor(String chocoColor);
	public ChocoEntity findByChocoPrice(int chocoPrice);
	public int deleteByChocoPrice(int chocoPrice);

}
