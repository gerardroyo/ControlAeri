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
                AirController.addAirPlane();
                break;
            case 2:
                //manageAirPlane();
                break;
            case 3:
                AirController.showAirSpace();
                break;
            case 4:
                //EncryptBAP();
                break;
            case 5:
                //DecryptBAP();
                break;
            case 0:
                exit = true;
                break;
        }

        return exit;
    }

}
