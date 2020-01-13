package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"count", "results"})
public class SpaceShips {

	@JsonProperty("count")
	private int count;
	@JsonProperty("results")
	private List<SpaceShip> spaceShips;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<SpaceShip> getSpaceShips() {
		return spaceShips;
	}
	public void setSpaceShips(List<SpaceShip> spaceShips) {
		this.spaceShips = spaceShips;
	}
	
	
}
