package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class OrderHistoryPage extends PageHelper {
    private By orderHistoryLink = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span");
    private By orderReferenceField = By.linkText("UINHFHCDL");
    private By orderDateField = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[2]");
    private By orderPriceField = By.className("history_price");
    private By orderPaymentField = By.className("history_method");
    private By orderStatusField = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[5]/span");
    private By orderInvoiceDownloadLink = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[6]/a");
    private By orderDetailsButton = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[7]/a[1]/span");
    private By reOrderButton = By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[7]/a[2]");

    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OrderHistoryPage clickHistory() {
        clickOnElement(orderHistoryLink);
        return this;
    }

    public String getReference() {
        return getString(orderReferenceField);
    }

    public String getOrderDate() {
        return getString(orderDateField);
    }

    public String getOrderPrice() {
        return getString(orderPriceField);
    }

    public String getOrderPayment() {
        return getString(orderPaymentField);
    }

    public String getOrderStatus() {
        return getString(orderStatusField);
    }

    public OrderHistoryPage clickInvoice() {
        clickOnElement(orderInvoiceDownloadLink);
        return this;
    }

    public OrderHistoryPage clickDetails() {
        clickOnElement(orderDetailsButton);
        return this;
    }

    public OrderHistoryPage clickReorder() {
        clickOnElement(reOrderButton);
        return this;
    }
}
