package com.example.framework;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		selectByText(By.name("bmonth"), contactInfoData.contactBmonth);
		type(By.name("byear"), contactInfoData.contactByear);
		selectByText(By.name("new_group"), contactInfoData.selectGroup); //to modify
		type(By.name("address2"), contactInfoData.contactSecondaryAdress);
		type(By.name("phone2"), contactInfoData.contactSecondaryPhone);
	}

	private void clickEditContact(int index) {
		click(By.xpath("//table[@id='maintable']//tr[" + (index+1) + "]//a/img[@title='Edit']"));
	}

	public void applyContactModification() {
		click(By.xpath("//input[@value = 'Update']"));
	}
	
	public void deleteContact(int index) {
		clickEditContact(index+1);
		click(By.xpath("//input[@value = 'Delete']"));
	}

	public void openContactPage(int index) {
		clickEditContact(index+1);
	}
	/****
	 * Getting contacts list here
	 ****/
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : rows) {
			ContactData contact = new ContactData();
			contact.secondName = (row.findElement(By.xpath("//td[2]")).getText());
			contact.contactName = (row.findElement(By.xpath("//td[3]")).getText());
		    contacts.add(contact);
		}
		return contacts;
	}

}
