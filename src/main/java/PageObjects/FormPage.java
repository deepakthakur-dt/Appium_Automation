package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class FormPage {

    private AppiumDriver driver;


    public FormPage(AppiumDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement nameField;


    @AndroidFindBy(xpath = "//*[@text='Female']")
    public AndroidElement femaleOption;
    // driver.findElement(By.id("android:id/text1")).click();
    @AndroidFindBy(id = "android:id/text1")

    private AndroidElement countrySelection;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Argentina" +
            "\"))")
    AndroidElement element;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private AndroidElement letsShop;

    public AndroidElement getNameField() {
        System.out.println("trying to find the Name field");
        return (AndroidElement) nameField;
    }

    public AndroidElement getCountrySelection() {
        System.out.println("Selecting the option from dropdown");
        return (AndroidElement) countrySelection;
    }

    public AndroidElement getCountry() {
        System.out.println("Selecting the option from dropdown");
        return (AndroidElement) element;
    }

    public AndroidElement getLetsShop() {
        System.out.println("trying to find the Name field");
        return (AndroidElement) letsShop;
    }


}





