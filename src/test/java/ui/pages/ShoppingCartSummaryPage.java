package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ui.helpers.PageHelper;

public class ShoppingCartSummaryPage extends PageHelper {
private By clickOnItem = By.xpath("//a[@title='Printed Dress']");
//private By clickOnPlus = By.className("icon-plus");
//private By clickOnPlus = By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i");
//private By clickOnSize = By.id("uniform-group_1");
//private By selectSize = By.xpath("//*[@id=\"group_1\"]/option[2]");
//private By selectColor = By.id("color_7");
private By clickAddCart = By.xpath("//*[@id=\"add_to_cart\"]/button");
//Select clickAddCart = new Select(driver.findElement(By.id("add_to_cart")));
//private By addToCart = By.cssSelector( "#add_to_cart > button > span");

    public ShoppingCartSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }



    public ShoppingCartSummaryPage clickPrintedDress(){
        clickOnElement(clickOnItem);
        return this;
    }
//    public ShoppingCartSummaryPage clickQuantity(){
//        clickOnElement(clickOnPlus);
//        return this;
//    }
//    public ShoppingCartSummaryPage clickSize(){
//        clickOnElement(clickOnSize);
//        return this;
//    }
//    public ShoppingCartSummaryPage chossingSize(){
//        clickOnElement(selectSize);
//        return this;
//    }
//    public ShoppingCartSummaryPage clickColor(){
//        clickOnElement(selectColor);
//        return this;
//    }
    public ShoppingCartSummaryPage addCart(){
        clickOnElement(clickAddCart);
        return this;
    }
}
