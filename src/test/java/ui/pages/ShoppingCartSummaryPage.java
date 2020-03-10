package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ShoppingCartSummaryPage extends PageHelper {
    private By clickOnItem = By.xpath("//a[@title='Printed Dress']");
    private By clickOnMore = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span");
    private By clickOnPlus = By.className("icon-plus");
    private By clickOnSize = By.id("uniform-group_1");
    private By selectSize = By.xpath("//*[@id=\"group_1\"]/option[2]");
    private By selectColor = By.id("color_7");
    private By clickAddCart = By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    private By verifySuccessfulAdding = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
    private By clickOnCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    private By continueShopping = By.xpath("//a[@title='Continue shopping']");

    public ShoppingCartSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingCartSummaryPage addingToCart() {
        mouseOver(clickOnItem);
        clickOnElement(clickOnMore);
        clickOnElement(clickOnPlus);
        clickOnElement(clickOnSize);
        clickOnElement(selectSize);
        clickOnElement(selectColor);
        clickOnElement(clickAddCart);
        isElementDisplayed(verifySuccessfulAdding);
        return this;
    }

    public String getSuccessMessage() {
        return getString(verifySuccessfulAdding);
    }

    public ShoppingCartSummaryPage checkOut() {
        clickOnElement(clickOnCheckout);
        return this;
    }

    public ShoppingCartSummaryPage continueShop() {
        clickOnElement(continueShopping);
        return this;
    }
}
