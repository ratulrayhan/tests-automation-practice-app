package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class VerifyOrderHistoryPage extends PageHelper {
    private By clickOnOrderHistory = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span");
    private By orderReference = By.linkText("UINHFHCDL");
    private By orderDate = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[2]");
    private By orderPrice = By.className("history_price");
    private By orderPayment = By.className("history_method");
    private By orderStatus = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[5]/span");
    private By orderInvoice = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[6]/a");
    private By orderDetails = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[7]/a[1]/span");
    private By reOrder = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[7]/a[2]");

    public VerifyOrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VerifyOrderHistoryPage clickHistory() {
        clickOnElement(clickOnOrderHistory);
        return this;
    }

    public String getReference() {
        return getString(orderReference);
    }

    public String getOrderDate() {
        return getString(orderDate);
    }

    public String getOrderPrice() {
        return getString(orderPrice);
    }

    public String getOrderPayment() {
        return getString(orderPayment);
    }

    public String getOrderStatus() {
        return getString(orderStatus);
    }

    public VerifyOrderHistoryPage clickInvoice() {
        clickOnElement(orderInvoice);
        return this;
    }

    public VerifyOrderHistoryPage clickDetails() {
        clickOnElement(orderDetails);
        return this;
    }

    public VerifyOrderHistoryPage clickReorder() {
        clickOnElement(reOrder);
        return this;
    }
}
