package com.flappy.screens;

import com.example.flappy.R;
import com.example.flappy.R.id;
import com.example.flappy.R.layout;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ScreenMenu extends Activity {

	private Button playButon;
	private Button quitButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_menu);
        
        playButon = (Button) findViewById(R.id.PLAY);
        quitButton = (Button) findViewById(R.id.QUIT);
          
    	playButon.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent fase1scr = new Intent(getApplicationContext(), FaseOneScreen.class);
				startActivity(fase1scr);
				
			};
		});
    	
    	quitButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/* Aqui sai do jogo; */
				
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				
			}
		});
    
    }
    

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
