package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class VerifyItemDetailPage extends PageHelper {
    private By clickOnYourLogo = By.xpath("//*[@id=\"header_logo\"]");
    private By mouseOverItem = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img");
    private By clickOnMore = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]/span");
    private By verifyItemTitle = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
    private By verifyItemPrice = By.xpath("//*[@id=\"our_price_display\"]");
    private By verifyItemQuantityOption = By.xpath("//*[@id=\"quantity_wanted_p\"]/label");
    private By verifyItemSizeOption = By.xpath("//*[@id=\"attributes\"]/fieldset[1]/label");
    private By verifyItemColorOption = By.xpath("//*[@id=\"attributes\"]/fieldset[2]/label");
    private By clickAddCart = By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    private By clickCloseModal = By.className("cross");

    public VerifyItemDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VerifyItemDetailPage clickYourLogo() {
        clickOnElement(clickOnYourLogo);
        return this;
    }

    public VerifyItemDetailPage mouseOnItem() {
        mouseOver(mouseOverItem);
        return this;
    }

    public VerifyItemDetailPage clickMore() {
        clickOnElement(clickOnMore);
        return this;
    }

    public VerifyItemDetailPage addCart() {
        clickOnElement(clickAddCart);
        return this;
    }

    public VerifyItemDetailPage closeModal() {
        clickOnElement(clickCloseModal);
        return this;
    }

    public String getItemTitle() {
        return getString(verifyItemTitle);
    }

    public String getItemPrice() {
        return getString(verifyItemPrice);
    }

    public String getItemQuantityOption() {
        return getString(verifyItemQuantityOption);
    }

    public String getItemSizeOption() {
        return getString(verifyItemSizeOption);
    }

    public String getItemColorOption() {
        return getString(verifyItemColorOption);
    }
}
