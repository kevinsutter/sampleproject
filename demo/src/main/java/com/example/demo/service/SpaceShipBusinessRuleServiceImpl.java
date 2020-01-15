package com.example.demo.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.SpaceShip;

@Service
public class SpaceShipBusinessRuleServiceImpl implements SpaceShipBusinessRuleService{
	@Value("${matchOn}")
	private String matchOn;
	
	@Value("${defaultCost}")
	private String defaultCost;
	
	public SpaceShipBusinessRuleServiceImpl() {
	}
	
	public SpaceShipBusinessRuleServiceImpl(String matchOn, String defaultCost) {
		this.defaultCost = defaultCost;
		this.matchOn = matchOn;
	}
	
	@Override
	public List<SpaceShip> execute(List<SpaceShip> spaceShips) {
		spaceShips.stream().forEach(this::convertUnkownCurrency);
		return spaceShips;
		
	}
	
	private void convertUnkownCurrency(SpaceShip spaceShip) {
		if (StringUtils.equalsIgnoreCase(spaceShip.getCost(), matchOn)) {
			spaceShip.setCost(defaultCost);
		}
	}
}
