package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ui.helpers.PageHelper;

public class ContactUsPage extends PageHelper {
    private By contactUsLink = By.id("contact-link");
    private By dropdownSubjectField = By.xpath("//*[@id=\"id_contact\"]");
    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By attachButton = By.cssSelector("input[id='fileUpload']");
    private By messageField = By.xpath("//*[@id=\"message\"]");
    private By sendButton = By.xpath("//*[@id=\"submitMessage\"]/span");
    private By verifyText = By.xpath("//*[@id=\"center_column\"]/p");

    public ContactUsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ContactUsPage clickOnContactUs() {
        clickOnElement(contactUsLink);
        new Select(driver.findElement(dropdownSubjectField)).selectByVisibleText("Customer service");
        setField(emailField, "test@gmail.com");
        setField(messageField, "This is Test Message");
        driver.findElement(attachButton).sendKeys("/Users/datripler/Downloads/test.png");
        clickOnElement(sendButton);
        return this;
    }

    public String getSuccessMessage() {
        return getString(verifyText);
    }
}
