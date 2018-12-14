package com.avios.statistics.domain;

public class Delivery {

	private String deliveryNumber;
	
	private int wideRuns;
	
	private int byeRuns;
	
	private int legbyeRuns;
	
	private int noballRuns;
	
	private int penaltyRuns;
	
	private int batsmanRuns;
	
	private int extraRuns;
	
	private int totalRuns;
	
	private String batsmanName;

	public String getBatsmanName() {
		return batsmanName;
	}

	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public int getWideRuns() {
		return wideRuns;
	}

	public void setWideRuns(int wideRuns) {
		this.wideRuns = wideRuns;
	}

	public int getByeRuns() {
		return byeRuns;
	}

	public void setByeRuns(int byeRuns) {
		this.byeRuns = byeRuns;
	}

	public int getLegbyeRuns() {
		return legbyeRuns;
	}

	public void setLegbyeRuns(int legbyeRuns) {
		this.legbyeRuns = legbyeRuns;
	}

	public int getNoballRuns() {
		return noballRuns;
	}

	public void setNoballRuns(int noballRuns) {
		this.noballRuns = noballRuns;
	}

	public int getPenaltyRuns() {
		return penaltyRuns;
	}

	public void setPenaltyRuns(int penaltyRuns) {
		this.penaltyRuns = penaltyRuns;
	}

	public int getBatsmanRuns() {
		return batsmanRuns;
	}

	public void setBatsmanRuns(int batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}

	public int getExtraRuns() {
		return extraRuns;
	}

	public void setExtraRuns(int extraRuns) {
		this.extraRuns = extraRuns;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
}
