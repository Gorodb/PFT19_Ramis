package com.example.tests;

import org.testng.annotations.Test;

public class NewGroup extends BaseClass{
	  
  @Test
  public void testNoneEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openGroupsPage();
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    groupSelectedData = "Group 1";
    group.groupName=groupSelectedData;
    group.header="Header 1";
    group.footer="Footer 1";
	app.getGroupHelper().fillNewGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupsPage();
  }
  
}
