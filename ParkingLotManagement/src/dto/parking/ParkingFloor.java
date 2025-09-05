package dto.parking;

import dto.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a parking floor with multiple parking spots.
 */
public class ParkingFloor {

    private final int spotCount;
    private final Map<Vehicle, ParkingSpot> parkingSpotMap = new HashMap<>();
    private final List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingFloor(int parkingSpotCount, int bikeSpotCount, int carSpotCount, int truckSpotCount) {
        int i = 1;
        this.spotCount = parkingSpotCount;
        while (bikeSpotCount > 0) {
            parkingSpots.add(new ParkingSpot(i++, enums.Vehicle.Bike));
            bikeSpotCount--;
        }
        while (carSpotCount > 0) {
            parkingSpots.add(new ParkingSpot(i++, enums.Vehicle.Car));
            carSpotCount--;
        }
        while (truckSpotCount > 0) {
            parkingSpots.add(new ParkingSpot(i++, enums.Vehicle.Truck));
            truckSpotCount--;
        }
    }

    /**
     * Checks if the vehicle is already parked on this floor.
     */
    public boolean isVehicleParked(Vehicle vehicle) {
        return parkingSpotMap.containsKey(vehicle);
    }

    /**
     * Checks if a free spot is available for the given vehicle.
     */
    public boolean isFreeSpotAvailable(Vehicle vehicle) {
        return parkingSpots.stream()
                .anyMatch(spot -> spot.isAvailable() && spot.supportsParking(vehicle));
    }

    /**
     * Finds a free spot for the given vehicle.
     * @throws IllegalStateException if no spot is available
     */
    public Optional<ParkingSpot> findFreeSpot(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.supportsParking(vehicle))
                .findFirst();
    }

    /**
     * Parks the vehicle if a spot is available.
     * @throws IllegalStateException if no spot is available or vehicle is already parked
     */
    public void parkVehicle(Vehicle vehicle) {
        if (isVehicleParked(vehicle)) {
            throw new IllegalStateException("Vehicle is already parked on this floor.");
        }
        Optional<ParkingSpot> spotOpt = findFreeSpot(vehicle);
        if (spotOpt.isEmpty()) {
            throw new IllegalStateException("No free spot available for this vehicle type.");
        }
        ParkingSpot spot = spotOpt.get();
        if (spot.parkVehicle(vehicle)) {
            parkingSpotMap.put(vehicle, spot);
        } else {
            throw new IllegalStateException("Failed to park vehicle due to spot error.");
        }
    }

    /**
     * Unparks the vehicle if it is parked.
     * @throws IllegalStateException if the vehicle is not parked
     */
    public void unparkVehicle(Vehicle vehicle) {
        if (!isVehicleParked(vehicle)) {
            throw new IllegalStateException("Vehicle is not parked on this floor.");
        }
        ParkingSpot spot = parkingSpotMap.get(vehicle);
        if (spot.unparkVehicle(vehicle)) {
            parkingSpotMap.remove(vehicle);
        } else {
            throw new IllegalStateException("Failed to unpark vehicle due to spot error.");
        }
    }

    /**
     * Returns the number of occupied and free spots.
     */
    public String getFloorData() {
        int spotsOccupiedCount = parkingSpotMap.size();
        return String.format("Parking Floor has %d total spots, %d occupied, %d free.",
                spotCount, spotsOccupiedCount, spotCount - spotsOccupiedCount);
    }
}