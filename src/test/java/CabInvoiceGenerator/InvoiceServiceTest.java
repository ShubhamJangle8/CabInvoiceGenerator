package CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

	/**
	 * UC1
	 * Calculate Fare
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
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
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateTotalFare(distance, time);
		Assert.assertEquals(fare, 5.0, 0.0);
	}
}