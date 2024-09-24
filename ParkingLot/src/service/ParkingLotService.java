package service;
import java.util.*;
import entity.*;
import repository.*;

public class ParkingLotService {
	HashMap<String, Vehicle> vehicleHashMap;
	ParkingLot parkingLot;
	ParkingDataRepository parkingDataRepository;
	
	public void createParkingLot(ParkingLot parkingLot) {
		vehicleHashMap = new HashMap<>();
		this.parkingLot = parkingLot;
		parkingDataRepository = new ParkingDataRepository();
		this.parkingLot.setParkingFloors(
				parkingDataRepository.initializeData(parkingLot.getNoOfFloors(), parkingLot.getNoOfSlotsPerFloors())
		);
	}
	
	public void parkVehicle(VehicleType vehicleType, String vehicleRegistrationNo, String color) {
		ParkingSlot parkingSlot = getFirstAvailableSlot(vehicleType);
		if(parkingSlot == null) {
			System.out.println("Parking id Full");
		}else {
			parkingSlot.setFree(false);
			Vehicle vehicle = new Vehicle(vehicleType, parkingSlot, color, vehicleRegistrationNo);
			String ticket = generateTicket(parkingSlot);
			vehicle.setTicketId(ticket);
			vehicleHashMap.put(ticket, vehicle);
			System.out.println("Parked vehicle. Ticket Id: " + ticket);
		}
	}
	
	public ParkingSlot getFirstAvailableSlot(VehicleType vehicleType) {
		List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
		for(ParkingFloor parkingFloor: parkingFloors) {
			List<ParkingSlot> parkingSlots = getAvailableTypeParkingSlot(parkingFloor.getParkingSlots(), vehicleType);
			for(ParkingSlot parkingSlot: parkingSlots)
				if(parkingSlot.getVehicleType().equals(vehicleType) && parkingSlot.isFree()) {
					return parkingSlot;
				}
		}
	}
	
	public List<ParkingSlot> getAvailableTypeParkingSlot(List<ParkingSlot> parkingSlot, VehicleType vehicleType) {
		if(vehicleType.equals(vehicleType.TRUCK) && parkingSlot.size()>=1) {
			return Arrays.asList(parkingSlot.get(0));
		}else if(vehicleType.equals(vehicleType.BIKE) && parkingSlot.size()>=3) {
			return Arrays.asList(parkingSlot.get(1), parkingSlot.get(2));
		}else {
			return parkingSlot;
		}
	}
	
	private String generateTicket(ParkingSlot parkingSlot) {
		return parkingLot.getParkingLotId() + "_" + (parkingSlot.getFloorId()+1);
	}
	
	public void unparkVehicle(String ticketId) {
		if(vehicleHashMap.get(ticketId) != null) {
			Vehicle vehicle = vehicleHashMap.get(ticketId);
			ParkingSlot parkingSlot = vehicle.getParkingSlot();
			parkingSlot.setFree(true);
			parkingLot.getParkingFloors().get(parkingSlot.getFloorId()).getParkingSlots().get(parkingSlot.getSlotId());
			vehicleHashMap.remove(ticketId);
		}else {
			System.out.println("Invalid Ticket");
		}
	}
	
	public void display(DisplayType displayType, VehicleType vehicleType) {
		if(displayType == DisplayType.FREE_COUNT) {
			displayFreeCount(vehicleType);
		}else if(displayType == DisplayType.FREE_SLOTS) {
			displayFreeSlots(vehicleType);
		}else if(displayType == DisplayType.OCCUPIED_SLOTS) {
			displayFreeSlots(vehicleType);
		}else {
			System.out.println("Invalid Display");
		}
	}
	
	public void displayFreeCount(VehicleType vehicleType) {
		for(int i = 0; i<parkingLot.getParkingFloors().size(); i++) {
			ParkingFloor floor = parkingLot.getParkingFloors().get(i);
			long count = floor.getParkingSlots().stream().filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType)).filter(ParkingSlot::isFree).count();
			System.out.println("No. of free slots for " + vehicleType + " on floor " + (i+1) + " : " + count);
		}
	}
	
	public void displayFreeSlots(VehicleType vehicleType) {
		for(int i = 0; i<parkingLot.getParkingFloors().size(); i++) {
			ParkingFloor floor = parkingLot.getParkingFloors().get(i);
			long count = floor.getParkingSlots().stream().filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType)).filter(ParkingSlot::isFree).count();
			System.out.println("No. of free slots for " + vehicleType + " on floor " + (i+1) + " : " + count);
		}
	}
}
