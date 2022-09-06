package Test;

import org.testng.annotations.Test;

public final class VerifyHomeware extends BaseTest {
    private VerifyHomeware(){
    }

    @Test(dataProvider="WebsiteLoginData")
    public void LoginThroughExcelData(String url, String username, String password) {
        pageFactory.getLoginPage().Login(url, username, password);
    }
    @Test(dependsOnMethods = "LoginThroughExcelData")
    public void clothing(){
        pageFactory.getHomeware().Select_Homeware();
    }

}
