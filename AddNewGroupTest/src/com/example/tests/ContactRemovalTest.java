package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTest extends BaseClass {

	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//get contacts
		List<ContactData> oldContactsList = app.getContactHelper().getContacts();
		
		//action
		app.getContactHelper().deleteContact(0);
		app.getNavigationHelper().gotoHomePage();
		
		//save new contacts at list
		List<ContactData> newContactsList = app.getContactHelper().getContacts();
		
		//asserts
		oldContactsList.remove(0);
		Collections.sort(oldContactsList);
		assertEquals(oldContactsList, newContactsList);
	}
	
}
