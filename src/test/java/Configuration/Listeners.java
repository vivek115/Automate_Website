package Configuration;

import Test.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.awt.*;
import java.io.IOException;


import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class Listeners extends BaseTest implements ITestListener, ISuiteListener {

    public static ScreenRecorder screenRecorder;

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        Object Listeners = result.getInstance();
        WebDriver webDriver = ((BaseTest) Listeners).getDrivers();
        if (webDriver != null)
        {
            ExtentReport.test.pass(result.getMethod().getMethodName() + " is passed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }

    @Override
    public void onTestFailure(ITestResult result){
        Object Listeners = result.getInstance();
        WebDriver webDriver = ((BaseTest) Listeners).getDrivers();
        if (webDriver != null) {
            ExtentReport.test.fail(MarkupHelper.createLabel(String.valueOf(result.getThrowable()), ExtentColor.RED));
            ExtentReport.test.fail(result.getMethod().getMethodName() + " is failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public static String getBase64Image(){
        return ((TakesScreenshot) BaseTest.getDrivers()).getScreenshotAs(OutputType.BASE64);
    }
    public static void getVideo() throws IOException, AWTException {
        GraphicsConfiguration gconfig = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gconfig,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                        ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, (int) (15 * 60)),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey,"black", FrameRateKey, Rational.valueOf(30)), null);

    }

}
