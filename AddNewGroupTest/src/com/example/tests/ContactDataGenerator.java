package com.example.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCSVFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXMLFile(contacts, file);	
		} else {
			System.out.println("Unknown format: " + format);
			return;
		}

	}

	private static void saveContactsToXMLFile(List<ContactData> contacts, File file) {
		// TODO Auto-generated method stub
		
	}

	private static void saveContactsToCSVFile(List<ContactData> contacts, File file) {
		// TODO Auto-generated method stub
		
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i=0; i<amount; i++) {
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
			list.add(contact);
		}
		return list;
	}

	public static String generateRandomContactString(String name, int task) {
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
