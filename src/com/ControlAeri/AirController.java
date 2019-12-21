package com.ControlAeri;

import java.util.ArrayList;
import java.util.Scanner;

public class AirController {

    private static ArrayList<AirPlane> OnAirPlane = new ArrayList<AirPlane>();
    private int[] AirSpace = new int []{1000, 1000};
    private int[] Track = new int[]{100, 120};
    private static Scanner keyboard = new Scanner(System.in);

    public static void addAirPlane(int concretAirPlane) { //add the airplane

        if(OnAirPlane.size() < 10) {// controll if the max number of the airplanes that air controller can controll isn't bigger than 10

            System.out.print("Brand: ");
            String brand = keyboard.next();

            System.out.print("Model: ");
            String model = keyboard.next();

            boolean noRepeatLicensePlate = false;
            String licensePlate = "";
            while(!noRepeatLicensePlate) {
                System.out.print("LicensePlate: ");
                licensePlate = keyboard.next();
                noRepeatLicensePlate = true;
                for(AirPlane a : OnAirPlane) {
                    if (a.getLicensePlate().equals(licensePlate)) {
                        noRepeatLicensePlate = false;
                        System.out.println("This License Plate already exsist. ");
                    }
                }
            }
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

                OnAirPlane.add(new BattleAirPlane(brand, model, licensePlate, destination, passengerCapacity, crew, maxRangeShot, enemy, encrypted));// adding the user entries to the new object/airPlane in to the arraylist
            }
        } else {
            System.out.println("You have created the max Air Planes that the Air Controller can control at the same time.");
        }

    }

    public static void deleteAirPlane(AirPlane airPlane) {// remove the airplane
        OnAirPlane.remove(airPlane);
    }

    public static void showAirSpace() {
        int counter = 1;
        for(AirPlane a: OnAirPlane) {
            System.out.println(counter + ". " + a.toString());
            counter++;
        }
    }

    public static boolean controlManager() {//check if there is already a plane created
        boolean empty = false;

        if(OnAirPlane.isEmpty()) {
            empty = true;
        }
        return empty;
    }

    public static void deleteColliderAirPlanes() {
        boolean delete = false;
        AirPlane airPlane = null;

        for(AirPlane a : OnAirPlane) {
            if (a.getCoordinate().getZ() == 0) {
                airPlane = a;
                delete = true;
            }
        }
        if(delete) {
            OnAirPlane.remove(airPlane);
        }
    }

    public static boolean somePlaneInTrack() {
        boolean inTrack = false;

        for(AirPlane a : OnAirPlane) {
            if (a.getCoordinate().getZ() == 0) {
                inTrack = true;
            }
        }
        return inTrack;
    }

    public static AirPlane askForAirPlane() { // ask to user which air plane wanna controll
        boolean exist = false;
        AirPlane airPlane = null;

        System.out.print("Enter the license plate of the airplane that you wish to manipulate:");
        String airPlaneToManipulate = keyboard.next();
        while(exist == false) {

            exist = searchIfAirPlaneExsist(airPlaneToManipulate);// check if the user entrie is correct or if the airplane exsist
            if(exist) {
                airPlane = catchObjectAirPlane(airPlaneToManipulate);// search the airplane to controll
            }

            if(exist == false) {
                System.out.println("This Air Plane doesn't exsist, try it again:");
                airPlaneToManipulate = keyboard.next();
            }
        }

        return airPlane; //return object/airplane that user wanna controll
    }

    public static boolean searchIfAirPlaneExsist(String airPlaneToManipulate) {// check if the user entrie is correct or if the airplane exsist
        boolean exist = false;
        for(AirPlane a : OnAirPlane) {
            if(airPlaneToManipulate.equals(a.getLicensePlate())) {
                exist = true;
            }
        }

        return exist;
    }

    public static AirPlane catchObjectAirPlane(String airPlaneToManipulate) {
        AirPlane airPlane = null;
        for(AirPlane a : OnAirPlane) {
            if(airPlaneToManipulate.equals(a.getLicensePlate())) {
                airPlane = a;
            }
        }

        return airPlane;
    }

}

