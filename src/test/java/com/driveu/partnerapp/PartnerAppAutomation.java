package com.driveu.partnerapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import com.driveu.partnerapp.HulkObject;
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

public class PartnerAppAutomation {

	AndroidDriver<MobileElement> driver;
	WebDriver webdriver;

	Dimension screenSize;
	
	DesiredCapabilities cap;
	SignInObject sign;
	LoginObject login;
	DashBoardObject dashboard;
	ReservedScreenObject reservedscreen;
	OnRouteScreenObject onroutescreen;
	ReachedScreenObject reachedscreen;
	OnGoingDriveObject ongoingscreen;
	SummaryScreenObject summaryscreen;
	DrawerMenuObject drawer;
	HistoryObject historyscreen;
	WalletObject walletdetails;

	@BeforeMethod
	public void capCheck() {
		try {// installing the app newly
			cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "500");
			cap.setCapability(MobileCapabilityType.APP, "/Users/durgadevi/Desktop/qa_driver.apk");
			cap.setCapability("app_package", "com.driveu.partner");
			cap.setCapability("app_activity", "com.driveu.partner.MainActivity");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void collectedFaretest() throws InterruptedException, IOException {
		summaryscreen = new SummaryScreenObject(driver);
		try {
			appFlow();
			
			Thread.sleep(3000);
			
			try {
				summaryscreen.collectfareok().click();// wallet money
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				summaryinput();//summary screen options 
				Thread.sleep(10000);
				swipeCollectedFare();// collect fare option in summary screen
			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(10000);
			drawerOption();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void payonlinetest() throws InterruptedException, IOException {
		summaryscreen = new SummaryScreenObject(driver);
		try {
			appFlow();
			
			summaryinput();//summary screen options 

			Thread.sleep(5000);
			swipeCheckIn();//customer pays online option in summary screen

			Thread.sleep(15000);

			HulkObject onlinePayment = new HulkObject(webdriver);
			onlinePayment.paymentonline();
			
			Thread.sleep(20000);

			summaryscreen.collectfareok().click();

			Thread.sleep(10000);
			drawerOption();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void appFlow() {
		try {
			
			dashboard = new DashBoardObject(driver);
			drawer = new DrawerMenuObject(driver);
			
			driver_signIn();
			Thread.sleep(10000);
			
			swipeCheckIn();
			
			Thread.sleep(3000);

			internetCheck();// Wifi off and on check

			Thread.sleep(20000);

			dashboard.hamMenu().click();

			hulkTest();

			Thread.sleep(20000);// waiting for booking
			drawer.currentBooking().click();
			try {
				dashboard.bookingList().click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver_reserved();
			Thread.sleep(3000);
			
			driver_onroute();
			Thread.sleep(5000);
			
			driver_reached();
			Thread.sleep(2000);
		
			driver_ongoing();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void driver_signIn(){
		sign = new SignInObject(driver);
		login = new LoginObject(driver);
		try {
			Thread.sleep(5000);
			sign.signInButton().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		login.driver_mobile().sendKeys("9036444804");
		login.driver_passcode().sendKeys("1234");
		try {
			login.driver_enter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void driver_reserved(){
		reservedscreen =  new ReservedScreenObject(driver);
		try{
			reservedscreen.reservedCalldispatch().click();
			Thread.sleep(3000);
			backEvent();
			Thread.sleep(20000);// time delay to swipe event
			swipeCheckIn();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void driver_onroute() throws InterruptedException{
		onroutescreen = new OnRouteScreenObject(driver);
		try{
			onroutescreen.onrouteCalldispatch().click();
			driver.startActivity("com.driveu.partner", "MainActivity");
			Thread.sleep(3000);
			onroutescreen.onrouteContactCustomer().click();
			driver.startActivity("com.driveu.partner", "MainActivity");
			Thread.sleep(10000);// time delay to swipe event
			swipeCheckIn();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void driver_reached(){
		reachedscreen = new ReachedScreenObject(driver);
		try{
			reachedscreen.reachedOkayPop().click();
			Thread.sleep(3000);
			driver.hideKeyboard();
			reachedscreen.regLater().click();
			Thread.sleep(5000);// time delay to swipe event
			swipeCheckIn();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void driver_ongoing(){
		ongoingscreen = new OnGoingDriveObject(driver);
		try{
			ongoingscreen.rnumtextstate().sendKeys("KA");
			ongoingscreen.rnumtextcityid().sendKeys("99");
			ongoingscreen.rnumtextalp().sendKeys("DD");
			ongoingscreen.rnumtextno().sendKeys("9999");
			driver.hideKeyboard();
			ongoingscreen.regSubmit().click();
			Thread.sleep(10000);// time delay to swipe event
			swipeCheckIn();
			Thread.sleep(3000);
			ongoingscreen.bookingTypeOne().click();
			ongoingscreen.bookingTypeRound().click();
			ongoingscreen.bookingTypeSubmit().click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void summaryinput() throws InterruptedException {
		summaryscreen = new SummaryScreenObject(driver);
		summaryscreen.rnumtextstate().sendKeys("KA");
		summaryscreen.rnumtextcityid().sendKeys("99");
		summaryscreen.rnumtextalp().sendKeys("DD");
		summaryscreen.rnumtextno().sendKeys("9999");

		driver.hideKeyboard();
		Thread.sleep(2000);
		summaryscreen.sumregsub().click();

		summaryscreen.summaryfarebreakup().click();
		Thread.sleep(2000);
		summaryscreen.fareokay().click();
	}
	
	private void drawer_history(){
		historyscreen = new HistoryObject(driver);
		try {
			historyscreen.historyList().click();
			historyscreen.hisTransactions().click();
			historyscreen.transactionClose().click();
			historyscreen.backImage().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void drawer_wallet(){
		walletdetails = new WalletObject(driver);
		walletdetails.walletTransaction().click();
		walletdetails.walletBalance().click();
	}

	private void drawerOption() {
		drawer = new DrawerMenuObject(driver);
		dashboard = new DashBoardObject(driver);

		dashboard.hamMenu().click();
		drawer.history().click();
		drawer_history();
		
		dashboard.hamMenu().click();
		drawer.wallet().click();
		drawer_wallet();
		
		dashboard.hamMenu().click();
		try{
			drawer.help().click();
			Thread.sleep(5000);
			driver.startActivity("com.driveu.partner", "MainActivity");
			Thread.sleep(10000);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		dashboard.hamMenu().click();
		try {
			drawer.checkOut().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dashboard.hamMenu().click();
		try {
			drawer.checkIn().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		drawer.signOut().click();
		

	}

	public void hulkTest() {
		try {
			HulkObject bookdriver = new HulkObject(webdriver);
			bookdriver.bookingassigndriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	private void internetCheck() throws IOException, InterruptedException {
		String line = "null";

		ProcessBuilder pbwOff = new ProcessBuilder("/Users/durgadevi/Library/Android/sdk/platform-tools/adb", "shell",
				"am", "start", "-n", "io.appium.settings/.Settings", "-e", "wifi", "off");
		Process pwOff = pbwOff.start();
		Thread.sleep(20000);

		BufferedReader bufwOff = new BufferedReader(new InputStreamReader(pwOff.getInputStream()));
		while ((line = bufwOff.readLine()) != null) {
			System.out.println(line);
		}
		System.out.print("Wifi off check completed");

		ProcessBuilder pbwOn = new ProcessBuilder("/Users/durgadevi/Library/Android/sdk/platform-tools/adb", "shell",
				"am", "start", "-n", "io.appium.settings/.Settings", "-e", "wifi", "on");
		Process pwOn = pbwOn.start();
		BufferedReader bufwOn = new BufferedReader(new InputStreamReader(pwOn.getInputStream()));
		while ((line = bufwOn.readLine()) != null) {
			System.out.println(line);
		}
		System.out.print("Wifi On check completed");

		ProcessBuilder pbdOff = new ProcessBuilder("/Users/durgadevi/Library/Android/sdk/platform-tools/adb", "shell",
				"am", "start", "-n", "io.appium.settings/.Settings", "-e", "data", "on");
		Process pdOff = pbdOff.start();
		Thread.sleep(20000);

		BufferedReader bufdOff = new BufferedReader(new InputStreamReader(pdOff.getInputStream()));
		while ((line = bufdOff.readLine()) != null) {
			System.out.println(line);
		}
		System.out.print("Data on check completed");

		ProcessBuilder pbdOn = new ProcessBuilder("/Users/durgadevi/Library/Android/sdk/platform-tools/adb", "shell",
				"am", "start", "-n", "io.appium.settings/.Settings", "-e", "data", "off");
		Process pdOn = pbdOn.start();
		BufferedReader bufdOn = new BufferedReader(new InputStreamReader(pdOn.getInputStream()));
		while ((line = bufdOn.readLine()) != null) {
			System.out.println(line);
		}
		System.out.print("Data off check completed");

	}
	

	public void swipeCheckIn() {
		screenSize = driver.manage().window().getSize();
		int startx = (int) (screenSize.width * 0.10);
		int endx = (int) (screenSize.width * 0.90);
		int starty = (int) (screenSize.height * 0.95);
		int endy = (int) (screenSize.height * 0.95);
		driver.swipe(startx, starty, endx, endy, 3000);
	}

	public void swipeCollectedFare() {
		screenSize = driver.manage().window().getSize();
		int startxcf = (int) (screenSize.width * 0.10);
		int endxcf = (int) (screenSize.width * 0.90);
		int startycf = (int) (screenSize.height * 0.85);
		int endycf = (int) (screenSize.height * 0.85);
		driver.swipe(startxcf, startycf, endxcf, endycf, 3000);
	}

	public void backEvent() {
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
}
