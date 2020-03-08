package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class VerifyItemDetailPage extends PageHelper {
    private By mouseOnItem = By.xpath("\"//a[@title='Printed Dress']\"");

    public VerifyItemDetailPage(WebDriver webDriver) {
        super(webDriver);
    }
}
