package com.driveu.partnerapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class LoginObject {

	AndroidDriver driver;
	public LoginObject(AndroidDriver driver){
		this.driver = driver;
	}
	
	By driver_mobile = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]");
	By driver_passcode = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[1]");
	By loginButton = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[5]/android.widget.TextView[1]");
	
	public WebElement driver_mobile(){
		return driver.findElement(driver_mobile);
	}
	
	public WebElement driver_passcode(){
		return driver.findElement(driver_passcode);
	}
	
	public void driver_enter(){
		driver.sendKeyEvent(AndroidKeyCode.ENTER);
	}
	
	public WebElement loginButton(){
		return driver.findElement(loginButton);
	}
	
	
	
}
	
	
	
