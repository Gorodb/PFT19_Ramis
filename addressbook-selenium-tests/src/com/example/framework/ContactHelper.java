package com.example.framework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cacheContacts;
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		addNewUserClick();
		contacstInfo(contact, CREATION);
		createNewContact();
		gotoHomePage();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		clickEditContact(index+1);
		submitContactDeletion();
		manager.navigateTo().gotoHomePage();
		return this;
	}

	public ContactHelper modifyContact(int index,ContactData contact) {
		manager.navigateTo().mainPage();
		initEditSomeContact(index);
		contacstInfo(contact, MODIFICATION);
		applyContactModification();
		gotoHomePage();
		return this;
	}

	public ContactHelper contacstInfo(ContactData contactInfoData, boolean formType) {
		type(By.name("firstname"), contactInfoData.getContactName());
		type(By.name("lastname"), contactInfoData.getSecondName());
		type(By.name("address"), contactInfoData.getContactAdress());
		type(By.name("home"), contactInfoData.getContactHomePhone());
		type(By.name("mobile"), contactInfoData.getContactMobilePhone());
		type(By.name("work"), contactInfoData.getContactWorkPhone());
		type(By.name("email"), contactInfoData.getContactEmail1());
		type(By.name("email2"), contactInfoData.getContactEmail2());
		selectByText(By.name("bday"), contactInfoData.getContactBday());
		selectByText(By.name("bmonth"), contactInfoData.getContactBmonth());
		type(By.name("byear"), contactInfoData.getContactByear());
		if (formType == CREATION) {
			selectByText(By.name("new_group"), contactInfoData.getSelectGroup()); //to modify
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}
		
		type(By.name("address2"), contactInfoData.getContactSecondaryAdress());
		type(By.name("phone2"), contactInfoData.getContactSecondaryPhone());
		return this;
	}
	
	/****
	 * Getting contacts list here
	 ****/

	public SortedListOf<ContactData> getUiContacts() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : rows) {
			String secondName = (row.findElement(By.xpath("//td[2]")).getText());
			String contactName = (row.findElement(By.xpath("//td[3]")).getText());
			cacheContacts.add(new ContactData()
				.withSecondName(secondName)
				.withContactName(contactName));
		}
		return contacts;
	}
	
	//*****************************************************************************//

	public void submitContactDeletion() {
		click(By.xpath("//input[@value = 'Delete']"));
	}
	
	private ContactHelper clickEditContact(int index) {
		click(By.xpath("//table[@id='maintable']//tr[" + (index+1) + "]//a/img[@title='Edit']"));
		return this;
	}

	public ContactHelper applyContactModification() {
		click(By.xpath("//input[@value = 'Update']"));
		return this;
	}

	public ContactHelper gotoHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initEditSomeContact(int index) {
		clickEditContact(index+1);
		return this;
	}

	public ContactHelper createNewContact() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper addNewUserClick() {
		click(By.linkText("add new"));
		return this;
	}

}
