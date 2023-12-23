package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseWebTest;

import java.time.Duration;

public class SeleniumTest extends BaseWebTest {

    @Test
    public void loginTestSucces(){
        //open browser

        //login
        driver.get().findElement(By.id("user-name")).sendKeys("standard_user");
        driver.get().findElement(By.name("password")).sendKeys("secret_sauce!");
        driver.get().findElement(By.xpath("//input[@id='login-button']")).click();

//        String txtActualBerhasilLogin = driver.get().findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
//        String txtExpectedBerhasilLogin = "Sauce Labs Backpack";
////        System.out.println(txtActualBerhasilLogin);
//        Assert.assertEquals(txtActualBerhasilLogin,txtExpectedBerhasilLogin);


    }

    @Test
    public void loginTestFailed(){
        //login page
        driver.get().findElement(By.id("user-name")).sendKeys("standard_user");
        driver.get().findElement(By.name("password")).sendKeys("secret_saucee");
        driver.get().findElement(By.xpath("//input[@id='login-button']")).click();
        //Home Page
        String txtErrorFailedPassExpc = driver.get().findElement(By.xpath("//h3[.='Epic sadface: Username and password do not match any user in this service']")).getText();
        Assert.assertTrue(txtErrorFailedPassExpc.contains("Epic sadface: Username and password do not match any user in this service"));


    }

}
