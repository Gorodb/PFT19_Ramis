package com.example.tests;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewContact extends BaseClass{

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	@AfterClass
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
  @Test
  public void testNewUserCreation() throws Exception {
	openMainPage();
	addNewUserClick();
	
	ContactData contactInfoData = new ContactData();
	contactInfoData.contactName = "Tester";
	contactInfoData.secondName = "Testerow";
	contactInfoData.contactAdress = "Testing city, tests street 18";
	contactInfoData.contactHomePhone = "8 (8422) 555555";
	contactInfoData.contactMobilePhone = "+7 955 5555555";
	contactInfoData.contactWorkPhone = "8 (8422) 999999";
	contactInfoData.contactEmail1 = "test-mail@gmail.com";
	contactInfoData.contactEmail2 = "test-e-mail@testdomen.com";
	contactInfoData.contactBday = "15";
	contactInfoData.contactBmonth = "November";
	contactInfoData.contactByear = "1988";
	contactInfoData.selectGroup = "Group 1";
	contactInfoData.contactSecondaryAdress = "Secondary adress for testing this textarea field";
	contactInfoData.contactSecondaryPhone = "Sweet dear home!";
	contacstInfo(contactInfoData);
	
	createNewContact(); 
	gotoHomePage();
  }

protected void openMainPage() {
    driver.get(baseUrl + "/addressbookv4.1.4/");
}
  
  
private void gotoHomePage() {
	driver.findElement(By.linkText("home page")).click();
}

private void createNewContact() {
	driver.findElement(By.name("submit")).click();
}

private void contacstInfo(ContactData contactInfoData) {
	driver.findElement(By.name("firstname")).clear();
	driver.findElement(By.name("firstname")).sendKeys(contactInfoData.contactName);
	driver.findElement(By.name("lastname")).clear();
	driver.findElement(By.name("lastname")).sendKeys(contactInfoData.secondName);
	driver.findElement(By.name("address")).clear();
	driver.findElement(By.name("address")).sendKeys(contactInfoData.contactAdress);
	driver.findElement(By.name("home")).clear();
	driver.findElement(By.name("home")).sendKeys(contactInfoData.contactHomePhone);
	driver.findElement(By.name("mobile")).clear();
	driver.findElement(By.name("mobile")).sendKeys(contactInfoData.contactMobilePhone);
	driver.findElement(By.name("work")).clear();
	driver.findElement(By.name("work")).sendKeys(contactInfoData.contactWorkPhone);
	driver.findElement(By.name("email")).clear();
	driver.findElement(By.name("email")).sendKeys(contactInfoData.contactEmail1);
	driver.findElement(By.name("email2")).clear();
	driver.findElement(By.name("email2")).sendKeys(contactInfoData.contactEmail2);
	new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactInfoData.contactBday);
	new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactInfoData.contactBmonth);
	driver.findElement(By.name("byear")).clear();
	driver.findElement(By.name("byear")).sendKeys(contactInfoData.contactByear);
	new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactInfoData.selectGroup);
	driver.findElement(By.name("address2")).clear();
	driver.findElement(By.name("address2")).sendKeys(contactInfoData.contactSecondaryAdress);
	driver.findElement(By.name("phone2")).clear();
	driver.findElement(By.name("phone2")).sendKeys(contactInfoData.contactSecondaryPhone);
}

private void addNewUserClick() {
	driver.findElement(By.linkText("add new")).click();
}

}
