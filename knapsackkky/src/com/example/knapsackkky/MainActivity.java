package com.example.knapsackkky;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{

    private ArrayList<item> items = new ArrayList<item>();
    private ArrayList<item> wishList = new ArrayList<item>();
    private knapsack ks;
    private int knapWeight;
    private ArrayList<item> optimalList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtonListener();
        populateItems();
        populateListView();
        registerClickCallBack();
    }

	
	private void populateItems() {
		items.add(new item("Gold",5,650000,R.drawable.gold));
		items.add(new item("Beer",1,60,R.drawable.beer));
		items.add(new item("Laptop",5,45000,R.drawable.lappy));
		items.add(new item("Briefcase with 10000 cash",4,10000,R.drawable.brief));
		items.add(new item("Sofa",40,6000,R.drawable.sofa));
		items.add(new item("Fridge",50,15000,R.drawable.fridge));
		items.add(new item("Watch",1,1000,R.drawable.watch));
		items.add(new item("Os Book",1,400,R.drawable.osbook));
		items.add(new item("Necklace",2,1000000,R.drawable.necklace));
		items.add(new item("Bose headset",1,6000,R.drawable.bose));
		items.add(new item("Diamonds",1,10000000,R.drawable.diam));
		items.add(new item("Home Theatre",15,15000,R.drawable.home));
		items.add(new item("Router",6,1000,R.drawable.internet));
		items.add(new item("Cool Drink",1,20,R.drawable.soft));
		items.add(new item("Money 200 cash",2,200,R.drawable.monet));
		items.add(new item("Car keys",1,900000,R.drawable.careys));
	}
	private void populateListView() {
		ArrayAdapter<item> adapter = new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.myListView);
		list.setAdapter(adapter);
	}
	private class MyListAdapter extends ArrayAdapter<item>
	{
		public MyListAdapter() {
			super(MainActivity.this,R.layout.item_view,items);
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
			item i = items.get(position);
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

	private void registerClickCallBack() {
		ListView l = (ListView) findViewById(R.id.myListView);
		l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked, int pos,
					long id) {
				item i = items.get(pos);
				String msg = ""+i.getName()+" is Added in to your Wish list";
				if(!wishList.contains(i))
				{
					wishList.add(i);
					Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
				}
				else
				{
					msg = ""+i.getName()+" is Already Added in to your Wish list";
					Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
				}
				
			}
		});
	}
	private void setButtonListener() {
		Button b = (Button)findViewById(R.id.button);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				TextView t = (TextView)findViewById(R.id.weightBox);
				knapWeight = Integer.parseInt((t.getText()).toString());
				ks = new knapsack(wishList, knapWeight);
				optimalList = ks.getKnapsack();
				optimalListStatic.add(optimalList);
				startActivity(new Intent(MainActivity.this, Second_Activity.class));
			}
		});
		
	}


}