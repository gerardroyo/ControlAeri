package com.ControlAeri;

import java.util.ArrayList;
import java.util.Scanner;

public class AirController {

    private static ArrayList<AirPlane> OnAirPlane = new ArrayList<AirPlane>();
    private int[] AirSpace = new int []{1000, 1000};
    private int[] Track = new int[]{100, 120};
    private static Scanner keyboard = new Scanner(System.in);

    public static void addAirPlane(int concretAirPlane) {
        if(OnAirPlane.size() < 10) {
            System.out.print("Brand: ");
            String brand = keyboard.next();

            System.out.print("Model: ");
            String model = keyboard.next();

            System.out.print("LicensePlate: ");
            String licensePlate = keyboard.next();
//-------------------------------------------------------------------------------------------------------------------------------------\\
            System.out.print("Passenger Capacity: ");
            int passengerCapacity;

            while(keyboard.hasNextInt() == false) {
                keyboard.nextLine();

                System.out.print("Incorrect Data, try again. Passenger Capacity: ");
            }

            passengerCapacity = keyboard.nextInt();
//-------------------------------------------------------------------------------------------------------------------------------------\\
            System.out.print("Crew: ");
            int crew;

            while(keyboard.hasNextInt() == false) {
                keyboard.nextLine();

                System.out.print("Incorrect Data, try again. Crew: ");
            }

            crew = keyboard.nextInt();
//-------------------------------------------------------------------------------------------------------------------------------------\\
            System.out.print("Destination: ");
            String destination = keyboard.next();

            if(concretAirPlane == 1) {
                OnAirPlane.add(new CommercialAirPlane(brand, model, licensePlate, destination, passengerCapacity, crew));
            } else {
//-------------------------------------------------------------------------------------------------------------------------------------\\
                System.out.print("Max Range Shot: ");
                int maxRangeShot;

                while(keyboard.hasNextInt() == false) {
                    keyboard.nextLine();

                    System.out.print("Incorrect Data, try again. Max Range Shot: ");
                }

                maxRangeShot = keyboard.nextInt();
//-------------------------------------------------------------------------------------------------------------------------------------\\
                System.out.print("Enemy(true/false): ");
                boolean enemy;

                while(keyboard.hasNextBoolean() == false) {
                    keyboard.nextLine();

                    System.out.print("Incorrect Data, try again. Enemy (true/false): ");
                }
                enemy = keyboard.nextBoolean();
//--------------------------------------------------------------------------------------------------------------------------------------\\
                System.out.print("Encrypted (true/false): ");
                boolean encrypted;

                while(keyboard.hasNextBoolean() == false) {
                    keyboard.nextLine();
                    System.out.print("Incorrect Data, try again. Encrypted (true/false): ");
                }
                encrypted = keyboard.nextBoolean();

                OnAirPlane.add(new BattleAirPlane(brand, model, licensePlate, destination, passengerCapacity, crew, maxRangeShot, enemy, encrypted));
            }
        } else {
            System.out.println("You have created the max Air Planes that the Air Controller can control at the same time.");
        }

    }

    public static void showAirSpace() {
        int counter = 1;
        for(AirPlane a: OnAirPlane) {
            System.out.println(counter + ". " + a.toString());
            counter++;
        }
    }
}

