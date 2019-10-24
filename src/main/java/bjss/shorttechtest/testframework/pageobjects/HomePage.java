package bjss.shorttechtest.testframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {


    private final By challengingDOM = By.linkText("Challenging DOM");
    private final By availableExamples = By.xpath("//h2[contains(text(),'Available Examples')]");
    private By dynamicLoading = By.linkText("Dynamic Loading");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickChallengingDOM() {

        waitForIsDisplayed(availableExamples);
        click(challengingDOM);

    }

    public void clickDynamicLoading() {

        waitForIsDisplayed(availableExamples);
        click(dynamicLoading);

    }

}
