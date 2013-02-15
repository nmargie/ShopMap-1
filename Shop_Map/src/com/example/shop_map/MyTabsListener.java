package com.example.shop_map;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * This class implements the Tab listeners for the "All Items" and "My Items" tabs
 * which call the AllItems fragment and MyItems fragment respectively
 *
 */
public class MyTabsListener implements ActionBar.TabListener {
	private Fragment fragment;
	
	/**
	 * Constructor: the tab is in a fragment, so create a tab listener for a particular fragment
	 * @param fragment
	 */
	public MyTabsListener(Fragment fragment) {
		this.fragment = fragment;
	}
	
	@Override
	/**
	 * When a tab is selected, perform a fragment transaction (change fragments if the tab was changed)
	 */
	 public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		int k = tab.getPosition();
		
		switch (k) {
			case 0: ft.replace(R.id.fragment_A, fragment);
			case 1: ft.replace(R.id.fragment_A, fragment);
		}
     }
	
	@Override
	/**
	 * When the tab is unselected, remove its fragment from the transaction
	 */
     public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) { 
		//if(fragment != null) {
			ft.remove(fragment);
		//}
	}

	@Override
	/**
	 * Stub
	 */
     public void onTabReselected(ActionBar.Tab tab,
             FragmentTransaction ft) { }
}
