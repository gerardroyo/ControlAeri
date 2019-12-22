package com.ControlAeri;

import java.util.ArrayList;

public class BattleAirPlane extends AirPlane {

    private static ArrayList<Missile> Missiles = new ArrayList<Missile>();
    private int MaxRangeShot;
    private  int NumMissiles = 4;

    public BattleAirPlane(String brand, String model, String licensePlate, String destination, int passengerCapacity, int MaxRangeShot, int crew, int airPlaneType) {
        super(brand, model, licensePlate, destination, passengerCapacity, crew, airPlaneType);
        this.MaxRangeShot = MaxRangeShot;
        for(int i = 0; i < NumMissiles; i++) {
            Missiles.add(new Missile(100));
        }
    }

    public ArrayList<Missile> getMissiles() { return Missiles; }

    public void setMissiles(ArrayList<Missile> missiles) { Missiles = missiles; }

    public int getMaxRangeShot() { return MaxRangeShot; }

    public void setMaxRangeShot(int maxRangeShot) { MaxRangeShot = maxRangeShot; }

    public  int getNumMissiles() { return NumMissiles; }

    public  void setNumMissiles(int numMissiles) {
        NumMissiles = numMissiles;
    }

    @Override
    public String toString() {
        return "(Battle) " + super.toString() +
                ", Missiles = " + NumMissiles +
                ", MaxRangeShot = " + MaxRangeShot + ".";
    }
}
