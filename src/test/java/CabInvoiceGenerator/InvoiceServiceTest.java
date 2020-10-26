package CabInvoiceGenerator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceService invoiceService = null;
	
	@Before
	public void setup() {
		invoiceService = new InvoiceService();
	}

	/**
	 * UC1
	 * Calculate Fare
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 10.0;
		int time = 5;
		double fare = invoiceService.calculateTotalFare(distance, time);
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
		double fare = invoiceService.calculateTotalFare(distance, time);
		Assert.assertEquals(fare, 5.0, 0.0);
	}
	
	/**
	 * UC2 
	 * Total fare for multiple rides
	 */
	@Test
	public void givenMultipleRides_ReturnsTotalFare() {
		Ride[] rides = {
						new Ride(10.0, 5),new Ride(0.1, 1)};
		double fare = invoiceService.calculateTotalFare(rides);
		Assert.assertEquals(fare, 110.0, 0.0);
	}
	
	/**
	 * UC3
	 * Invoice Summary for multiple rides
	 */
	@Test
	public void givenMultipleRides_ReturnsInvoiceSummary() {
		Ride[] rides = {
						new Ride(10.0, 5),new Ride(0.1, 1)};
		InvoiceSummary summary = invoiceService.getSummary(rides);
		InvoiceSummary invoiceSummary = new InvoiceSummary(2, 110);
		Assert.assertEquals(summary, invoiceSummary);
	}
	
	/**
	 * UC4
	 * Invoice Summary for a particular User
	 */
	@Test
	public void givenUserIDAndRides_ReturnsInvoiceSummary() {
		String userID = "a@";
		Ride[] rides = {
						new Ride(10.0, 5),new Ride(0.1, 1)};
		invoiceService.addRides(userID, rides);
 		InvoiceSummary summary = invoiceService.getSummaryForUserID(userID);
		InvoiceSummary invoiceSummary = new InvoiceSummary(2, 110);
		Assert.assertEquals(summary, invoiceSummary);
	}
}