package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PageHelper {

    public final WebDriver driver;

    public PageHelper(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void setField(By byElement, String value) {
        waitUntilVisibilityOfElementLocatedBy(5, byElement);
        driver.findElement(byElement).clear();
        driver.findElement(byElement).sendKeys(value);
    }

    public void clickOnElement(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byElement));
        driver.findElement(byElement).click();
    }

    public void mouseOver(By byElement) {
        waitUntilVisibilityOfElementLocatedBy(5, byElement);
        new Actions(driver).moveToElement(driver.findElement(byElement)).perform();
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
        return driver.findElement(byElement).getText();
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
