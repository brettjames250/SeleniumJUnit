package bjss.shorttechtest.testframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {


    By challengingDOM = By.linkText("Challenging DOM");
    By availableExamples = By.xpath("//h2[contains(text(),'Available Examples')]");
    By dynamicLoading = By.linkText("Dynamic Loading");

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
