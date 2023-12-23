package test;

import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends BaseWebTest{

    @Test
    public void successLogin(){
        LoginPage loginPage = new LoginPage(driver,explicitWait);
        HomePage homePage = new HomePage(driver,explicitWait);

        loginPage.login("standard_user","secret_sauce");
        //String txtExpecctedBerhasilLogin = "Products";
    }
}
