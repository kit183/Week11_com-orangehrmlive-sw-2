package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
    openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the username field element and type username
        driver.findElement(By.name("username")).sendKeys("Admin");
        // Find the password field element and type password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Find the login button element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedMessage = "Dashboard";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualMessage = actualTextMessageElement.getText();
        //Validate actual and expected
        Assert.assertEquals("Text not displayed", expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
