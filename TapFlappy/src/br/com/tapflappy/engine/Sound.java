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
		music = MediaPlayer.create(context, R.raw.music_forest);
		
		music.setLooping(true);
		music.start();
		
		
		
		//Definição de Assets
		PULO 			= pool.load(context, R.raw.sfx_jump, 1);
		JUMP 			= pool.load(context, R.raw.sfx_jump, 1);
		ITEM_GET 		= pool.load(context, R.raw.sfx_item_get, 1);
		COLLIDE 		= pool.load(context, R.raw.explosion, 1);
		ENDGAME 		= pool.load(context, R.raw.endgame, 1);
		NEWGAME 		= pool.load(context, R.raw.newgame, 1);
		BUTTONPRESS 	= pool.load(context, R.raw.buttonpress, 1);
		MUSIC_FOREST	= pool.load(context, R.raw.music_forest, 1);
	}
	
	//Private Members
	private SoundPool pool;
	private MediaPlayer music;
	
	//Public Members
	public static int PULO; //Renomear: JUMP
	public static int JUMP;
	public static int ITEM_GET;
	public static int COLLIDE;
	public static int ENDGAME;
	public static int NEWGAME;
	public static int BUTTONPRESS;
	public static int MUSIC_FOREST;
	
	private int MUSIC_CURRENT;
	

	public void play(int sound_id){
		pool.play(sound_id, 1, 1, 1, 0, 1);
	}
	
	public void	music(int sound_id){
		MUSIC_CURRENT = sound_id;
		pool.play(sound_id, 1, 1, 1, -1, 1);
	}
	
	public void stop_music(){
		//pool.stop(MUSIC_CURRENT);
		music.stop();
	}
}
