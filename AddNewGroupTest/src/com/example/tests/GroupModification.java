package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModification extends BaseClass{

	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().openGroupsPage();
	    
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //action
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.groupName = "new group";
		app.getGroupHelper().fillNewGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compase states
	    //assertEquals(newList.size(), oldList.size()+1);
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
}
