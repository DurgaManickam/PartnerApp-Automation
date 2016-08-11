package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ReachedScreenObject {
	AndroidDriver driver;
	public ReachedScreenObject(AndroidDriver driver){
		this.driver = driver;
	}
	By reachedOkayPop = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]");
	By reachedCallDispatch = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
	By reachedContactCustomer = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[2]");
	By reachedGetDirection = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.view.View[3]");
	
	By regLater = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]");
	By regsub = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[4]/android.view.View[1]");
	
	
	public WebElement reachedOkayPop(){
		return driver.findElement(reachedOkayPop);
	}
	
	public WebElement reachedCallDispatch(){
		return driver.findElement(reachedCallDispatch);
	}
	
	public WebElement reachedContactCustomer(){
		return driver.findElement(reachedContactCustomer);
	}
	
	public WebElement reachedGetDirection(){
		return driver.findElement(reachedGetDirection);
	}
	
	public WebElement regLater(){
		return driver.findElement(regLater);
	}
	
	public WebElement regsub(){
		return driver.findElement(regsub);
	}
}
