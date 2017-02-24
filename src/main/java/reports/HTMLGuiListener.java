package reports;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.uncommons.reportng.HTMLReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by USER on 24-Feb-17.
 */
public class HTMLGuiListener extends HTMLReporter implements ITestListener {

    private final static Logger logger = Logger.getLogger(HTMLGuiListener.class);

    private void maximize() {
        //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        //WebDriverManager.getDriverInstance().manage().window().setSize(dim);
    }

    @Override
    public void onTestStart(ITestResult result) {
        maximize();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test SUCCEDED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Failure on test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private String currentDate() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        return formatter.format(now);
    }
}