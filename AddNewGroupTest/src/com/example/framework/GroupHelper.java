package com.example.framework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cacheGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cacheGroups == null) {
			rebuildCache();
		}
		return cacheGroups;
	}

	private void rebuildCache() {
		cacheGroups = new SortedListOf<GroupData>();
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupName = title.substring("select (".length(), title.length() - ")".length());
			cacheGroups.add(new GroupData().withName(groupName));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initNewGroupCreation();
		fillNewGroupForm(group);
	    submitGroupCreation();
	    gotoGroupsPage();
	    rebuildCache();
	    return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillNewGroupForm(group);
		submitGroupModification();
	    gotoGroupsPage();
	    rebuildCache();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
	    gotoGroupsPage();
	    rebuildCache();
		return this;
	}
	
	//*****************************************************//

	public void submitGroupDeletion() {
		click(By.name("delete"));
		cacheGroups = null;
	}
	
	public GroupHelper fillNewGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper gotoHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public GroupHelper initNewGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		cacheGroups = null;
		return this;
	}
	
	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cacheGroups = null;
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+ (index+1) +"]"));
	}

	public GroupHelper gotoGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cacheGroups = null;
		return this;
	}
	
}
