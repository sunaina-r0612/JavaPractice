package entity;
import java.util.*;

public class ParkingLot {
	String parkingLotId;
	int noOfFloors;
	int noOfSlotsPerFloor;
	List<ParkingFloor> parkingFloors;
	
	public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor, List<ParkingFloor> parkingFloor) {
		this.parkingLotId = parkingLotId;
		this.noOfFloors = noOfFloors;
		this.noOfSlotsPerFloor = noOfSlotsPerFloor;
		this.parkingFloors = parkingFloors;
	}
	
	public String getParkingLotId() {
		return parkingLotId;
	}
	
	public void setParkingLotId(String lotId) {
		this.parkingLotId = lotId;
	}
	
	public int getNoOfFloors() {
		return noOfFloors;
	}
	
	public void setNoOfFloors(int noOfFloors) {
		this.noOfFloors = noOfFloors;
	}
	
	public int getNoOfSlotsPerFloors() {
		return noOfSlotsPerFloor;
	}
	
	public void setNoOfSlotsPerFloors(int noOfSlotsPerFloor) {
		this.noOfSlotsPerFloor = noOfSlotsPerFloor;
	}
	
	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}
	
	public void setParkingFloors(List<ParkingFloor> floors) {
		this.parkingFloors = floors;
	}
}
