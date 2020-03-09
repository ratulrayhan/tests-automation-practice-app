package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.HomePage;
import ui.pages.ShoppingCartSummaryPage;
import ui.pages.VerifyItemDetailPage;

public class ShoppingCartTest extends TestHelper {

    @Test
    public void VerifyShoppingCart() {
        String expectedMessage = "Product successfully added to your shopping cart";

        HomePage homePage = new HomePage(driver);
        homePage.openEveningDress();

        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.addingToCart();

        String actualStatusMessage = shoppingCartSummaryPage.getSuccessMessage();

        verifyTrue("Failed - after click on Checkout message not matched", actualStatusMessage.contains(expectedMessage));

        shoppingCartSummaryPage.checkOut();
        shoppingCartSummaryPage.continueShop();
    }

    @Test
    public void verifyItemDetail() {

        VerifyItemDetailPage verifyItemDetailPage = new VerifyItemDetailPage(driver);
        verifyItemDetailPage.clickYourLogo();
        verifyItemDetailPage.mouseOnItem();
        verifyItemDetailPage.clickMore();

        String actualStatusMessage = verifyItemDetailPage.getItemTitle();
        verifyTrue("Failed - after click on more, Item Title not matched", actualStatusMessage.contains("Faded Short Sleeve T-shirts"));

        String actualStatusMessage1 = verifyItemDetailPage.getItemPrice();
        verifyTrue("Failed - after click on more, Item price not matched", actualStatusMessage1.contains("$16.51"));

        String actualStatusMessage2 = verifyItemDetailPage.getItemQuantityOption();
        verifyTrue("Failed - after click on more, Item quantity not found", actualStatusMessage2.contains("Quantity"));

        String actualStatusMessage3 = verifyItemDetailPage.getItemSizeOption();
        verifyTrue("Failed - after click on more Item size not found", actualStatusMessage3.contains("Size"));

        String actualStatusMessage4 = verifyItemDetailPage.getItemColorOption();
        verifyTrue("Failed - after click on more Item color not found", actualStatusMessage4.contains("Color"));

        verifyItemDetailPage.addCart();
        verifyItemDetailPage.closeModal();
    }
}
