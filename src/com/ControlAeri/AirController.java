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

        System.out.print("Crew: ");
        int crew = keyboard.nextInt();

        System.out.println("Destination: ");
        String destination = keyboard.nextLine();

        OnAirPlane.add(new AirPlane(brand, model, licensePlate, destination, passengerCapacity, crew));

    }

    public static void showAirSpace() {
        System.out.print("                     BRAND    ");
        System.out.print("MODEL    ");
        System.out.print("LICENSE PLATE    ");
        System.out.print("X    ");
        System.out.print("Y    ");
        System.out.print("HEIGHT    ");
        System.out.print("VELOCITY    ");
        System.out.print("UNDERCARRIAGE    ");
        System.out.print("MOTOR    ");
        System.out.print("MISSILES   ");
        System.out.print("ORIGIN   ");
        System.out.print("DESTINATION   ");

        System.out.println("");
        System.out.print("AirPlane 1 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getBrand());
        }

        System.out.println("");
        System.out.print("AirPlane 2 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getModel());
        }

        System.out.println("");
        System.out.print("AirPlane 3 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getLicensePlate());
        }

        System.out.println("");
        System.out.print("AirPlane 3 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getCoordinate().getX());
        }

        System.out.println("");
        System.out.print("AirPlane 4 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getCoordinate().getY());
        }

        System.out.println("");
        System.out.print("AirPlane 5 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getCoordinate().getZ());
        }

        System.out.println("");
        System.out.print("AirPlane 6 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getVelocity());
        }

        System.out.println("");
        System.out.print("AirPlane 7 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getUndercarriage());
        }

        System.out.println("");
        System.out.print("AirPlane 8 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getMotor());
        }

        System.out.println("");
        System.out.print("AirPlane 9 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getCoordinate().getX());
        }

        System.out.println("");
        System.out.print("AirPlane 10 ");
        for(int i = 0; i < OnAirPlane.size(); i++) {
            System.out.print("               " + OnAirPlane.get(i).getOrigin());
        }
    }

}

