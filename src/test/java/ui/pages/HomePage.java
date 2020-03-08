package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class HomePage extends PageHelper {
    private By mouseOverWomen = By.xpath("//a[@title='Women']");
    private By clickOnEvening = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a");
    private By verifyEveningDress = By.className("cat-name");
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public HomePage openTab() {
        mouseOver(mouseOverWomen);
        return this;
    }

    public HomePage clickTab() {
        clickOnElement(clickOnEvening);
        return this;
    }

    public HomePage verify() {
        isElementDisplayed(verifyEveningDress);
        return this;
    }

    public String getHomePageMessage() {
        return getString(verifyEveningDress);
    }
}
