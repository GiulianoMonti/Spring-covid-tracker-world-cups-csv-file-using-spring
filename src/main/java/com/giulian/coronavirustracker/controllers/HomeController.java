package com.giulian.coronavirustracker.controllers;

import com.giulian.coronavirustracker.models.LocationStats;
import com.giulian.coronavirustracker.services.CoronavirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CoronavirusDataService coronavirusDataService;


    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronavirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();

//        for (LocationStats stat : allStats) {
//            int latestTotalCases = stat.getLatestTotalCases();
//            totalCases += latestTotalCases;
//        }
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalReportedCases);

        return "home";
    }
}
