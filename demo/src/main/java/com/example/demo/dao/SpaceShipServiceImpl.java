package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.example.demo.model.SpaceShip;
import com.example.demo.model.SpaceShips;

@Service
public class SpaceShipServiceImpl implements SpaceShipService {

	@Autowired
	private RestOperations restOperations;
	
	@Override
	public List<SpaceShip> retreiveSpaceShips() {
      
		return restOperations.getForObject("https://swapi.co/api/starships/", SpaceShips.class).getSpaceShips();
	}
}
