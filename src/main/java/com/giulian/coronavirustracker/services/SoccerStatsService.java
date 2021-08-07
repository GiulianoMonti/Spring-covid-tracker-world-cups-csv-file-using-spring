package com.giulian.coronavirustracker.services;

import com.giulian.coronavirustracker.models.LocationStats;
import com.giulian.coronavirustracker.models.SoccerStats;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SoccerStatsService {

    public void getSoccerStats() {
        List<LocationStats> newStats = new ArrayList<>();

        {
            try {
                Reader in = new FileReader("/Users/giulianodanielmonti/Desktop/spring/coronavirus/coronavirus-tracker/es.csv");
                Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);

                for (CSVRecord soccer : records) {
                    SoccerStats soccerStats = new SoccerStats();

                    //soccerStats.setTeam1(soccer.get("Team 1"));

                    String team1 = soccer.get("Team 1");
                    String round = soccer.get("Round");
                    String date = soccer.get("Date");
                    String FT = soccer.get("FT");
                    String team2 = soccer.get("Team 2");

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}