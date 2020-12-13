package com.leaderboardapp.model;

import java.math.BigInteger;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="team")
public class Team {
//@Id
//private int id;
@Id
private String _id;
public String get_id() {
	return _id;
}
public void set_id(String _id) {
	this._id = _id;
}



public int getWins() {
	return wins;
}
public void setWins(int wins) {
	this.wins = wins;
}
public int getLosses() {
	return losses;
}
public void setLosses(int losses) {
	this.losses = losses;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public String getTeam_name() {
	return team_name;
}
public void setTeam_name(String team_name) {
	this.team_name = team_name;
}
private String team_name;
private int wins;
private int losses;
private int score;
private int ties;
@Override
public String toString() {
	return "Team [_id=" + _id + ", team_name=" + team_name + ", wins=" + wins + ", losses=" + losses + ", score="
			+ score + ", ties=" + ties + "]";
}
public int getTies() {
	return ties;
}
public void setTies(int ties) {
	this.ties = ties;
}
}
