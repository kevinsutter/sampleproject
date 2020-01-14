package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SpaceShipService;
import com.example.demo.model.SpaceShip;
import com.example.demo.service.SpaceShipBusinessRuleService;

@RestController
@RequestMapping(value = "/SpaceShips")
public class SpaceShipsController {
	
	@Autowired
	private SpaceShipBusinessRuleService spaceShipBusinessRuleService;

	@Autowired
	private SpaceShipService spaceShipService;

	@GetMapping
	public List<SpaceShip> getSpaceShips() {
		List<SpaceShip> ships = spaceShipService.retreiveSpaceShips();

		return spaceShipBusinessRuleService.execute(ships);

	}
	
}
