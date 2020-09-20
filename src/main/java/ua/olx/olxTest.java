package ua.olx;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class olxTest {
    WebDriver webDriver = new ChromeDriver();
    MainPage mainPage;
    @Before
    public void PrepeareTest() {

        mainPage = new MainPage (webDriver);
        mainPage.SwitchToelement();
        // Telling the system where to find the Chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

    }

    @Test
    public void OpenTest() throws InterruptedException {

        webDriver.get("https://www.olx.ua/"); // open OLX site
        Thread.sleep(4000);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("olx"));//check if the OLX word is in the link
        webDriver.findElement(By.id("my-account-link")).click();// click on the account button
        Thread.sleep(3000);
        webDriver.findElement(By.id("userEmail")).sendKeys("rockettester3107@gmail.com");
        //writing in the email field
        Thread.sleep(1500);
        webDriver.findElement(By.id("userPass")).sendKeys("qwe123321Q", Keys.ENTER);
        //writing in the password field
        Thread.sleep(4000);
        webDriver.findElement(By.id("headerLogo")).click();//find the button to go to the main page
        Thread.sleep(2000);
        webDriver.findElement(By.id("headerSearch")).sendKeys("iPhone X", Keys.ENTER);//search for iPhone
        boolean results = webDriver.getCurrentUrl().contains("iPhone");//check the search results
           if(results)
               System.out.print("The search results are matching the request");
           else if (!results)
               System.out.print("The search results are not OK");//check that search results are fine
        Thread.sleep(2000);
        webDriver.get("https://www.olx.ua/uk/obyavlenie/iphone-chohol-na-6-s-x-8-7-xs-silicone-chehol-dlya-ayfon-" +
                "keys-case-IDJ9Dd1.html?sd=1#f4fad521cd;promoted");//open one of the adver
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);//wait 1 sec
        Thread.sleep(2000);
        WebElement message = webDriver.findElement(By.cssSelector(".contactbox-indent.rel.brkword"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("arguments[0].click()", message);//click on the message button
        Thread.sleep(1000);
        webDriver.findElement(By.id("ask-text")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.id("ask-text")).sendKeys("Hello, how are you doing");//send message
        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector(".button.br3.large.fright")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.id("my-account-link")).click();//open my account page
        Thread.sleep(1000);
        Actions actions = new Actions(webDriver);
        WebElement myProfile = webDriver.findElement(By.id("my-account-link"));
        Thread.sleep(500);
        actions.moveToElement(myProfile).build().perform();//hover over the My profile
        Thread.sleep(1000);
        webDriver.findElement(By.className("last")).click();//logout click

    }
    @After
    public void Teardown() {
        if (webDriver != null);
        System.out.print("Test was completed");
        //webDriver.close();
    }
}
