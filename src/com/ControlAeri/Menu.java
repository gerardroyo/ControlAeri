package com.ControlAeri;

import java.util.Scanner;

public class Menu {
    private static Scanner keyboard = new Scanner(System.in);


    public static int menuControl() {

        int option;

        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                             █");
        System.out.println("█                  0.Exit                                     █");
        System.out.println("█                                                             █");
        System.out.println("█                  1.Add AirPlane                             █");
        System.out.println("█                                                             █");
        System.out.println("█                  2.Manage AirPlane                          █");
        System.out.println("█                                                             █");
        System.out.println("█                  3.Show Airspace                            █");
        System.out.println("█                                                             █");
        System.out.println("█                  4.Encrypt Battle AirPlanes                 █");
        System.out.println("█                                                             █");
        System.out.println("█                  5.Decrypt Battle AirPlanes                 █");
        System.out.println("█                                                             █");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");

        while (keyboard.hasNextInt() == false) { //controlling if user insert some value that are incorrect
            keyboard.nextLine();

            System.out.println("Incorrect Data, try again. ");
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█                                                             █");
            System.out.println("█                  0.Exit                                     █");
            System.out.println("█                                                             █");
            System.out.println("█                  1.Add AirPlane                             █");
            System.out.println("█                                                             █");
            System.out.println("█                  2.Manage AirPlane                          █");
            System.out.println("█                                                             █");
            System.out.println("█                  3.Show Airspace                            █");
            System.out.println("█                                                             █");
            System.out.println("█                  4.Encrypt Battle AirPlanes                 █");
            System.out.println("█                                                             █");
            System.out.println("█                  5.Decrypt Battle AirPlanes                 █");
            System.out.println("█                                                             █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        }

        option = keyboard.nextInt();

        return option;
    }

    public static int menuManage() {

        int option;

        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                             █");
        System.out.println("█                  0. Exit                                    █");
        System.out.println("█                                                             █");
        System.out.println("█                  1. Turn ON motor                           █");
        System.out.println("█                                                             █");
        System.out.println("█                  2. Turn OFF motor                          █");
        System.out.println("█                                                             █");
        System.out.println("█                  3. Modify Speed                            █");
        System.out.println("█                                                             █");
        System.out.println("█                  4. Climb/Go down landing gear              █");
        System.out.println("█                                                             █");
        System.out.println("█                  5. Go Up/Down                              █");
        System.out.println("█                                                             █");
        System.out.println("█                  6. Position                                █");
        System.out.println("█                                                             █");
        System.out.println("█                  7. Shoot                                   █");
        System.out.println("█                                                             █");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");


        while (keyboard.hasNextInt() == false) {
            keyboard.nextLine();

            System.out.println("Incorrect Data, try again. ");
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█                                                             █");
            System.out.println("█                  0. Exit                                    █");
            System.out.println("█                                                             █");
            System.out.println("█                  1. Turn ON motor                           █");
            System.out.println("█                                                             █");
            System.out.println("█                  2. Turn OFF motor                          █");
            System.out.println("█                                                             █");
            System.out.println("█                  3. Modify Speed                            █");
            System.out.println("█                                                             █");
            System.out.println("█                  4. Climb/Go down landing gear              █");
            System.out.println("█                                                             █");
            System.out.println("█                  5. Go Up/Down                              █");
            System.out.println("█                                                             █");
            System.out.println("█                  6. Set resource                            █");
            System.out.println("█                                                             █");
            System.out.println("█                  7. Position                                █");
            System.out.println("█                                                             █");
            System.out.println("█                  8. Shoot                                   █");
            System.out.println("█                                                             █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        }

        option = keyboard.nextInt();

        return option;
    }

    public static int menuConcretAirPlane() { //which air plane want to create

        int option;

        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                             █");
        System.out.println("█                  1.Comercial AirPlane                       █");
        System.out.println("█                                                             █");
        System.out.println("█                  2.Battle AirPlane                          █");
        System.out.println("█                                                             █");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");

        while (keyboard.hasNextInt() == false) { //controlling if user insert some value that are incorrect
            keyboard.nextLine();

            System.out.println("Incorrect Data, try again. ");
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█                                                             █");
            System.out.println("█                  1.Comercial AirPlane                       █");
            System.out.println("█                                                             █");
            System.out.println("█                  2.Battle AirPlane                          █");
            System.out.println("█                                                             █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        }

        option = keyboard.nextInt();

        return option;
    }

}
