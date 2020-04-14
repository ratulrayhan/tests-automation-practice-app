package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

import static org.junit.Assert.fail;
import static ui.helpers.CommonHelper.getEnvironmentProperty;

public class LoginPage extends PageHelper {

    private By usernameField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitButton = By.id("SubmitLogin");
    private By customerTab = By.xpath("//*[@id=\"center_column\"]/h1");
    private By signinTab = By.xpath("//a[@class='login']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void login(String username, String password) {
        //Navigate to the site
        String url = getEnvironmentProperty("app.url");
        driver.get(url);

        //Login to the app
        clickOnElement(signinTab);
        setField(usernameField, username);
        setField(passwordField, password);
        clickOnElement(submitButton);

        if (!isElementDisplayed(customerTab)) {
            fail("Failed to login to Customer Account.");
        }
    }
}
