package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModification extends BaseClass {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//get contacts
		List<ContactData> oldContactsList = app.getContactHelper().getContacts();
		
		//action
		app.getContactHelper().openContactPage(0);
		ContactData contact = new ContactData();
		contact.contactName = "Djohn";
		contact.secondName = "Lenon";
		app.getContactHelper().contacstInfo(contact);
		app.getContactHelper().applyContactModification();
		app.getNavigationHelper().gotoHomePage();
		
		//save new contacts at list
		List<ContactData> newContactsList = app.getContactHelper().getContacts();
		
		//asserts
		oldContactsList.remove(0);
		oldContactsList.add(contact);
		Collections.sort(oldContactsList);
		assertEquals(oldContactsList, newContactsList);
	}
	
}
