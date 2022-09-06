package Test;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static Configuration.Listeners.screenRecorder;


public class DemoTest extends BaseTest {
    @Parameters("Data")
    @Test
    public void GoogleSearch(String Data) throws IOException {
        //screenRecorder.start();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(Data, Keys.ENTER);

    }
}