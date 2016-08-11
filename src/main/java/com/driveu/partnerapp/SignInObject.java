package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SignInObject {

	AndroidDriver driver;
	public SignInObject(AndroidDriver driver){
		this.driver = driver;
	}
	By signInButton = By.xpath("//android.widget.TextView[contains(@text,'SIGN IN')]");
	
	public WebElement signInButton(){
		return driver.findElement(signInButton);
	}
}
