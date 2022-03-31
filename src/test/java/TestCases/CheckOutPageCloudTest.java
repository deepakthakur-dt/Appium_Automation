//package TestCases;
//
////import Base.BaseCloud;
//
////import Base.BaseCloud;
//import PageObjects.FormPageCloud;
//import PageObjects.PaymentPageCloud;
//import PageObjects.ProductPageCloud;
//import io.appium.java_client.PerformsTouchActions;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.touch.LongPressOptions;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//import static io.appium.java_client.touch.TapOptions.tapOptions;
//import static io.appium.java_client.touch.offset.ElementOption.element;
//
//
//public class CheckOutPageCloudTest extends BaseCloud {
//
//    @Test
//    public void test1() throws Exception {
//
//        AndroidDriver driver;
//        driver =  runCap(true);
//        FormPageCloud formPageCloud = new FormPageCloud( driver);
//        Thread.sleep(2000);
//        formPageCloud.getNameField().sendKeys("hello");
//        //driver.hideKeyboard();
//        formPageCloud.femaleOption.click();
//        formPageCloud.getCountrySelection().click();
//        formPageCloud.getCountry().click();
//        formPageCloud.getLetsShop().click();
//        ProductPageCloud productsPageCloud = new ProductPageCloud(driver);
//        productsPageCloud.getP1().click();
//        productsPageCloud.getP2().click();
//        productsPageCloud.getCartButton().click();
//        Thread.sleep(4000);
//        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
//        double sum = 0;
//        PaymentPageCloud paymentPageCloud = new PaymentPageCloud(driver);
//        for (int i = 0; i < count; i++) {
//            String amount1 = paymentPageCloud.getProductList().get(i).getText();
//            double amount = getAmount(amount1);
//            sum = sum + amount;
//        }
//        System.out.println("sum of products:-" + sum);
//
//        String total = paymentPageCloud.totalAmount.getText();
//
//        total = total.substring(1);
//        double totalValue = Double.parseDouble(total);
//        System.out.println("Total value of products:-" + totalValue);
//        Assert.assertEquals(sum, totalValue);
//
//
//        AndroidElement checkbox = (AndroidElement) driver.findElement(By.className("android.widget.CheckBox"));
//
//        TouchAction t = new TouchAction((PerformsTouchActions) driver);
//
//        t.tap(tapOptions().withElement(element(checkbox))).perform();
//        AndroidElement tc = (AndroidElement) driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
//        t.longPress(new LongPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
//        driver.findElement(By.id("android:id/button1")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
//    }
//
//    public static double getAmount(String value) {
//        value = value.substring(1);
//        double amount2value = Double.parseDouble(value);
//        return amount2value;
//
//
//    }
//
//
//}
//
//
