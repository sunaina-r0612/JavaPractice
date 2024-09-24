package entity;
import java.util.*;

public class ParkingSlot {
	int floorId;
	int slotId;
	Vehicle vehicle;
	boolean isFree;
	VehicleType vehicleType;
	
	public ParkingSlot(int slotId, VehicleType vehicleType, boolean isFree) {
		this.slotId = slotId;
		this.vehicleType = vehicleType;
		this.isFree = isFree;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle v) {
		this.vehicle = v;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType v) {
		this.vehicleType = v;
	}

	public int getSlotId() {
		return slotId;
	}
	
	public void setSlotId(int id) {
		this.slotId = id;
	}
	
	public int getFloorId() {
		return floorId;
	}
	
	public void setFloorId(int id) {
		this.floorId = id;
	}
	
	public boolean isFree() {
		return isFree;
	}
	
	public void setFree(boolean free) {
		this.isFree = free;
	}
	
}
