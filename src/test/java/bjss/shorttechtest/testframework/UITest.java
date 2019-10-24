package bjss.shorttechtest.testframework;

import bjss.shorttechtest.testframework.reportutils.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Listeners({TestListener.class})
public class UITest extends TestBase {


    @Test(priority = 1, description = "Confirm that the blue, red and green button ids change after the red button is clicked")
    public void verifyButtonIDsChangeAfterClick() {


        homePage.clickChallengingDOM();
        challengingDOMPage.locateButtonIDs();
        challengingDOMPage.clickRedButton();
        assertThat(challengingDOMPage.getButtonIds(), not(equalTo(challengingDOMPage.getUpdatedButtonIDs())));


    }

    @Test(priority = 2, description = "Confirm 'Hello World!' is rendered after the fact")
    public void verifyHelloWorldMessageDisplay() {


        homePage.clickDynamicLoading();
        dynamicLoading.generateElement();
        dynamicLoading.verifyHelloWorld();


    }

    @Test(priority = 3, description = "Accept alert after trigger, then verify no further alerts are present")
    public void acceptMessageAfterTrigger() {

        homePage.clickContextMenu();
        contextMenu.rightClickHotSpot();
        contextMenu.waitForAlertAndClick();
        assertThat(contextMenu.isAlertPresent(), equalTo(false));


    }


}

