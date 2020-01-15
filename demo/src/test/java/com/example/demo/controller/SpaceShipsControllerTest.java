package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.dao.SpaceShipService;
import com.example.demo.model.SpaceShip;
import com.example.demo.service.SpaceShipBusinessRuleService;

public class SpaceShipsControllerTest {
	@Mock
	private SpaceShipBusinessRuleService spaceShipBusinessRuleService;
	@Mock
	private SpaceShipService spaceShipService;
	
	private SpaceShipsController spaceShipsController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		spaceShipsController = new SpaceShipsController(spaceShipBusinessRuleService, spaceShipService);
	}
	
	@Test
	public void getSpaceShipsTest() {
		List<SpaceShip> retreivedShips = new LinkedList<SpaceShip>();
		List<SpaceShip> expectedReturnedShips = new LinkedList<SpaceShip>();

		Mockito.when(spaceShipService.retreiveSpaceShips()).thenReturn(retreivedShips);
		Mockito.when(spaceShipBusinessRuleService.execute(retreivedShips)).thenReturn(expectedReturnedShips);
		assertEquals(expectedReturnedShips, spaceShipsController.getSpaceShips());
	}
	
	@Test
	public void getSpaceShipsTest_JSONMapping() {
		
	}

}
