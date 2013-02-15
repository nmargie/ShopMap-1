package com.example.shop_map;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

/**
 * This class is the List Activity - the main activity of ShopMap 
 * 
 */
public class MainActivity extends FragmentActivity implements AllItemsFragment.OnItemSelectedListener {

	Fragment fragmentA, fragmentB;
	ArrayList<String> selectedItems;

	@Override
	/**
	 * This function is executed when the app is opened
	 * @param A bundle containing the saved state of the app
	 */
	protected void onCreate(Bundle savedInstanceState) {
		
		//call the parent implementation
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		selectedItems = new ArrayList<String>();
		final ActionBar actionBar = getActionBar();

		fragmentA = new AllItemsFragment(); //"left tab"
		fragmentB = new MyItemsFragment(); //"right tab"

		// Specify that tabs should be displayed in the action bar.
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab itemsTab = actionBar.newTab().setText("All Items");
		Tab myItemsTab = actionBar.newTab().setText("My Items");

		itemsTab.setTabListener(new MyTabsListener(fragmentA));
		myItemsTab.setTabListener(new MyTabsListener(fragmentB));

		actionBar.addTab(itemsTab);
		actionBar.addTab(myItemsTab);
		
		//following code is to ensure something is sent to fragmentB before the user clicks on any item
		Bundle bundle = new Bundle();
		
		//place selected items in bundle
		bundle.putStringArrayList("items", selectedItems);
		
		//send the bundle to fragment B
		fragmentB.setArguments(bundle);
	}

	@Override
	/**
	 * This function inflates the menu - it adds items to the action bar if it is present.
	 * @return true if the menu was successfully inflated
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * Implements the logic behind selecting an item. If the item was already selected, remove it from the 
	 * user's list. If not, add it. 
	 * @param the name of the item selected (a String) 
	 */
	public void onItemSelected(String item) {
		Bundle bundle = new Bundle();

		if(!selectedItems.contains(item)) {
			selectedItems.add(item);
		} else {
			selectedItems.remove(item);
		}
		bundle.putStringArrayList("items", selectedItems);
		fragmentB.setArguments(bundle);
	}
	
	/**
	 * When an item is removed from the MyItems fragment, remove it from the
	 * selectedItems list 
	 * @param item to be removed
	 */
	public void onItemRemoved(String item) {
		if(this.selectedItems.contains(item)) {
			this.selectedItems.remove(item);
		}
	}
	
	


}
