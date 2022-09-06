package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Beauty {
    WebDriver driver;
    @FindBy(linkText = "Beauty")
    private WebElement Beauty;
    String Dropdown_Values = "(//ul[@class='nav-dropdown nav-dropdown--restrict'])[4]//li[%s]";

    @FindBy(xpath = "(//ul[@class='nav-dropdown nav-dropdown--restrict'])[4]//li[3]")
    private WebElement Select_Dropdown;

    public Beauty(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Select_Beauty() {
        Actions action = new Actions(driver);
        action.moveToElement(Beauty).build().perform();
        for (Beauty_Drop_Down ele : Beauty_Drop_Down.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(Dropdown_Values, ele.ChallengeId())));
            Assert.assertEquals(io.getText(), ele.ChallengeName(), "Values are not same");
        }
        Select_Dropdown.click();
    }
}
