package com.example.knapsackkky;

import java.util.ArrayList;

import com.example.knapsackkky.Second_Activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Second_Activity extends Activity {

	private ArrayList<item> optList;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		optList = optimalListStatic.list;
		if(optList.size()>0)
        {
			populateListView();
        }
		else
		{
			TextView l = (TextView)findViewById(R.id.act2_finalText);
			l.setText("Sorry!, You cant take any items with the given weight");
		}
	}
	private void populateListView() {
		ArrayAdapter<item> adapter = new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.act2_finalListview);
		list.setAdapter(adapter);
	}
	private class MyListAdapter extends ArrayAdapter<item>
	{
		public MyListAdapter() {
			super(Second_Activity.this,R.layout.item_view,optList);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// make sure you have a view to work with (may be given null)
			View itemView = convertView;
			if(itemView == null)
			{
				itemView = getLayoutInflater().inflate(R.layout.item_view, parent,false);
				
			}
			// Find the item to work with;
			item i = optList.get(position);
			ImageView imageview = (ImageView)itemView.findViewById(R.id.item_icon);
			imageview.setImageResource(i.getIcon());
			//name
			TextView makeName = (TextView) itemView.findViewById(R.id.item_txtName);
			makeName.setText(i.getName());
			//value
			TextView makeValue = (TextView) itemView.findViewById(R.id.item_txtValue);
			makeValue.setText("Value : "+i.getValue()+" Rupees");
			//weight
			TextView makeWeight = (TextView) itemView.findViewById(R.id.item_txtWeight);
			makeWeight.setText("Weight : "+i.getWeight()+" Kg");
			return itemView;
		}
		
	}
}
