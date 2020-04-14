package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.HomePage;
import ui.pages.ShoppingCartSummaryPage;

public class ShoppingCartTest extends TestHelper {

    @Test
    public void verifyShoppingCart() {
        String expectedMessage = "Product successfully added to your shopping cart";

        HomePage homePage = new HomePage(driver);
        homePage.openEveningDress();

        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.addingToCart();

        String actualStatusMessage = shoppingCartSummaryPage.getSuccessMessage();

        verifyTrue("Failed - after click on Checkout message not matched", actualStatusMessage.contains(expectedMessage));

        shoppingCartSummaryPage.clickOnCheckOut();
        shoppingCartSummaryPage.continueShop();
    }
}

