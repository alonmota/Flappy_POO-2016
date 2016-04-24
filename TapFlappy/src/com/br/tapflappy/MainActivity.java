package com.br.tapflappy;

import com.br.tapflappy.engine.Game;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	private Game game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FrameLayout container = (FrameLayout) findViewById(R.id.container);
		
		game = new Game(this);
		container.addView(game);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		game.inicia();
		new Thread(game).start();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		game.pausa();
		
	}
}
