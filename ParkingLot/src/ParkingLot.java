import Model.Address;
import Model.ParkingSlotType;
import Model.Vehicle;

import java.util.List;
import java.util.Map;

public class ParkingLot {


    private String name;
    private Address address;
    private List< ParkingFloor> parkingFloorList;
    private static ParkingLot parkingLot  = null ;

    private ParkingLot(String name, Address address, List< ParkingFloor>  parkingFloorList){
        this.name = name;
        this.address = address;
        this.parkingFloorList = parkingFloorList;
    }

    public static ParkingLot getInstance ( String name, Address address, List < ParkingFloor > parkingFloorList){
        if(parkingLot == null){
            parkingLot = new ParkingLot(name, address, parkingFloorList);
        }
        return parkingLot;
    }

    public void addFloors(String name, Map <ParkingSlotType , Map< String, ParkingSlot >> parkingSlots){
        ParkingFloor parkingFloor = new ParkingFloor(name, parkingSlots);
        parkingFloorList.add(parkingFloor);
    }

    public void removeFloors(ParkingFloor parkingFloor){
        parkingFloorList.remove(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle){

        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        //System.out.println(parkingSlot);
        if( parkingSlot == null)
            return null;
        Ticket parkingTicket = createTicketForSlot(parkingSlot , vehicle);
        return parkingTicket;


    }

    public double scanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());

        int duration = (int )(endTime - ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        return price;
    }

    private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        for( ParkingFloor parkingFloor : parkingFloorList){
            //System.out.println(parkingFloor);
            parkingSlot = parkingFloor.getRelevantSlotAndPark(vehicle);
            if(parkingSlot != null)
                break;
        }
        return  parkingSlot;
    }

}
