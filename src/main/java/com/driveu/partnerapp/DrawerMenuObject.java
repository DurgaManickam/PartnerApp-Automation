package com.driveu.partnerapp;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DrawerMenuObject {
	
	AndroidDriver<MobileElement> driver;
	public DrawerMenuObject(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	String driver_currentbooking = "new UiSelector().text(\"Current Booking\")";
	String driver_history = "new UiSelector().text(\"History\")";
	String driver_wallet = "new UiSelector().text(\"My Wallet\")";
	String driver_help = "new UiSelector().text(\"Help\")";
	String driver_checkin = "new UiSelector().text(\"Check In\")";
	String driver_checkout = "new UiSelector().text(\"Check Out\")";
	String driver_signout = "new UiSelector().text(\"Sign Out\")";
	
	public WebElement currentBooking(){
		return driver.findElementByAndroidUIAutomator(driver_currentbooking);
	}
	
	public WebElement history(){
		return driver.findElementByAndroidUIAutomator(driver_history);
	}
	
	public WebElement wallet(){
		return driver.findElementByAndroidUIAutomator(driver_wallet);
	}
	
	public WebElement help(){
		return driver.findElementByAndroidUIAutomator(driver_help);
	}
	
	public WebElement checkIn(){
		return driver.findElementByAndroidUIAutomator(driver_checkin);
	}
	
	public WebElement checkOut(){
		return driver.findElementByAndroidUIAutomator(driver_checkout);
	}
	
	public WebElement signOut(){
		return driver.findElementByAndroidUIAutomator(driver_signout);
	}
}
