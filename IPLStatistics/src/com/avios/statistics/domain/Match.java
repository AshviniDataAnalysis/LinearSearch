package com.avios.statistics.domain;

import java.util.Date;

public class Match {

	private String matchID;
	
	private String seasonYear;
	
	private String matchCity;
	
	private Innings firstInnings;
	
	private Innings secondInnings;
	
	private Date matchDate;
	
	private String firstTeamName;
	
	private String secondTeamName;
	
	private String tossWinner;
	
	private String tossDecision;
	
	private String matchWinner;
	
	private String matchResult;

	public String getTossDecision() {
		return tossDecision;
	}

	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}

	public String getMatchCity() {
		return matchCity;
	}

	public void setMatchCity(String matchCity) {
		this.matchCity = matchCity;
	}

	public Match() {
		firstInnings = new Innings();
		secondInnings = new Innings();
	}
	
	public String getMatchID() {
		return matchID;
	}

	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}

	public String getSeasonYear() {
		return seasonYear;
	}

	public void setSeasonYear(String seasonYear) {
		this.seasonYear = seasonYear;
	}

	public Innings getFirstInnings() {
		return firstInnings;
	}

	public void setFirstInnings(Innings firstInnings) {
		this.firstInnings = firstInnings;
	}

	public Innings getSecondInnings() {
		return secondInnings;
	}

	public void setSecondInnings(Innings secondInnings) {
		this.secondInnings = secondInnings;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public String getFirstTeamName() {
		return firstTeamName;
	}

	public void setFirstTeamName(String firstTeamName) {
		this.firstTeamName = firstTeamName;
	}

	public String getSecondTeamName() {
		return secondTeamName;
	}

	public void setSecondTeamName(String secondTeamName) {
		this.secondTeamName = secondTeamName;
	}

	public String getTossWinner() {
		return tossWinner;
	}

	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}

	public String getMatchWinner() {
		return matchWinner;
	}

	public void setMatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}
}
