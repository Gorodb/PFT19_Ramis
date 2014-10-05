package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXMLFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class NewGroup extends BaseClass{

@DataProvider
public Iterator<Object[]> groupsFromFile() throws IOException {
	return wrapGroupsForDataProvider(loadGroupsFromXMLFile(new File("groups.xml"))).iterator();
}
	
@Test(dataProvider = "groupsFromFile")
  public void testValidDatasGroupCreation(GroupData group) throws Exception {
    //save old state
	SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
    
    //action
    app.getGroupHelper().createGroup(group);
    
    //save new state
    SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
    
    //compase states
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }	  
  
}
