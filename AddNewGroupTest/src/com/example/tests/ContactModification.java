package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;
import static com.example.framework.ContactHelper.MODIFICATION;

public class ContactModification extends BaseClass {
	
	@Test
	public void modifySomeContact(ContactData contact) {
		//get contacts
		List<ContactData> oldContactsList = app.getContactHelper().getContacts();

	    Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size()-1);
	    
		//action
	    app.getContactHelper().modifyContact(index, contact);
		
		//save new contacts at list
		List<ContactData> newContactsList = app.getContactHelper().getContacts();
		
		//asserts
		oldContactsList.remove(0);
		oldContactsList.add(contact);
		Collections.sort(oldContactsList);
		assertEquals(oldContactsList, newContactsList);
	}
	
}
