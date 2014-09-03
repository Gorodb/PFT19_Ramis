package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String contactName;
	public String secondName;
	public String contactAdress;
	public String contactHomePhone;
	public String contactMobilePhone;
	public String contactWorkPhone;
	public String contactEmail1;
	public String contactEmail2;
	public String contactBday;
	public String contactBmonth;
	public String contactByear;
	public String selectGroup;
	public String contactSecondaryAdress;
	public String contactSecondaryPhone;

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
	
}