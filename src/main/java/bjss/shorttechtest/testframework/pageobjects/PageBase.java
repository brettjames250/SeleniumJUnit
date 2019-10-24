package bjss.shorttechtest.testframework.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class PageBase {

    final WebDriver driver;
    WebDriverWait wait;

    PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 5;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }


    private WebElement find(By locator) {
        return driver.findElement(locator);
    }


    protected void click(By locator) {
        find(locator).click();
    }

    protected void rightClick(By locator) {

        Actions actions = new Actions(driver);
        WebElement elementLocator = find(locator);
        actions.contextClick(elementLocator).perform();
    }

    Boolean waitForIsDisplayed(By locator, Integer... timeout) {
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeout.length > 0 ? timeout[0] : null));
        } catch (org.openqa.selenium.TimeoutException exception) {
            System.out.println("The expected element: " + locator + "was not found on the page");
            return false;
        }
        return true;
    }


}
