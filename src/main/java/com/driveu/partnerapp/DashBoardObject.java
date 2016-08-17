package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class DashBoardObject {
	
	AndroidDriver driver;
	Dimension screenSize ;
	public DashBoardObject(AndroidDriver driver){
		this.driver = driver;
	}
	By hamMenu = By.className("android.widget.ImageView");
	By bookingList = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]");
	By collectedfareok = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]");
	
	public WebElement hamMenu(){
		return driver.findElement(hamMenu);
	}
	
	public WebElement bookingList(){
		return driver.findElement(bookingList);
	}
	
	public WebElement collectedfareok() {
		return driver.findElement(collectedfareok);
	}
}
