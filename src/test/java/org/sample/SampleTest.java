package org.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTest {

    public WebDriver driver = null;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void loginTest() {
        WebElement input_username = driver.findElement(By.id("user-name"));
        input_username.sendKeys("standard_user");

        WebElement input_password = driver.findElement(By.id("password"));
        input_password.sendKeys("secret_sauce");

        WebElement button_login = driver.findElement(By.id("login-button"));
        button_login.click();
    }

    @AfterTest
    public void tearDown() {
        try {
            Thread.sleep(2000);
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
