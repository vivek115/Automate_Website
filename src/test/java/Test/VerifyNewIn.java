package Test;

import org.testng.annotations.Test;

public final class VerifyNewIn extends BaseTest{
    private VerifyNewIn(){
    }

    @Test(dataProvider="WebsiteLoginData")
    public void LoginThroughExcelData(String url, String username, String password) {
        pageFactory.getLoginPage().Login(url, username, password);
    }
    @Test(dependsOnMethods = "LoginThroughExcelData",dataProvider = "NewIn module")
    public void newin() throws InterruptedException {
        pageFactory.getNewin().newin();
        pageFactory.getNewin().displaypages();
    }
}
