package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ReservedScreenObject {

	AndroidDriver<MobileElement> driver;
	public ReservedScreenObject(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	By reservedCalldispatch = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
	
	public WebElement reservedCalldispatch(){
		return driver.findElement(reservedCalldispatch);
	}
}
