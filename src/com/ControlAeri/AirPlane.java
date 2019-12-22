package com.ControlAeri;

import java.util.Scanner;

public class AirPlane {
    private String brand;
    private String model;
    private String licensePlate;
    private String origin = "BCN";
    private String destination;
    private int passengerCapacity;
    private int crew;
    private int velocity = 0;
    private float route;
    private boolean undercarriage = true;
    private boolean motor = false;
    private boolean track = true;
    private Coordinate coordinate;
    private static boolean exit = false;

    private static Scanner keyboard = new Scanner(System.in);

    public AirPlane(String brand, String model, String licensePlate, String destination, int passengerCapacity, int crew) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.destination = destination;
        this.crew = crew;
        this.coordinate = new Coordinate(100, 100, 0);
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getLicensePlate() { return licensePlate; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getOrigin() { return origin; }

    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public int getPassengerCapacity() { return passengerCapacity; }

    public void setPassengerCapacity(int passengerCapacity) { this.passengerCapacity = passengerCapacity; }

    public int getCrew() { return crew; }

    public void setCrew(int crew) { this.crew = crew; }

    public int getVelocity() { return velocity; }

    public void setVelocity(int velocity) { this.velocity = velocity; }

    public float getRoute() { return route; }

    public void setRoute(float route) { this.route = route; }

    public boolean getUndercarriage() { return undercarriage; }

    public void setUndercarriage(boolean undercarriage) { this.undercarriage = undercarriage; }

    public Coordinate getCoordinate() { return coordinate; }

    public void setCoordinate(Coordinate coordinate) { this.coordinate = coordinate; }

    public boolean getMotor() { return motor; }

    public void setMotor(boolean motor) { this.motor = motor; }

    public boolean getTrack() { return track; }

    public void setTrack(boolean track) { this.track = track; }


    public static boolean optionSelected(int option, AirPlane airPlane) {// backend of MenuManage | optionManage = option that user selected | airPlaneToManipulate = airplane selected


        switch(option) {
            case 0:
                break;
            case 1:
                TurnONMotor(airPlane);
                break;
            case 2:
                TurnOFFMotor(airPlane);
                break;
            case 3:
                speed(airPlane);
                break;
            case 4:
                undercarriage(airPlane);
                break;
            case 5:
                goUpDown(airPlane);
                break;
            case 6:
                position(airPlane);
                break;
            case 7:

                break;
        }

        return exit;
    }

    public static void position(AirPlane airPlane) {
        int posX= askForPositionX();;
        int posY= askForPositionY();;

        if(airPlane.getCoordinate().getZ() == 0) {
            System.out.println("To modify the position, the AirPlane must be in the air");
        } else  {
            AirController.positionControl(posX, posY, airPlane);
        }
    }

    public static int askForPositionY() {
        System.out.println("Enter the meters X: ");

        while(!keyboard.hasNextInt()) {
            keyboard.nextLine();

            System.out.println("Incorrect value, try again.");
            System.out.println("Enter the meters X: ");
        }

        return keyboard.nextInt();
    }

    public static int askForPositionX() {
        System.out.println("Enter the meters X: ");

        while(!keyboard.hasNextInt()) {
            keyboard.nextLine();

            System.out.println("Incorrect value, try again.");
            System.out.println("Enter the meters X: ");
        }

        return keyboard.nextInt();
    }

    public static void goUpDown(AirPlane airPlane) {// FALTA CONTROLAR QUE EL AVIO POGUI ATERRITZAR SEMPRE I QUAN ESTIGUI = A LA X I Y DE LA PISTA I NO HI HAGIN NINGUN AVIO A LA MATEIXA PISTA
        int z;
        if(airPlane.getVelocity() < 180) {
            System.out.println("This AirPlane cant go up because needs to go 180Km/h or more");
        } else if(airPlane.getCoordinate().getZ() > 1 || airPlane.getVelocity() >= 180) {
            upDownController(airPlane, askForZ());
        }
    }

    public static void upDownController(AirPlane airPlane, int z) {
        if(airPlane.getCoordinate().getZ() < 500) {
            if(z >= 500 && airPlane.getUndercarriage()) {
                System.out.println("If u want to up more than 500m and the landing gear is out the AirPlane gonna crash... Are you sure (true/false)? ");

                while(!keyboard.hasNextBoolean()) {
                    keyboard.nextLine();

                    System.out.println("Incorrect value, try again.");
                    System.out.println("If u want to up more than 500m and the landing gear is out the AirPlane gonna crash... Are you sure (true/false)? ");
                }
                if(keyboard.nextBoolean()) { // if the confirm from user are true
                    System.out.println("The AirPlane crashed... that was a bad idea.");
                    AirController.deleteAirPlane(airPlane); //delete AirPlane because got crashed
                    exit = true; // dont show the menu again, cause we don't have the plane
                }
            } else if(z <= 0) {
                careZ0(airPlane, z);
            } else {
                System.out.println("Changing height...");
                airPlane.getCoordinate().setZ(z);
                System.out.println("Done");
                exit = false;
            }
        } else {
            if(z <= 0) {
                careZ0(airPlane, z);
            } else {
                System.out.println("Changing height...");
                airPlane.getCoordinate().setZ(z);
                System.out.println("Done");
                exit = false;
            }
        }
    }

    public static void careZ0(AirPlane airPlane, int z) {
        if(z == 0) {
            if(airPlane.getCoordinate().getX() == 100 && (airPlane.getCoordinate().getY() >= 100 && airPlane.getCoordinate().getY() <= 120)) {
                if(airPlane.getVelocity() <= 200) {
                    if(airPlane.getUndercarriage()) {
                        if(!AirController.somePlaneInTrack()) {
                            landingAirPlane(airPlane);
                        } else {
                            crashColliderController("The landing track is in use. The manipulated AirPlane and the one on the landing track will collide, are you sure (true / false)? ", airPlane);
                        }
                    } else {
                        crashController("To land the landing gear must be out, but it isn't, the AirPlane will crash, are you sure (true / false)? ", airPlane);
                    }
                } else {
                    crashController("The AirPlane is going faster than is should (recomendation <= 200Km/h), the AirPlane will crash, are you sure (true/false)? ", airPlane);
                }
            } else {
                crashController("The AirPlane isn't alineated with the Landing Track (x = 100, y between 100-120), the AirPlane will crash, are you sure (true/false)? ", airPlane);
            }
        } else {
            crashController("Are you sure about that? the AirPlane will crash versus floor.. (true/false) ", airPlane);
        }
    }

    public static void landingAirPlane(AirPlane airPlane) {
        System.out.println("The AirPlane is landing...");
        System.out.println("Entering the garage...");
        AirController.deleteAirPlane(airPlane);
        System.out.println("Done");
    }

    public static void crashColliderController(String warning, AirPlane airPlane) {
        System.out.println(warning);

        while(!keyboard.hasNextBoolean()) {
            keyboard.nextLine();

            System.out.println("Incorrect value, try again.");
            System.out.println(warning);
        }
        if(keyboard.nextBoolean()) { // if the confirm from user are true
            System.out.println("Both AirPlane crashed... that was a bad idea.");
            AirController.deleteAirPlane(airPlane); //delete AirPlane because got crashed
            AirController.deleteColliderAirPlanes(); //delete AirPlane in the landing trak because got crashed by other AirPlane trying landing

            exit = true; // dont show the menu again, cause we don't have the plane
        }
    }

    public static void crashController(String warning, AirPlane airPlane) {
        System.out.println(warning);

        while(!keyboard.hasNextBoolean()) {
            keyboard.nextLine();

            System.out.println("Incorrect value, try again.");
            System.out.println(warning);
        }
        if(keyboard.nextBoolean()) { // if the confirm from user are true
            System.out.println("The AirPlane crashed... that was a bad idea.");
            AirController.deleteAirPlane(airPlane); //delete AirPlane because got crashed
            exit = true; // dont show the menu again, cause we don't have the plane
        }
    }

    public static int askForZ() {
        System.out.println("Enter the meters that you want to up/down: ");

        while(!keyboard.hasNextInt()) {
            keyboard.nextLine();

            System.out.println("Incorrect value, try again.");
            System.out.println("Enter the meters that you want to up/down: ");        }

        return keyboard.nextInt();
    }

    public static void undercarriage(AirPlane airPlane) {
        boolean landingGear = askForLandingGear();

        if(airPlane.getCoordinate().getZ() == 0) { // if airplane are on the landing trak
            if(landingGear) {
                System.out.println("The landing gear it's already out");
                exit = false;
            } else {
                System.out.println("Can't remove the landing gear because this plane are in the landing trak");
                exit = false;
            }
        } else if(airPlane.getCoordinate().getZ() >= 500) { // if the AirPlane is more than 500m
            if(landingGear) {// if the entrie from user are true
                System.out.println("If take out the landing gear at this height, the AirPlane gonna crash... Are you sure (true/false)? ");

                while(!keyboard.hasNextBoolean()) {
                    keyboard.nextLine();

                    System.out.println("Incorrect value, try again.");
                    System.out.println("If take out the landing gear at this height, the AirPlane gonna crash... Are you sure (true/false)? ");
                }
                if(keyboard.nextBoolean()) { // if the confirm from user are true
                    System.out.println("The AirPlane crashed... that was a bad idea.");
                    AirController.deleteAirPlane(airPlane); //delete AirPlane because got crashed
                    exit = true; // dont show the menu again, cause we don't have the plane
                }
            } else {
                System.out.println("The landing gear is already removed");
                exit = false;
            }
        } else if(airPlane.getVelocity() >= 300 && airPlane.getCoordinate().getZ() < 500) {

            System.out.println("If take out the landing gear at this speed, the AirPlane gonna crash... Are you sure (true/false)? ");

            while(!keyboard.hasNextBoolean()) {
                keyboard.nextLine();

                System.out.println("Incorrect value, try again.");
                System.out.println("If take out the landing gear at this speed, the AirPlane gonna crash... Are you sure (true/false)? ");
            }
            if(keyboard.nextBoolean()) { // if the confirm from user are true
                System.out.println("The AirPlane crashed... that was a bad idea.");
                AirController.deleteAirPlane(airPlane); //delete AirPlane because got crashed
                exit = true; // dont show the menu again, cause we don't have the plane
            }
        } else {
            if(landingGear) {
                deployLandingGear(airPlane);
            } else {
                removeLandingGear(airPlane);
            }
        }
    }

    public static void deployLandingGear(AirPlane airPlane) {
        System.out.println("Deploying landing gear...");
        airPlane.setUndercarriage(true);
        System.out.println("Done");
    }

    public static void removeLandingGear(AirPlane airPlane) {
        System.out.println("Removing landing gear...");
        airPlane.setUndercarriage(false);
        System.out.println("Done");
    }

    public static boolean askForLandingGear(){
        System.out.println("Take out landing gear (true) or hide it (false)? ");

        while(!keyboard.hasNextBoolean()) {
            keyboard.nextLine();

            System.out.println("Incorrect value, try again.");
            System.out.println("Take out landing gear (true) or hide it (false)? ");
        }

        return keyboard.nextBoolean();
    }

    public static void speed(AirPlane airPlane) {
        if(airPlane.getCoordinate().getZ() == 0) { // if airplane are on the landing trak
            if(airPlane.getMotor()) { // if the motor it's ON
                int kmH = airPlane.getVelocity();
                boolean possibleCrash = true;

                while(possibleCrash) {
                    kmH = askForKmH(airPlane);
                    possibleCrash = controllVelocity(kmH, airPlane);
                }
            } else {
                System.out.println("To accelerate, you need to turn ON the motor");
                exit = false;
            }
        } else { // if airplane are on air
            int kmH = airPlane.getVelocity();
            if(airPlane.getVelocity() <= 300){ // if velocity less or same than 300
                if(airPlane.getUndercarriage()) {
                    boolean possibleCrash = true;
                    while(possibleCrash) { // loop for control the possibles crashes
                        kmH = askForKmH(airPlane); // ask for km/h
                        possibleCrash = controllVelocity(kmH, airPlane); // control the entrie from user
                    }
                } else {
                    kmH = askForKmH(airPlane); // ask for km/h
                    airPlane.setVelocity(kmH);
                    exit = false; // for dont exit from loop MenuManage
                }
            } else {
                kmH = askForKmH(airPlane);
                airPlane.setVelocity(kmH);
                exit = false; // for dont exit from loop MenuManage
            }
        }
    }

    public static int askForKmH(AirPlane airPlane){
        int kmH;

        System.out.print("How many Km/h you want? ");

        while(!keyboard.hasNextInt()) {
        keyboard.nextLine();

            System.out.println("Incorrect value, you have to enter an enter number, try again.");
            System.out.println("How many Km/h you want? ");

        }
        kmH = keyboard.nextInt();

        return kmH;
    }

    public static boolean controllVelocity(int kmH, AirPlane airPlane) {
        boolean possibleCrash = true;
        if(kmH >= 300 && airPlane.getUndercarriage()) { // if user entrie bigger than 300 and if the landing gear it's out
            System.out.println("The undercarriage is out, if you put more than 300Km/h the AirPlane gonna crash, are you sure to put more than 300Km/h (true/false)?");

            while(!keyboard.hasNextBoolean()) {
                keyboard.nextLine();

                System.out.println("Incorrect value, try again.");
                System.out.println("The undercarriage is true, if you put more than 300Km/h the AirPlane gonna crash, are you sure to put more than 300Km/h (true/false)?");
            }
            if(keyboard.nextBoolean()) { // if the confirm from user are true
                System.out.println("The AirPlane crashed... that was a bad idea.");
                AirController.deleteAirPlane(airPlane); //delete AirPlane because got crashed
                possibleCrash = false; // finish the loop control
                exit = true; // dont show the menu again, cause we don't have the plane
            }
        } else {
            airPlane.setVelocity(kmH);
            possibleCrash = false; // finish the loop control
        }

        return possibleCrash;
    }

    public static void TurnONMotor(AirPlane airPlane) {

        if(airPlane.getCoordinate().getZ() > 0 && airPlane.getMotor() == true) {// check if airplane are or not in the landing track
            System.out.println("The motor is already ON.");
            exit = false; // for dont exit from loop MenuManage
        } else {
            System.out.println("Turning ON...");
            airPlane.setMotor(true);
            System.out.println("Ready");
            exit = false; // for dont exit from loop MenuManage
        }
    }

    public static void TurnOFFMotor(AirPlane airPlane) {
        Scanner keyboard = new Scanner(System.in);
        if(airPlane.getCoordinate().getZ() > 0) { // check if airplane are or not in the landing track
            System.out.println("The AirPlane is on air, are you sure(true/false)?");
            while(keyboard.hasNextBoolean() == false) {
                keyboard.nextLine();
                System.out.println("Incorrect value, try again.");
                System.out.println("The AirPlane is on air, are you sure(true/false)?");
            }
            if(keyboard.nextBoolean()) {// if user decide turn OFF the motor when the airplane is on air, it obviously crashes
                System.out.println("The AirPlane fall down and get crashed... that was a bad idea.");
                AirController.deleteAirPlane(airPlane); // remove the airplane
                exit = true;// for exit from loop MenuManage, because we already have not the AirPlane
            }
        } else {
            if(airPlane.getMotor()) {
                System.out.println("Turning OFF...");
                airPlane.setMotor(false);
                airPlane.setVelocity(0);
                System.out.println("Ready");
                exit = false; // for dont exit from loop MenuManage
            } else {
                System.out.println("The motor is already OFF.");
                exit = false; // for dont exit from loop MenuManage
            }

        }
    }

    @Override
    public String toString() {
        return "AirPlane: " +
                "brand = " + brand +
                ", model = " + model +
                ", licensePlate = " + licensePlate +
                ", origin = " + origin +
                ", destination = " + destination +
                ", passengerCapacity = " + passengerCapacity +
                ", crew = " + crew +
                ", velocity = " + velocity +
                ", route = " + route +
                ", undercarriage = " + undercarriage +
                ", motor = " + motor;
    }
}
