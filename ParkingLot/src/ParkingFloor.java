import Model.ParkingSlotType;
import Model.Vehicle;
import Model.VehicleCategory;

import java.util.Map;

public class ParkingFloor {

    String name;
    Map <ParkingSlotType , Map< String, ParkingSlot >> parkingSlots;


    public ParkingFloor ( String name, Map < ParkingSlotType , Map< String, ParkingSlot> >  parkingSlots ){
        this.name = name;
        this.parkingSlots = parkingSlots;

    }

    public ParkingSlot getRelevantSlotAndPark( Vehicle vehicle){
        ParkingSlot slot = null;
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickAvailableSlot(vehicleCategory);
        //System.out.println(vehicleCategory + " " + parkingSlotType);
        Map< String , ParkingSlot> relevantSlots = parkingSlots.get( parkingSlotType);
        //System.out.println(relevantSlots.size());
        for(Map.Entry<String, ParkingSlot> m : relevantSlots.entrySet()){
            //System.out.println("1");
            if(m.getValue().isAvailable == true){
                //System.out.println("2");
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }
        //System.out.println(slot);
        return slot;

    }

    private ParkingSlotType pickAvailableSlot( VehicleCategory vehicleCategory){
        if(vehicleCategory.equals(VehicleCategory.TwoWheeler))
            return ParkingSlotType.TwoWheeler;
        else if( vehicleCategory.equals(VehicleCategory.HatchBack) || vehicleCategory.equals(VehicleCategory.Sedan))
            return ParkingSlotType.Compact;
        else if( vehicleCategory.equals(VehicleCategory.Suv))
            return ParkingSlotType.Medium;
        else
            return ParkingSlotType.Large;
    }
}
