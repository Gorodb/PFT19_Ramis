package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
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

	private static void saveContactsToXMLFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	public static List<ContactData> loadContactsFromXMLFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCSVFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(	contact.getContactName() + "," + contact.getSecondName() + "," + contact.getContactAdress() + "," + 
							contact.getContactHomePhone() + "," + contact.getContactMobilePhone() + "," + contact.getContactWorkPhone() + "," + 
							contact.getContactEmail1() + "," + contact.getContactEmail2() + "," + contact.getContactBday() + "," + 
							contact.getContactBmonth() + "," + contact.getContactByear() + "," + contact.getContactSecondaryAdress() + "," + 
							contact.getContactSecondaryPhone() + ",|" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCSVFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withContactName(part[0])
			.withSecondName(part[1])
			.withContactAdress(part[2])
			.withContactHomePhone(part[3])
			.withContactMobilePhone(part[4])
			.withContactWorkPhone(part[5])
			.withContactEmail1(part[6])
			.withContactEmail2(part[7])
			.withContactBday(part[8])
			.withContactBmonth(part[9])
			.withContactByear(part[10])
			.withContactSecondaryAdress(part[11])
			.withContactSecondaryPhone(part[12]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
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
