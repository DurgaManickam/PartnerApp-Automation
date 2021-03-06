package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WalletObject {
	AndroidDriver<MobileElement> driver;
	public WalletObject(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	By walletTransaction = By.xpath("//android.widget.TextView[contains(@text,'TRANSACTIONS')]");
	By walletBalance = By.xpath("//android.widget.TextView[contains(@text,'BALANCE')]");
	
	public WebElement walletTransaction(){
		return driver.findElement(walletTransaction);
	}
	
	public WebElement walletBalance(){
		return driver.findElement(walletBalance);
	}
	
}
