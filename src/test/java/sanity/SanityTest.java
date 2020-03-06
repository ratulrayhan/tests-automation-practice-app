package sanity;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.HomePage;

public class SanityTest extends TestHelper {

    @Test
    public void VerifyEveningDress() {

        HomePage homePage = new HomePage(driver);
        homePage.openTab();
        homePage.clickTab();
        homePage.verify();
        String actualStatusMessage = homePage.getHomePageMessage();

        String expectedMessage = "EVENING DRESSES";

        verifyTrue("Failed - after click on Evening Dresses message not matched", actualStatusMessage.contains(expectedMessage));
    }
}

