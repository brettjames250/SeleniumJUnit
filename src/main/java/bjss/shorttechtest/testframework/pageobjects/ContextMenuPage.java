package bjss.shorttechtest.testframework.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage extends PageBase {


    private final By hotSpot = By.xpath("//div[@id='hot-spot']");


    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void rightClickHotSpot() {
        rightClick(hotSpot);
    }

    public void waitForAlertAndClick() {

        new WebDriverWait(driver, 60)
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());

        Alert al = driver.switchTo().alert();
        al.accept();

    }

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }
}



