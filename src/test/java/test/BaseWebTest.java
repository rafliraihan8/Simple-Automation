package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseWebTest {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

//    public WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments();

        // run tanpa open browser
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-error",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
        driver.get().get("https://www.saucedemo.com/v1/");
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(90)));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }
}