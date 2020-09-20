package ua.olx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver webDriver;
    private WebDriver wait;
    @FindBy(css = "#submit-searchmain")
    WebElement titleradiobutton;

    public MainPage (WebDriver webDriver){

        //wait new = WebDriver(webDriver, 30);
        PageFactory.initElements(webDriver, this);

    }
    public void SwitchToelement () {
        titleradiobutton.click();
    }
}
