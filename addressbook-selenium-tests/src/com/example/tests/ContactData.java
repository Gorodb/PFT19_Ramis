package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String id;
	private String contactName;
	private String secondName;
	private String contactAdress;
	private String contactHomePhone;
	private String contactMobilePhone;
	private String contactWorkPhone;
	private String contactEmail1;
	private String contactEmail2;
	private String contactBday;
	private String contactBmonth;
	private String contactByear;
	private String selectGroup;
	private String contactSecondaryAdress;
	private String contactSecondaryPhone;

	public ContactData() {
		this.contactName = contactName;
		this.secondName = secondName;
		this.contactAdress = contactAdress;
		this.contactHomePhone = contactHomePhone;
		this.contactMobilePhone = contactMobilePhone;
		this.contactWorkPhone = contactWorkPhone;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactBday = contactBday;
		this.contactBmonth = contactBmonth;
		this.contactByear = contactByear;
		this.selectGroup = selectGroup;
		this.contactSecondaryAdress = contactSecondaryAdress;
		this.contactSecondaryPhone = contactSecondaryPhone;
	}
	
	public String getContactName() {
		return contactName;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getContactAdress() {
		return contactAdress;
	}
	public String getContactHomePhone() {
		return contactHomePhone;
	}
	public String getContactMobilePhone() {
		return contactMobilePhone;
	}
	public String getContactWorkPhone() {
		return contactWorkPhone;
	}
	public String getContactEmail1() {
		return contactEmail1;
	}
	public String getContactEmail2() {
		return contactEmail2;
	}
	public String getContactBday() {
		return contactBday;
	}
	public String getContactBmonth() {
		return contactBmonth;
	}
	public String getContactByear() {
		return contactByear;
	}
	public String getSelectGroup() {
		return selectGroup;
	}
	public String getContactSecondaryAdress() {
		return contactSecondaryAdress;
	}
	public String getContactSecondaryPhone() {
		return contactSecondaryPhone;
	}
	
	@Override
	public String toString() {
		return "ContactData [contactName=" + contactName + ", secondName="
				+ secondName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		//result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.contactName.toLowerCase().compareTo(other.contactName.toLowerCase());
	}

	public ContactData withContactName(String name) {
		contactName = name;
		return this;
	}

	public ContactData withSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}

	public ContactData withContactAdress(String contactAdress) {
		this.contactAdress = contactAdress;
		return this;
	}

	public ContactData withContactHomePhone(String contactHomePhone) {
		this.contactHomePhone = contactHomePhone;
		return this;
	}

	public ContactData withContactMobilePhone(String contactMobilePhone) {
		this.contactMobilePhone = contactMobilePhone;
		return this;
	}

	public ContactData withContactWorkPhone(String contactWorkPhone) {
		this.contactWorkPhone = contactWorkPhone;
		return this;
	}

	public ContactData withContactEmail1(String contactEmail1) {
		this.contactEmail1 = contactEmail1;
		return this;
	}

	public ContactData withContactEmail2(String contactEmail2) {
		this.contactEmail2 = contactEmail2;
		return this;
	}

	public ContactData withContactBday(String contactBday) {
		this.contactBday = contactBday;
		return this;
	}

	public ContactData withContactBmonth(String contactBmonth) {
		this.contactBmonth = contactBmonth;
		return this;
	}

	public ContactData withContactByear(String contactByear) {
		this.contactByear = contactByear;
		return this;
	}

	public ContactData withContactSecondaryAdress(String contactSecondaryAdress) {
		this.contactSecondaryAdress = contactSecondaryAdress;
		return this;
	}

	public ContactData withContactSecondaryPhone(String contactSecondaryPhone) {
		this.contactSecondaryPhone = contactSecondaryPhone;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setContactAdress(String contactAdress) {
		this.contactAdress = contactAdress;
	}

	public void setContactHomePhone(String contactHomePhone) {
		this.contactHomePhone = contactHomePhone;
	}

	public void setContactMobilePhone(String contactMobilePhone) {
		this.contactMobilePhone = contactMobilePhone;
	}

	public void setContactWorkPhone(String contactWorkPhone) {
		this.contactWorkPhone = contactWorkPhone;
	}

	public void setContactEmail1(String contactEmail1) {
		this.contactEmail1 = contactEmail1;
	}

	public void setContactEmail2(String contactEmail2) {
		this.contactEmail2 = contactEmail2;
	}

	public void setContactBday(String contactBday) {
		this.contactBday = contactBday;
	}

	public void setContactBmonth(String contactBmonth) {
		this.contactBmonth = contactBmonth;
	}

	public void setContactByear(String contactByear) {
		this.contactByear = contactByear;
	}

	public void setSelectGroup(String selectGroup) {
		this.selectGroup = selectGroup;
	}

	public void setContactSecondaryAdress(String contactSecondaryAdress) {
		this.contactSecondaryAdress = contactSecondaryAdress;
	}

	public void setContactSecondaryPhone(String contactSecondaryPhone) {
		this.contactSecondaryPhone = contactSecondaryPhone;
	}
	
}