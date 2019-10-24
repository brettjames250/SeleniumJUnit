package bjss.shorttechtest.testframework.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends PageBase {



    private final By helloWorldMessage = By.xpath("//div[@id='finish']");
    private final By startButton = By.xpath("//button[contains(text(),'Start')]");
    private final By example2 = By.linkText("Example 2: Element rendered after the fact");
    private final By pageTitle = By.xpath("//h4[contains(text(),'Example 2: Element rendered after the fact')]");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void generateElement() {

        click(example2);
        waitForIsDisplayed(pageTitle);
        click(startButton);
    }

    public void verifyHelloWorld() {

        waitForIsDisplayed(helloWorldMessage);
    }


}

