package CabInvoiceGenerator;

public class InvoiceService {

	private static final double COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MIN_FARE = 5;
	private RideRepository rideRepository = null;
	
	public InvoiceService() {
		this.rideRepository  = new RideRepository();
	}
	
	public double calculateTotalFare(double distance, int time) {
		double total_fare = distance * COST_PER_KM + time * COST_PER_TIME;
		if(total_fare < MIN_FARE) {
			return MIN_FARE;
		}
		return Math.max(total_fare, MIN_FARE);
	}
	
	public double calculateTotalFare(Ride[] rides) {
		double total_fare = 0;
		for(Ride ride : rides) {
			total_fare += this.calculateTotalFare(ride.distance, ride.time);
		}
		return Math.max(total_fare, MIN_FARE);
	} 
	
	public InvoiceSummary getSummary(Ride[] rides) {
		double total_fare = 0;
		for(Ride ride : rides) {
			total_fare += this.calculateTotalFare(ride.distance, ride.time);
		}
		
		return new InvoiceSummary(rides.length, total_fare);
	}
	
	public void addRides(String userID, Ride[] rides) {
		rideRepository.addRide(userID, rides);
	}
	
	public InvoiceSummary getSummaryForUserID(String userID) {
		return this.getSummary(rideRepository.getRides(userID));
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Invoice Generator Service");
	}

}
