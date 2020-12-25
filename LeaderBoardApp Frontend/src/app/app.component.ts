import { Component } from '@angular/core';
import { TeamService } from './services/team.service';
import {Team} from './models/team';
import { MatchPair } from './models/matchPair';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LeaderBoardApp';
  selectedTeam:any;
  playMatchPair:MatchPair;
  idx:number;
isMatch:boolean=false;
checkedTeam:Team;
  teams:Team[];
  arrayTeams:Team[]=[];
  checkedTeams=[];
  selectedTeams: Set<any>;
  myArray=[];
  checkWin=false;
  isPlayMatch=false;
  flag=0;
  searchtext:string;
startIndex=0;
pos=0;
endIndex=5;
arr=new Array(10);

  constructor(private _teamService:TeamService){
this.selectedTeams=new Set<any>();
  }
  ngOnInit()
  {
    
this._teamService.getTeams().subscribe(data=>{
  this.teams=data;
  console.log(data);
})
this._teamService.getTeamsPlayed().subscribe(data=>{
  for(let i=0;i<data.length;i++)
  {
    this.selectedTeams.add(data[i]);
}

console.log(this.selectedTeams);
this.myArray=Array.from(this.selectedTeams.values());
}
)
  }
  getArrayFromNumber(length)
  {
    return new Array(length/5);
  }
  match()
  {
this.isMatch=true;
  }
  addToTable()
  {
    console.log(this.selectedTeam);
    for(let team of Array.from(this.selectedTeams.values()))
    {
      console.log(team._id);
      console.log(this.selectedTeam._id);
if(team._id===this.selectedTeam._id)
{
  this.flag=1;
break;
}
}
if(this.flag==0)
{
this.selectedTeams.add(this.selectedTeam);
  console.log(this.selectedTeams);
  this.myArray=Array.from(this.selectedTeams.values());
  this.arr.length=this.myArray.length/5;


}
this.flag=0;
  }
   changeHandler(checkedTeam,isChecked:boolean)
   {
    if(isChecked) 
    {
      this.checkedTeams.push(checkedTeam);
     console.log(this.checkedTeams);
    }
    if(!isChecked)

    {
      this.idx=this.checkedTeams.indexOf(checkedTeam);
      this.checkedTeams.splice(this.idx,1);
      console.log(this.checkedTeams);

    }
    if(this.checkedTeams.length==2)
    {
      this.checkWin=true;
     
    }
    else
    {
      this.checkWin=false;
     
    }
   }

playMatch()
{
  this.isPlayMatch=true;
  this.playMatchPair=new MatchPair();
  this.playMatchPair.teamOneId=this.checkedTeams[0]._id;
  this.playMatchPair.teamTwoId=this.checkedTeams[1]._id;
  console.log(this.playMatchPair);
}
isWin(winId:string,loseId:string)
{
  this.playMatchPair.winId=winId;
  this.playMatchPair.loseId=loseId;
this._teamService.matchWin(this.playMatchPair).subscribe(res=>{
  console.log(res);
})
location.reload();
}

tie()
{
this.playMatchPair.tie=true;
this._teamService.matchWin(this.playMatchPair).subscribe(res=>{
  console.log(res);
})
location.reload();
}
updateIndex(pageIndex)
{
  this.startIndex=pageIndex*5;
  this.endIndex=this.startIndex+5;
}
updatePos()
{
  console.log(this.pos);
  this.pos=this.pos+1;

}

}
