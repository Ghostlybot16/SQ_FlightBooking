package com.flightbooking.controller;

import com.flightbooking.model.Flight;
import com.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public String homePage() {
        return "booking";
    }

    @GetMapping("/booking")
    public String bookingPage(Model model) {
        List<Flight> allFlights = flightService.findAllFlights();
        model.addAttribute("flights", allFlights);
        return "booking";
    }

    @GetMapping("/searchFlights")
    public String searchFlights(@RequestParam String departureAirport, @RequestParam String arrivalAirport, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate, Model model) {
        List<Flight> flights = flightService.searchFlights(departureAirport, arrivalAirport, departureDate);
        System.out.println("Found flights: " + flights); // Add this line for logging
        model.addAttribute("searchResults", flights);
        return "booking";
    }

}
