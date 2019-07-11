package mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class Basics {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = MobileT.capabilities();

    }

}
