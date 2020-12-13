package com.leaderboardapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.leaderboardapp.model.MatchPair;

public interface MatchPairRepository extends MongoRepository<MatchPair,String>{

}
