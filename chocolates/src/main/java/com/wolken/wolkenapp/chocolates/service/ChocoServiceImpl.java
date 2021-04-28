package com.wolken.wolkenapp.chocolates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.chocolates.entity.ChocoEntity;
import com.wolken.wolkenapp.chocolates.entity.ResponseEntity;
import com.wolken.wolkenapp.chocolates.repository.ChocoRepository;


@Service
public class ChocoServiceImpl implements ChocoService{
	@Autowired
	ChocoRepository repo;
	@Autowired
	ChocoEntity chocoentity;
	@Autowired
	ResponseEntity resentity;

	@Override
	public ResponseEntity validateAndAddChoco(ChocoEntity entity) {
		// TODO Auto-generated method stub
		if(!entity.getChocoColor().equals(null) && !entity.getChocoBrand().equals(null) && entity.getChocoPrice() > 0) {
			repo.save(entity);
			resentity.setEntity(entity);
			resentity.setMessage("Data added successfully");
			return resentity;
		}
		resentity.setEntity(null);
		resentity.setMessage("Data not added successfully, error");
		return resentity;
	}

	@Override
	public List<ChocoEntity> validateAndGetAll() {
		// TODO Auto-generated method stub
		List<ChocoEntity>getAllList = repo.findAll();
		return getAllList;
		
	}

	@Override
	public ResponseEntity validateAndUpdateByBrand(ChocoEntity entity) {
		// TODO Auto-generated method stub
		
		if(entity != null) {
			if(!entity.getChocoBrand().equals(null) && !entity.getChocoColor().equals(null) && entity.getChocoPrice() > 0) {
				chocoentity = repo.findByChocoBrand(entity.getChocoBrand());
				if(chocoentity != null) {
					chocoentity.setChocoColor(entity.getChocoColor());
					chocoentity.setChocoPrice(entity.getChocoPrice());
					repo.save(chocoentity);
					resentity.setEntity(chocoentity);
					resentity.setMessage("Data updated successfully");
					return resentity;
				}
				resentity.setEntity(null);
				resentity.setMessage("Data does not exist with given brandname");
				return resentity;
				
			}
		}
		resentity.setEntity(null);
		resentity.setMessage("Error,data not updated");
		return resentity;
	}

	@Override
	public ResponseEntity validateAndDeleteByBrand(String chocoBrand) {
		// TODO Auto-generated method stub
		if(!chocoBrand.equals(null)) {
			int result = repo.deleteByChocoBrand(chocoBrand);
			if(result > 0) {
				resentity.setEntity(null);
				resentity.setMessage("Deleted Successfully");
				return resentity;
			}
		}
		resentity.setEntity(null);
		resentity.setMessage("Data not deleted, error");
		return resentity;
	}

	@Override
	public String validateAndSaveAll(List<ChocoEntity> saveAllList) {
		// TODO Auto-generated method stub
		if(saveAllList != null) {
			repo.saveAll(saveAllList);
			return "data saved successfully";
		}
		return "data isn't saved";
	}

	@Override
	public ResponseEntity validateAndUpdateBychocoColor(ChocoEntity entity) {
		// TODO Auto-generated method stub
		if(entity != null) {
			if(!entity.getChocoBrand().equals(null) && !entity.getChocoColor().equals(null) && entity.getChocoPrice() > 0) {
				chocoentity = repo.findByChocoColor(entity.getChocoColor());
				if(chocoentity != null) {
					chocoentity.setChocoBrand(entity.getChocoBrand());
					chocoentity.setChocoColor(entity.getChocoColor());
					chocoentity.setChocoPrice(entity.getChocoPrice());
					repo.save(chocoentity);
					resentity.setEntity(chocoentity);
					resentity.setMessage("Data updated successfully");
					return resentity;
				}
				
			}
		}
		resentity.setEntity(null);
		resentity.setMessage("Data not updated successfully");
		return resentity;
	}

	@Override
	public ResponseEntity validateAndDeleteBychocoColor(String chocoColor) {
		// TODO Auto-generated method stub
		if(!chocoColor.equals(null)) {
			int result  = repo.deleteByChocoColor(chocoColor);
			if(result > 0) {
				resentity.setEntity(null);
				resentity.setMessage("Data deleted successfully");
				return resentity;
			}
			
		}
		resentity.setEntity(null);
		resentity.setMessage("data is not deleted");
		return resentity;
	}

	@Override
	public ResponseEntity validateAndUpdateByPrice(ChocoEntity entity) {
		// TODO Auto-generated method stub
		if(entity != null) {
			if(!entity.getChocoBrand().equals(null) && !entity.getChocoColor().equals(null) && entity.getChocoPrice() > 0) {
				chocoentity = repo.findByChocoPrice(entity.getChocoPrice());
				if(chocoentity != null) {
					chocoentity.setChocoBrand(entity.getChocoBrand());
					chocoentity.setChocoColor(entity.getChocoColor());
					repo.save(chocoentity);
					resentity.setEntity(chocoentity);
					resentity.setMessage("Updated successfully");
					return resentity;
				}
				
			}
		}
		resentity.setEntity(null);
		resentity.setMessage("Not updated some error");
		return resentity;
	}

	@Override
	public ResponseEntity validateAndDeleteByPrice(int chocoPrice) {
		// TODO Auto-generated method stub
		if(chocoPrice > 0) {
			int result = repo.deleteByChocoPrice(chocoPrice);
			if(result > 0) {
				resentity.setEntity(null);
				resentity.setMessage("Deleted successfully");
				return resentity;
			}
		}
		resentity.setEntity(null);
		resentity.setMessage("Delete operation failed!!");
		return resentity;
	}

}
