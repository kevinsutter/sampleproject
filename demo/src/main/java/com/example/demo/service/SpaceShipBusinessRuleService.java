package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SpaceShip;

public interface SpaceShipBusinessRuleService {

	List<SpaceShip> execute(List<SpaceShip> spaceShips);
}
