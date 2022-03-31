//package Base;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.concurrent.TimeUnit;
//
//import static java.sql.DriverManager.getConnection;
//
//public class BaseLib extends AppiumServer{
//    public static AppiumDriver driver;
//
//
//    public static void startEmulator() throws IOException, InterruptedException {
//
//        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\startEmulator.bat");
//        Thread.sleep(6000);
//    }
//
//    @BeforeTest
//    public void Init() throws Exception {
//
//        String host = "localhost";
//        String port = "3306";
//
//
//        //location of the app
//        ConfigReader configReader = new ConfigReader();
//
//        File app = new File(System.getProperty("user.dir") + "\\app\\" + configReader.getApp());
//
//        //To create an object of Desired Capabilities
//        if (configReader.getDeviceName().contains("emulator")) {
//            startEmulator();
//        }
//        Connection con = getConnection("jdbc:mysql://" + host + ":" + port + "/mobileautomation", "root", "admin");
//        Statement s = con.createStatement();
//        ResultSet rs=s.executeQuery("select * from mobileautomation");
//
//        while(rs.next()) {
//            DesiredCapabilities capability = new DesiredCapabilities();
//            capability.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//            capability.setCapability(MobileCapabilityType.DEVICE_NAME, rs.getString("DeviceName"));
//            System.out.println(rs.getString("DeviceName"));
//            capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, rs.getString("PlatformVersion"));
//            System.out.println(rs.getString("PlatformVersion"));
//            capability.setCapability(MobileCapabilityType.PLATFORM_NAME, rs.getString("PlatformName"));
//            System.out.println(rs.getString("PlatformName"));
//
//
////        capability.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getDeviceName());
////        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getPlatformVersion());
////        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.getPlatformName());
//            URL url = new URL(configReader.getUrl());
//            driver = new AppiumDriver(url, capability);
//
//            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//            Thread.sleep(3000);
//            System.out.println("App Launched");
//
//        }
//    }
//
//
//    public static void getScreenshot(String s) throws IOException {
//        File scrfile = driver.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));
//
//    }
//
//    @AfterTest
//    public void close() {
//        driver.quit();
//    }
//
//
//}