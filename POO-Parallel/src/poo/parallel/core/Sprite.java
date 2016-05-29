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
		/*	Sprite é uma classe meio enjoadinha: temos que implementá-la pouco a pouco
		 * 		Uma vez que for possível implementar a core com o mínimo da sprite feita,
		 * 		é hora de partir para o próximo passo.
		 * 
		 * 	Implementações essenciais:
		 * 		- Abertura de arquivo
		 * 		- Aquisição de informações da imagem através dela própria (flexibilidade)
		 * 		- Renderização
		 * 
		 * 	Coisas que devemos adiar nela:
		 * 		- Rotação de sprites
		 * 		- Escala de sprites
		 * 		- Animação em spritesheets
		 * 
		 */
	
		public Sprite	(){}
		public Sprite	(String file){}
		public Sprite	(String file, int frameCount, float frameTime){}
		/*	Construtores em sprite. A quantidade de argumentos indica as
		 * 		subsequentes complexidades da figura:
		 * 
		 * 	Sprite() inicializa uma figura sem textura (imagem)
		 * 		- Útil basicamente apenas para texto, se é que isso é verdade (??)
		 * 
		 * 	Sprite(String file) carrega uma textura (file) e incializa uma
		 * 		figura a ela associada
		 * 		- Útil para renderizar-se imagens inertes
		 * 
		 * 	Sprite(String file, int frameCount, float frameTime);
		 * 		Carrega um spritesheet com um frameTime proposto, informando-se
		 * 		o número de frames nele contido, para que a função seja capaz de
		 * 		iterar através deles no time providenciado, gerando assim a
		 * 		animação
		 * 		- Basicamente o que vamos utilizar para os personagens do jogo,	
		 * 			Porém a implementação é meio cara, vale mais a pena deixarmos
		 * 			para o final do jogo (no meu caso, foi apenas no trabalho 6
		 * 			que lidamos com rotação e animação de sprite)
		 * 
		 * 
		 */

		//Métodos de Clipping
		public void Open	(String file){}
		public void SetClip(int x, int y, int w, int h){}
		public void Render	(int x, int y, float angle){}
		/*	Métodos essenciais para operações com sprite, sem eles
		 * 		não há imagem no jogo, basicamente.
		 * 
		 * 	Open() lê a imagem e a guarda no objeto sprite
		 * 	SetClip() indica onde a imagem deve ser renderizada. Em geral,
		 * 		é chamada pelo GameObject dono da sprite, que passa como
		 * 		parâmetros os quatro vértices de sua hitbox.
		 * 
		 * 	Render() aciona o processo de renderização, uma vez que a sprite já
		 * 		tem todas as informações que precisa (textura, posição // rotação,
		 * 		escala, etc.)
		 */
		
		
		//Métodos de Animacao
		public void Update			(float dt){}
		public void SetFrame		(int frame){}
		public void SetFrameCount	(int frameCount){}
		public void SetFrameTime	(float frameTime){}
		/*	Processamento de spritesheets, para renderização sequencial de
		 * 		imagens, para formar a animação.
		 * 		Não vem ao caso iniciar a implementação por aqui.
		 */
		
		//Métodos de Escala
		void SetScaleX(float scale){}
		void SetScaleY(float scale){}
		/*	Escalamento da imagem. Também tem caráter secundário.
		 */

		//Métodos de Acesso
		int 	GetWidth(){}
		int 	GetHeight(){}
		boolean IsOpen(){}
		/*	Métodos de retorno de informações a respeito da sprite.
		 * 		Outras classes necessitarão isso
		 */

	
		//private SDL_Texture*	texture;	//Imagem
		//private SDL_Rect		clipRect;	//Retângulo de Clipping
		/*	Originalmente, a informação crucial a respeito da imagem:
		 * 		texture		= Que imagem é?
		 * 		clipRect	= Onde está sendo renderizada?
		 * 
		 * 	Implementação android exigirá algumas mudanças, em tese
		 */

		//Dimensões
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
		/*	Novamente, a noção de animação vai exigir algumas implementações
		 * 		que ao primeiro momento não estarão disponíveis.
		 */
}
