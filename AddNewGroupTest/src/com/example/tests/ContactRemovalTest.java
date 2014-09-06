package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTest extends BaseClass {

	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//get contacts
		List<ContactData> oldContactsList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size()-1);
		
		//action
		app.getContactHelper().deleteContact(index);
		app.getNavigationHelper().gotoHomePage();
		
		//save new contacts at list
		List<ContactData> newContactsList = app.getContactHelper().getContacts();
		
		//asserts
		oldContactsList.remove(0);
		Collections.sort(oldContactsList);
		assertEquals(oldContactsList, newContactsList);
	}
	
}
