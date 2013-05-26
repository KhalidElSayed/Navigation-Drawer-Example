package com.YvesB.Nexus;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class Page4 extends Activity {
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.page4);
           ActionBar ab = getActionBar();
          ab.setHomeButtonEnabled(true);
          ab.setDisplayHomeAsUpEnabled(true);
  }
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
          // TODO Auto-generated method stub
          MenuInflater mMenuInflater = getMenuInflater();
          mMenuInflater.inflate(R.menu.main, menu);
          
          return true;
  }
  
 
      @Override
      public boolean onOptionsItemSelected(MenuItem item) {
              switch (item.getItemId()) {
              case android.R.id.home:
                      Intent intent = new Intent(this, MainActivity.class);
                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                      startActivity(intent);
                      return true;
             
              default:
                      return super.onOptionsItemSelected(item);

              }
      }

 
}
