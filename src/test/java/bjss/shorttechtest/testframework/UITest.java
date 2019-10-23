package bjss.shorttechtest.testframework;

import bjss.shorttechtest.testframework.reportutils.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
public class UITest extends TestBase {


    @Test(priority = 1 ,description = "Confirm that the blue, red and green button ids change after the red button is clicked")
    public void verifyButtonIDsChangeAfterClickingRedButton() {


        objHomePage.clickChallengingDOM();
        objChallengingDOMPage.getInitialButtonIDs();
        objChallengingDOMPage.clickRedButton();
        objChallengingDOMPage.checkForIDChange();


    }

    @Test(priority = 2, description = "Confirm 'Hello World!' is rendered after the fact")
    public void verifyTheHelloWorldMessageDisplayAfterRender() {


        objHomePage.clickDynamicLoading();
        dynamicLoading.generateElement();
        dynamicLoading.verifyHelloWorld();


    }


}

