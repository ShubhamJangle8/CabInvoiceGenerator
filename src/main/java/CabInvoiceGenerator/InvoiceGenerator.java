package CabInvoiceGenerator;

public class InvoiceGenerator {

	private static final double COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;

	public double calculateTotalFare(double distance, int time) {
		return distance * COST_PER_KM + time * COST_PER_TIME;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Invoice Generator Service");
	}

}
