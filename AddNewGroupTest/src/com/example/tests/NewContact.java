package com.example.tests;

import java.util.Collections;
import java.util.List;
import static com.example.framework.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewContact extends BaseClass{

  @Test(dataProvider = "randomValidContactGenerator")
  public void testNewUserCreation(ContactData contactInfoData) throws Exception {
	//get contacts
	List<ContactData> oldContactsList = app.getContactHelper().getContacts();
	
	//action
	app.getContactHelper().createContact(contactInfoData);
	
	//save new contacts at list
	List<ContactData> newContactsList = app.getContactHelper().getContacts();
	
	//asserts
	oldContactsList.add(contactInfoData);
	Collections.sort(oldContactsList);
	Collections.sort(newContactsList);
	assertEquals(newContactsList, oldContactsList);
  }

}
