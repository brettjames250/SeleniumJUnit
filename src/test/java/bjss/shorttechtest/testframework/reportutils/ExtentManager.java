package bjss.shorttechtest.testframework.reportutils;

import com.relevantcodes.extentreports.ExtentReports;

class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReports() {
        if (extent == null) {
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}

