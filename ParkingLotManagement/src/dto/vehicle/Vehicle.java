package dto.vehicle;

public abstract class Vehicle {
    private final String licenseNumber;
    private final enums.Vehicle type;

    public Vehicle(String vehicleLicenseNumber, enums.Vehicle vehicleType){
        this.licenseNumber = vehicleLicenseNumber;
        this.type = vehicleType;
    }

    public enums.Vehicle getType(){
        return type;
    };

    public String getLicense(){
        return licenseNumber;
    }
}
