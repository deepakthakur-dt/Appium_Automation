package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPageCloud {
    private RemoteWebDriver driver;

    public ProductPageCloud(AndroidDriver driver) {

        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    public AndroidElement P1;


    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    public AndroidElement P2;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public AndroidElement CartButton;

    public AndroidElement getP1() {
        return P1;
    }

    public AndroidElement getP2() {
        return P2;
    }

    public AndroidElement getCartButton() {
        return CartButton;
    }

}
