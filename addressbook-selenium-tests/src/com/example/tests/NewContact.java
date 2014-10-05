package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCSVFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class NewContact extends BaseClass{

@DataProvider	
public Iterator<Object[]> contactsFromFile() throws IOException {
	return wrapContactsForDataProvider(loadContactsFromCSVFile(new File("contacts.txt"))).iterator();
}
	
  @Test(dataProvider = "contactsFromFile")
  public void testNewUserCreation(ContactData contact) throws Exception {
	//get contacts
	  SortedListOf<ContactData> oldContactsList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts()); //app.getContactHelper().getContacts();
	
	//action
	app.getContactHelper().createContact(contact);
	
	//save new contacts at list
	SortedListOf<ContactData> newContactsList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts()); // app.getContactHelper().getContacts();
	
	//asserts
	assertThat(newContactsList, equalTo(oldContactsList.withAdded(contact)));
  }

}
