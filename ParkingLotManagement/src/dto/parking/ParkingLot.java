package dto.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the parking lot containing multiple floors.
 */
public class ParkingLot {
    private final List<ParkingFloor> parkingFloors = new ArrayList<>();

    /**
     * Adds a new floor to the parking lot.
     * @throws IllegalArgumentException if counts are invalid
     */
    public void addFloor(int parkingSpotCount, int bikeSpotCount, int carSpotCount, int truckSpotCount) {
        if (parkingSpotCount < 0 || bikeSpotCount < 0 || carSpotCount < 0 || truckSpotCount < 0) {
            throw new IllegalArgumentException("Spot counts must be non-negative.");
        }
        if (parkingSpotCount != (bikeSpotCount + carSpotCount + truckSpotCount)) {
            throw new IllegalArgumentException("Total spot count must equal sum of all spot types.");
        }
        ParkingFloor floor = new ParkingFloor(parkingSpotCount, bikeSpotCount, carSpotCount, truckSpotCount);
        parkingFloors.add(floor);
    }

    public List<ParkingFloor> getParkingFloors() {
        return new ArrayList<>(parkingFloors);
    }
}