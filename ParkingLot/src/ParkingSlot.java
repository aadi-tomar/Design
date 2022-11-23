import Model.ParkingSlotType;
import Model.Vehicle;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParkingSlot {


    String name;
    boolean isAvailable = true;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;

    public ParkingSlot( String name, ParkingSlotType parkingSlotType){
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    public void addVehicle( Vehicle vehicle){
        this.vehicle = vehicle;
        isAvailable = false;
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicle = null;
        isAvailable = true;
    }
}
