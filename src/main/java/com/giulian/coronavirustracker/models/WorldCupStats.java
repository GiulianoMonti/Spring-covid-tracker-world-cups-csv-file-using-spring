package com.giulian.coronavirustracker.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WorldCupStats {
    public int year;
    public String team;
    public String ISO;
    public int goalsFor;
    public int goalsAgainst;
    public int penalties;
    public int matches;
    public int shotsOnGoal;
    public int shotsWide;
    public int freeKicks;
    public int offside;
    public int corners;
    public int won;
    public int drawn;
    public int lost;

}
