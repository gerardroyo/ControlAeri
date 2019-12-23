package com.ControlAeri;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirController {

    private static ArrayList<AirPlane> OnAirPlane = new ArrayList<AirPlane>();
    private static Scanner keyboard = new Scanner(System.in);

    public static void addAirPlane(int concretAirPlane) throws UnsupportedEncodingException { //add the airplane

        int type;

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


            type = 1;


            if(concretAirPlane == 1) {

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

                String origin = "BCN";
                if(encrypted) {

                    brand = Encrypt.Encrypt(brand);
                    model = Encrypt.Encrypt(model);
                    origin = Encrypt.Encrypt(origin);
                    destination = Encrypt.Encrypt(destination);
                }

                OnAirPlane.add(new CommercialAirPlane(brand, model, licensePlate, destination, passengerCapacity, crew, type, origin, enemy, encrypted));
            } else {
                String origin = "BCN";
                type = 2;
//-------------------------------------------------------------------------------------------------------------------------------------\\
                System.out.print("Max Range Shot: ");
                int maxRangeShot;

                while(keyboard.hasNextInt() == false) {
                    keyboard.nextLine();

                    System.out.print("Incorrect Data, try again. Max Range Shot: ");
                }

                maxRangeShot = keyboard.nextInt();

                OnAirPlane.add(new BattleAirPlane(brand, model, licensePlate, destination, passengerCapacity, crew, type, maxRangeShot, origin));// adding the user entries to the new object/airPlane in to the arraylist
            }
        } else {
            System.out.println("You have created the max Air Planes that the Air Controller can control at the same time.");
        }

    }

    public static void decrypt(AirPlane airPlane1) throws UnsupportedEncodingException {
        for(AirPlane a:OnAirPlane) {
            if(airPlane1.getLicensePlate().equals(a.getLicensePlate())) {
                if(a instanceof CommercialAirPlane) {
                    CommercialAirPlane airPlane = (CommercialAirPlane) a;
                    if(airPlane.getEncrypted()) {
                        a.setBrand(Encrypt.Decrypt(a.getBrand()));
                        a.setModel(Encrypt.Decrypt(a.getModel()));
                        a.setOrigin(Encrypt.Decrypt(a.getOrigin()));
                        a.setDestination(Encrypt.Decrypt(a.getDestination()));
                        ((CommercialAirPlane) a).setEncrypted(false);
                    }
                }
            }
        }
        System.out.println("Decrypting...");
        System.out.println("Done.");
    }

    public static void encrypt(AirPlane airPlane1) throws UnsupportedEncodingException {
        for(AirPlane a:OnAirPlane) {
            if(airPlane1.getLicensePlate().equals(a.getLicensePlate())) {
                if(a instanceof CommercialAirPlane) {
                    CommercialAirPlane airPlane = (CommercialAirPlane) a;
                    if(airPlane.getEncrypted()) {
                        a.setBrand(Encrypt.Encrypt(a.getBrand()));
                        a.setModel(Encrypt.Encrypt(a.getModel()));
                        a.setOrigin(Encrypt.Encrypt(a.getOrigin()));
                        a.setDestination(Encrypt.Encrypt(a.getDestination()));
                        ((CommercialAirPlane) a).setEncrypted(true);
                    }
                }
            }
        }
        System.out.println("Encrypting...");
        System.out.println("Done.");
    }

    public static void enemyControl(AirPlane airPlane) {
        BattleAirPlane airPlaneBattle = (BattleAirPlane) airPlane;
        int posXshoot = airPlaneBattle.getCoordinate().getX() + airPlaneBattle.getMaxRangeShot();
        int posX_shoot = airPlaneBattle.getCoordinate().getX() - 100;

        int posYshoot = airPlaneBattle.getCoordinate().getY() + 100;
        int posY_shoot = airPlaneBattle.getCoordinate().getY() - 100;

        boolean enemyFounded = false;

        System.out.print("AirPlane(" + airPlaneBattle.getLicensePlate() + ") Enemy detected: ");

        for(AirPlane a:OnAirPlane) {
            if(a instanceof CommercialAirPlane) {
                CommercialAirPlane b = (CommercialAirPlane) a;
                if((b.getCoordinate().getY() <= posYshoot && b.getCoordinate().getY() >= posY_shoot) && (b.getCoordinate().getX() == airPlaneBattle.getCoordinate().getX())) {
                    if(b.getEnemy() == true) {
                        enemyFounded = true;
                        AirPlane.showWarning(b);
                    }
                } else if((a.getCoordinate().getX() <= posXshoot && a.getCoordinate().getX() >= posX_shoot) && (a.getCoordinate().getY() == airPlaneBattle.getCoordinate().getY())) {
                    if(b.getEnemy() == true) {
                        enemyFounded = true;
                        AirPlane.showWarning(b);
                    }
                } else {
                    System.out.println("No enemies founded");
                }
            }
        }
        System.out.println("");
        if(airPlaneBattle.getNumMissiles() == 0) {
            System.out.println("Have 0 missiles, cant shoot");
        } else {
            if(enemyFounded) {
                String enemyLicensePlante;
                System.out.print("Wich enemy want's to shoot? ");
                enemyLicensePlante = keyboard.next();
                boolean eliminated = false;

                for(AirPlane a:OnAirPlane) {
                    if(a instanceof CommercialAirPlane) {
                        CommercialAirPlane b = (CommercialAirPlane) a;
                        if (b.getLicensePlate().equals(enemyLicensePlante)) {
                            AirController.deleteAirPlane(b); //delete AirPlane because got crashed
                            System.out.println("Enemy eliminated successfully");
                            airPlaneBattle.setNumMissiles(airPlaneBattle.getNumMissiles() - 1);
                            airPlaneBattle.getMissiles().remove(1);
                            eliminated = true;
                        }
                    }
                }
                if(!eliminated) {
                    System.out.println("Enemy not found, or incorrect entrie.");
                }

            }
        }


    }

    public static void showEnemies(AirPlane airPlane) {
        if(airPlane instanceof BattleAirPlane) {
            BattleAirPlane airPlaneBattle = (BattleAirPlane) airPlane;
            int posXshoot = airPlaneBattle.getCoordinate().getX() + airPlaneBattle.getMaxRangeShot();
            int posX_shoot = airPlaneBattle.getCoordinate().getX() - 100;

            int posYshoot = airPlaneBattle.getCoordinate().getY() + 100;
            int posY_shoot = airPlaneBattle.getCoordinate().getY() - 100;

            boolean enemyFounded = false;

            System.out.print("AirPlane(" + airPlaneBattle.getLicensePlate() + ") Enemy detected: ");

            for (AirPlane a : OnAirPlane) {
                if (a instanceof CommercialAirPlane) {
                    CommercialAirPlane b = (CommercialAirPlane) a;
                    if ((b.getCoordinate().getY() <= posYshoot && b.getCoordinate().getY() >= posY_shoot) && (b.getCoordinate().getX() == airPlaneBattle.getCoordinate().getX())) {
                        if (b.getEnemy() == true) {
                            enemyFounded = true;
                            AirPlane.showWarning(b);
                        }
                    } else if ((a.getCoordinate().getX() <= posXshoot && a.getCoordinate().getX() >= posX_shoot) && (a.getCoordinate().getY() == airPlaneBattle.getCoordinate().getY())) {
                        if (b.getEnemy() == true) {
                            enemyFounded = true;
                            AirPlane.showWarning(b);
                        }
                    }/* else {
                    System.out.println("No enemies founded");
                }*/
                }
            }
            if(!enemyFounded) {
                System.out.println("No enemies founded");
            }
        }

    }

    public static void positionControl(int posX, int posY, AirPlane airPlane) {
        boolean toFalse = true;

        if(posX >= 1000 || posY >= 1000) {
            AirPlane.crashController("The AirPlane will exit from the max range that control tower can control, are you sure? (true/false) ", airPlane);
        } else {
            for(int i = 0; i < OnAirPlane.size(); i++) {
                if(posX == OnAirPlane.get(i).getCoordinate().getX() && posY == OnAirPlane.get(i).getCoordinate().getY()) {
                    AirPlane.crashColliderController("If move to that position the AirPlane will collide versus other AirPlane, are you sure (true / false)? ", airPlane);
                    i = OnAirPlane.size();
                    toFalse = false;
                }
            }
            if(toFalse) {
                airPlane.getCoordinate().setX(posX);
                airPlane.getCoordinate().setY(posY);
            }
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

