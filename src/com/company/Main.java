package com.company;
import java.awt.desktop.SystemSleepEvent;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main extends Menu{
    static List<Flights> OwnedFlights = new ArrayList<Flights>();

    public static void main(String[] args) {
        while(true){
            switch (Menu.MainMenu())
            {
                case 1:
                    ViewNewFlights();
                    break;
                case 2:
                    ViewSelectedflights();
                    break;
                default:
                    System.out.println("Enter a valid number");
            }
        }

    }

    public static void ViewNewFlights(){
        Date departDate = null;
        Date arriveDate = null;

        departDate = Menu.CheckDate(true);
        arriveDate = Menu.CheckDate(false,departDate);

        Airports departureAirport = Menu.SelectAirport(true);
        if(departureAirport == null){  //going back to the main menu
            return;
        }
        Airports arrivalAirport = Menu.SelectAirport(false);
        if(arrivalAirport == null){   //going back to the main menu
            return;
        }
        while(true){
            switch (Menu.SelectFlightType()){
                case 1:
                    String seatNo = SelectSeatNo();
                    Flights newPassengerFlight = new Flights(departDate,arriveDate,departureAirport,arrivalAirport, FlightType.PASSENGER,seatNo,0);
                    System.out.println(newPassengerFlight.getDepartDate() + "Departing to " + arrivalAirport);
                    System.out.println(newPassengerFlight.getArriveDate() + "Arriving to " + departureAirport);
                    System.out.println("flight type is" + newPassengerFlight.getFlightType());
                    OwnedFlights.add(newPassengerFlight);
                    return;
                case 2:
                    int cargoWeight = SelectWeight();
                    Flights newCargoFlight = new Flights(departDate,arriveDate,departureAirport,arrivalAirport,FlightType.CARGO,null,cargoWeight);
                    System.out.println(newCargoFlight.getDepartDate() + "Departing to " + arrivalAirport);
                    System.out.println(newCargoFlight.getArriveDate() + "Arriving to " + departureAirport);
                    System.out.println("flight type is" + newCargoFlight.getFlightType());
                    OwnedFlights.add(newCargoFlight);
                    return;
                default:
                    System.out.println("Enter a valid number");
            }
        }
        


    }
    public static void ViewSelectedflights(){
        for (Flights flight: OwnedFlights) {
            System.out.println("On  " + flight.getDepartDate() + "Departing to   " + flight.arrivalAirport);
            System.out.println("On  " + flight.getArriveDate() + "Arriving to   " + flight.departureAirport);
            System.out.println("flight type is  " + flight.getFlightType());
            if(flight.getFlightType() == FlightType.PASSENGER){
                System.out.println("seat no is  " + flight.getSeatNo());
            }else{
                System.out.println("cargo weight is " + flight.getWeight());
            }
        }

    }


}
