package com.example.tests;

import org.testng.annotations.Test;

public class NewContact extends BaseClass{

  @Test
  public void testNoneEmptyGroupCreation() throws Exception {
	openMainPage();
    openGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupName="Group 1";
    group.header="Header 1";
    group.footer="Footer 1";
	fillNewGroupForm(group);
    submitGroupCreation();
    gotoGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    openGroupsPage();
    initNewGroupCreation();
    fillNewGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    gotoGroupsPage();
  }

}
