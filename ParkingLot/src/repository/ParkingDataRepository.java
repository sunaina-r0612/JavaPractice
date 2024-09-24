package repository;
import java.util.*;
import entity.*;

public class ParkingDataRepository {
	List<ParkingSlot> parkingSlotData;
	List<ParkingFloor> parkingFloor;
	
	public List<ParkingFloor> initializeData(int noOfFloors, int noOfSlots){
		parkingFloor = new ArrayList<>(noOfFloors);
		for(int i = 0; i< noOfFloors; i++) {
			initializeSlots(noOfSlots);
			List<ParkingSlot> parkingSlots = getAllParkingSlots(i);
			parkingFloor.add(new ParkingFloor(parkingSlots));
		}
		
		return parkingFloor;
	}
	
	public void initializeSlots(int noOfSlots) {
		parkingSlotData = new ArrayList<>(noOfSlots);
		if(noOfSlots>=1) {
			parkingSlotData.add(getTruckData());
		}if(noOfSlots>=3) {
			for(int i = 0; i<3; i++)
				parkingSlotData.add(getBikeData(i));
		}if(noOfSlots>3) {
			for(int i = 0; i<noOfSlots; i++)
				parkingSlotData.add(getCarData(i));
		}
	}
	
	public List<ParkingSlot> getAllParkingSlots(int floorid){
		parkingSlotData.forEach(ps -> ps.setFloorId(floorid));
		return parkingSlotData;
	}
	
	private ParkingSlot getTruckData() {
		return new ParkingSlot(0, VehicleType.TRUCK, true);
	}
	
	private ParkingSlot getBikeData(int id) {
		return new ParkingSlot(id, VehicleType.BIKE, true);
	}
	
	private ParkingSlot getCarData(int id) {
		return new ParkingSlot(id, VehicleType.CAR, true);
	}
}
