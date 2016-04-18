package com.flappy.screens;

import com.example.flappy.GameView;
import com.example.flappy.R;
import com.example.flappy.R.layout;

import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FaseOneScreen extends Activity { /* Essa é a classe de view para a fase 1; */

	GameView game;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fase1);
         
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
          
        game = new GameView(this);
    	container.addView(game);
    	
    }
	
	@Override
	protected void onPause() {
		super.onPause();
		game.cancela();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		game.inicia();
		new Thread(game).start();
	}
	
};
