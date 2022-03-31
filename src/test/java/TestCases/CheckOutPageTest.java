//package TestCases;
//
//import Base.BaseLib;
//import PageObjects.FormPage;
//import PageObjects.PaymentPage;
//import PageObjects.ProductPage;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.touch.LongPressOptions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//import java.util.Set;
//
//import static io.appium.java_client.touch.TapOptions.tapOptions;
//import static io.appium.java_client.touch.offset.ElementOption.element;
//
//
//public class CheckOutPageTest extends BaseLib {
//
//    @Test
//    public void test1() throws Exception {
//
//
//        FormPage formPage = new FormPage(driver);
//        Thread.sleep(2000);
//        formPage.getNameField().sendKeys("hello");
//        //driver.hideKeyboard();
//        formPage.femaleOption.click();
//        formPage.getCountrySelection().click();
//        formPage.getCountry().click();
//        formPage.getLetsShop().click();
//        ProductPage productsPage = new ProductPage(driver);
//        productsPage.getP1().click();
//        productsPage.getP2().click();
//        productsPage.getCartButton().click();
//        Thread.sleep(4000);
//        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
//        double sum = 0;
//        PaymentPage paymentPage = new PaymentPage(driver);
//        for (int i = 0; i < count; i++) {
//            String amount1 = paymentPage.getProductList().get(i).getText();
//            double amount = getAmount(amount1);
//            sum = sum + amount;
//        }
//        System.out.println("sum of products:-" + sum);
//
//        String total = paymentPage.totalAmount.getText();
//
//        total = total.substring(1);
//        double totalValue = Double.parseDouble(total);
//        System.out.println("Total value of products:-" + totalValue);
//        Assert.assertEquals(sum, totalValue);
//
//
//        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
//
//        TouchAction t = new TouchAction(driver);
//
//        t.tap(tapOptions().withElement(element(checkbox))).perform();
//        AndroidElement tc = (AndroidElement) driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
//        t.longPress(new LongPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
//        driver.findElement(By.id("android:id/button1")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
//        Thread.sleep(7000);
//        Set<String> contexts = driver.getContextHandles();
//        for (String contextName : contexts) {
//            System.out.println(contextName);
//        }
//        driver.context("WEBVIEW_com.androidsample.generalstore");
//        AppiumDriver context = (AppiumDriver) driver.context("WEBVIEW_com.androidsample.generalstore");
//        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello");
//        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
//        driver.context("NATIVE_APP");
//        // ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
//
//
//        //driver.context("NATIVE_APP");
//
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
