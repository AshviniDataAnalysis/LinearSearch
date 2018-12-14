package com.avios.statistics.dataprep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.avios.statistics.domain.Delivery;
import com.avios.statistics.domain.Match;
import com.avios.statistics.domain.Over;

public class DataAggregator {

	static private Map<String, Match> matches = new HashMap<String, Match>();
	
	public void aggregateMatchData(String matchLine) {
		
		String[] inputs = matchLine.split(",");
		
		String matchID = inputs[0];
		String seasonYear = inputs[1];
		String city = inputs[2];
		String date = inputs[3];
		String team1 = inputs[4];
		String team2 = inputs[5];
		String tossWinner = inputs[6];
		String tossDecision = inputs[7];
		String result = inputs[8];
		String winner = null;
		if(!result.equalsIgnoreCase("no result")) {
			winner = inputs[9];
		}
		
		Match match = matches.get(matchID);
		if(null == match) {
			
			match = new Match();
			
			match.setMatchID(matchID);
			match.setSeasonYear(seasonYear);
			match.setMatchCity(city);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date matchDate = null;
			try {
				matchDate = simpleDateFormat.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			match.setMatchDate(matchDate);
			match.setFirstTeamName(team1);
			match.setSecondTeamName(team2);
			match.setTossWinner(tossWinner);
			match.setTossDecision(tossDecision);
			
			if(tossWinner.equalsIgnoreCase(team1)) {
				if(tossDecision.equalsIgnoreCase("field")) {
					match.getFirstInnings().setBowlingTeamName(team1);
					match.getSecondInnings().setBattingTeamName(team1);
					match.getFirstInnings().setBattingTeamName(team2);
					match.getSecondInnings().setBowlingTeamName(team2);
				} else {
					match.getFirstInnings().setBattingTeamName(team1);
					match.getSecondInnings().setBowlingTeamName(team1);
					match.getFirstInnings().setBowlingTeamName(team2);
					match.getSecondInnings().setBattingTeamName(team2);
				}
			} else {
				if(tossDecision.equalsIgnoreCase("field")) {
					match.getFirstInnings().setBowlingTeamName(team2);
					match.getSecondInnings().setBattingTeamName(team2);
					match.getFirstInnings().setBattingTeamName(team1);
					match.getSecondInnings().setBowlingTeamName(team1);
				} else {
					match.getFirstInnings().setBattingTeamName(team2);
					match.getSecondInnings().setBowlingTeamName(team2);
					match.getFirstInnings().setBowlingTeamName(team1);
					match.getSecondInnings().setBattingTeamName(team1);
				}
			}
			
			match.setMatchResult(result);
			match.setMatchWinner(winner);
			
			matches.put(matchID, match);
		}
	}
	
	public void aggregateDeliveriesData(String deliveryLine) {
		
		String[] inputs = deliveryLine.split(",");
		
		String matchID = inputs[0];
		String inningNumber = inputs[0];
		String overNumber = inputs[4];
		String deliveryNumber = inputs[5];
		String batsmanName = inputs[6];
		String bowler = inputs[7];
		String wideRuns = inputs[8];
		String byeRuns = inputs[9];
		String legByeRuns = inputs[10];
		String noBallRuns = inputs[11];
		String penaltyRuns = inputs[12];
		String batsmanRuns = inputs[13];
		String extraRuns = inputs[14];
		String totalRuns = inputs[15];
		
		Match match = matches.get(matchID);
		
		if(null != match) {
				
			Over over = null;
			
			if(inningNumber.equalsIgnoreCase("1")) {
				over = match.getFirstInnings().getOverByNumber(overNumber);
				
				if(null == over) {
					over = new Over();
					
					over.setBowlerName(bowler);
					over.setOverNumber(overNumber);
				}
				
				match.getFirstInnings().setOvers(over);
			} else {
				over = match.getSecondInnings().getOverByNumber(overNumber);
				
				if(null == over) {
					over = new Over();
					
					over.setBowlerName(bowler);
					over.setOverNumber(overNumber);
				}
				
				match.getSecondInnings().setOvers(over);
			}
			
			Delivery delivery = new Delivery();
			
			delivery.setBatsmanName(batsmanName);
			delivery.setBatsmanRuns(Integer.parseInt(batsmanRuns));
			delivery.setByeRuns(Integer.parseInt(byeRuns));
			delivery.setExtraRuns(Integer.parseInt(extraRuns));
			delivery.setLegbyeRuns(Integer.parseInt(legByeRuns));
			delivery.setNoballRuns(Integer.parseInt(noBallRuns));
			delivery.setPenaltyRuns(Integer.parseInt(penaltyRuns));
			delivery.setTotalRuns(Integer.parseInt(totalRuns));
			delivery.setWideRuns(Integer.parseInt(wideRuns));
			delivery.setDeliveryNumber(deliveryNumber);
			
			over.setDeliveries(delivery);
		}
	}
	
	public Map<String, Match> getAggregatedData(){
		return matches;
	}
	
	
	}

