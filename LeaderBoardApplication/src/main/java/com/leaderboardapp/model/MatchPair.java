package com.leaderboardapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="matchPair")
public class MatchPair {
	@Id
	private String id;
	private String teamOneId;
	private String teamTwoId;
	private String winId;
	private String loseId;
	private boolean tie;
	public String getTeamOneId() {
		return teamOneId;
	}
	public void setTeamOneId(String teamOneId) {
		this.teamOneId = teamOneId;
	}
	public String getTeamTwoId() {
		return teamTwoId;
	}
	public void setTeamTwoId(String teamTwoId) {
		this.teamTwoId = teamTwoId;
	}
	public String getWinId() {
		return winId;
	}
	public void setWinId(String winId) {
		this.winId = winId;
	}
	public String getLoseId() {
		return loseId;
	}
	public void setLoseId(String loseId) {
		this.loseId = loseId;
	}
	public boolean isTie() {
		return tie;
	}
	public void setTie(boolean tie) {
		this.tie = tie;
	}


}
