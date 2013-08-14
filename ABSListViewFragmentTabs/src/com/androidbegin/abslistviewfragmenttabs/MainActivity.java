package com.androidbegin.abslistviewfragmenttabs;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;

public class MainActivity extends SherlockFragmentActivity {
	// Declare Variables
	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set the view from main_fragment.xml
		setContentView(R.layout.main_fragment);
		
		// Locate android.R.id.tabhost in main_fragment.xml
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		
		// Create the tabs in main_fragment.xml
		mTabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent);

		// Create Tab1 with a custom image in res folder
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Tab1"), 
				FragmentTab1.class, null);
		
		// Create Tab2
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("Tab2"),
				FragmentTab2.class, null);
		
		}
}
