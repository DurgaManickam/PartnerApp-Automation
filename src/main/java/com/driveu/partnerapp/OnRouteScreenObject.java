package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OnRouteScreenObject {
	AndroidDriver<MobileElement> driver;
	public OnRouteScreenObject(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	By onrouteCalldispatch = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
	By onrouteContactCustomer = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[2]");
	By onrouteGetDirection = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[3]");
	
	public WebElement onrouteCalldispatch(){
		return driver.findElement(onrouteCalldispatch);
	}
	
	public WebElement onrouteContactCustomer(){
		return driver.findElement(onrouteContactCustomer);
	}
	
	
	public WebElement onrouteGetDirection(){
		return driver.findElement(onrouteGetDirection);
	}
	
}
