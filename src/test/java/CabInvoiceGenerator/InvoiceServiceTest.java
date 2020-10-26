package CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator = null;
	
	@Before
	public void setup() {
		invoiceGenerator = new InvoiceGenerator();
	}

	/**
	 * UC1
	 * Calculate Fare
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 10.0;
		int time = 5;
		double fare = invoiceGenerator.calculateTotalFare(distance, time);
		Assert.assertEquals(fare, 105.0, 0.0);
	}
	
	/**
	 * UC1 Refactor
	 * Test for Minimum Fare
	 */
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateTotalFare(distance, time);
		Assert.assertEquals(fare, 5.0, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ReturnsTotalFare() {
		Ride[] rides = {new Ride(10.0, 5),new Ride(0.1, 1)};
		double fare = invoiceGenerator.calculateTotalFare(rides);
		Assert.assertEquals(fare, 110.0, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ReturnsInvoiceSummary() {
		Ride[] rides = {
				new Ride(10.0, 5),new Ride(0.1, 1)};
		InvoiceSummary summary = invoiceGenerator.getSummary(rides);
		InvoiceSummary invoiceSummary = new InvoiceSummary(2, 110);
		Assert.assertEquals(summary, invoiceSummary);
	}
}