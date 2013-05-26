package com.YvesB.Nexus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    @SuppressWarnings("unused")
	private CharSequence mTitle;
    private String[] mGalaxyTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();
        mGalaxyTitles = getResources().getStringArray(R.array.items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mGalaxyTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

       
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  
                mDrawerLayout,         
                R.drawable.ic_drawer,  
                R.string.drawer_open,  
                R.string.drawer_close  
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); 
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); 
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

   

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
       
        switch(item.getItemId()) {
        case R.id.action_settings:
            setting();
            
            return true;
            
        case R.id.about:
        	about();
        	
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    protected void setting() {
    	Intent Main1 = new Intent(MainActivity.this, Setting.class);
        startActivity(Main1);
           return;
    }
    protected void about() {
    	Intent Main1 = new Intent(MainActivity.this, About.class);
        startActivity(Main1);
           return;
    }

    
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	switch(position){
        	
            case 0:
               menu0(); 
                return;
            case 1:
               menu1(); 
                return;
            case 2:
                menu2(); 
                 return;
            case 3:
               menu3(); 
                return;
            case 4:
               menu4(); 
                return;
            case 5:
               menu5(); 
                return;
            case 6:
               menu6(); 
                return;
            case 7:
               menu7(); 
                return;
            case 8:
               menu8(); 
                return;
        }
    }
    }
        protected void menu0() {
        	Intent Main0 = new Intent(MainActivity.this, Page0.class);
            startActivity(Main0);
               return;
        }
        
        protected void menu1() {
        	Intent Main1 = new Intent(MainActivity.this, Page1.class);
            startActivity(Main1);
               return;
        }
        
        protected void menu2() {
    	      Intent Main2 = new Intent(MainActivity.this, Page2.class);
              startActivity(Main2);
           return;
    }
        protected void menu3() {
        	Intent Main3 = new Intent(MainActivity.this, Page3.class);
            startActivity(Main3);
               return;
        }
        
        protected void menu4() {
        	Intent Main4 = new Intent(MainActivity.this, Page4.class);
            startActivity(Main4);
               return;
        }
        
        protected void menu5() {
        	Intent Main5 = new Intent(MainActivity.this, Page5.class);
            startActivity(Main5);
               return;
        }
        
        protected void menu6() {
        	Intent Main6 = new Intent(MainActivity.this, Page6.class);
            startActivity(Main6);
               return;
        }
        
        protected void menu7() {
        	Intent Main7 = new Intent(MainActivity.this, Page7.class);
            startActivity(Main7);
               return;
        }
        
        protected void menu8() {
        	Intent Main8 = new Intent(MainActivity.this, Page8.class);
            startActivity(Main8);
               return;
        }
        
	private void selectItem(int position) {
    	
       
        Fragment fragment = new GalaxyFragment();
        Bundle args = new Bundle();
        args.putInt(GalaxyFragment.ARG_GALAXY_NUMBER, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        
        mDrawerList.setItemChecked(position, true);
        setTitle(mGalaxyTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mDrawerTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
       
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public static class GalaxyFragment extends Fragment {
        public static final String ARG_GALAXY_NUMBER = "galaxy_number";

        public GalaxyFragment() {
           
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
           

           
           
            return rootView;
        }
    }
}
