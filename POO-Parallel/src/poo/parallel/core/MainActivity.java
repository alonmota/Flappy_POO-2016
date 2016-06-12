package poo.parallel.core;

/**
 * Secao Core
 * 
 * Classe Main: 
 * 	Trata da execucao do jogo, por fim.
 *
 *	- Relacao estrita com:
 *		-- Classes da secao Core.
 * 
 * :O
 * 
 * @author Rafael
 * 
 */

import poo.parallel.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**TODO 
 * Instanciar GameActivity aqui
 * */

public class MainActivity extends Activity {
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
				Intent fase1scr = new Intent(MainActivity.this, GameActivity.class);
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
}
