package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class HomePage extends PageHelper {
    private By womenLink = By.xpath("//a[@title='Women']");
    private By eveningDressesLink = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a");
    private By eveningDressText = By.className("cat-name");
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public HomePage openEveningDress() {
        mouseOver(womenLink);
        clickOnElement(eveningDressesLink);
        isElementDisplayed(eveningDressText);
        return this;
    }

    public String getHomePageMessage() {
        return getString(eveningDressText);
    }
}
