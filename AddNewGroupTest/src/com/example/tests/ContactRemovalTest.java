package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactRemovalTest extends BaseClass {

	@Test
	public void deleteSomeContact() {
		//get contacts
		SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size() -1 );
		
		//action
		app.getContactHelper().deleteContact(index);
		
		//save new contacts at list
		SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts();
		
		//asserts
		assertThat(newContactsList, equalTo(oldContactsList.without(index)));
	}
	
}
