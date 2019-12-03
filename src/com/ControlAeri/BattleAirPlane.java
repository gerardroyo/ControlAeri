package com.ControlAeri;

import java.util.ArrayList;

public class BattleAirPlane extends AirPlane {

    private ArrayList<Missile> Missiles = new ArrayList<Missile>();
    private float MaxRangeShot;
    private boolean Enemy;
    private boolean Encrypted;

    public BattleAirPlane(String brand, String model, String licensePlate, String origin, String destination, int passengerCapacity, int crew, float autonomy, float route, boolean undercarriage, int x, int y, int z, float maxRangeShot, boolean enemy, boolean encrypted) {
        super(brand, model, licensePlate/*, origin, destination*/, passengerCapacity/*, crew, autonomy, route, undercarriage, x, y, z*/);
        this.MaxRangeShot = maxRangeShot;
        this.Enemy = enemy;
        this.Encrypted = encrypted;
    }
}
