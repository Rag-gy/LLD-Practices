package dto.parking;

import dto.vehicle.Vehicle;

/**
 * Represents a single parking spot.
 */
public class ParkingSpot {
    private final int spotId;
    private final enums.Vehicle spotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, enums.Vehicle spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean supportsParking(Vehicle vehicle) {
        return vehicle.getType() == spotType;
    }

    /**
     * Parks the vehicle if the spot is available and supports the vehicle type.
     * @return true if parked, false otherwise
     */
    public boolean parkVehicle(Vehicle vehicle) {
        if (!isAvailable() || !supportsParking(vehicle)) {
            return false;
        }
        this.parkedVehicle = vehicle;
        return true;
    }

    /**
     * Unparks the vehicle if it matches the parked vehicle.
     * @return true if unparked, false otherwise
     */
    public boolean unparkVehicle(Vehicle vehicle) {
        if (parkedVehicle != null && parkedVehicle.equals(vehicle)) {
            parkedVehicle = null;
            return true;
        }
        return false;
    }

    public int getSpotId() {
        return spotId;
    }

    public enums.Vehicle getSpotType() {
        return spotType;
    }
}