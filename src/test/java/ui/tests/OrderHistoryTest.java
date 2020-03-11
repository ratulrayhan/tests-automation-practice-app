package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.OrderHistoryPage;

public class OrderHistoryTest extends TestHelper {

    @Test
    public void verifyOrderHistory() {
        OrderHistoryPage verifyOrderHistory = new OrderHistoryPage(driver);
        verifyOrderHistory.clickHistory();

        String actualReferenceNumber = verifyOrderHistory.getReference();
        verifyTrue("Failed - after click on History, Item reference number not matched", actualReferenceNumber.contains("UINHFHCDL"));

        String actualPurchaseDate = verifyOrderHistory.getOrderDate();
        verifyTrue("Failed - after click on History, Purchase date not matched", actualPurchaseDate.contains("03/09/2020"));

        String actualPurchasePrice = verifyOrderHistory.getOrderPrice();
        verifyTrue("Failed - after click on History, Purchase Price not matched", actualPurchasePrice.contains("$18.51"));

        String actualPaymentMessage = verifyOrderHistory.getOrderPayment();
        verifyTrue("Failed - after click on History, Payment method not matched", actualPaymentMessage.contains("Payment by check"));

        String actualOrderStatus = verifyOrderHistory.getOrderStatus();
        verifyTrue("Failed - after click on History, Purchase Status not matched", actualOrderStatus.contains("On backorder"));

        verifyOrderHistory.clickInvoice();
        verifyOrderHistory.clickDetails();
        verifyOrderHistory.clickReorder();
    }
}
