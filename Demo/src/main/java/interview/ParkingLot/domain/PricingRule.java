package interview.ParkingLot.domain;

import java.util.UUID;

public class PricingRule {
    private UUID id;
    private VehicleType vehicleType;
    private double pricePerHour;
    private double flatRate;

    public PricingRule(VehicleType vehicleType, double pricePerHour, double flatRate) {
        this.id = UUID.randomUUID();
        this.vehicleType = vehicleType;
        this.pricePerHour = pricePerHour;
        this.flatRate = flatRate;
    }

    public UUID getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public double getFlatRate() {
        return flatRate;
    }

    public void setHourlyRate(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setFlatRate(double flatRate) {
        this.flatRate = flatRate;
    }

}
