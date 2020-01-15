package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.SpaceShip;

public class SpaceShipBusinessRuleServiceImplTest {

	private SpaceShipBusinessRuleServiceImpl spaceShipBusinessRuleServiceImpl;
	
	@BeforeEach
	public void setup() {
		spaceShipBusinessRuleServiceImpl = new SpaceShipBusinessRuleServiceImpl("unknown", "10000");
	}
	
	@Test
	public void executeTest() {
		List<SpaceShip> spaceShips = new LinkedList<SpaceShip>();
		SpaceShip spaceShipUnknown= new SpaceShip();
		spaceShipUnknown.setCost("unknown");
		spaceShips.add(spaceShipUnknown);
		SpaceShip spaceShipKnown= new SpaceShip();
		spaceShipKnown.setCost("1234");
		spaceShips.add(spaceShipKnown);
		
		spaceShipBusinessRuleServiceImpl.execute(spaceShips);
		
		assertEquals("10000", spaceShipUnknown.getCost());
		assertEquals("1234", spaceShipKnown.getCost());
	}
}
