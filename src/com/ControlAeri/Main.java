package com.ControlAeri;

public class Main {

    public static void main(String[] args) {
        int option;
        boolean exit = false;

        while(exit == false) {
            option = Menu.menuControl();

            exit = switchMenuControl(option, exit);
        }
    }

    public static boolean switchMenuControl(int option, boolean exit) {
        switch(option) {
            case 1:
                int concretAirPlane = Menu.menuConcretAirPlane();
                if(!AirController.somePlaneInTrack()) {
                    AirController.addAirPlane(concretAirPlane);
                } else {
                    System.out.println("Can't create a new AirPlane, because there are someone using the landing track");
                }
                break;
            case 2:
                //manageAirPlane();
                break;
            case 3:
                AirController.showAirSpace();
                break;
            case 4:
                //EncryptBattAirPlane();
                break;
            case 5:
                //DecryptBattAirPlane();
                break;
            case 0:
                exit = true;
                break;
        }

        return exit;
    }

}
