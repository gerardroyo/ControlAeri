package com.ControlAeri;

import java.util.ArrayList;
import java.util.Scanner;

public class AirController {

    private static ArrayList<AirPlane> OnAirPlane = new ArrayList<AirPlane>();
    private int[] AirSpace = new int []{1000, 1000};
    private int[] Track = new int[]{100, 120};
    private static Scanner keyboard = new Scanner(System.in);

    public static void addAirPlane(int concretAirPlane) {
        System.out.print("Brand: ");
        String brand = keyboard.next();

        System.out.print("Model: ");
        String model = keyboard.next();

        System.out.print("LicensePlate: ");
        String licensePlate = keyboard.next();

        System.out.print("Passenger Capacity: ");
        int passengerCapacity = keyboard.nextInt();

        System.out.print("Crew: ");
        int crew = keyboard.nextInt();

        System.out.print("Destination: ");
        String destination = keyboard.next();

        if(concretAirPlane == 1) {
            OnAirPlane.add(new CommercialAirPlane(brand, model, licensePlate, destination, passengerCapacity, crew));
        } else {
            OnAirPlane.add(new AirPlane(brand, model, licensePlate, destination, passengerCapacity, crew));
        }



    }

    public static void showAirSpace() {
        for(AirPlane a: OnAirPlane) {
            System.out.println(a.toString());
        }
    }

}

