package bjss.shorttechtest.testframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ChallengingDOMPage extends PageBase {


    List<String> initialButtonIDs;
    By redButton = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]");

    public ChallengingDOMPage(WebDriver driver) {
        super(driver);
    }


    public void clickRedButton() {
        click(redButton);
    }

    public List getInitialButtonIDs() {

        List<WebElement> initialButtonElements = driver.findElements(By.xpath("//*[contains(@class, 'button')]"));

        initialButtonIDs = new ArrayList<>();
        for (WebElement e : initialButtonElements) {
            initialButtonIDs.add(e.getAttribute("id"));
        }

        return initialButtonIDs;
    }


    public void checkForIDChange() {

        List<WebElement> afterButtonElements = driver.findElements(By.xpath("//*[contains(@class, 'button')]"));

        List<String> afterButtonIDs = new ArrayList<>();
        for (WebElement e : afterButtonElements) {
            afterButtonIDs.add(e.getAttribute("id"));
        }

        System.out.println(afterButtonIDs);

        tryAssertNotEquals(initialButtonIDs, afterButtonIDs);

    }
}
