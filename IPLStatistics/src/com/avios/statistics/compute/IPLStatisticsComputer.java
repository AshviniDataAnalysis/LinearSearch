package com.avios.statistics.compute;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.avios.statistics.domain.Delivery;
import com.avios.statistics.domain.Match;
import com.avios.statistics.domain.Over;
import com.avios.statistics.domain.Team;

public class IPLStatisticsComputer {
	
	public void getTopTeamsOf1617ByField(Map<String, Match> matches) {
		
		Calendar calendar = Calendar.getInstance();
		Map<String, Team> listFor2016 = new HashMap<String, Team>();
		Map<String, Team> listFor2017 = new HashMap<String, Team>();
		
		for(Match match : matches.values()) {
		
			calendar.setTime(match.getMatchDate());
			int year = calendar.get(1);
			if(year == 2017) {
				
				if(match.getMatchWinner().equalsIgnoreCase(match.getTossWinner())
						&& match.getTossDecision().equalsIgnoreCase("field")) {
					Team team = listFor2017.get(match.getMatchWinner());
					if(null == team) {
						team = new Team();
						team.setSeasonYear("2017");
						team.setTeamName(match.getMatchWinner());
					}
					team.addWin();
					listFor2017.put(match.getMatchWinner(), team);
				}
			} else if(year == 2016) {
				
				if(match.getMatchWinner().equalsIgnoreCase(match.getTossWinner())
						&& match.getTossDecision().equalsIgnoreCase("field")) {
					Team team = listFor2016.get(match.getMatchWinner());
					if(null == team) {
						team = new Team();
						team.setSeasonYear("2016");
						team.setTeamName(match.getMatchWinner());
					}
					team.addWin();
					listFor2016.put(match.getMatchWinner(), team);
				}
			}
		}
		
		List<String> finalList = new LinkedList<String>();
		String header = "Year\tTeam\tCount";
		finalList.add(header);
		
		List<Team> list = new LinkedList<Team>(listFor2016.values());
		Collections.sort(list,new Comparator<Team>() {

			@Override
			public int compare(Team o1, Team o2) {
				return o2.getWins()-o1.getWins();
			}
		});
		
		int i = 4;
		for(Team team : list) {
			
			String teamWinner = team.getSeasonYear() +"\t" + team.getTeamName() +"\t"+ team.getWins();
			finalList.add(teamWinner);
			if(--i == 0) {
				break;
			}
		}
		
		list = new LinkedList<Team>(listFor2017.values());
		Collections.sort(list,new Comparator<Team>() {

			@Override
			public int compare(Team o1, Team o2) {
				return o2.getWins()-o1.getWins();
			}
		});
		
		i = 4;
		for(Team team : list) {
			
			String teamWinner = team.getSeasonYear() +"\t" + team.getTeamName() +"\t"+ team.getWins();
			finalList.add(teamWinner);
			if(--i == 0) {
				break;
			}
		}
		printList(finalList);
	}
	
	public void getBoundariesSummary(Map<String, Match> matches) {
		
		Map<String, Team> teamList = new HashMap<String, Team>();
		Calendar calendar = Calendar.getInstance();
		
		for(Match match : matches.values()) {
			
			calendar.setTime(match.getMatchDate());
			int year = calendar.get(1);
			
			String key = match.getFirstInnings().getBattingTeamName()+"_"+year;
			Team team = teamList.get(key);
			
			if(null == team) {
				team = new Team();
				team.setSeasonYear(String.valueOf(year));
				team.setTeamName(match.getFirstInnings().getBattingTeamName());
			}
			
			Map<String, Integer> summary = getSummary(match.getFirstInnings().getOvers());
			team.setNumOfFours(summary.get("fours"));
			team.setNumOfSixes(summary.get("sixes"));
			team.setTotalScore(summary.get("total"));
			
			teamList.put(key, team);
			
			key = match.getSecondInnings().getBattingTeamName()+"_"+year;
			team = teamList.get(key);
			
			if(null == team) {
				team = new Team();
				team.setSeasonYear(String.valueOf(year));
				team.setTeamName(match.getSecondInnings().getBattingTeamName());
			}
			
			summary = getSummary(match.getSecondInnings().getOvers());
			team.setNumOfFours(summary.get("fours"));
			team.setNumOfSixes(summary.get("sixes"));
			team.setTotalScore(summary.get("total"));
			
			teamList.put(key, team);
		}
		
		List<Team> sortedList = new LinkedList<Team>(teamList.values());
		Collections.sort(sortedList, new Comparator<Team>() {

			@Override
			public int compare(Team o1, Team o2) {
				return Integer.parseInt(o1.getSeasonYear()) - Integer.parseInt(o2.getSeasonYear());
			}
		});
		
		List<String> finalList = new LinkedList<String>();
		String header = "Year\tTeam_Name\tFours_Count\tSixes_Count\tTotal_Score";
		finalList.add(header);
		
		for(Team team : sortedList) {
			
			String printLine = team.getSeasonYear() + "\t" + team.getTeamName() + "\t" + team.getNumOfFours() + "\t" + team.getNumOfSixes() + "\t" + team.getTotalScore();
			finalList.add(printLine);
		}
		
		printList(finalList);
	}
	
	
	private Map<String, Integer> getSummary(Map<String, Over> overs){
		
		Map<String, Integer> summary = new HashMap<String, Integer>();
		
		int numOfFours = 0;
		int numOfSixes = 0;
		int totalScore = 0;
		
		for(Over over : overs.values()) {
			
			for(Delivery delivery : over.getDeliveries().values()) {
			
				if(delivery.getBatsmanRuns() == 6) {
					numOfSixes++;
				} else if(delivery.getBatsmanRuns() == 4) {
					numOfFours++;
				}
				
				totalScore += delivery.getTotalRuns();
			}
		}
		
		summary.put("sixes", numOfSixes);
		summary.put("fours", numOfFours);
		summary.put("total", totalScore);
		
		return summary;
	}
	
	private void printList(List<String> list) {
		for(String line : list) {
			System.out.println(line);
		}
	}
}
