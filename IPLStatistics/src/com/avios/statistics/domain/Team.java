package com.avios.statistics.domain;

public class Team {

	private String teamName;
	
	private String seasonYear;
	
	private int numOfFours;
	
	private int numOfSixes;
	
	private int totalScore;
	
	private int wins;

	public int getNumOfFours() {
		return numOfFours;
	}

	public void setNumOfFours(int numOfFours) {
		this.numOfFours += numOfFours;
	}

	public int getNumOfSixes() {
		return numOfSixes;
	}

	public void setNumOfSixes(int numOfSixes) {
		this.numOfSixes += numOfSixes;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore += totalScore;
	}


	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSeasonYear() {
		return seasonYear;
	}

	public void setSeasonYear(String seasonYear) {
		this.seasonYear = seasonYear;
	}

	public int getWins() {
		return wins;
	}

	public void addWin() {
		this.wins += 1;
	}
}
