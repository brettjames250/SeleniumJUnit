package bjss.shorttechtest.testframework.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends PageBase {



    private final By helloWorldMessage = By.xpath("//div[@id='finish']");
    private final By startButton = By.xpath("//button[contains(text(),'Start')]");
    final By example2 = By.linkText("Example 2: Element rendered after the fact");
    final By pageTitle = By.xpath("//h4[contains(text(),'Example 2: Element rendered after the fact')]");

    public DynamicLoading(WebDriver driver) {
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

