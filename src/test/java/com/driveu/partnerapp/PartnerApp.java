package com.driveu.partnerapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class PartnerApp {
	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1200);
		cap.setCapability(MobileCapabilityType.APP, "/Users/rohit/Desktop/driver.apk");
		cap.setCapability("app_package", "com.driveu.partner");
		cap.setCapability("app_activity", "com.driveu.partner.MainActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void highAccuracy() throws InterruptedException, IOException {
		Thread.sleep(10000);
		Runtime.getRuntime().exec(
				"/Users/rohit/Library/Android/sdk/platform-tools/adb shell settings put secure location_providers_allowed gps,network,wifi");
	}

	@Test(priority = 2)
	public void deviceOnly() throws InterruptedException, IOException {
		Thread.sleep(10000);
		Runtime.getRuntime().exec(
				"/Users/rohit/Library/Android/sdk/platform-tools/adb shell settings put secure location_providers_allowed gps");
	}

	@Test(priority = 3)
	public void batterySaving() throws InterruptedException, IOException {
		Thread.sleep(10000);
		Runtime.getRuntime().exec(
				"/Users/rohit/Library/Android/sdk/platform-tools/adb shell settings put secure location_providers_allowed wifi,network");
		Thread.sleep(10000);
		driver.runAppInBackground(60);
	}

	@Test(priority = 4)
	public void reboot() throws InterruptedException, IOException {
		Thread.sleep(10000);
		driver.closeApp();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("/Users/rohit/Library/Android/sdk/platform-tools/adb reboot");
		Thread.sleep(50000);
		Runtime.getRuntime()
				.exec("/Users/rohit/Library/Android/sdk/platform-tools/adb shell am start -n io.appium.unlock/.Unlock");
		Thread.sleep(5000);
		driver.quit();
		Thread.sleep(10000);
		LaunchApp();
	}

	@Test(priority = 5)
	public void disableGps() throws InterruptedException, IOException {
		Thread.sleep(10000);
		Runtime.getRuntime().exec(
				"/Users/rohit/Library/Android/sdk/platform-tools/adb shell settings put secure location_providers_allowed 'true'");
		Thread.sleep(10000);
	}

}
