package com.ajay.flight;
import  java.util.stream.Collectors;
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
		repo.add(new FlightPOJO(  "2005",
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO("0638",
			    "UA",
			  "IAH",
			   "2018-01-31T07:45:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO( "1160",
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Boeing 737-800",
			   " 925",
			    "02:33",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  "1256",
			    "UA",
			  "IAH",
			   "2018-01-31T14:22:00",
			     "ORD",
			    "2018-01-31T17:01:00",
			    "Boeing 737-800",
			   " 925",
			    "02:41",
			     "On Time"));
		repo.add(new FlightPOJO(  "2153",
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  "2155",
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO( "2131",
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Boeing 737-900",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO( "2043",
			    "UA",
			  "IAH",
			   "2018-01-31T05:10:00",
			     "ORD",
			    "2018-01-31T07:57:00",
			    "Boeing 737-800",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  "0748",
			    "UA",
			  "ORD",
			   "2018-01-31T05:10:00",
			     "IAH",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:47",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO(  "2166",
			    "UA",
			  "ORD",
			   "2018-01-31T05:10:00",
			     "IAH",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:34",
			     "Arrived at Gate"));
		repo.add(new FlightPOJO( "2177",
			    "UA",
			  "ORD",
			   "2018-01-31T05:10:00",
			     "IAH",
			    "2018-01-31T07:57:00",
			    "Airbus A320",
			   " 925",
			    "02:41",
			     "On Time"));
		repo.add(new FlightPOJO( "1128",
			    "UA",
			  "ORD",
			   "2018-01-31T05:10:00",
			     "IAH",
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
		
		public List<FlightPOJO> findByOD(String flightNO,String date,String origin,String destination ){
			return flights.stream()
					.filter(f->f.getFlightNumber().equals(flightNO) || ( f.getDestination().equals(destination) && f.getOrigin().equals(origin)) )
					.collect(Collectors.toList())
					;}
		
		
		public Optional<FlightPOJO> findByFlightNo(String flightNO,String date)
	
		{
			return this.flights.stream().filter(f->f.getFlightNumber().equals(flightNO)).findFirst();
		}
	
}
	
	
	// Controller class 
	@RestController
	@RequestMapping(value="/")
	@CrossOrigin // needed as ui runs on different server
	public static class FlightController
	
	{
		private final FlightRepo repo;
		public FlightController(final FlightRepo repo) {this.repo=repo;}
		
		@GetMapping("/flights")
		
		public List<FlightPOJO> allflights(){return repo.showall();}
		
         @GetMapping("/flight")
         
         public Optional<FlightPOJO> findByNo(@RequestParam String no, @RequestParam(required=false) String date)
         {
        	 return repo.findByFlightNo(no,date);
         }
		
	@GetMapping("/flightOD")
		
		public List<FlightPOJO> flightsOD(@RequestParam(required=false) String no, @RequestParam(required=false) String date, @RequestParam(required=false) String origin, @RequestParam(required=false) String destination)
	{return repo.findByOD(no, date, origin, destination);}
		
		
	}

}
