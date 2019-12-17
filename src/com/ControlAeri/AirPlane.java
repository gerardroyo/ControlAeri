package com.ControlAeri;

public class AirPlane {
    private String brand;
    private String model;
    private String licensePlate;
    private String origin = "BCN";
    private String destination;
    private int passengerCapacity;
    private int crew;
    private float velocity = 0;
    private float route;
    private boolean undercarriage = true;
    private boolean motor = false;
    private boolean track = true;
    private Coordinate coordinate;

    public AirPlane(String brand, String model, String licensePlate, String destination, int passengerCapacity, int crew) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.destination = destination;
        this.crew = crew;
        this.coordinate = new Coordinate(100, 100, 0);
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getLicensePlate() { return licensePlate; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getOrigin() { return origin; }

    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public int getPassengerCapacity() { return passengerCapacity; }

    public void setPassengerCapacity(int passengerCapacity) { this.passengerCapacity = passengerCapacity; }

    public int getCrew() { return crew; }

    public void setCrew(int crew) { this.crew = crew; }

    public float getVelocity() { return velocity; }

    public void setVelocity(float velocity) { this.velocity = velocity; }

    public float getRoute() { return route; }

    public void setRoute(float route) { this.route = route; }

    public boolean getUndercarriage() { return undercarriage; }

    public void setUndercarriage(boolean undercarriage) { this.undercarriage = undercarriage; }

    public Coordinate getCoordinate() { return coordinate; }

    public void setCoordinate(Coordinate coordinate) { this.coordinate = coordinate; }

    public boolean getMotor() { return motor; }

    public void setMotor(boolean motor) { this.motor = motor; }

    public boolean getTrack() { return track; }

    public void setTrack(boolean track) { this.track = track; }

    /*public boolean canviarMoviment() {

    }*/

    /*public boolean apagarMotor() {

    }*/

    public void acelerarMotor() {

    }

    @Override
    public String toString() {
        return "AirPlane: " +
                "brand = " + brand +
                ", model = " + model +
                ", licensePlate = " + licensePlate +
                ", origin = " + origin +
                ", destination = " + destination +
                ", passengerCapacity = " + passengerCapacity +
                ", crew = " + crew +
                ", velocity = " + velocity +
                ", route = " + route +
                ", undercarriage = " + undercarriage +
                ", motor = " + motor;
    }
}
