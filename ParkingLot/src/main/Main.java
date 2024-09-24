package main;
import java.util.*;
import service.*;
import entity.*;
import repository.*;

public class Main {
	public static void main(String[] args) {
		ParkingLotService parkingLotService = new ParkingLotService();
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			Command type = Command.of(sc.next());
			switch(type):
				case CREATE_PARKING_LOT: parkingLotService.createParkingLot(new ParkingLot(sc.next sc.nextInt()));
		}
	}
}
