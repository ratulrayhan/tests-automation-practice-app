package ui.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ui.helpers.TestHelper;
import ui.pages.HomePage;
import ui.pages.ShoppingCartSummaryPage;

public class ShoppingCartTest extends TestHelper {

    @Test
    public void VerifyShoppingCart() {

        HomePage homePage = new HomePage(driver);
        homePage.openTab();
        homePage.clickTab();

        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);

        shoppingCartSummaryPage.clickPrintedDress();

//        shoppingCartSummaryPage.clickQuantity();
//        shoppingCartSummaryPage.clickSize();
//        shoppingCartSummaryPage.choosingSize();
//        shoppingCartSummaryPage.clickColor();
       shoppingCartSummaryPage.addCart();
    }
}
