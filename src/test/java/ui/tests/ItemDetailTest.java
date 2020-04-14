package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.ItemDetailPage;

public class ItemDetailTest extends TestHelper {

    @Test
    public void verifyItemDetail() {

        ItemDetailPage verifyItemDetailPage = new ItemDetailPage(driver);
        verifyItemDetailPage.clickYourLogo();
        verifyItemDetailPage.mouseOnItem();
        verifyItemDetailPage.clickMore();

        String actualTitle = verifyItemDetailPage.getItemTitle();
        verifyTrue("Failed - after click on more, Item Title not matched", actualTitle.contains("Faded Short Sleeve T-shirts"));

        String actualPrice = verifyItemDetailPage.getItemPrice();
        verifyTrue("Failed - after click on more, Item price not matched", actualPrice.contains("$16.51"));

        String actualQuantity = verifyItemDetailPage.getItemQuantityOption();
        verifyTrue("Failed - after click on more, Item quantity not found", actualQuantity.contains("Quantity"));

        String actualSize = verifyItemDetailPage.getItemSizeOption();
        verifyTrue("Failed - after click on more Item size not found", actualSize.contains("Size"));

        String actualColor = verifyItemDetailPage.getItemColorOption();
        verifyTrue("Failed - after click on more Item color not found", actualColor.contains("Color"));

        verifyItemDetailPage.addCart();
        verifyItemDetailPage.closeModal();
    }
}
