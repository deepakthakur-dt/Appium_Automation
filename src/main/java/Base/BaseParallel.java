package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseParallel extends AppiumServer {
    public static ThreadLocal<AppiumDriver> driver= new ThreadLocal<>();
    public void setDriver(AppiumDriver driver)
    {
        this.driver.set(driver);
    }
    public AppiumDriver getDriver()
    {
        return this.driver.get();
    }
    @BeforeMethod
    @Parameters({"deviceName","platformVersion","portNumber"})
    public void Init(String deviceName, String platformVersion,String portNumber) throws MalformedURLException {
        ConfigReader configReader=new ConfigReader();
        File app=new File(System.getProperty("user.dir")+"\\app\\"+ configReader.getApp());
        startAppiumService(portNumber);
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        setDriver(new AppiumDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"),capability));
    }

    public void startAppiumService(String portNumber)
    {
        DesiredCapabilities cap;
        cap = new DesiredCapabilities();
        AppiumDriverLocalService service;
        AppiumServiceBuilder builder= new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(Integer.parseInt(portNumber));
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                .withAppiumJS(new File("C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
        service=AppiumDriverLocalService.buildService(builder);
        service.start();
    }


}
