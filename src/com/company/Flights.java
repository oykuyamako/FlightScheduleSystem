package com.company;

import java.util.Date;

public class Flights {
    private Date departDate;
    private Date arriveDate;
    public Airports departureAirport;
    public Airports arrivalAirport;
    private FlightType flightType;
    private String seatNo;
    private int Weight;

    public Date getDepartDate() {
        return departDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public int getWeight() {
        return Weight;
    }



    public Flights(Date departDate, Date arriveDate, Airports departureAirport, Airports arrivalAirport, FlightType flightType, String seatNo, int weight) {
        this.departDate = departDate;
        this.arriveDate = arriveDate;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightType = flightType;
        this.seatNo = seatNo;
        this.Weight = weight;
    }
}
enum Airports{
    KLM("KLM Airlines","KLM",true),
    TK("Turkish Airlines","TK",true),
    LH("Lufthansa Airlines","LH",true),

    ISL("Istanbul","ISL",false),
    AMS("Schiphol","AMS",false),
    FRA("Frankfurt","FRA",false);
    private final String fullName;
    private final String code;
    private final boolean departure;

    Airports(String fullName, String code, boolean departure) {
        this.fullName = fullName;
        this.code = code;
        this.departure = departure;
    }

    public String getFullName(Airports airport) {
        return airport.fullName;
    }
    public String getCode(Airports airport) {
        return airport.code;
    }
    public boolean isDeparture(Airports airport){
        return airport.departure;
    }
}

enum FlightType{
    PASSENGER,
    CARGO;
}