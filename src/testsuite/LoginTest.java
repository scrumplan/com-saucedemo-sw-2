package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.ws.WebEndpoint;
import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        String expectedResult = "PRODUCTS";
        //Enter username
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        //enter password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        //click on login button

        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();

        //verify the text "PRODUCTS"
        WebElement actualMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals("Product not found", expectedResult, actualMessage);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        String expectedProduct = "six products are displayed on page ";

        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        //enter password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int totalProducts = productNo.size();

        int expectedNumber = 6;
        Assert.assertEquals("Products numbers not matching", expectedNumber, totalProducts);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
