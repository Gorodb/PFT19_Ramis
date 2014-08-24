package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends BaseClass {

	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().openGroupsPage();
		app.getGroupHelper().deleteGroup(1);
	    app.getNavigationHelper().gotoGroupsPage();
	}
	
}
