package bjss.shorttechtest.testframework.reportutils;

import bjss.shorttechtest.testframework.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        ExtentTestManager.endTest();
        ExtentManager.getReports().flush();
    }


}
