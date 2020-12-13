import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Team} from '../models/team';
import {MatchPair} from '../models/matchPair';
@Injectable({
  providedIn: 'root'
})
export class TeamService {
readonly ApiUrl="http://localhost:8080/";
  constructor(private http:HttpClient) { }
getTeams():Observable<Team[]>
{
return this.http.get<Team[]>(this.ApiUrl+"teams");
}
getTeamsPlayed():Observable<Team[]>
{
  return this.http.get<Team[]>(this.ApiUrl+"teams/played");
}
matchWin(matchPair:MatchPair)
{
  return this.http.post<any>(this.ApiUrl + 'match',matchPair);
}

}


