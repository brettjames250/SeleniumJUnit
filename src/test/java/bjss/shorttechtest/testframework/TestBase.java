package bjss.shorttechtest.testframework;

import bjss.shorttechtest.testframework.pageobjects.ChallengingDOMPage;
import bjss.shorttechtest.testframework.pageobjects.DynamicLoading;
import bjss.shorttechtest.testframework.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    protected WebDriver driver;
    HomePage homePage;
    ChallengingDOMPage challengingDOMPage;
    DynamicLoading dynamicLoading;


    @BeforeClass
    public void classLevelSetup() {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver");

        } else {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

        }

    }

    @BeforeMethod
    public void methodLevelSetup() {


        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        challengingDOMPage = new ChallengingDOMPage(driver);
        homePage = new HomePage(driver);
        dynamicLoading = new DynamicLoading(driver);


    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}
