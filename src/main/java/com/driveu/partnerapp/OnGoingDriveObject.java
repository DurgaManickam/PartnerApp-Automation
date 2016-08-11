package com.driveu.partnerapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class OnGoingDriveObject {
	AndroidDriver driver;
	public OnGoingDriveObject(AndroidDriver driver){
		this.driver = driver;
	}
	By regNum = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[2]");
	By regSubmit = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]");
	By ongoingCallDispatch = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[1]"); 
	By ongoingContactCustomer = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[2]");
	By ongoingGetDirection = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[3]");
	By bookingTypeOne = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
	By bookingTypeRound = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]");
	By bookingTypeSubmit = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View[1]");
		
	By rnumtextstate = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]");
	By rnumtextcityid = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[2]");
	By rnumtextalp = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[3]");
	By rnumtextno = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[4]");
	
	
	
	
	
	public WebElement rnumtextstate(){
		return driver.findElement(rnumtextstate);
	}
	
	public WebElement rnumtextcityid(){
		return driver.findElement(rnumtextcityid);
	}
	
	public WebElement rnumtextalp(){
		return driver.findElement(rnumtextalp);
	}
	
	public WebElement rnumtextno(){
		return driver.findElement(rnumtextno);
	}
	
	public WebElement regNum() {
		return driver.findElement(regNum);
	}
	
	public WebElement regSubmit() {
		return driver.findElement(regSubmit);
	}
	
	public WebElement ongoingCallDispatch(){
		return driver.findElement(ongoingCallDispatch);
	}
	
	public WebElement ongoingContactCustomer(){
		return driver.findElement(ongoingContactCustomer);
	}
	
	public WebElement ongoingGetDirection(){
		return driver.findElement(ongoingGetDirection);
	}
	public WebElement bookingTypeOne() {
		return driver.findElement(bookingTypeOne);
	}
	
	public WebElement bookingTypeRound() {
		return driver.findElement(bookingTypeRound);
	}
	
	public WebElement bookingTypeSubmit() {
		return driver.findElement(bookingTypeSubmit);
	}

}
