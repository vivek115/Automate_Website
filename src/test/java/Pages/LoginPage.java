package Pages;

import Configuration.ExtentLogger;
import Configuration.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath="//a[@class='header__action-item-link hidden-pocket hidden-lap']")
    private WebElement MyAccount;

    @FindBy(xpath="//input[@id='login-customer[email]']")
    private WebElement enterusername;

    @FindBy(xpath="//input[@id='login-customer[password]']")
    private WebElement enterpassword;

    @FindBy(xpath="(//button[@class='form__submit button button--primary button--full'])[1]")
    private WebElement clickonloginbutton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Login(String url,String username, String password) {
        driver.get(url);
        MyAccount.click();
        enterusername.sendKeys(username);
        ExtentLogger.pass("Enter username:- "+username);
        enterpassword.sendKeys(password);
        ExtentLogger.pass("Enter password:- "+password);
        clickonloginbutton.click();
        System.out.println("successfull login");
    }

}