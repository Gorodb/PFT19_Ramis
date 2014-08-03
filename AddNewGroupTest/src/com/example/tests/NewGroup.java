package com.example.tests;

import org.testng.annotations.Test;

public class NewGroup extends BaseClass{
  
  @Test
  public void testNoneEmptyGroupCreation() throws Exception {
	openMainPage();
    openGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData();
    groupSelectedData = "Group 1";
    group.groupName=groupSelectedData;
    group.header="Header 1";
    group.footer="Footer 1";
	fillNewGroupForm(group);
    submitGroupCreation();
    gotoGroupsPage();
  }
  
}
