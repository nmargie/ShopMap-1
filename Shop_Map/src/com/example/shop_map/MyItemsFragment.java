package com.example.shop_map;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

/**
 * Implements the MyItems fragment
 */
public class MyItemsFragment extends Fragment {
	
	//OnItemRemovedListener myListener;
	
	ArrayList<String> selectedItems = new ArrayList<String>();
	
	ListView listView;
	
	ArrayAdapter<String> adapter;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.activity_my_items, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		//selectedItems.add("");
		listView = (ListView) view.findViewById(R.id.listView1);
		
		Button clearBtn = (Button) view.findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ClearSelections();
				
			}
		});
		// Adding items to listview
		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// NOT USED: Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data
		
		selectedItems = getArguments().getStringArrayList("items");
		
		if(selectedItems.isEmpty()) {
			AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
	        alert.setTitle("No Items Selected");
	        alert.setMessage("Please select items from the All Items tab");
	       // alert.setNegativeButton("Cancel", null);
	        alert.setPositiveButton("Ok", null);
	        alert.show();
		}
		
		adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_selectable_list_item,  this.selectedItems);

		listView.setAdapter(adapter);
		
//		Listener to receive selections
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> a, View v, int position, long id){
				//Toast.makeText(getActivity().getApplicationContext(), "Clicked on ListItem Number " + position, Toast.LENGTH_SHORT).show();  
				AlertDialog.Builder adb = new AlertDialog.Builder(MyItemsFragment.this.getActivity());
		        adb.setTitle("Remove?");
		        adb.setMessage("Are you sure you want to remove " + listView.getItemAtPosition(position).toString());
		        final int positionToRemove = position;
		        adb.setNegativeButton("Cancel", null);
		        adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
		            public void onClick(DialogInterface dialog, int p) {
		                selectedItems.remove(positionToRemove);
		                adapter.notifyDataSetChanged();
		            }});
		        		        
		        adb.show();
		       // myListener.onItemRemoved(listView.getItemAtPosition(position).toString());
			}
		});
	}

	/**
	 * Implements the "clear button": remove all items from the selectedItems list
	 */
    private void ClearSelections(){
    	selectedItems.removeAll(selectedItems);
    	adapter.notifyDataSetChanged();
    }
	
	

}
