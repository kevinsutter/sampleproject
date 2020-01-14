package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestOperations;

import com.example.demo.model.SpaceShip;
import com.example.demo.model.SpaceShips;

public class SpaceShipServiceImplTest {

	@Mock
	private RestOperations restOperations;

	private SpaceShipServiceImpl spaceShipServiceImpl;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		spaceShipServiceImpl = new SpaceShipServiceImpl(restOperations, "url");
	}

	@Test
	public void retreiveSpaceShipsTest() {
		SpaceShips spaceShips = new SpaceShips();
		List<SpaceShip> ships = new LinkedList<SpaceShip>();
		spaceShips.setSpaceShips(ships);
		Mockito.when(restOperations.getForObject(eq("url"), eq(SpaceShips.class))).thenReturn(spaceShips);
		assertEquals(ships, spaceShipServiceImpl.retreiveSpaceShips());
		Mockito.verify(restOperations);
	}

	@Test
	public void retreiveSpaceShipsTest_nullReturn() {
		SpaceShips spaceShips = null;
		Mockito.when(restOperations.getForObject(eq("url"), eq(SpaceShips.class))).thenReturn(spaceShips);
		assertThrows(SpaceShipServiceException.class, () -> spaceShipServiceImpl.retreiveSpaceShips());
		Mockito.verify(restOperations);
	}
	
	@Test
	public void retreiveSpaceShipsTest_nullList() {
		SpaceShips spaceShips = new SpaceShips();
		Mockito.when(restOperations.getForObject(eq("url"), eq(SpaceShips.class))).thenReturn(spaceShips);
		assertThrows(SpaceShipServiceException.class, () -> spaceShipServiceImpl.retreiveSpaceShips());
		Mockito.verify(restOperations);
	}
}
