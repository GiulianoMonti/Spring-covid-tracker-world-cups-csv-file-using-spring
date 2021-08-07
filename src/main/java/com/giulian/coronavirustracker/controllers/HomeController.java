package com.giulian.coronavirustracker.controllers;

import com.giulian.coronavirustracker.models.LocationStats;
import com.giulian.coronavirustracker.models.WorldCupStats;
import com.giulian.coronavirustracker.services.CoronavirusDataService;
import com.giulian.coronavirustracker.services.WorldCupStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronavirusDataService coronaVirusDataService;
    @Autowired
    WorldCupStatsService worldCupStatsService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }


    @GetMapping("/world-cup")
    public String worldCup(Model model) {
        List<WorldCupStats> allStats =worldCupStatsService.getAllStats();
        model.addAttribute("worldCupStats", allStats);
        return "world-cup-home";
    }



    @GetMapping("/covid-tracker")
    public String home(Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);

        return "home";
    }
}