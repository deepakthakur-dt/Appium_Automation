//package Base;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//public class BaseCloud extends AppiumServer{
//    public static AndroidDriver driver;
//
//    public AndroidDriver runCap(Boolean cloud) throws Exception {
//        if(cloud)
//        {
//            return  InitCloud();
//        }
//
//        {
//            return  Init();
//        }
//
//    }
//
//
//    public static void startEmulator() throws IOException, InterruptedException {
//
//        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\startEmulator.bat");
//        Thread.sleep(6000);
//    }
//
//
//    public static AndroidDriver<AndroidElement> Init() throws Exception {
//        //location of the app
//        ConfigReader configReader = new ConfigReader();
//        File app = new File(System.getProperty("user.dir") + "\\app\\" + configReader.getApp());
//
//        //To create an object of Desired Capabilities
//        if (configReader.getDeviceName().contains("emulator")) {
//            startEmulator();
//        }
//        DesiredCapabilities capability = new DesiredCapabilities();
//        capability.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        capability.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getDeviceName());
//        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getPlatformVersion());
//        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.getPlatformName());
//        URL url = new URL(configReader.getUrl());
//        driver = new AndroidDriver(url, capability);
//        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//        Thread.sleep(3000);
//        System.out.println("App 1 Launched");
//
//
//        return driver;
//    }
//
//
//    public AndroidDriver InitCloud() throws Exception {
//        //location of the app
//        ConfigReader configReader = new ConfigReader();
//        File app = new File(System.getProperty("user.dir") + "\\app\\" + configReader.getApp());
//        if (configReader.getDeviceName().contains("emulator")) {
//            startEmulator();
//        }
//        DesiredCapabilities capability = new DesiredCapabilities();
//        capability.setCapability("browserstack.user", "aakashdahiya_Io8mHP");
//        capability.setCapability("browserstack.key", "CDzHs9yuqyDyGsoTHHdv");
//
//        // Set URL of the application under test
//        capability.setCapability("app", "bs://ae1865f352cc48681aed605bc8ac00e00c457ebd");
//        // Specify dev  ice and os_version for testing
//        capability.setCapability("device", "Google Pixel 3");
//        capability.setCapability("os_version", "9.0");
//        capability.setCapability("browserstack.idleTimeout", "300");
//        AndroidDriver driver = new AndroidDriver(
//                new URL("http://hub.browserstack.com/wd/hub"), capability);
//
////        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
////        Thread.sleep(3000);
//        System.out.println("App 2 Launched");
//
//
//        return  driver;
//    }
//
//
//    public static void getScreenshot(String s) throws IOException {
//        File scrfile = driver.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));
//
//    }
//
//
//
//
//}
