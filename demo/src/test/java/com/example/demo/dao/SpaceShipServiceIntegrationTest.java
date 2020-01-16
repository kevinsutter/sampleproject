package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpaceShipServiceIntegrationTest {

	@Autowired
	private SpaceShipServiceImpl spaceShipServiceImpl;
	
	@Test
	public void spaceShipServiceImplIntigrationTest() {
		assertNotNull(spaceShipServiceImpl.retreiveSpaceShips());
		assertFalse(spaceShipServiceImpl.retreiveSpaceShips().isEmpty());
	}
}
