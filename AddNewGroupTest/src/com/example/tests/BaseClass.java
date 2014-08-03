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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	protected static String groupSelectedData;

	protected void gotoGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	protected void submitGroupCreation() {
	    driver.findElement(By.name("submit")).click();
	}

	protected void fillNewGroupForm(GroupData group) {
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupName);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void initNewGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

	protected void openGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	protected void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	protected void gotoHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}

	protected void createNewContact() {
		driver.findElement(By.name("submit")).click();
	}

	protected void contacstInfo(ContactData contactInfoData) {
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

	protected void addNewUserClick() {
		driver.findElement(By.linkText("add new")).click();
	}

}
