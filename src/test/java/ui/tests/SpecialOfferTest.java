package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.SpecialOfferPage;

public class SpecialOfferTest extends TestHelper {

    @Test
    public void verifySpecialOffer() {
        SpecialOfferPage specialOfferPage = new SpecialOfferPage(driver);
        specialOfferPage.clickOnSpecialOffer();

        String actualTitle = specialOfferPage.getItemTitle();
        verifyTrue("Failed - Item Title does not Matched!", actualTitle.contains("Printed Chiffon Dress"));

        String actualOldPrice = specialOfferPage.getOldPrice();
        verifyTrue("Failed - Item Old Price does not Matched!", actualOldPrice.contains("$20.50"));

        String actualReductionPercent = specialOfferPage.getReductionPercent();
        verifyTrue("Failed - Item Old Price does not Matched!", actualReductionPercent.contains("-20%"));

        String actualCurrentPrice = specialOfferPage.getCurrentPrice();
        verifyTrue("Failed - Item Old Price does not Matched!", actualCurrentPrice.contains("$16.40"));
    }
}
