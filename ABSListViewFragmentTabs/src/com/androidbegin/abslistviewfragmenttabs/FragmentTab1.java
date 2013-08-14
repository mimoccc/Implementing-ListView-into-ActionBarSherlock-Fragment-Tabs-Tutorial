package com.androidbegin.abslistviewfragmenttabs;

import com.actionbarsherlock.app.SherlockFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FragmentTab1 extends SherlockFragment {
	String[] rank;
	String[] country;
	String[] population;
	int[] flag;
	ListView list;
	ListViewAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragmenttab1, container,
				false);
		// Generate sample data
		rank = new String[] { "1", "2", "3", "4", "5" };

		country = new String[] { "China", "India", "United States",
				"Indonesia", "Brazil" };

		population = new String[] { "1,354,040,000", "1,210,193,422",
				"315,761,000", "237,641,326", "193,946,886" };

		flag = new int[] { R.drawable.china, R.drawable.india,
				R.drawable.unitedstates, R.drawable.indonesia,
				R.drawable.brazil };

		// Locate the ListView in fragmenttab1.xml
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
