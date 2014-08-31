package com.example.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class NewGroup extends BaseClass{
	  
  @Test
  public void testNoneEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openGroupsPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //action
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    groupSelectedData = "Group 1";
    group.groupName=groupSelectedData;
    group.header="Header 1";
    group.footer="Footer 1";
	app.getGroupHelper().fillNewGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compase states
    //assertEquals(newList.size(), oldList.size()+1);
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }	  
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openGroupsPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //action
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupName="";
    group.header="";
    group.footer="";
	app.getGroupHelper().fillNewGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compase states
    //assertEquals(newList.size(), oldList.size()+1);
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}
