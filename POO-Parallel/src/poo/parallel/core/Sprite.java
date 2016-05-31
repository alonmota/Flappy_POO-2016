package poo.parallel.core;

/**
 * Secao Core
 * 
 * Classe Sprite: 
 * 	Essa classe coordena os componentes do jogo num sentido mais estetico, sendo assim, eh responsavel
 * por checar as entidades, o estado e atribuir imagens ou animacoes condizentes.
 * 
 * 	- Caracteristicas:
 * 		-- Tudo relativo a imagens e animacoes;
 * 		-- Necessita renderizador.
 * 
 * :O
 * 
 * @author Rafael, Thales
 * 
 */


public class Sprite {
		/*	Sprite � uma classe meio enjoadinha: temos que implement�-la pouco a pouco
		 * 		Uma vez que for poss�vel implementar a core com o m�nimo da sprite feita,
		 * 		� hora de partir para o pr�ximo passo.
		 * 
		 * 	Implementa��es essenciais:
		 * 		- Abertura de arquivo
		 * 		- Aquisi��o de informa��es da imagem atrav�s dela pr�pria (flexibilidade)
		 * 		- Renderiza��o
		 * 
		 * 	Coisas que devemos adiar nela:
		 * 		- Rota��o de sprites
		 * 		- Escala de sprites
		 * 		- Anima��o em spritesheets
		 * 
		 */
	
		public Sprite	(){}
		public Sprite	(String file){}
		public Sprite	(String file, int frameCount, float frameTime){}
		/*	Construtores em sprite. A quantidade de argumentos indica as
		 * 		subsequentes complexidades da figura:
		 * 
		 * 	Sprite() inicializa uma figura sem textura (imagem)
		 * 		- �til basicamente apenas para texto, se � que isso � verdade (??)
		 * 
		 * 	Sprite(String file) carrega uma textura (file) e incializa uma
		 * 		figura a ela associada
		 * 		- �til para renderizar-se imagens inertes
		 * 
		 * 	Sprite(String file, int frameCount, float frameTime);
		 * 		Carrega um spritesheet com um frameTime proposto, informando-se
		 * 		o n�mero de frames nele contido, para que a fun��o seja capaz de
		 * 		iterar atrav�s deles no time providenciado, gerando assim a
		 * 		anima��o
		 * 		- Basicamente o que vamos utilizar para os personagens do jogo,	
		 * 			Por�m a implementa��o � meio cara, vale mais a pena deixarmos
		 * 			para o final do jogo (no meu caso, foi apenas no trabalho 6
		 * 			que lidamos com rota��o e anima��o de sprite)
		 * 
		 * 
		 */

		//M�todos de Clipping
		public void Open	(String file){}
		public void SetClip(int x, int y, int w, int h){}
		public void Render	(int x, int y, float angle){}
		/*	M�todos essenciais para opera��es com sprite, sem eles
		 * 		n�o h� imagem no jogo, basicamente.
		 * 
		 * 	Open() l� a imagem e a guarda no objeto sprite
		 * 	SetClip() indica onde a imagem deve ser renderizada. Em geral,
		 * 		� chamada pelo GameObject dono da sprite, que passa como
		 * 		par�metros os quatro v�rtices de sua hitbox.
		 * 
		 * 	Render() aciona o processo de renderiza��o, uma vez que a sprite j�
		 * 		tem todas as informa��es que precisa (textura, posi��o // rota��o,
		 * 		escala, etc.)
		 */
		
		
		//M�todos de Animacao
		public void Update			(float dt){}
		public void SetFrame		(int frame){}
		public void SetFrameCount	(int frameCount){}
		public void SetFrameTime	(float frameTime){}
		/*	Processamento de spritesheets, para renderiza��o sequencial de
		 * 		imagens, para formar a anima��o.
		 * 		N�o vem ao caso iniciar a implementa��o por aqui.
		 */
		
		//M�todos de Escala
		void SetScaleX(float scale){}
		void SetScaleY(float scale){}
		/*	Escalamento da imagem. Tamb�m tem car�ter secund�rio.
		 */

		//M�todos de Acesso
		int 	GetWidth(){
			return 1; //EDITAAAAAAAAAAAAAAAA
		}
		int 	GetHeight(){
			return 1; //EDITAAAAAAAAAAAAAAAA
		}
		boolean IsOpen(){
			return true; //EDITAAAAAAAAAAAAAAAA
		}
		/*	M�todos de retorno de informa��es a respeito da sprite.
		 * 		Outras classes necessitar�o isso
		 */

	
		//private SDL_Texture*	texture;	//Imagem
		//private SDL_Rect		clipRect;	//Ret�ngulo de Clipping
		/*	Originalmente, a informa��o crucial a respeito da imagem:
		 * 		texture		= Que imagem �?
		 * 		clipRect	= Onde est� sendo renderizada?
		 * 
		 * 	Implementa��o android exigir� algumas mudan�as, em tese
		 */

		//Dimens�es
		private int	width;
		private int height;

		//Escala
		private float scaleX;
		private float scaleY;

		//Animacao
		private int frameCount;		//Numero de Frames em uma imagem
		private int currentFrame;	//Frame atual
		private float timeElapsed;	//Tempo passado em cada imagem
		private float frameTime;	//Tempo de passagem de frame
		/*	Novamente, a no��o de anima��o vai exigir algumas implementa��es
		 * 		que ao primeiro momento n�o estar�o dispon�veis.
		 */
}
