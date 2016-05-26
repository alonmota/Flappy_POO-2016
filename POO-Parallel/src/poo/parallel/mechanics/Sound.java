package poo.parallel.mechanics;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Secao Mechanics
 * 
 * Classe Sound: 
 * 	Como o nome ja entrega, responsabiliza-se pelo processamento basico de quesitos relacionados
 * ao som do jogo.
 * 
 * :)
 * 
 * @author Rafael
 * 
 */

public class Sound {
	
	private SoundPool pool;

	public Sound(Context context){
		pool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
	}

}
