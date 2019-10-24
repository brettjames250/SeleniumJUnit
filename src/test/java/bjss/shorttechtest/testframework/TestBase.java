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

    public WebDriver driver;
    public HomePage objHomePage;
    public ChallengingDOMPage objChallengingDOMPage;
    public DynamicLoading dynamicLoading;


    @BeforeClass
    public void classLevelSetup() {


        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\java\\drivers\\chromedriver.exe");


    }

    @BeforeMethod
    public void methodLevelSetup() {


        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        objChallengingDOMPage = new ChallengingDOMPage(driver);
        objHomePage = new HomePage(driver);
        dynamicLoading = new DynamicLoading(driver);


    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}
