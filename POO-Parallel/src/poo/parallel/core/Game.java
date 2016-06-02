package poo.parallel.core;

import java.util.Stack;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;
import poo.parallel.physics.CollisionChecker;
import poo.parallel.core.State;
import poo.parallel.mechanics.Input;

/**
 * Secao Core
 * 
 * Classe Game: 
 * 	Mais alto nivel, essa classe se relaciona com classes de manipulacao geral e somente
 * trata da formalizacao do jogo como um jogo, da juncao de todos os componentes em prol
 * de um bom funcionamento.
 * 
 * 	- Possiveis funcionalidades:
 * 		-- Renderer;
 * 		-- Surface.
 * 		
 *	- Relacao estrita com:
 *		-- State;
 *		-- Sound.
 * 
 * :O
 * 
 * @author Rafael, Thales
 * 
 */


public class Game extends SurfaceView implements Runnable {

	//public:
	private Context context;
	//public	Game(String title, int width, int height){}	//Construtor Padr�o
	public	Game(Context context){
		super(context);
		this.context = context;
		
	}	//Construtor Padr�o
	/*	O construtor fica respons�vel por inicializar TODOS os subsitemas
	 * 		exigidos pelo programa, e certificar que est�o em pleno funcionamento.
	 * 		Recebe como par�metro as dimens�es da janela e o nome do execut�vel,
	 * 		se for o caso.
	 * 
	 *  R: No caso de ser no Android, talvez tenhamos que ver essa questao das dimen-
	 *  	soes da janela, pois, a meu ver, estamos trabalhando com views varia-
	 *  	veis de distintos celulares. Nao sei muito bem como seria isso.
	 *  
	 *	Em C++, haveria um destrutor para finalizar os subsistemas e certificar
	 *		o final da execu��o do jogo. Se vier a ser conveniente, podemos
	 *		implementar uma fun��o close() que tome conta disso.
	 */
	private boolean isRunning = true;
	
	@Override
	public	void run(){		//Runnable!
		
		while(isRunning){
			Input.update();
			
			State.getState().Update(dt);
			State.getState().Render();
			
		}
		
	} 
	
	
	/*	Run() � o main loop de jogo. Consiste basicamente em:
	 * 		1. Verificar se existe algum estado a ser inserido no topo
	 * 			da pilha (equivalente de: houve ou n�o mudan�a na m�quina
	 * 			de estados da nossa arquitetura). Se houver sido requisitada
	 * 			a sa�da do jogo, o loop deve ser encerrado aqui.
	 * 
	 * 		2. Uma vez determinado o estado a ser processado, fazer update em
	 * 			Input (por meio do acesso ao pacote mechanics.input), que
	 * 			ser� consultado por State
	 * 
	 * 		3. Chamar o processamento no estado atual com o intervalo de
	 * 			tempo calculado (dt, a partir de CalculateDeltaTime() - 
	 * 			� importante a exist�ncia desse temporizador para c�lculos
	 * 			de f�sica no jogo, para que independam de framerate etc.)
	 * 
	 * 		4. Chamar a renderiza��o no estado - todos os objetos devem
	 * 			se imprimir por conta pr�pria.
	 * 
	 * 		5. Se isso se aplicar: Update no renderizador, para fazer com
	 * 			que as imagens de fato apare�am na tela.
	 * 
	 * 		Novamente, dependendo de como for a implementa��o da m�quina de
	 * 			estados no jogo, talvez o passo 1 se torne obsoleto
	 */
	
	
	//public	SDL_Renderer	GetRenderer(){}
	
	
	public	static Game	GetInstance(){
		return instance;
	}
	/*	M�todos de Acesso: Muitas das classes exigir�o a chamada de
	 * 		m�todos em Game e em membros internos a ela.
	 * 
	 * 		1. Renderer: Classe da SDL que lida com o processamento
	 * 			de texturas e a impress�o delas em tela. Dever� ser
	 * 			substituido pela implementa��o android adequada.
	 * 
	 * 		2. State: Descrito em mais detalhes adiante.
	 * 
	 * 		3. Game: Em C++, � proposta a implementa��o de um singleton
	 * 			(modelo de arquitetura de classe) para game, pois permite
	 * 			a todas as classes do jogo que se comuniquem com game
	 * 			a qualquer momento. Por isso a exist�ncia do m�todo
	 * 			GetInstance(). Pode ser descartado se implementarmos
	 * 			Game como uma classe est�tica.
	 * 
	 */

