package com.ajay.flight;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.tomcat.jni.Time;




@XmlRootElement
public class FlightPOJO {
    public FlightPOJO(long flightNumber, String carrierr, String origin, String depature, String destination,
			String arrival, String aircraft, String distance, String travelTime, String status) {
		super();
		this.flightNumber = flightNumber;
		this.carrierr = carrierr;
		this.origin = origin;
		this.depature = depature;
		this.destination = destination;
		this.arrival = arrival;
		this.aircraft = aircraft;
		this.distance = distance;
		this.travelTime = travelTime;
		Status = status;
	}
	@Override
	public String toString() {
		return "FlightPOJO [flightNumber=" + flightNumber + ", carrierr=" + carrierr + ", origin=" + origin
				+ ", depature=" + depature + ", destination=" + destination + ", arrival=" + arrival + ", aircraft="
				+ aircraft + ", distance=" + distance + ", travelTime=" + travelTime + ", Status=" + Status + "]";
	}
	public long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrierr() {
		return carrierr;
	}
	public void setCarrierr(String carrierr) {
		this.carrierr = carrierr;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	private	long flightNumber ;
	private	String carrierr ;
	private	String origin;
	private String depature;
	private String destination;
    private String arrival;
	private String aircraft;
	private String distance;
	private String travelTime;
	private String Status;
}
