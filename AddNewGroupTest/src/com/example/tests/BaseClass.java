package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.framework.ApplicationManager;

public class BaseClass {
	
	protected static String groupSelectedData;
	
	protected static ApplicationManager app;
	
	@BeforeTest
	public void setUp() throws Exception {
	    app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	/****
	 * Random group generator
	 ****/
	
	@DataProvider	
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++) {
			GroupData group = new GroupData()
				.withName(generateRandomString("Umma "))
				.withHeader(generateRandomString("Mila "))
				.wuthFooter(generateRandomString("Angelina "));
			//group.groupName=generateRandomString("Umma ");
			//group.header=generateRandomString("Mila ");
			//group.footer=generateRandomString("Angelina ");
			list.add(new Object[]{group});
		}
		return list.iterator();
	  }

	public String generateRandomString(String name) {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {
			return (name + rnd.nextInt());
		}
	}
	
	/****
	 * Random contacts generator
	 ****/

	@DataProvider	
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<1; i++) {
			ContactData contact = new ContactData()
				.withContactName(generateRandomContactString("Umma", 0))
				.withSecondName(generateRandomContactString("Mila", 0))
				.withContactAdress(generateRandomContactString("Angelina ", 0))
				.withContactHomePhone(generateRandomContactString("8 (8422) ", 1))
				.withContactMobilePhone(generateRandomContactString("Angelina ", 2))
				.withContactWorkPhone(generateRandomContactString("8 (8422) ", 1))
				.withContactEmail1(generateRandomContactString("AngelinasMail", 3))
				.withContactEmail2(generateRandomContactString("MilasMail", 3))
				.withContactBday("4")
				.withContactBmonth("July")
				.withContactByear(generateRandomContactString("", 6))
				.withContactSecondaryAdress(generateRandomContactString("Angelina ", 0))
				.withContactSecondaryPhone(generateRandomContactString("8 (8422) ", 1));
			list.add(new Object[]{contact});
		}
		return list.iterator();
	  }

	public String generateRandomContactString(String name, int task) {
		Random rnd = new Random();
		if (rnd.nextInt(10) == 0) {
			return "";
		} 
		else {
			String outData = "";
			if (task == 0) {outData = (name + rnd.nextInt());}
			if (task == 1) {outData = (name + rnd.nextInt(99) + "-" + rnd.nextInt(99) + "-" + rnd.nextInt(99));}
			if (task == 2) {outData = (name + rnd.nextInt(9999999));}
			if (task == 3) {outData = (name + "@" + rnd.nextInt() + ".com");}
			if (task == 4) {outData = (name + (rnd.nextInt(30)+1));}
			if (task == 5) {outData = (name);} // it could be mass in the future
			if (task == 6) {outData = (name + rnd.nextInt(9999));}
			return outData;
		}
	}
	
}
