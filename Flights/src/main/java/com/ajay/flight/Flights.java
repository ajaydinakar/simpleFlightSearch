package com.ajay.flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Flights {

	public static void main(String[] args) {
		SpringApplication.run(Flights.class, args);
	}
	// initializing a repository of flights
	@Bean
	public FlightRepo repo()
	{
		FlightRepo repo=new FlightRepo();
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2005,
			    "UA",
			  "ORD",
			   "2018-01-31T05:10:00",
			     "IAH",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  2171,
			    "UA",
			  "ORD",
			   "2018-01-31T05:10:00",
			     "IAH",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  1128,
			    "UA",
			  "ORD",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Boeing 737-800",
			   " 925",
			    "02:41",
			     "On Time"));
		return repo;
	}
	
	
	//Repository for list of flights
	public static class FlightRepo {
		private List<FlightPOJO> flights=Collections.synchronizedList(new ArrayList<FlightPOJO>());

		public void add(FlightPOJO flight)
		{
		this.flights.add(flight)	;
		}

		public List<FlightPOJO> showall(){
		return flights;}
		
		
		public Optional<FlightPOJO> findByFlightNo(long flightNO)
	
		{
			return this.flights.stream().filter(f->f.getFlightNumber()==flightNO).findFirst();
		}
	
}
	
	
	// Controller class 
	@RestController
	@RequestMapping(value="/")
	@CrossOrigin
	public static class FlightController
	
	{
		private final FlightRepo repo;
		public FlightController(final FlightRepo repo) {this.repo=repo;}
		
		@GetMapping("/flights")
		
		public List<FlightPOJO> allflights(){return repo.showall();}
		
         @GetMapping("/flight")
         
         public Optional<FlightPOJO> findByNo(@RequestParam long no)
         {
        	 return repo.findByFlightNo(no);
         }
		
		
		
		
	}

}