	public	float	GetDeltatime(){
		return dt;
	}
		/*	M�todo que retorna o tempo decorrido desde o �ltimo frame.
		 * 		Descri��o do m�todo de temporiza��o abaixo.
		 */
	
	//private:

	private	void	CalculateDeltaTime(){}
	private	int		frameStart;
	private	float	dt;
	/*	Elementos de temporiza��o: servem basicamente para c�lculos
	 * 		f�sicos do jogo. dt � calculado no in�cio do loop e
	 * 		passado como par�metro para a chamada de Update no estado
	 * 		corrente, que ent�o o passa para o update de todas as entidades
	 * 		subsequentes.
	 * 
	 * 	Por exemplo: suponha que o jogador apertou para a direita:
	 * 		O loop far� update no input, de forma que seja poss�vel
	 * 		detectar o comando, e ent�o calcular� quanto tempo se passou
	 * 		desde o in�cio do frame. Com isso e com a velocidade do
	 * 		player, � feito o c�lculo da nova posi��o.
	 * 
	 * Isso resolve 2 problemas:
	 * 		1. Framerate vari�vel: O c�lculo da f�sica independe (at�
	 * 			certo ponto) da quantidade de frames disposta por segundo,
	 * 			j� que o jogo deixa de utilizar a contagem de frames como
	 * 			par�metro de tempo.
	 * 
	 * 		2. Timers: Na implementa��o final do jogo foi necess�ria a
	 * 			presen�a de uma classe temporizadora, para processamento
	 * 			de anima��es, ou mesmo para in-game timers (HUD). Secund�rio.
	 */

	private	static Game	instance;
	/*	Deixei aqui mais por car�ter ilustrativo, j� que n�o faz
	 * 		sentido a perman�ncia dessa vari�vel. O ponteiro
	 * 		Game* instance tinha como prop�sito apenas possibilitar
	 * 		que outras classes do jogo acessassem a inst�ncia para
	 * 		obter informa��es importantes para processamento, por
	 * 		exemplo, de f�sica (GetDeltaTime()) ou de renderiza��o
	 * 		(GetRenderer()) ou processamento (GetState())
	 * 
	 * O importante �: as classes v�o precisar acessar m�todos em Game,
	 * 		n�o importa muito como isso seja resolvido.
	 */

	//private	State			storedState;	//Estado Corrente do Jogo
	//private	Stack <State>	stateStack;		//Pilha de Estados
	/*	Esses dois membros se responsabilizam basicamente por manipular
	 * 		os estados de jogo (menu, op��es, fase, game over, etc...).
	 * 
	 * 	Talvez seja o caso de descart�-los e utilizar a mec�nica de
	 * 		menus etc. j� desenvolvido, pode ser mais simples e menos
	 * 		propenso a erro.
	 * 
	 * 
	 * 	De uma forma ou de outra, a ideia da abstra��o de State para
	 * 		game tem um objetivo: State deve centralizar o contato
	 * 		do jogo com os objetos por ele processados, de forma que
	 * 		com cada loop em Game::Run(), haja apenas as chamadas:
	 * 		State.GetInput(),
	 * 		State.Update(dt) e 
	 * 		State.Render().
	 * 
	 * 	Essas chamadas s�o o suficiente para Game - State se torna
	 * 		respons�vel por passar adiante para todos os objetos de
	 * 		jogo as chamadas subsequentes em GameObject.Update(dt)
	 * 		e GameObject.Render(), por exemplo.
	 * 
	 * 	Resta saber qual a melhor forma de se compatibilizar essa
	 * 		funcionalidade com a implementa��o j� feita e funcional
	 * 		dos menus e estados.
	 */
	

	
	//private	SDL_Window		window;
	//private	SDL_Renderer	renderer;
	/*	Esses dois membros carregam as informa��es b�sicas necess�rias para
	 * 		que o jogo possa se renderizar e responder como um programa com
	 * 		informa��es em tela. S�o para ser substitu�dos por o que quer
	 * 		que seja a implementa��o android respectiva
	 */
	public void start() {
		isRunning = true;

	}

	public void pause() {
		isRunning = false;

	}
}
