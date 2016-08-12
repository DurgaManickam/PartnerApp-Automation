package com.driveu.partnerapp;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import com.driveu.partnerapp.CreateBookingAssignDriver;
import com.driveu.partnerapp.DashBoardObject;
import com.driveu.partnerapp.DrawerMenuObject;
import com.driveu.partnerapp.HistoryObject;
import com.driveu.partnerapp.LoginObject;
import com.driveu.partnerapp.OnGoingDriveObject;
import com.driveu.partnerapp.OnRouteScreenObject;
import com.driveu.partnerapp.ReachedScreenObject;
import com.driveu.partnerapp.ReservedScreenObject;
import com.driveu.partnerapp.SignInObject;
import com.driveu.partnerapp.SummaryScreenObject;
import com.driveu.partnerapp.WalletObject;

public class PartnerAppJunitTest {

	AndroidDriver driver;
	WebDriver webdriver;
	
	Dimension screenSize;
	
	@BeforeMethod
	public void capCheck(){
		try{//installing newly
			DesiredCapabilities cap = new DesiredCapabilities();
		    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "500");
		    cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.driveu.partner");
		    cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.driveu.partner.MainActivity");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			driver.manage().timeouts().implicitlyWait(60L,TimeUnit.SECONDS);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		
		SignInObject sign = new SignInObject(driver);
		LoginObject login = new LoginObject(driver);
		DashBoardObject dashboard = new DashBoardObject(driver);
		DrawerMenuObject drawer = new DrawerMenuObject(driver);
		HistoryObject historylist = new HistoryObject(driver);
		WalletObject walletdetails = new WalletObject(driver);
		ReservedScreenObject reservedscreen = new ReservedScreenObject(driver);
		OnRouteScreenObject onroutescreen = new OnRouteScreenObject(driver);
		ReachedScreenObject reachedscreen = new ReachedScreenObject(driver);
		OnGoingDriveObject ongoingscreen = new OnGoingDriveObject(driver);
		SummaryScreenObject summaryscreen = new SummaryScreenObject(driver);
		
		try{
			sign.signInButton().click();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		login.driver_mobile().sendKeys("9036444804");
		login.driver_passcode().sendKeys("1234");
		try{
			login.driver_enter();
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			login.loginButton().click();
		}catch (Exception e) {
			e.printStackTrace();
		}		

		Thread.sleep(10000);
		swipeCheckIn();
		dashboard.hamMenu().click();
		
		CreateBookingAssignDriver cb = new CreateBookingAssignDriver(webdriver);
		cb.cbad();
		
		Thread.sleep(20000);//waiting for booking
		drawer.currentBooking().click();
		
		try{
			dashboard.bookingList().click();
		}catch (Exception e) {
			e.printStackTrace();
		}
		reservedscreen.reservedCalldispatch().click();
		driver.startActivity("com.driveu.partner", "MainActivity");
		Thread.sleep(20000);//time delay to swipe event
		swipeCheckIn();
		Thread.sleep(3000);
		onroutescreen.onrouteCalldispatch().click();
		driver.startActivity("com.driveu.partner", "MainActivity");
		Thread.sleep(3000);
			//backEvent();
		onroutescreen.onrouteContactCustomer().click();
		driver.startActivity("com.driveu.partner", "MainActivity");
			//backEvent();
		Thread.sleep(10000);//time delay to swipe event
		swipeCheckIn();
		Thread.sleep(5000);
		reachedscreen.reachedOkayPop().click();
		Thread.sleep(3000);
		driver.hideKeyboard();
		reachedscreen.regLater().click();
		Thread.sleep(3000);
		
		reachedscreen.reachedCallDispatch().click();
			backEvent();
		reachedscreen.reachedContactCustomer().click();
			backEvent();
		Thread.sleep(10000);//time delay to swipe event
		swipeCheckIn();
		
		Thread.sleep(2000);
		ongoingscreen.rnumtextstate().sendKeys("KA");
		ongoingscreen.rnumtextcityid().sendKeys("99");
		ongoingscreen.rnumtextalp().sendKeys("DD");
		ongoingscreen.rnumtextno().sendKeys("9999");
		driver.hideKeyboard();
		ongoingscreen.regSubmit().click();
		
		ongoingscreen.ongoingCallDispatch().click();
			backEvent();
		ongoingscreen.ongoingContactCustomer().click();
			backEvent();
		Thread.sleep(10000);//time delay to swipe event
		swipeCheckIn();
		Thread.sleep(3000);
		ongoingscreen.bookingTypeOne().click();
		ongoingscreen.bookingTypeRound().click();
		ongoingscreen.bookingTypeSubmit().click();
		Thread.sleep(2000);
		
		try{
			summaryscreen.rnumtextstate().sendKeys("KA");
			summaryscreen.rnumtextcityid().sendKeys("99");
			summaryscreen.rnumtextalp().sendKeys("DD");
			summaryscreen.rnumtextno().sendKeys("9999");
			
			summaryscreen.sumregsub().click();
			
			summaryscreen.summaryfarebreakup().click();
			Thread.sleep(2000);
			summaryscreen.farebreakupok().click();
			Thread.sleep(2000);
			summaryscreen.summaryCallDispatch().click();
			Thread.sleep(2000);
			backEvent();
			summaryscreen.summaryContactCustomer().click();
			Thread.sleep(2000);
			backEvent();
			Thread.sleep(15000);
			swipeCollectedFare();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Thread.sleep(5000);
		dashboard.hamMenu().click();
		drawer.history().click();
		try{
			historylist.historyList().click();
			historylist.hisTransactions().click();
			historylist.transactionClose().click();
			historylist.backImage().click();
		}catch(Exception e){
			e.printStackTrace();
		}
		dashboard.hamMenu().click();
		drawer.wallet().click();
		walletdetails.walletTransaction().click();
		walletdetails.walletBalance().click();
		dashboard.hamMenu().click();
		drawer.help().click();
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		dashboard.hamMenu().click();
		try{
			drawer.checkOut().click();
		}catch(Exception e){
			e.printStackTrace();
		}
		dashboard.hamMenu().click();
		try{
			drawer.checkIn().click();
		}catch(Exception e){
			e.printStackTrace();
		}
		drawer.signOut().click();
		driver.closeApp();
		

	}
	public void swipeCheckIn(){
		screenSize= driver.manage().window().getSize();
		int startx = (int) (screenSize.width * 0.10);
		int endx = (int) (screenSize.width * 0.90);
		int starty = (int)(screenSize.height * 0.95);
		int endy = (int) (screenSize.height * 0.95);
	    driver.swipe(startx,starty , endx, endy, 3000);
	}
	public void swipeCollectedFare(){
		screenSize= driver.manage().window().getSize();
		int startxcf = (int) (screenSize.width * 0.10);
		int endxcf = (int) (screenSize.width * 0.90);
		int startycf = (int)(screenSize.height * 0.85);
		int endycf = (int) (screenSize.height * 0.85);
	    driver.swipe(startxcf,startycf , endxcf, endycf, 3000);
	}
	public void backEvent(){
		driver.sendKeyEvent(AndroidKeyCode.BACK);
	}
}
