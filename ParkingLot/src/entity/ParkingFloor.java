package entity;
import java.util.*;

public class ParkingFloor {
	List<ParkingSlot> parkingSlots = null;
	
	public ParkingFloor(List<ParkingSlot> parkingSlot) {
		this.parkingSlots = parkingSlot;
	}
	
	public List<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}
	
	public void setParkingSlots() {
		this.parkingSlots = parkingSlots;
	}
}
