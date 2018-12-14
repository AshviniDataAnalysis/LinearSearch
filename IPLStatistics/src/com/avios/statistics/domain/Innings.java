package com.avios.statistics.domain;

import java.util.HashMap;
import java.util.Map;

public class Innings {

	private String bowlingTeamName;
	
	private String battingTeamName;
	
	private int inningTotal;
	
	private Map<String, Over> overs;
	
	public Innings() {
		overs = new HashMap<String,Over>();
	}

	public String getBowlingTeamName() {
		return bowlingTeamName;
	}

	public void setBowlingTeamName(String bowlingTeamName) {
		this.bowlingTeamName = bowlingTeamName;
	}

	public String getBattingTeamName() {
		return battingTeamName;
	}

	public void setBattingTeamName(String battingTeamName) {
		this.battingTeamName = battingTeamName;
	}

	public int getInningTotal() {
		return inningTotal;
	}

	public void setInningTotal(int inningTotal) {
		this.inningTotal = inningTotal;
	}

	public Over getOverByNumber(String overNumber) {
		return overs.get(overNumber);
	}

	public void setOvers(Over over) {
		if(!overs.containsKey(over.getOverNumber())){
			overs.put(over.getOverNumber(), over);
		}
	}
	
	public int getInningsTotal() {
		
		int total = 0;
		
		for(String over : overs.keySet()) {
			total += overs.get(over).getOverTotal();
		}
		return total;
	}
	
	public Map<String, Over> getOvers(){
		return overs;
	}
}
