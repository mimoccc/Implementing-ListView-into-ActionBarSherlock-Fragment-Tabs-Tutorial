package com.androidbegin.abslistviewfragmenttabs;

import com.actionbarsherlock.app.SherlockFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentTab2 extends SherlockFragment {
	String[] rank;
	String[] country;
	String[] population;
	int[] flag;
	ListView list;
	ListViewAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragmenttab2, container,
				false);
		// Generate sample data
		rank = new String[] { "6", "7", "8", "9", "10" };

		country = new String[] { "Pakistan", "Nigeria", "Bangladesh", "Russia",
				"Japan" };

		population = new String[] { "182,912,000", "170,901,000",
				"152,518,015", "143,369,806", "127,360,000" };

		flag = new int[] { R.drawable.pakistan, R.drawable.nigeria,
				R.drawable.bangladesh, R.drawable.russia, R.drawable.japan };

		// Locate the ListView in fragmenttab2.xml
		list = (ListView) rootView.findViewById(R.id.listview);

		// Pass results to ListViewAdapter Class
		adapter = new ListViewAdapter(getActivity(), rank, country, population,
				flag);
		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
		// Capture clicks on ListView items
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Send single item click data to SingleItemView Class
				Intent i = new Intent(getActivity(), SingleItemView.class);
				// Pass all data rank
				i.putExtra("rank", rank);
				// Pass all data country
				i.putExtra("country", country);
				// Pass all data population
				i.putExtra("population", population);
				// Pass all data flag
				i.putExtra("flag", flag);
				// Pass a single position
				i.putExtra("position", position);
				// Open SingleItemView.java Activity
				startActivity(i);
			}

		});
		return rootView;
	}

}
