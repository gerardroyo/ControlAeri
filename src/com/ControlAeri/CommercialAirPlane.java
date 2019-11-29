package com.ControlAeri;

public class CommercialAirPlane extends AirPlane {

    private boolean Adapted;

    public CommercialAirPlane(String brand, String model, String licensePlate, String origin, String destination, int passengerCapacity, int crew, float autonomy, float route, boolean undercarriage, int x, int y, int z, boolean adapted) {
        super(brand, model, licensePlate, origin, destination, passengerCapacity, crew, autonomy, route, undercarriage, x, y, z);
        this.Adapted = adapted;
    }
}
