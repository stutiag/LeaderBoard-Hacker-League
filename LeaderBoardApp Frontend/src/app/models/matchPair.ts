export class MatchPair

{
    teamOneId:string;
    teamTwoId:string;
    winId:string;
    loseId:string;
    tie:boolean;
    MatchPair()
    {
        this.teamOneId="";
        this.teamTwoId="";
        this.winId="";
        this.loseId="";
        this.tie=false;
    }
}