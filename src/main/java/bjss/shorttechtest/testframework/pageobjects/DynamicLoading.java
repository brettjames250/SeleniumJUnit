package bjss.shorttechtest.testframework.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends PageBase {



    By helloWorldMessage = By.xpath("//div[@id='finish']");
    By startButton = By.xpath("//button[contains(text(),'Start')]");
    By example2 = By.linkText("Example 2: Element rendered after the fact");
    By pageTitle = By.xpath("//h4[contains(text(),'Example 2: Element rendered after the fact')]");

    public DynamicLoading(WebDriver driver) {
        super(driver);
    }

    public void generateElement() {

        click(example2);
        waitForIsDisplayed(pageTitle);
        click(startButton);
    }

    public Boolean verifyHelloWorld() {

        return waitForIsDisplayed(helloWorldMessage, 15);
    }


}

