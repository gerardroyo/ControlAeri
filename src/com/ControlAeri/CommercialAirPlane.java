package com.ControlAeri;

public class CommercialAirPlane extends AirPlane {

    private boolean Adapted = true;
    private boolean enemy;
    private boolean encrypted;

    public CommercialAirPlane(String brand, String model, String licensePlate, String destination, int passengerCapacity, int crew, int airPlaneType, boolean enemy, boolean encrypted) {
        super(brand, model, licensePlate, destination, passengerCapacity, crew, airPlaneType);
        this.enemy = enemy;
        this.encrypted = encrypted;
    }

    public boolean isAdapted() { return Adapted; }

    public void setAdapted(boolean adapted) { Adapted = adapted; }

    public boolean getEnemy() { return enemy; }

    public void setEnemy(boolean enemy) { this.enemy = enemy; }

    public boolean getEncrypted() { return encrypted; }

    public void setEncrypted(boolean encrypted) { this.encrypted = encrypted; }

    @Override
    public String toString() {
        return "(Comercial) " + super.toString() + ", Adapted = " + Adapted + ", Enemy = " + enemy + ", Encrypted = " + encrypted + ".";
    }
}
