package com.ControlAeri;

import java.util.ArrayList;

public class BattleAirPlane extends AirPlane {

    private static ArrayList<Missile> Missiles = new ArrayList<Missile>();
    private float MaxRangeShot;
    private boolean Enemy;
    private boolean Encrypted;
    private static int numMissiles = 4;

    public BattleAirPlane(String brand, String model, String licensePlate, String destination, int passengerCapacity, int crew, float maxRangeShot, boolean enemy, boolean encrypted) {
        super(brand, model, licensePlate, destination, passengerCapacity, crew );
        this.MaxRangeShot = maxRangeShot;
        this.Enemy = enemy;
        this.Encrypted = encrypted;
        addMissiles();
    }

    public ArrayList<Missile> getMissiles() { return Missiles; }

    public void setMissiles(ArrayList<Missile> missiles) { Missiles = missiles; }

    public float getMaxRangeShot() { return MaxRangeShot; }

    public void setMaxRangeShot(float maxRangeShot) { MaxRangeShot = maxRangeShot; }

    public boolean isEnemy() { return Enemy; }

    public void setEnemy(boolean enemy) { Enemy = enemy; }

    public boolean isEncrypted() { return Encrypted; }

    public void setEncrypted(boolean encrypted) { Encrypted = encrypted; }

    private static void addMissiles() {
        for(int i = 0; i < numMissiles; i++) {
            Missiles.add(new Missile(100));
        }
    }

    @Override
    public String toString() {
        return "(Battle) " + super.toString() +
                ", Missiles = " + numMissiles +
                ", MaxRangeShot = " + MaxRangeShot +
                ", Enemy = " + Enemy +
                ", Encrypted = " + Encrypted + ".";
    }
}
