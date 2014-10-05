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
	  SortedListOf<ContactData> oldContactsList = app.getModel().getContacts(); 
	
	//action
	app.getContactHelper().createContact(contact);
	
	//save new contacts at list
	SortedListOf<ContactData> newContactsList = app.getModel().getContacts(); 
	
	//asserts
	assertThat(newContactsList, equalTo(oldContactsList.withAdded(contact)));
    //if (wantToCheck()) {
        if ("yes".equals(app.getProperty("check.db"))) {
            assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));	
        }
        if ("yes".equals(app.getProperty("check.ui"))) {
            assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));   
        }
    //}
  }

}
