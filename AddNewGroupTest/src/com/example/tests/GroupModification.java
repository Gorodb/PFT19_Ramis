package com.example.tests;

import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupModification extends BaseClass{

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //action
	    app.getGroupHelper().modifyGroup(index, group);
	    
	    //save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compase states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
	
}
