package com.company;
import java.awt.desktop.SystemSleepEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    static Scanner scl= new Scanner(System.in); //deneme

    public static int MainMenu(){
        Scanner sc= new Scanner(System.in);
        System.out.println("----MENU-----");
        System.out.println("New Flight --- 1 ");
        System.out.println("My Flights --- 2");
        int option= sc.nextInt();
        return option;
    }

    public static Date CheckDate(boolean way){   // way: boolean for specifying departure/arrival

        Scanner sc= new Scanner(System.in);
        while(way){
          System.out.print("Enter the departure date of the flight");
            Date departDate = null;
            departDate = isValidFormat("dd/MM/yyyy", sc.nextLine());
            if(departDate!= null){
                Date date = new Date();
                if(compareDates(date,departDate)){
                    return departDate;
                }
            }
        }

        return null;
    }

    public static Date CheckDate(boolean way, Date dpdate){

        Scanner sc= new Scanner(System.in);
        while(!way){
            System.out.print("Enter the arrival date of the flight");
            Date arriveDate= null;
            arriveDate = isValidFormat("dd/MM/yyyy", sc.nextLine());
            if(arriveDate!= null){
                if(compareDates(dpdate,arriveDate))
                    return arriveDate;
            }
        }
        return null;
    }

    public static boolean compareDates(Date d1, Date d2){
        boolean state = false;
        if(d1.compareTo(d2) > 0) {
            System.out.print("Enter a date after");
            System.out.println(d1);
            return state;
        } else if(d1.compareTo(d2) < 0) {
            state = true;
            return state;
        }else if(d1.compareTo(d2) == 0) {
            System.out.println("Returning on the same day? You are crazy!");
            state = true;
            return state;
        }
        return state;
    }

    public static Date isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
                System.out.println("This format is not supported. Try dd/MM/YYYY");
            }
        } catch (ParseException ex) {
            System.out.println("This format is not supported. Try dd/MM/YYYY");
            ex.printStackTrace();
        }
        return date;
    }

    public static Airports SelectAirport(boolean way){
        Scanner sc= new Scanner(System.in);
        String space = "---";
        System.out.println("Press any key to continue");
        System.out.println("Press Y to go back to main menu");

        while(way){
            String airportName = sc.nextLine();
            if(airportName.equals("y")){
                return null;
            }
            for (Airports flight : Airports.values()) {
                if(flight.isDeparture(flight) == way){
                    System.out.println(flight.getCode(flight) + space  + flight.getFullName(flight));
                    if(flight.getFullName(flight).equals(airportName) || flight.getCode(flight).equals(airportName)){
                        return flight;
                    }//else{System.out.println("Please enter a valid name"); }
                }
            }
            System.out.println("Select one of the airports below for DEPARTING and enter their code or full name");
            //airportName= sc.nextLine();
        }
        while(!way){
            String airportName= sc.nextLine();
            if(airportName.equals("y")){
                return null;
            }
            for (Airports flight : Airports.values()) {
                if(flight.isDeparture(flight) == way){
                    System.out.println(flight.getCode(flight) + space  + flight.getFullName(flight));
                    if(flight.getFullName(flight).equals(airportName) || flight.getCode(flight).equals(airportName)){
                        return flight;
                    }
                }
            }
            System.out.println("Select one of the airports below for ARRIVING and enter their code or full name");
        }
       return null;
    }

    public static int SelectFlightType(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Passenger -- 1");
        System.out.print("Cargo -- 2");
        int option= sc.nextInt();
        return option;
    }

    public static String SelectSeatNo(){
        while (true) {
            System.out.println("Enter a seat no between 1-99 and A-Z");
            String  seatNo = scl.nextLine();
            char[] chars = seatNo.toCharArray();
            switch (chars.length){
                case 2:
                    try {
                        Character.isDigit(seatNo.charAt(0));
                        Character.isLetter(seatNo.charAt(1));
                        return seatNo;
                    } catch (NumberFormatException e) {
                        // str is not a number
                        System.out.println("Wrong format");
                    }
                case 3:
                    try {
                        Character.isDigit(seatNo.charAt(0));
                        Character.isDigit(seatNo.charAt(1));
                        Character.isLetter(seatNo.charAt(2));
                        return seatNo;
                    } catch (NumberFormatException e) {
                        // str is not a number
                        System.out.println("Wrong format");
                    }
                default:
                    System.out.println("Wrong format");

            }
        }

    }

    public static int SelectWeight(){
        while (true){
            System.out.println("Enter the weight of your cargo *Should be between 100-500");
            int weight = scl.nextInt();
            if(weight<100 || weight > 500){
                System.out.println("Wrong amount");
            }else{
                return weight;
            }
        }
    }
}
