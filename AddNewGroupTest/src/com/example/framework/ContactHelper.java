package com.example.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createNewContact() {
		click(By.name("submit"));
	}

	public void addNewUserClick() {
		click(By.linkText("add new"));
	}

	public void contacstInfo(ContactData contactInfoData) {
		type(By.name("firstname"), contactInfoData.contactName);
		type(By.name("lastname"), contactInfoData.secondName);
		type(By.name("address"), contactInfoData.contactAdress);
		type(By.name("home"), contactInfoData.contactHomePhone);
		type(By.name("mobile"), contactInfoData.contactMobilePhone);
		type(By.name("work"), contactInfoData.contactWorkPhone);
		type(By.name("email"), contactInfoData.contactEmail1);
		type(By.name("email2"), contactInfoData.contactEmail2);
		selectByText(By.name("bday"), contactInfoData.contactBday);
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactInfoData.contactBmonth);
		type(By.name("byear"), contactInfoData.contactByear);
		new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactInfoData.selectGroup);
		type(By.name("address2"), contactInfoData.contactSecondaryAdress);
		type(By.name("phone2"), contactInfoData.contactSecondaryPhone);
	}


}
