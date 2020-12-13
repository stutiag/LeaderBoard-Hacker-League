package com.leaderboardapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leaderboardapp.repository.MatchPairRepository;
import com.leaderboardapp.repository.TeamRepository;
import com.leaderboardapp.model.MatchPair;
import com.leaderboardapp.model.Team;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TeamController {
@Autowired
private TeamRepository teamRepository;
@Autowired
private MatchPairRepository matchRepo;

@GetMapping("/teams")
public List<Team> getTeams()
{
	return teamRepository.findAll();
}
@GetMapping("/teams/played")
public List<Team> getTeamsPlayed()
{
	

	return teamRepository.findTeamsPlayed();
}

@GetMapping
List<Team> search(@PathVariable(value="query") String query)
{
	return teamRepository.search(query);
}
@PostMapping(value="/match")
public ResponseEntity<String> playMatch(@RequestBody MatchPair matchPair) {
	System.out.println("inside match pair function");
	matchRepo.save(matchPair);
	String oid=matchPair.getTeamOneId();
	System.out.println(oid);
	String tid=matchPair.getTeamTwoId();
	System.out.println(tid);
	Team tt1=null,tt2=null;


	int one,two,oloss,owin,tloss,twin,oties,tties;
	Optional<Team> t1=teamRepository.findById(oid);
	Optional<Team> t2=teamRepository.findById(tid);	
	System.out.println(matchPair.isTie());
	if(matchPair.isTie())
	{
		System.out.println("inside tie");
		if(t1.isPresent())
			{
			tt1=t1.get();
			}
		if(t2.isPresent())
		{
			tt2=t2.get();
		}
		one=tt1.getScore();
		System.out.println(one);

		two=tt2.getScore();
		System.out.println(two);

		oties=tt1.getTies();
		System.out.println(oties);

		tties=tt2.getTies();
		System.out.println(tties);

		tt1.setScore(one+1);
		one=tt1.getScore();
		System.out.println(one);

		tt1.setTies(oties+1);
teamRepository.save(tt1);
		tt2.setScore(two+1);
		tt2.setTies(tties+1);
		teamRepository.save(tt2);
		System.out.println("object one"+tt1.toString());
		System.out.println("object one"+tt2.toString());

return ResponseEntity.ok().body("tied");
		
	}
	else
	{
		System.out.println("inside else block");

		String winId=matchPair.getWinId();
		String loseId=matchPair.getLoseId();
		Optional<Team> winT=teamRepository.findById(winId);
		Optional<Team> loseT=teamRepository.findById(loseId);
		tt1=winT.get();
		tt2=loseT.get();
		System.out.println(tt1.toString());
		System.out.println(tt2.toString());

		System.out.println(tt1.getTeam_name());


		int wscore=tt1.getScore();
		tt1.setScore(wscore+3);
		twin=tt1.getWins();
		tt1.setWins(twin+1);
		teamRepository.save(tt1);
		tloss=tt2.getLosses();
		tt2.setLosses(tloss+1);
		teamRepository.save(tt2);

		System.out.println(tt1.toString());
		System.out.println(tt2.toString());


		return ResponseEntity.ok().body("team a wins");

	} 	 

}
}
