package com.ControlAeri;

public class Main {

    public static void main(String[] args) {
        int option;
        boolean exit = false;

        while(exit == false) {
            option = Menu.menuControl(); //ask to the user some option from 1st menu

            exit = switchMenuControl(option, exit); //backend from 1st menu | option = option that user selected | exit = boolean if user wanna exit from the Air Controller
        }
    }

    public static boolean switchMenuControl(int option, boolean exit) {

        AirPlane airPlaneToManipulate;

        switch(option) {
            case 1: // if option is that the user want's add some airplene
                int concretAirPlane = Menu.menuConcretAirPlane();// 1st ask which type of air plane want create | concretAirPlane = which type of airplain, comercial or battle
                if(!AirController.somePlaneInTrack()) { //controll if some airplane are in the landing track
                    AirController.addAirPlane(concretAirPlane); //adding air plane | concretAirPlane = which type of airplain, comercial or battle
                } else {
                    System.out.println("Can't create a new AirPlane, because there are someone using the landing track");
                }
                break;
            case 2: // if option is that the user want's controll an specific air plane
                int optionManage = 1;
                //boolean exit = false;

                if(!AirController.controlManager()){ //check if there is already a plane created
                    airPlaneToManipulate = AirController.askForAirPlane();// ask to user which air plane wanna controll | airPlaneToManipulate = the airplane specific that user wanna controll
                    while(optionManage != 0) {
                        AirPlane.showStats(airPlaneToManipulate);
                        if(airPlaneToManipulate.getAirPlaneType() == 1) {
                            optionManage = Menu.menuManageCommercial();//ask to the user some option from MenuManage | optionManage = option that user selected
                        } else {
                            optionManage = Menu.menuManageBattle();//ask to the user some option from MenuManage | optionManage = option that user selected
                        }

                        if(AirPlane.optionSelected(optionManage, airPlaneToManipulate)) {// backend of MenuManage | optionManage = option that user selected | airPlaneToManipulate = airplane selected
                            optionManage = 0;
                        }
                    }
                } else {
                    System.out.println("There aren't AirPlanes created.");

                }

                break;
            case 3:
                AirController.showAirSpace(); //show all airplanes and all their stats in the area that the air controller can catch
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
