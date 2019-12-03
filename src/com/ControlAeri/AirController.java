package com.ControlAeri;

import java.util.ArrayList;
import java.util.Scanner;

public class AirController {

    private static ArrayList<AirPlane> OnAirPlane = new ArrayList<AirPlane>();
    private int[] AirSpace = new int []{1000, 1000};
    private int[] Track = new int[]{100, 120};
    private static Scanner keyboard = new Scanner(System.in);

    public static void addAirPlane() {
        System.out.print("Brand: ");
        String brand = keyboard.nextLine();

        System.out.print("Model: ");
        String model = keyboard.nextLine();

        System.out.print("LicensePlate: ");
        String licensePlate = keyboard.nextLine();

        System.out.print("Passenger Capacity: ");
        int passengerCapacity = keyboard.nextInt();

        OnAirPlane.add(new AirPlane(brand, model, licensePlate, passengerCapacity));

    }

    public static void showAirSpace() {
        System.out.print("                     AirPlane 1");
        System.out.print("AirPlane 2    ");
        System.out.print("AirPlane 3    ");
        System.out.print("AirPlane 4    ");
        System.out.print("AirPlane 5    ");
        System.out.print("AirPlane 6    ");
        System.out.print("AirPlane 7    ");
        System.out.print("AirPlane 8    ");
        System.out.print("AirPlane 9    ");
        System.out.print("AirPlane 10   ");

        System.out.println("");
        System.out.print("Brand ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getBrand());
        }

        System.out.println("");
        System.out.print("Model ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getModel());
        }

        System.out.println("");
        System.out.print("License Plate");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getLicensePlate());
        }

        System.out.println("");
        System.out.print("X");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            if(OnAirPlane.get(i).getCoordinate().getX().) {

            }
            System.out.print(OnAirPlane.get(i).getCoordinate().getX());
        }

        System.out.println("");
        System.out.print("Y");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            if(OnAirPlane.get(i).getCoordinate().getY().isEmpty()) {

            }
            System.out.print(OnAirPlane.get(i).getCoordinate().getY());
        }

        System.out.println("");
        System.out.print("Height");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            if(OnAirPlane.get(i).getCoordinate().getZ().isEmpty()) {

            }
            System.out.print(OnAirPlane.get(i).getCoordinate().getZ());
        }

        System.out.println("");
        System.out.print("Velocity");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            if(OnAirPlane.get(i).getVelocity().isEmpty()) {

            }
            System.out.print(OnAirPlane.get(i).getVelocity());
        }

        System.out.println("");
        System.out.print("Undercarriage");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getUndercarriage());
        }

        System.out.println("");
        System.out.print("Motor");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getMotor());
        }

        System.out.println("");
        System.out.print("Missiles");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getCoordinate().getX());
        }

        System.out.println("");
        System.out.print("Origin");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getOrigin());
        }

        System.out.println("");
        System.out.print("Destination");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print(OnAirPlane.get(i).getDestination());
        }
    }

}

