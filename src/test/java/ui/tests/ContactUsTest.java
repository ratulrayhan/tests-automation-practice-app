package ui.tests;

import org.junit.Test;
import ui.helpers.TestHelper;
import ui.pages.ContactUsPage;

public class ContactUsTest extends TestHelper {

    @Test
    public void verifyContactUs() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.clickOnContactUs();
        String actualText = contactUsPage.getSuccessMessage();
        verifyTrue("Failed - After Submit form, Successful message does not Matched!", actualText.contains("Your message has been successfully sent to our team."));
    }
}
