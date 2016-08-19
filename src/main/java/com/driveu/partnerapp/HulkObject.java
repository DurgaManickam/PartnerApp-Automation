package com.driveu.partnerapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class HulkObject {
	WebDriver driver;
	static String bookingid;
	String fareamount;
	static SeleniumDatabase sa;

	public HulkObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openhulk() {
		driver = new FirefoxDriver();
		driver.get("http://apps.driveubox.com/");
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
	}

	public void loginauthen() {
		driver.findElement(By.xpath("//a[@href='/login/google-oauth2/']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("durga.m@driveu.in");
		driver.findElement(By.xpath("//input[@id='next']")).click();
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("durgaDivya1194");
		driver.findElement(By.xpath("//input[@id='PersistentCookie']")).click();
		driver.findElement(By.xpath("//input[@id='signIn']")).click();
	}

	public void booking_pickup_address() {
		WebElement address = driver.findElement(By.xpath("//input[@id='id_booking-pickup_address']"));
		address.sendKeys("white");
		List<WebElement> addresslist = driver.findElements(By.xpath("//div[@class='pac-item']"));
		addresslist.get(1).click();
	}

	public void booking_pickup_datetime() {
		driver.findElement(By.xpath("//input[@id='id_booking-pickup_datetime']")).click();
		WebElement datetimepicker = driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", datetimepicker);

		WebElement dateprevbutton = driver.findElement(By.xpath("//button[@class='xdsoft_prev']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", dateprevbutton);

		WebElement datetoday = driver.findElement(By.xpath("//button[@class='xdsoft_today_button']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", datetoday);

		WebElement datenextbutton = driver.findElement(By.xpath("//button[@class='xdsoft_next']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", datenextbutton);

		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date(System.currentTimeMillis() + 10 * 60 * 1000);
		String newdatetime = dateformat.format(date);
		System.out.println(newdatetime);

		WebElement datetime = driver.findElement(By.xpath("//input[@id='id_booking-pickup_datetime']"));
		datetime.sendKeys(newdatetime);
		System.out.println(newdatetime);
		datetime.sendKeys(Keys.TAB);
	}

	public void booking_userdetails() {
		WebElement loginmobile = driver.findElement(By.xpath("//input[@id='id_login-mobile']"));
		loginmobile.sendKeys("9900151005");
		loginmobile.sendKeys(Keys.TAB);

		WebElement loginname = driver.findElement(By.xpath("//input[@id='id_login-name']"));
		loginname.sendKeys("Durga");
		loginname.sendKeys(Keys.TAB);

		WebElement loginemail = driver.findElement(By.xpath("//input[@id='id_login-email']"));
		loginemail.sendKeys("durga@driveu.in");
		loginemail.sendKeys(Keys.TAB);
	}

	public void booking_other_spec() {
		WebElement logininvitecode = driver.findElement(By.xpath("//input[@id='id_login-invite_code']"));
		logininvitecode.sendKeys(Keys.TAB);

		WebElement bookingins = driver.findElement(By.xpath("//input[@id='id_booking-instructions']"));
		bookingins.sendKeys(Keys.TAB);

		WebElement foundus = driver.findElement(By.name("booking-found_us_through"));
		Select sefoundus = new Select(foundus);
		sefoundus.selectByIndex(1);
		foundus.sendKeys(Keys.TAB);
	}

	public void booking_booking_car_type() {
		WebElement booking_bookingtype = driver.findElement(By.xpath("//select[@id='id_booking-booking_type']"));
		Select sebookingbookingtype = new Select(booking_bookingtype);
		sebookingbookingtype.selectByVisibleText("Round Trip");
		booking_bookingtype.sendKeys(Keys.TAB);

		WebElement booking_cartype = driver.findElement(By.xpath("//select[@id='id_booking-car_type']"));
		Select sebookingcartype = new Select(booking_cartype);
		sebookingcartype.selectByIndex(6);
		booking_cartype.sendKeys(Keys.TAB);
	}

	public void request_driver() {
		driver.findElement(By.xpath("//button[@id='create_booking']")).click();

		driver.findElement(By.xpath("//a[text()='Select Action']")).click();
		driver.findElement(By.xpath("//a[text()='Request Driver']")).click();

		driver.findElement(By.xpath("//strong[text()='Booking']")).click();
		driver.findElement(By.xpath("//a[@href='/abs/driver-requests/']")).click();
	}

	public void assign_driver() {
		driver.findElement(By.xpath("//a[text()='Select Action']")).click();
		driver.findElement(By.xpath("//a[text()='Assign driver']")).click();
		driver.findElement(By.xpath("//span[@class='input-group-addon dropdown-toggle']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("9");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("0");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("6");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("0");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("4");
		driver.findElement(By.xpath("//li[@class='active']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block center-block submit-btn-center']")).click();

	}

	public void create_booking() {
		openhulk();//opens the hulk
		loginauthen();//google login authentication

		driver.findElement(By.xpath("//strong[text()='Booking']")).click();
		driver.findElement(By.xpath("//a[@href='/app/create-booking/']")).click();

		booking_pickup_address();
		booking_pickup_datetime();
		booking_userdetails();
		booking_other_spec();//login invite code,booking ins,found us through
		booking_booking_car_type();//booking and car type 

		request_driver();
	}

	public void bookingassigndriver() {

		create_booking();//booking creation 

		sa = new SeleniumDatabase();
		sa.setUp();
		bookingid = sa.getAppBookingDataBase();

		driver.findElement(By.xpath("//input[@class='form-control search-go']")).sendKeys(bookingid);
		driver.findElement(By.xpath("//button[@class='btn btn-booking-status btn-danger']")).click();

		assign_driver();//assigning the driver

		driver.findElement(By.xpath("//a[@href='/accounts/logout/']")).click();
		driver.close();

	}

	public void paymentonline() throws InterruptedException {

		System.out.println("Bokking Id:" + bookingid);
		openhulk();
		loginauthen();
		
		Thread.sleep(3000);

		driver.get("http://apps.driveubox.com/app/bookings/?search_for=booking_id&q=" + bookingid);
		driver.findElement(By.xpath("//button[@class='btn btn-booking-status btn-danger']")).click();
		driver.findElement(By.xpath("//a[text()='Edit Fare']")).click();
		fareamount = sa.getBookingFare();
		System.out.println(fareamount);
		driver.findElement(By.xpath("//input[@id='id_amount_paid']")).sendKeys(fareamount);
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block center-block submit-btn-center']")).click();
		driver.close();
	}

}
