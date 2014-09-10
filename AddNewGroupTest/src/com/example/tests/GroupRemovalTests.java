package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends BaseClass {

	@Test
	public void deleteSomeGroup() {
		app.navigateTo().mainPage();
	    app.navigateTo().groupsPage();
	    
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //action
		app.getGroupHelper()
			.deleteGroup(index)
			.gotoGroupsPage();
	    
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compase states
	    //assertEquals(newList.size(), oldList.size()+1);
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
}
