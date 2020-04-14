package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class SpecialOfferPage extends PageHelper {
    private By specialsLink = By.xpath("//a[@title='Specials']");
    private By itemQuickView = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
    private By moreButton = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]/span");
    private By itemTitle = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
    private By oldPrice = By.id("old_price_display");
    private By reductionPercent = By.id("reduction_percent_display");
    private By currentPrice = By.id("our_price_display");

    public SpecialOfferPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SpecialOfferPage clickOnSpecialOffer() {
        clickOnElement(specialsLink);
        mouseOver(itemQuickView);
        clickOnElement(moreButton);
        return this;
    }

    public String getItemTitle() {
        return getString(itemTitle);
    }

    public String getOldPrice() {
        return getString(oldPrice);
    }

    public String getReductionPercent() {
        return getString(reductionPercent);
    }

    public String getCurrentPrice() {
        return getString(currentPrice);
    }
}
