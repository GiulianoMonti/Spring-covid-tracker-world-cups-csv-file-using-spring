package com.giulian.coronavirustracker.services;

import com.giulian.coronavirustracker.models.LocationStats;
import com.giulian.coronavirustracker.models.WorldCupStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


@Service
public class WorldCupStatsService {
    List<WorldCupStats> newStats = new ArrayList<>();

    public List<WorldCupStats> getAllStats() {
        return newStats;
    }

    @PostConstruct
    public void getWorldCupStats() {

        {
            try {
                Reader in = new FileReader("/Users/giulianodanielmonti/Desktop/spring/coronavirus/coronavirus-tracker/worldcup.csv");

                Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);


                for (CSVRecord cup : records) {
                    WorldCupStats worldCupStats = new WorldCupStats();

                    worldCupStats.setYear(Integer.parseInt(cup.get("Year")));
                    worldCupStats.setTeam(cup.get("Team"));
                    worldCupStats.setISO(cup.get("ISO"));
                    worldCupStats.setGoalsFor(Integer.parseInt(cup.get("Goals for")));
                    worldCupStats.setGoalsAgainst(Integer.parseInt(cup.get("Goals against")));
                    worldCupStats.setPenalties(Integer.parseInt(cup.get("Penalties")));
                    worldCupStats.setMatches(Integer.parseInt(cup.get("Matches")));
                    worldCupStats.setShotsOnGoal(Integer.parseInt(cup.get("Shots on goal")));
                    worldCupStats.setShotsWide(Integer.parseInt(cup.get("Shots wide")));
                    worldCupStats.setFreeKicks(Integer.parseInt(cup.get("Free kicks")));
                    worldCupStats.setOffside(Integer.parseInt(cup.get("Offside")));
                    worldCupStats.setCorners(Integer.parseInt(cup.get("Corners")));
                    worldCupStats.setWon(Integer.parseInt(cup.get("Won")));
                    worldCupStats.setDrawn(Integer.parseInt(cup.get("Drawn")));
                    worldCupStats.setLost(Integer.parseInt(cup.get("Offside")));
                    
                    newStats.add(worldCupStats);


                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}