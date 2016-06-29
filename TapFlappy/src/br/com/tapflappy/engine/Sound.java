package br.com.tapflappy.engine;

import com.br.tapflappy.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class Sound{
	//Constructor
	public Sound(Context context){
		pool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
		
		//Defini��o de Assets
		JUMP 			= pool.load(context, R.raw.sfx_jump, 		1);
		ITEM_GET 		= pool.load(context, R.raw.sfx_item_get, 	1);
		COLLIDE 		= pool.load(context, R.raw.sfx_explosion, 	1);
		ENDGAME 		= pool.load(context, R.raw.sfx_endgame, 	1);
		NEWGAME 		= pool.load(context, R.raw.sfx_newgame, 	1);
		BUTTONPRESS 	= pool.load(context, R.raw.sfx_buttonpress, 1);
		COIN_GET		= pool.load(context, R.raw.sfx_coin_get,	1);
		
		/*	Cat�logo de Sound Assets:
		 * 
		 * 		EM USO
		 * 	- Jump: 		som padr�o de pulo
		 *  - Item Get:		obten��o de objetos
		 *  - Collide:		colis�o com cen�rio (explos�o)
		 *  - ButtonPress: 	cliques de bot�o (main menu)
		 *  
		 *		Para serem utilizados p�s game-over, quando o jogador pedir para:
		 *  - Endgame: voltar ao menu
		 *  - Newgame: tentar novamente
		 *  		- Por enquanto est�o no main menu, tocando JUNTO a ButtonPress
		 *  			(devem ser removidas de l� ap�s implementa��o descrita acima)
		 *  
		 */
		

		
		music[0] = MediaPlayer.create(context, R.raw.music_forest);
		music[0].setLooping(true);
		
		music[1] = MediaPlayer.create(context, R.raw.music_city);
		music[1].setLooping(true);
		
		music[2] = MediaPlayer.create(context, R.raw.music_desert);
		music[2].setLooping(true);
	}
	
	//Private Members
	private SoundPool pool;
	private MediaPlayer music[] = new MediaPlayer[3];
	
	//Public Members
	public static int PULO; //Renomear: JUMP
	public static int JUMP;
	public static int ITEM_GET;
	public static int COLLIDE;
	public static int ENDGAME;
	public static int NEWGAME;
	public static int BUTTONPRESS;
	public static int MUSIC_FOREST;
	public static int COIN_GET;
	
	//Public Methods
	public void play(int sound_id){
		pool.play(sound_id, 1, 1, 1, 0, 1);
	}
	
	public void set_music(int environment){
		int counter = 0;
		for(MediaPlayer channel : music){
			if (counter == environment)
				channel.setVolume(1, 1);
			else channel.setVolume(0, 0);
			counter++;
		}
	}
	
	public void stop_music(){
		for(MediaPlayer channel : music){
			channel.stop();
		}
	}
	
	public void start_music(){
		music[0].setVolume(1, 1);
		music[1].setVolume(0, 0);
		music[2].setVolume(0, 0);
		
		music[0].start();
		music[1].start();
		music[2].start();
	}
}
