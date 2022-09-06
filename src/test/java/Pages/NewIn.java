package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewIn {

    WebDriver driver;
    int y = 0;
    @FindBy(linkText = "New In")
    private WebElement NewIn;
    String product = "(//div[@class='product-list product-list--collection product-list--with-sidebar']//a[@class='product-item__title text--strong link'])";
    @FindBy(xpath = "//a[contains(text(),'Next')]")
    private WebElement nextbutton;
    @FindBy(xpath = "(//button[@class='value-picker-button'])[1]")
    private WebElement displaybutton;
    String productSize = "(//button[@class='value-picker__choice-item link '])[%s]";
    @FindBy(xpath = "(//button[@class='value-picker-button'])[2]")
    private WebElement sortbyfilter;

    public NewIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void newin() throws InterruptedException {
        NewIn.click();
        for (int i = 1; i <= 4; i++) {
            int firstpagesize = driver.findElements(By.xpath(product)).size();
            y = y + firstpagesize;
            if (i == 4)
                break;
            nextbutton.click();
            Thread.sleep(3000);
        }
        System.out.println(y);
    }

    public void displaypages() throws InterruptedException {
        NewIn.click();
        for(int i=1;i<=3;i++) {
            displaybutton.click();
            WebElement io = driver.findElement(By.xpath(String.format(productSize, i)));
            int s = Integer.parseInt(io.getText().replace("per page", "").trim());
            io.click();
            Thread.sleep(3000);
            int pageverify = driver.findElements(By.xpath(product)).size();
            Assert.assertEquals(s, pageverify,"values are not same");
        }
    }
    public void sortby(){
        NewIn.click();
        sortbyfilter.click();
      //  (//button[@class='value-picker__choice-item link '])[4]

    }
}
