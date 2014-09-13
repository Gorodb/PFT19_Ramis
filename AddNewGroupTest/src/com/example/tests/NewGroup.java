package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class NewGroup extends BaseClass{

  @Test(dataProvider = "randomValidGroupGenerator")
  public void testValidDatasGroupCreation(GroupData group) throws Exception {
    //save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //action
    app.getGroupHelper().createGroup(group);
    
    //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compase states
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }	  
  
}
