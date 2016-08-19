package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HistoryObject {
	AndroidDriver<MobileElement> driver;
	public HistoryObject(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	By historyList = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]");
	String hisTransactions = "new UiSelector().text(\"TRANSACTIONS\")";
	By backImage =By.className("android.widget.ImageView");
	String transactionClose = "new UiSelector().text(\"CLOSE\")";
	
	public WebElement historyList(){
		return driver.findElement(historyList);
	}
	
	public WebElement hisTransactions(){
		return driver.findElementByAndroidUIAutomator(hisTransactions);
	}
	
	public WebElement backImage(){
		return driver.findElement(backImage);
	}
	
	public WebElement transactionClose(){
		return driver.findElementByAndroidUIAutomator(transactionClose);
	}
}
