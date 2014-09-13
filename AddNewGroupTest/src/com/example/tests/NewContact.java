package com.example.tests;

import java.util.Collections;
import static com.example.framework.ContactHelper.CREATION;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class NewContact extends BaseClass{

  @Test(dataProvider = "randomValidContactGenerator")
  public void testNewUserCreation(ContactData contact) throws Exception {
	//get contacts
	  SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContacts();
	
	//action
	app.getContactHelper().createContact(contact);
	
	//save new contacts at list
	SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts();
	
	//asserts
	assertThat(newContactsList, equalTo(oldContactsList.withAdded(contact)));
  }

}
