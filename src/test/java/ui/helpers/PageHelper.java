package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;
import static ui.helpers.CommonHelper.captureScreenshot;

public abstract class PageHelper {

    public final WebDriver driver;

    public PageHelper(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void setField(By byElement, String value) {
        waitUntilVisibilityOfElementLocatedBy(5, byElement);
        findByWebElement(byElement).clear();
        findByWebElement(byElement).sendKeys(value);
    }

    public WebElement findByWebElement(By byElement) {
        WebElement webElement = null;
        try {
            waitUntilVisibilityOfElementLocatedBy(5, byElement);
            webElement = driver.findElement(byElement);
        } catch (Exception e) {
            captureScreenshot();
            fail("Failed locate element using By: " + byElement + "\nCheck Screenshot \n" + e.getStackTrace());
        }
        return webElement;
    }

//    public void selectElement(By byElement) {
//        waitUntilVisibilityOfElementLocatedBy(5, byElement);
//        new Select(findByWebElement(byElement)).selectByIndex();
//    }


    public void clickOnElement(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byElement));
        findByWebElement(byElement).click();
    }

    public void mouseOver(By byElement) {
        waitUntilVisibilityOfElementLocatedBy(5, byElement);
        new Actions(driver).moveToElement(findByWebElement(byElement)).perform();
    }

    public boolean isElementDisplayed(By byElement) {
        boolean isFound;
        try {
            waitUntilVisibilityOfElementLocatedBy(5, byElement);
            isFound = true;
        } catch (Exception ignore) {
            isFound = false;
        }
        return isFound;
    }

    public void waitUntilVisibilityOfElementLocatedBy(int timeoutSec, By byElement) {
        new WebDriverWait(driver, timeoutSec).until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public String getString(By byElement) {
        waitUntilVisibilityOfElementLocatedBy(5, byElement);
        return findByWebElement(byElement).getText();
    }

    public List<String> getStringList(By byElements) {
        waitUntilVisibilityOfElementLocatedBy(5, byElements);
        List<WebElement> webElementList = driver.findElements(byElements);

        List<String> stringList = new ArrayList<>();
        for (WebElement element : webElementList) {
            stringList.add(element.getText().trim());
        }
        return stringList;
    }

    public Map<String, String> getTableMap(List<String> fieldName, List<String> fieldValue) {
        Map<String, String> empDetailsInoMap = new HashMap<>();
        for (int i = 0; i < fieldName.size(); i++) {
            empDetailsInoMap.put(fieldName.get(i).trim(), fieldValue.get(i).trim());
        }
        return empDetailsInoMap;
    }

    public List<WebElement> findWebElements(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byElement));
        return driver.findElements(byElement);
    }
}
