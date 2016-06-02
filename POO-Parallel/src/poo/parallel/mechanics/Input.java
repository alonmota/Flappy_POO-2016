package poo.parallel.mechanics;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * Secao Mechanics
 * 
 * Classe Input: 
 * 	Importante no sentido de consultar a interacao do usuario com o jogo e receber as alteracoes
 * que ocorrem de tempos em tempos.
 * 
 * 	- Caracteristicas:
 * 		-- Update chamado por State;
 * 		-- Todos consultam;
 * 		-- Static;
 * 		-- Entradas.
 * 
 * :)
 * 
 * @author Rafael
 * 
 */

public class Input extends SurfaceView implements OnTouchListener {
	
	private Context context;

	public Input(Context context) {
		super(context);
		this.context = context;
		setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		//character.jump();
		return false;
	}
	/**TODO
	 * implementar character, e o metodo update.
	 * */
	public static boolean update() {
		return false;
	}

}
