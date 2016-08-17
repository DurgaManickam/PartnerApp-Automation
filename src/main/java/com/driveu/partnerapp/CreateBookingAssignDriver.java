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


public class CreateBookingAssignDriver {
	WebDriver driver;
	static String bok;
	
	public CreateBookingAssignDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public void openhulk(){
		driver = new FirefoxDriver();
		driver.get("http://apps.driveubox.com/");
		driver.manage().timeouts().implicitlyWait(60L,TimeUnit.SECONDS);
	}
	
	public void loginauthen(){
		driver.findElement(By.xpath("//a[@href='/login/google-oauth2/']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("durga.m@driveu.in");
		driver.findElement(By.xpath("//input[@id='next']")).click();
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("123");
		
	
		driver.findElement(By.xpath("//input[@id='PersistentCookie']")).click();
		driver.findElement(By.xpath("//input[@id='signIn']")).click();
	}
	
	public void bookingassigndriver() {
		openhulk();
		
		loginauthen();
		
		driver.findElement(By.xpath("//strong[text()='Booking']")).click();
		driver.findElement(By.xpath("//a[@href='/app/create-booking/']")).click();
		
		WebElement address = driver.findElement(By.xpath("//input[@id='id_booking-pickup_address']"));
		address.sendKeys("white");
		List<WebElement> addresslist = driver.findElements(By.xpath("//div[@class='pac-item']"));
		addresslist.get(1).click();
		
		driver.findElement(By.xpath("//input[@id='id_booking-pickup_datetime']")).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", element);

		WebElement element1 = driver.findElement(By.xpath("//button[@class='xdsoft_prev']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", element1);

		WebElement element2 = driver.findElement(By.xpath("//button[@class='xdsoft_today_button']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", element2);

		WebElement element3 = driver.findElement(By.xpath("//button[@class='xdsoft_next']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].style.visibility='hidden'", element3);
		 
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d=new Date(System.currentTimeMillis()+10*60*1000);
		String newdatetime = df.format(d);
		System.out.println(newdatetime);
		
		 WebElement datetime = driver.findElement(By.xpath("//input[@id='id_booking-pickup_datetime']"));
		 datetime.sendKeys(newdatetime);
		 System.out.println(newdatetime);
		 datetime.sendKeys(Keys.TAB);
		 
		 WebElement loginmobile = driver.findElement(By.xpath("//input[@id='id_login-mobile']"));
		 loginmobile.sendKeys("9900151005");
		 loginmobile.sendKeys(Keys.TAB);
		  
		 WebElement loginname = driver.findElement(By.xpath("//input[@id='id_login-name']"));
		 loginname.sendKeys("Durga");
		 loginname.sendKeys(Keys.TAB);
		 
		 WebElement loginemail = driver.findElement(By.xpath("//input[@id='id_login-email']"));
		 loginemail.sendKeys("durga@driveu.in");
		 loginemail.sendKeys(Keys.TAB);
		 
		 WebElement logininvitecode = driver.findElement(By.xpath("//input[@id='id_login-invite_code']"));
		 logininvitecode.sendKeys(Keys.TAB);
		 
		 WebElement bookingins = driver.findElement(By.xpath("//input[@id='id_booking-instructions']"));
		 bookingins.sendKeys(Keys.TAB);
		 	 
		 WebElement foundus=driver.findElement(By.name("booking-found_us_through"));
		 Select sefoundus=new Select(foundus);
		 sefoundus.selectByIndex(1);
		 foundus.sendKeys(Keys.TAB);
		 
		 WebElement bookingbookingtype = driver.findElement(By.xpath("//select[@id='id_booking-booking_type']"));
		 Select sebookingbookingtype=new Select(bookingbookingtype);
		 sebookingbookingtype.selectByVisibleText("Round Trip");
		 bookingbookingtype.sendKeys(Keys.TAB);
		 
		 WebElement bookingcartype = driver.findElement(By.xpath("//select[@id='id_booking-car_type']"));
		 Select sebookingcartype=new Select(bookingcartype);
		 sebookingcartype.selectByIndex(6);
		 bookingcartype.sendKeys(Keys.TAB);
		 
		 driver.findElement(By.xpath("//button[@id='create_booking']")).click();
		 
		 driver.findElement(By.xpath("//a[text()='Select Action']")).click();
		 driver.findElement(By.xpath("//a[text()='Request Driver']")).click();
		 
		 driver.findElement(By.xpath("//strong[text()='Booking']")).click();
		 driver.findElement(By.xpath("//a[@href='/abs/driver-requests/']")).click();	 
		
		 SeleniumDatabase sa = new SeleniumDatabase();
		 sa.setUp();
		 bok = sa.getAppBookingDataBase();
		// sa.tearDown();	
		 
		 driver.findElement(By.xpath("//input[@class='form-control search-go']")).sendKeys(bok);
		 driver.findElement(By.xpath("//button[@class='btn btn-booking-status btn-danger']")).click();
		 
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
		 
		 driver.findElement(By.xpath("//a[@href='/accounts/logout/']")).click();
		 driver.close();

	}
	
	public void paymentonline() throws InterruptedException {
		System.out.println("paymennnnttttttt");
		System.out.println("Bokking Id::::"+bok);
		
		openhulk();
		
		loginauthen();
		
		Thread.sleep(3000);
         
        driver.get("http://apps.driveubox.com/app/bookings/?search_for=booking_id&q="+bok);
		driver.findElement(By.xpath("//button[@class='btn btn-booking-status btn-danger']")).click();
		 
		driver.findElement(By.xpath("//a[text()='Edit Fare']")).click();
		
	}

}



