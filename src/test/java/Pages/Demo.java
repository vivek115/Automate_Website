package Pages;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestNG;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {
    HSSFWorkbook wb;
    HSSFSheet sheet;
    boolean result;
    public static FileInputStream fis;
    WebDriver driver;
    public Demo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void getdata() throws IOException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        fis=new FileInputStream("C:\\Users\\VivekJoshi\\Desktop\\AutomateWebsite\\TestData\\TestData.xls");
        wb=new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(2);
        int rows = sheet.getLastRowNum();
        for (int i = 1; i <= rows + 1; i++) {
            result = sheet.getRow(i).getCell(1).getBooleanCellValue();
            String data = sheet.getRow(i).getCell(2).getStringCellValue();
            if (result) {
                // Create object of TestNG Class
                TestNG runner = new TestNG();
                // Create a list of String
                List<String> suitefiles = new ArrayList<String>();
                // Add xml file which you have to execute
                suitefiles.add(data);
                // now set xml file for execution
                runner.setTestSuites(suitefiles);
                // finally execute the runner using run method
                runner.run();
            }
        }
    }
}

