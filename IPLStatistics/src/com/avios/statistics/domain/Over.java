package com.avios.statistics.domain;

import java.util.HashMap;
import java.util.Map;

public class Over {

	private String overNumber;
	
	private String bowlerName;
	
	private Map<String, Delivery> deliveries;

	public Over() {
		deliveries = new HashMap<String, Delivery>(6);
	}

	public String getOverNumber() {
		return overNumber;
	}

	public void setOverNumber(String overNumber) {
		this.overNumber = overNumber;
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public Delivery getDeliveriesByNumber(String deliveryNumber) {
		return deliveries.get(deliveryNumber);
	}

	public void setDeliveries(Delivery delivery) {
		if(!deliveries.containsKey(delivery.getDeliveryNumber())) {
			deliveries.put(delivery.getDeliveryNumber(), delivery);
		}
	}
	
	public int getOverTotal() {
		int total = 0;
		for(String delivery : deliveries.keySet()) {
			total += deliveries.get(delivery).getTotalRuns();
		}
		
		return total;
	}
	
	public Map<String, Delivery> getDeliveries(){
		return deliveries;
	}
}
