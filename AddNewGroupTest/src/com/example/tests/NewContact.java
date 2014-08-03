package com.example.tests;

import org.testng.annotations.Test;

public class NewContact extends BaseClass{

  @Test
  public void testNewUserCreation() throws Exception {
	openMainPage();
	addNewUserClick();
	
	ContactData contactInfoData = new ContactData();
	contactInfoData.contactName = "Tester";
	contactInfoData.secondName = "Testerow";
	contactInfoData.contactAdress = "Testing city, tests street 18";
	contactInfoData.contactHomePhone = "8 (8422) 555555";
	contactInfoData.contactMobilePhone = "+7 955 5555555";
	contactInfoData.contactWorkPhone = "8 (8422) 999999";
	contactInfoData.contactEmail1 = "test-mail@gmail.com";
	contactInfoData.contactEmail2 = "test-e-mail@testdomen.com";
	contactInfoData.contactBday = "15";
	contactInfoData.contactBmonth = "November";
	contactInfoData.contactByear = "1988";
	contactInfoData.selectGroup = groupSelectedData;
	contactInfoData.contactSecondaryAdress = "Secondary adress for testing this textarea field";
	contactInfoData.contactSecondaryPhone = "Sweet dear home!";
	contacstInfo(contactInfoData);
	
	createNewContact(); 
	gotoHomePage();
  }

}
