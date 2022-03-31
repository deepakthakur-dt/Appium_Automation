package TestCases;

import Base.BaseParallel;
import PageObjects.FormPage;
import PageObjects.PaymentPage;
import PageObjects.ProductPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class CheckOutPageParallelTest extends BaseParallel {

    @Test
    public void test1() throws Exception {


        FormPage formPage = new FormPage(getDriver());
        Thread.sleep(2000);
        formPage.getNameField().sendKeys("hello");
        //driver.hideKeyboard();
        formPage.femaleOption.click();
        formPage.getCountrySelection().click();
        formPage.getCountry().click();
        formPage.getLetsShop().click();
        ProductPage productsPage = new ProductPage(getDriver());
        productsPage.getP1().click();
        productsPage.getP2().click();
        Thread.sleep(2000);
        productsPage.getCartButton().click();
        Thread.sleep(4000);
        int count = driver.get().findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;
        PaymentPage paymentPage = new PaymentPage(getDriver());
        for (int i = 0; i < count; i++) {
            String amount1 = paymentPage.getProductList().get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }
        System.out.println("sum of products:-" + sum);

        String total = paymentPage.totalAmount.getText();

        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
        System.out.println("Total value of products:-" + totalValue);
        Assert.assertEquals(sum, totalValue);


        WebElement checkbox = driver.get().findElement(By.className("android.widget.CheckBox"));

        TouchAction t = new TouchAction(getDriver());

        t.tap(tapOptions().withElement(element(checkbox))).perform();
        AndroidElement tc = (AndroidElement) driver.get().findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        t.longPress(new LongPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.get().findElement(By.id("android:id/button1")).click();
        driver.get().findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(7000);
    }



    @Test
    public void test2() throws Exception {

        Thread.sleep(2000);
        FormPage formPage = new FormPage(getDriver());
        Thread.sleep(2000);
        formPage.getNameField().sendKeys("hello");
        //driver.hideKeyboard();
        formPage.femaleOption.click();
        formPage.getCountrySelection().click();
        formPage.getCountry().click();
        formPage.getLetsShop().click();
        ProductPage productsPage = new ProductPage(getDriver());
        productsPage.getP1().click();
        productsPage.getP2().click();
        Thread.sleep(2000);
        productsPage.getCartButton().click();
        Thread.sleep(4000);
        int count = driver.get().findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;
        PaymentPage paymentPage = new PaymentPage(getDriver());
        for (int i = 0; i < count; i++) {
            String amount1 = paymentPage.getProductList().get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }
        System.out.println("sum of products:-" + sum);

        String total = paymentPage.totalAmount.getText();

        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
        System.out.println("Total value of products:-" + totalValue);
        Assert.assertEquals(sum, totalValue);


        WebElement checkbox = driver.get().findElement(By.className("android.widget.CheckBox"));

        TouchAction t = new TouchAction(getDriver());

        t.tap(tapOptions().withElement(element(checkbox))).perform();
        AndroidElement tc = (AndroidElement) driver.get().findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        t.longPress(new LongPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.get().findElement(By.id("android:id/button1")).click();
        driver.get().findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(7000);
    }

    public static double getAmount(String value) {
        value = value.substring(1);
        double amount2value = Double.parseDouble(value);
        return amount2value;


    }



}


