package poo.parallel.actors;

import android.graphics.Canvas;

/**
 * Secao Actors
 * 
 * Interface Entities: 
 * 	Trata-se, basicamente, da generalizacao dos elementos que atuam no jogo.
 * 
 * Duvida: Seria possivel colocar todos os elementos relacionados so a classe Actors e a
 * interface Entities?
 * 
 * 	- Caracteristicas:
 * 		-- Get Input;
 * 		-- Check Update;
 * 		-- Render.
 * 
 * :D
 * 
 * @author Rafael
 * 
 */

public interface Entities {
	
	public void drawOnThe(Canvas canvas); /* Desenho de entidade na view atual. */
	
	public void GetInput();
			
	public void CheckUpdate();	

}
