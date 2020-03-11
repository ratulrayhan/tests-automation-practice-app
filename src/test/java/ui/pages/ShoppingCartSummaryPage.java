package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ShoppingCartSummaryPage extends PageHelper {
    private By itemBox = By.xpath("//a[@title='Printed Dress']");
    private By moreButton = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span");
    private By plusButton = By.className("icon-plus");
    private By dropdownSizeField = By.id("uniform-group_1");
    private By sizeField = By.xpath("//*[@id=\"group_1\"]/option[2]");
    private By colorField = By.id("color_7");
    private By addCartButton = By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    private By verifySuccessfulAdding = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
    private By checkoutButton = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    private By continueShoppingButton = By.xpath("//a[@title='Continue shopping']");

    public ShoppingCartSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingCartSummaryPage addingToCart() {
        mouseOver(itemBox);
        clickOnElement(moreButton);
        clickOnElement(plusButton);
        clickOnElement(dropdownSizeField);
        clickOnElement(sizeField);
        clickOnElement(colorField);
        clickOnElement(addCartButton);
        return this;
    }

    public String getSuccessMessage() {
        return getString(verifySuccessfulAdding);
    }

    public ShoppingCartSummaryPage clickOnCheckOut() {
        clickOnElement(checkoutButton);
        return this;
    }

    public ShoppingCartSummaryPage continueShop() {
        clickOnElement(continueShoppingButton);
        return this;
    }
}
