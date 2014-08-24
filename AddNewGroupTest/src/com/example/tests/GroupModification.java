package com.example.tests;

import org.testng.annotations.Test;

public class GroupModification extends BaseClass{

	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().openGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.groupName = "new group";
		app.getGroupHelper().fillNewGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getNavigationHelper().gotoGroupsPage();
	}
	
}
