package com.ControlAeri;

public class AirPlane {
    private String brand;
    private String model;
    private String licensePlate;
    private String origin;
    private String destination;
    private int passengerCapacity;
    private int crew;
    private float velocity;
    private float autonomy;
    private float route;
    private boolean undercarriage;
    private Coordinate coordinate;

    public AirPlane(String brand, String model, String licensePlate, String origin, String destination, int passengerCapacity, int crew, float autonomy, float route, boolean undercarriage, int x, int y, int z) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.origin = origin;
        this.destination = destination;
        this.passengerCapacity = passengerCapacity;
        this.crew = crew;
        this.velocity = 0;
        this.autonomy = autonomy;
        this.route = route;
        this.undercarriage = true;
        this.coordinate = new Coordinate(100, y, z);
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

    public float getAutonomy() { return autonomy; }

    public void setAutonomy(float autonomy) { this.autonomy = autonomy; }

    public float getRoute() { return route; }

    public void setRoute(float route) { this.route = route; }

    public boolean isUndercarriage() { return undercarriage; }

    public void setUndercarriage(boolean undercarriage) { this.undercarriage = undercarriage; }

    public Coordinate getCoordinate() { return coordinate; }

    public void setCoordinate(Coordinate coordinate) { this.coordinate = coordinate; }

    /*public boolean canviarMoviment() {

    }*/

    /*public boolean apagarMotor() {

    }*/

    public void acelerarMotor() {

    }

}
