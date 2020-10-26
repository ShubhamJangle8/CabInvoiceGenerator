package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	public Map<String, ArrayList<Ride>> mapIdRides = null;

	public RideRepository() {
		this.mapIdRides = new HashMap<>();
	}
	
	public void addRide(String userID, Ride[] rides) {
		this.mapIdRides.put(userID, new ArrayList<Ride>(Arrays.asList(rides)));
	}
	
	public Ride[] getRides(String userID) {
		return this.mapIdRides.get(userID).toArray(new Ride[0]);
	}
	
}
