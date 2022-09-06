package Test;

import org.testng.annotations.Test;

public final class VerifyStationery extends BaseTest{
    private VerifyStationery(){
    }

    @Test(dataProvider="WebsiteLoginData")
    public void LoginThroughExcelData(String url, String username, String password) {
        pageFactory.getLoginPage().Login(url, username, password);
    }
    @Test(dependsOnMethods = "LoginThroughExcelData")
    public void stationery(){
        pageFactory.getStationery().Select_Stationery();
        pageFactory.getStationery().Add_to_cart();
    }
}
