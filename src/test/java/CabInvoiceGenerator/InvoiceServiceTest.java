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
		Assert.assertTrue(fare == 105.0);
		
	}
}