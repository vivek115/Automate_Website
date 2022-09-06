package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private LoginPage loginPage;
    private Clothing clothing;
    private Stationary stationery;
    private HomeWare homeware;
    private Beauty beauty;
    private NewIn newin;
    private Demo demo;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
        public Clothing getClothing() {
            if (clothing == null) {
                clothing = new Clothing(driver);
            }
            return clothing;
        }
    public Stationary getStationery() {
        if (stationery == null) {
            stationery = new Stationary(driver);
        }
        return stationery;
    }
    public HomeWare getHomeware() {
        if (homeware == null) {
            homeware = new HomeWare(driver);
        }
        return homeware;
    }
    public Beauty getBeauty() {
        if (beauty == null) {
            beauty = new Beauty(driver);
        }
        return beauty;
    }
    public NewIn getNewin() {
        if (newin == null) {
            newin = new NewIn(driver);
        }
        return newin;
    }
    public Demo getdemo() {
        if (demo == null) {
            demo = new Demo(driver);
        }
        return demo;
    }
    }

