package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomeWare {
    WebDriver driver;
    @FindBy(linkText = "Homeware")
    private WebElement Homeware;
    String Dropdown_Values = "(//ul[@class='nav-dropdown nav-dropdown--restrict'])[3]//li[%s]";

    @FindBy(xpath="(//ul[@class='nav-dropdown nav-dropdown--restrict'])[3]//li[6]")
    private WebElement Select_Dropdown;

    public HomeWare(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Select_Homeware(){
        Actions action = new Actions(driver);
        action.moveToElement(Homeware).build().perform();
        for (HomeWare_Drop_Down ele : HomeWare_Drop_Down.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(Dropdown_Values , ele.ChallengeId())));
            Assert.assertEquals(io.getText(), ele.ChallengeName(), "Values are not same");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select_Dropdown.click();
    }
}
