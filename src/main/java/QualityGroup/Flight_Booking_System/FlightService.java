package com.flightbooking.service;

import com.flightbooking.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	private List<Flight> flights = Arrays.asList(
			new Flight("FL101", "JFK", "LAX", LocalDateTime.parse("2024-03-15 08:00", formatter), LocalDateTime.parse("2024-03-15 11:00", formatter), 120, LocalDate.parse("2024-03-15")),
			new Flight("FL102", "LAX", "JFK", LocalDateTime.parse("2024-03-16 13:00", formatter), LocalDateTime.parse("2024-03-16 21:00", formatter), 120, LocalDate.parse("2024-03-16")),
			new Flight("FL103", "LHR", "CDG", LocalDateTime.parse("2024-03-17 09:30", formatter), LocalDateTime.parse("2024-03-17 10:30", formatter), 80, LocalDate.parse("2024-03-17")),
			new Flight("FL104", "CDG", "LHR", LocalDateTime.parse("2024-03-18 15:00", formatter), LocalDateTime.parse("2024-03-18 16:00", formatter), 80, LocalDate.parse("2024-03-18")),
			new Flight("FL105", "HND", "LAX", LocalDateTime.parse("2024-03-19 17:00", formatter), LocalDateTime.parse("2024-03-20 03:00", formatter), 200, LocalDate.parse("2024-03-19"))
	);

	public List<Flight> findAllFlights() {
		return flights;
	}

	public List<Flight> searchFlights(String departureAirport, String arrivalAirport, LocalDate departureDate) {
		return flights.stream()
				.filter(flight ->
						(departureAirport == null || flight.getDepartureAirport().equalsIgnoreCase(departureAirport)) ||
								(arrivalAirport == null || flight.getArrivalAirport().equalsIgnoreCase(arrivalAirport)) ||
								(departureDate == null || flight.getDepartureDate().equals(departureDate))
				)
				.collect(Collectors.toList());
	}

}
