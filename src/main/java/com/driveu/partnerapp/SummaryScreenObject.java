package com.driveu.partnerapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SummaryScreenObject {
	
	AndroidDriver<MobileElement> driver;
	
	public SummaryScreenObject(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	By summaryfarebreakup = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]");							
	String fareokay = "new UiSelector().text(\"OKAY\")";
	
	By summaryCallDispatch = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
	By summaryContactCustomer = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]");
	
	
	By rnumtextstate = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]");
	By rnumtextcityid = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[2]");
	By rnumtextalp = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[3]");
	By rnumtextno = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[4]");
	
	By sumregSub = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]");
	String collectfareok = "new UiSelector().text(\"Ok\")";
	
	public WebElement collectfareok(){
		return driver.findElementByAndroidUIAutomator(collectfareok);
	}
	
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
	
	public WebElement sumregsub(){
		return driver.findElement(sumregSub);
	}
	
	public WebElement summaryfarebreakup(){
		return driver.findElement(summaryfarebreakup);
	}

	public WebElement fareokay(){
		return driver.findElementByAndroidUIAutomator(fareokay);
	}
	
	public WebElement summaryCallDispatch(){
		return driver.findElement(summaryCallDispatch);
	}
	
	public WebElement summaryContactCustomer(){
		return driver.findElement(summaryContactCustomer);
	}
	
	
	
}
