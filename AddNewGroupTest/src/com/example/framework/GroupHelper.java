package com.example.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillNewGroupForm(GroupData group) {
		type(By.name("group_name"), group.groupName);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	}

	public void gotoHomePage() {
		click(By.linkText("home page"));
	}

	public void initNewGroupCreation() {
		click(By.name("new"));
	}
	
	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+ (index+1) +"]"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.groupName = title.substring("select (".length(), title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	}
	
}
