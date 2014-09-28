package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.framework.Contact;

public class TestContactCreation extends BaseClass {

	@Test
	public void shouldCreateContactWithValidData() {
		Contact contact = new Contact().setFirstName("Tester").setLastName("Testerov");
		app.getContactHelper().createContact(contact);
		Contact created_contact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, created_contact);
	}

}
