package com.Ibraheem;

public class Main {

    public static void main(String[] args) {
        League<Team<FootballPlayer>> footballLeague = new League<>("NFL");
        Team<FootballPlayer> nigeriaSuperEagles = new Team<>("Nigeria SuperEagles");
        Team<FootballPlayer> arsenal = new Team<>("Arsenal");
        Team<FootballPlayer> chelsea = new Team<>("Chelsea");
        Team<FootballPlayer> ManU = new Team<>("Man U");

        chelsea.matchResult(ManU, 1, 0);;
        chelsea.matchResult(nigeriaSuperEagles, 3, 8);
        nigeriaSuperEagles.matchResult(chelsea, 2, 1);

        footballLeague.add(nigeriaSuperEagles);
        footballLeague.add(arsenal);
        footballLeague.add(chelsea);
        footballLeague.add(ManU);

        footballLeague.showLeagueTitle();



    }
}
