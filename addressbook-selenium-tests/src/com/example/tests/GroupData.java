package com.example.tests;

public class GroupData implements Comparable<GroupData> {
	private String groupName;
	private String header;
	private String footer;
	private String id;
	
	public GroupData() {
		this.groupName = groupName;
		this.header = header;
		this.footer = footer;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public String getHeader() {
		return header;
	}
	public String getFooter() {
		return footer;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		 //result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "GroupData [groupName=" + groupName + ", header=" + header
				+ ", footer=" + footer + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupData other = (GroupData) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(GroupData other) {
		return this.groupName.toLowerCase().compareTo(other.groupName.toLowerCase());
	}
	
	public GroupData withId(String id) {
		this.id = id;
		return this;
	}
	public GroupData withName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	public GroupData withHeader(String header) {
		this.header = header;
		return this;
	}
	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}