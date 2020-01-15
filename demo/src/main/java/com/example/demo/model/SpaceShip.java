package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "model", "manufacturer", "cost_in_credits", "description", "hyperdrive_rating"})
public class SpaceShip {
	@JsonProperty("name")
	private String name;
	@JsonProperty("model")
	private String model;
	@JsonProperty("manufacturer")
	private String manufacturer;
	@JsonProperty("cost_in_credits")
	private String cost;
	@JsonProperty("hyperdrive_rating")
	private String hyperdrive_rating;

	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
}
