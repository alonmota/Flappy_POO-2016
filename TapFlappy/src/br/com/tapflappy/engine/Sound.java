package br.com.tapflappy.engine;

import com.br.tapflappy.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Sound{
	//Constructor
	public Sound(Context context){
		pool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
		
		//Definição de Assets
		PULO = pool.load(context, R.raw.jump_test, 1);
	}
	
	//Private Members
	private SoundPool pool;
	
	//Public Members
	public static int PULO;
	
	public void play(int sound_id){
		pool.play(sound_id, 1, 1, 1, 0, 1);
	}
}
