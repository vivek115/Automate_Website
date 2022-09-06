package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Stationary {
    float y = 0;
    WebDriver driver;
    @FindBy(linkText = "Stationery")
    private WebElement Stationery;
    String Dropdown_Values = "(//ul[@class='nav-dropdown nav-dropdown--restrict'])[2]//li[%s]";
    @FindBy(xpath = "(//ul[@class='nav-dropdown nav-dropdown--restrict'])[2]//li[2]")
    private WebElement Select_Dropdown;
    String product = "(//div[@class='product-item__info']/div/a)[%s]";
    String price = "(//div[@class='product-item__price-list price-list'])[%s]";
    @FindBy(xpath = "(//button[contains(text(),'Add to cart')])[1]")
    private WebElement addtocart;
    @FindBy(xpath = "(//div[@class='line-item__meta'])[1]/a")
    private WebElement by;
    @FindBy(xpath = "(//div[@class='line-item__price-list'])[1]")
    private WebElement py;
    String compareprice = "//td[@class='line-item__line-price table__cell--right hidden-phone']";
    String pricepack = "(//td[@class='line-item__line-price table__cell--right hidden-phone'])[%s]//span";
    @FindBy(xpath = "//div[@class='cart-recap__price-line text--pull']//span[2]")
    private WebElement total;

    public Stationary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Select_Stationery() {
        Actions action = new Actions(driver);
        action.moveToElement(Stationery).build().perform();
        for (Stationary_Drop_Down ele : Stationary_Drop_Down.values()) {
            WebElement io = driver.findElement(By.xpath(String.format(Dropdown_Values, ele.ChallengeId())));
            Assert.assertEquals(io.getText(), ele.ChallengeName(), "Values are not same");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Select_Dropdown.click();
    }

    public void Add_to_cart() {
        for (int i = 1; i <= 4; i++) {
            Actions action = new Actions(driver);
            action.moveToElement(Stationery).build().perform();
            Select_Dropdown.click();
            WebElement s = driver.findElement(By.xpath(String.format(product, i)));
            WebElement p = driver.findElement(By.xpath(String.format(price, i)));
            String yrr = s.getText();
            String pr = p.getText().replace("Sale price", "").trim();
            s.click();
            addtocart.click();
            Assert.assertEquals(yrr, by.getText(), "text is not same");
            Assert.assertEquals(pr, py.getText(), "price is not same");
        }
        int size = driver.findElements(By.xpath(compareprice)).size();
        for (int x = 1; x <= size; x++) {
            WebElement trr = driver.findElement(By.xpath(String.format(pricepack, x)));
            float u = Float.parseFloat(trr.getText().replace("£", ""));
            y = y + u;
        }
        Assert.assertEquals(y, Float.parseFloat(total.getText().replace("£", "")));
    }
}
