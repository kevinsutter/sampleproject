package com.example.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SpaceShipService;
import com.example.demo.model.SpaceShip;

@RestController
@RequestMapping(value = "/SpaceShips")
public class SpaceShipsController {

	@Autowired
	private SpaceShipService spaceShipService;

	@GetMapping
	public List<SpaceShip> getSpaceShips() {
		List<SpaceShip> ships = spaceShipService.retreiveSpaceShips();

		ships.stream().forEach(this::convertUnkownCurrency);

		return ships;
	}

	public void convertUnkownCurrency(SpaceShip spaceShip) {
		if (StringUtils.equalsIgnoreCase(spaceShip.getCost(), "unknown")) {
			spaceShip.setCost("100");
		}
	}
}
