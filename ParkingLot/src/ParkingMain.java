import Model.Address;
import Model.ParkingSlotType;
import Model.Vehicle;
import Model.VehicleCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingMain {


    public static void main(String[] args) throws InterruptedException {
        String nameofParkingLot = "Tomar's Parking Lot";
        Address address = Address.builder().city("Ghaziabad").country("india").state("UP").build();

        Map<ParkingSlotType , Map< String , ParkingSlot> > allSlots = new HashMap<>();

        Map< String, ParkingSlot> compactSlots = new HashMap<>();
        compactSlots.put("C1" , new ParkingSlot("C1", ParkingSlotType.Compact));
        compactSlots.put("C2" , new ParkingSlot("C2", ParkingSlotType.Compact));
        compactSlots.put("C3" , new ParkingSlot("C3", ParkingSlotType.Compact));
        allSlots.put(ParkingSlotType.Compact, compactSlots);

        Map< String , ParkingSlot> largeSlots = new HashMap<>();
        largeSlots.put("L1" , new ParkingSlot("L1" , ParkingSlotType.Large));
        largeSlots.put("L2" , new ParkingSlot("L2" , ParkingSlotType.Large));
        largeSlots.put("L3" , new ParkingSlot("L3" , ParkingSlotType.Large));
        allSlots.put(ParkingSlotType.Large, largeSlots);
        //System.out.println(allSlots.size());

        ParkingFloor parkingFloor = new ParkingFloor( "1" , allSlots);
        List< ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(parkingFloor);

        ParkingLot parkingLot =  ParkingLot.getInstance(nameofParkingLot, address, parkingFloorList);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("67-354-34");
        vehicle.setVehicleCategory(VehicleCategory.HatchBack);

        Ticket ticket = parkingLot.assignTicket(vehicle);
        System.out.println("ticket  number is " + ticket.getTicketNumber());

        Thread.sleep(10000);
        double price = parkingLot.scanAndPay(ticket);
        System.out.println("You've to pay Rs." + price);


    }
}
