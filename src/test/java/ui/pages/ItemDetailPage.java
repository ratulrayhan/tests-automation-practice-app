package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ItemDetailPage extends PageHelper {
    private By yourLogo = By.xpath("//*[@id=\"header_logo\"]");
    private By itemQuickView = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img");
    private By moreButton = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]/span");
    private By itemTitle = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
    private By itemPrice = By.xpath("//*[@id=\"our_price_display\"]");
    private By itemQuantityOption = By.xpath("//*[@id=\"quantity_wanted_p\"]/label");
    private By itemSizeOption = By.xpath("//*[@id=\"attributes\"]/fieldset[1]/label");
    private By itemColorOption = By.xpath("//*[@id=\"attributes\"]/fieldset[2]/label");
    private By addCartButton = By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    private By closeModalButton = By.className("cross");

    public ItemDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ItemDetailPage clickYourLogo() {
        clickOnElement(yourLogo);
        return this;
    }

    public ItemDetailPage mouseOnItem() {
        mouseOver(itemQuickView);
        return this;
    }

    public ItemDetailPage clickMore() {
        clickOnElement(moreButton);
        return this;
    }

    public ItemDetailPage addCart() {
        clickOnElement(addCartButton);
        return this;
    }

    public ItemDetailPage closeModal() {
        clickOnElement(closeModalButton);
        return this;
    }

    public String getItemTitle() {
        return getString(itemTitle);
    }

    public String getItemPrice() {
        return getString(itemPrice);
    }

    public String getItemQuantityOption() {
        return getString(itemQuantityOption);
    }

    public String getItemSizeOption() {
        return getString(itemSizeOption);
    }

    public String getItemColorOption() {
        return getString(itemColorOption);
    }
}
