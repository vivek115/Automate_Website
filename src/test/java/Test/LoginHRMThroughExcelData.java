package Test;
import org.testng.annotations.Test;

public final class LoginHRMThroughExcelData extends BaseTest {

    private LoginHRMThroughExcelData(){}

    @Test(dataProvider="WebsiteLoginData")
    public void LoginThroughExcelData(String url, String username, String password) {
        pageFactory.getLoginPage().Login(url, username, password);
    }
}