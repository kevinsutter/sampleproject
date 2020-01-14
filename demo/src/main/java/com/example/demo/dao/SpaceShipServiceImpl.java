package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.example.demo.model.SpaceShip;
import com.example.demo.model.SpaceShips;

@Service
public class SpaceShipServiceImpl implements SpaceShipService {

	public SpaceShipServiceImpl(RestOperations restOperations, String url) {
		this.restOperations = restOperations;
		this.url = url;
	}

	@Autowired
	private RestOperations restOperations;

	@Value("endpoinUrl")
	private String url;

	@Override
	public List<SpaceShip> retreiveSpaceShips() {
		SpaceShips spaceShips = restOperations.getForObject(url, SpaceShips.class);
		if (spaceShips == null || spaceShips.getSpaceShips() == null) {
			throw new SpaceShipServiceException("Result did not contain content");
		}

		return spaceShips.getSpaceShips();
	}
}
