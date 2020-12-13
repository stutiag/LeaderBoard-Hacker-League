package com.leaderboardapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.leaderboardapp.model.Team;

public interface TeamRepository extends MongoRepository<Team, String> {
	@Query("{$or : [{score: { $gt: 0} }, {losses : { $gt: 0}}]}")
	List<Team> findTeamsPlayed(Sort sort);
	@Query("{team_name:{?0}}")
	List<Team> search(String teamName);
}
