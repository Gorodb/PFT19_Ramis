package com.example.tests;

import org.testng.annotations.Test;

public class ContactModification extends BaseClass {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openContactPage(1);
		ContactData contact = new ContactData();
		contact.contactName = "Djohn";
		contact.secondName = "Lenon";
		app.getContactHelper().contacstInfo(contact);
		app.getContactHelper().applyContactModification();
		app.getNavigationHelper().gotoHomePage();
	}
	
}
