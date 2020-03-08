package ui.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class CommonHelper {
    private static WebDriver driver;

    public static WebDriver loadWebDriver() {

        String driverType = "chrome";
        if ("chrome".equalsIgnoreCase(driverType)) {

            WebDriverManager.chromedriver().setup();
            Map<String, String> prefMap = new HashMap<>();
            prefMap.put("download.default_directory", getSeleniumDownloadDirectoryPath());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("prefs", prefMap);
            driver = new ChromeDriver(chromeOptions);

        } else if ("firefox".equalsIgnoreCase(driverType)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.dri", getSeleniumDownloadDirectoryPath());
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("disable-infobars");
            firefoxOptions.setProfile(firefoxProfile);
            driver = new FirefoxDriver(firefoxOptions);

        } else if ("ie".equalsIgnoreCase(driverType) && SystemUtils.IS_OS_WINDOWS) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static String getSeleniumDownloadDirectoryPath() {
        String defaultDownloadPath = SystemUtils.IS_OS_WINDOWS ? "C:\\selenium-tests-downloads\\" : System.getProperty("user.home") + "/selenium-tests-downloads/";
        File directory = new File(defaultDownloadPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        System.out.println("++++++++++ All Selenium Test downloads located: " + defaultDownloadPath + " ++++++++++");
        return defaultDownloadPath;
    }

    public static String getEnvironmentProperty(String propertyName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(getEnvironment());
        return resourceBundle.getString(propertyName);
    }

    private static String getEnvironment() {
        String env = null;
        try {
            env = System.getenv("ENVIRONMENT").toLowerCase();
        } catch (Exception e) {
            fail("Please enter a valid environment, please use one of the valid environment name: test, preprod, prod");
        }
        return env;
    }

    public static void captureScreenshot() {
        String fileName = "selenium-screen-capture-" + new SimpleDateFormat("MMddyyyymmsss").format(new Date()) + ".png";
        String filePathWithFileName = getSeleniumDownloadDirectoryPath() + fileName;
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(filePathWithFileName));
            System.out.println("++++++++++ Screenshot captured and saved: " + filePathWithFileName + " ++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
