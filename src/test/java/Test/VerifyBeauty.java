package Test;
import org.testng.annotations.Test;
public final class VerifyBeauty extends  BaseTest{
    private VerifyBeauty(){
    }
    @Test(dataProvider="WebsiteLoginData")

    public void LoginThroughExcelData(String url, String username, String password) {
        pageFactory.getLoginPage().Login(url, username, password);
    }
    @Test(dependsOnMethods = "LoginThroughExcelData")
    public void clothing(){
        pageFactory.getBeauty().Select_Beauty();
    }
}
