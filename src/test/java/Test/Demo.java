package Test;

import org.testng.annotations.Test;

import java.io.IOException;

public class Demo extends  BaseTest {
    private Demo() {
    }

    @Test(dataProvider = "WebsiteLoginData")
    public void LoginThroughExcelData(String url, String username, String password) {
        pageFactory.getLoginPage().Login(url, username, password);
    }
    @Test( dependsOnMethods = "LoginThroughExcelData")
    public void getdata() throws IOException {
        pageFactory.getdemo().getdata();
    }
}