package com.ControlAeri;

public class CommercialAirPlane extends AirPlane {

    private boolean Adapted = true;

    public CommercialAirPlane(String brand, String model, String licensePlate, String destination, int passengerCapacity, int crew) {
        super(brand, model, licensePlate, destination, passengerCapacity, crew);
    }

    @Override
    public String toString() {
        return "(Comercial)" + super.toString() + "Adapted=" + Adapted;
    }
}
