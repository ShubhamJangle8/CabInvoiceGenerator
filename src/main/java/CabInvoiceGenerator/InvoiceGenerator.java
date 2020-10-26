package CabInvoiceGenerator;

public class InvoiceGenerator {

	private static final double COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MIN_FARE = 5;

	public double calculateTotalFare(double distance, int time) {
		double total_fare = distance * COST_PER_KM + time * COST_PER_TIME;
		if(total_fare < MIN_FARE) {
			return MIN_FARE;
		}
		return total_fare;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Invoice Generator Service");
	}

	public double calculateTotalFare(Ride[] rides) {
		double total_fare = 0;
		for(Ride ride : rides) {
			total_fare += this.calculateTotalFare(ride.distance, ride.time);
		}
		return total_fare;
	}

}
