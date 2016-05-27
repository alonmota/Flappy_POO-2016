package poo.parallel.core;

import java.util.Stack;

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
 * @author Rafael
 * 
 */


public class Game {

	//public:
	
	public	Game(String title, int width, int height){}	//Construtor Padrão
	/*	O construtor fica responsável por inicializar TODOS os subsitemas
	 * 		exigidos pelo programa, e certificar que estão em pleno funcionamento.
	 * 		Recebe como parâmetro as dimensões da janela e o nome do executável,
	 * 		se for o caso. 
	 *  
	 *	Em C++, haveria um destrutor para finalizar os subsistemas e certificar
	 *		o final da execução do jogo. Se vier a ser conveniente, podemos
	 *		implementar uma função close() que tome conta disso.
	 */

	public	void Run(){}
	public	void Push(State state){}
	/*	Run() é o main loop de jogo. Consiste basicamente em:
	 * 		1. Verificar se exista algum estado a ser inserido no topo
	 * 			da pilha (equivalente de: houve ou não mudança na máquina
	 * 			de estados da nossa arquitetura). Se houver sido requisitada
	 * 			a saída do jogo, o loop deve ser encerrado aqui.
	 * 
	 * 		2. Uma vez determinado o estado a ser processado, fazer update em
	 * 			Input (por meio do acesso ao pacote mechanics.input), que
	 * 			será consultado por State
	 * 
	 * 		3. Chamar o processamento no estado atual com o intervalo de
	 * 			tempo calculado (dt, a partir de CalculateDeltaTime() - 
	 * 			é importante a existência desse temporizador para cálculos
	 * 			de física no jogo, para que independam de framerate etc.)
	 * 
	 * 		4. Chamar a renderização no estado - todos os objetos devem
	 * 			se imprimir por conta própria.
	 * 
	 * 		5. Se isso se aplicar: Update no renderizador, para fazer com
	 * 			que as imagens de fato apareçam na tela.
	 * 
	 * 		Novamente, dependendo de como for a implementação da máquina de
	 * 			estados no jogo, talvez o passo 1 se torne obsoleto
	 */

	
	//public	SDL_Renderer	GetRenderer(){}
	public	State			GetState(){}
	public	static Game		GetInstance(){}
	/*	Métodos de Acesso: Muitas das classes exigirão a chamada de
	 * 		métodos em Game e em membros internos a ela.
	 * 
	 * 		1. Renderer: Classe da SDL que lida com o processamento
	 * 			de texturas e a impressão delas em tela. Deverá ser
	 * 			substituido pela implementação android adequada.
	 * 
	 * 		2. State: Descrito em mais detalhes adiante.
	 * 
	 * 		3. Game: Em C++, é proposta a implementação de um singleton
	 * 			(modelo de arquitetura de classe) para game, pois permite
	 * 			a todas as classes do jogo que se comuniquem com game
	 * 			a qualquer momento. Por isso a existência do método
	 * 			GetInstance(). Pode ser descartado se implementarmos
	 * 			Game como uma classe estática.
	 * 
	 */

	public	float	GetDeltatime(){}
		/*	Método que retorna o tempo decorrido desde o último frame.
		 * 		Descrição do método de temporização abaixo.
		 */
	
	//private:

	private	void	CalculateDeltaTime(){}
	private	int		frameStart;
	private	float	dt;
	/*	Elementos de temporização: servem basicamente para cálculos
	 * 		físicos do jogo. dt é calculado no início do loop e
	 * 		passado como parâmetro para a chamada de Update no estado
	 * 		corrente, que então o passa para o update de todas as entidades
	 * 		subsequentes.
	 * 
	 * 	Por exemplo: suponha que o jogador apertou para a direita:
	 * 		O loop fará update no input, de forma que seja possível
	 * 		detectar o comando, e então calculará quanto tempo se passou
	 * 		desde o início do frame. Com isso e com a velocidade do
	 * 		player, é feito o cálculo da nova posição.
	 * 
	 * Isso resolve 2 problemas:
	 * 		1. Framerate variável: O cálculo da física independe (até
	 * 			certo ponto) da quantidade de frames disposta por segundo,
	 * 			já que o jogo deixa de utilizar a contagem de frames como
	 * 			parâmetro de tempo.
	 * 
	 * 		2. Timers: Na implementação final do jogo foi necessária a
	 * 			presença de uma classe temporizadora, para processamento
	 * 			de animações, ou mesmo para in-game timers (HUD). Secundário.
	 */

	private	static Game	instance;
	/*	Deixei aqui mais por caráter ilustrativo, já que não faz
	 * 		sentido a permanência dessa variável. O ponteiro
	 * 		Game* instance tinha como propósito apenas possibilitar
	 * 		que outras classes do jogo acessassem a instância para
	 * 		obter informações importantes para processamento, por
	 * 		exemplo, de física (GetDeltaTime()) ou de renderização
	 * 		(GetRenderer()) ou processamento (GetState())
	 * 
	 * O importante é: as classes vão precisar acessar métodos em Game,
	 * 		não importa muito como isso seja resolvido.
	 */

	private	State			storedState;	//Estado Corrente do Jogo
	private	Stack <State>	stateStack; //Pilha de Estados
	/*	Esses dois membros se responsabilizam basicamente por manipular
	 * 		os estados de jogo (menu, opções, fase, game over, etc...).
	 * 
	 * 	Talvez seja o caso de descartá-los e utilizar a mecânica de
	 * 		menus etc. já desenvolvido, pode ser mais simples e menos
	 * 		propenso a erro.
	 * 
	 * 
	 * 	De uma forma ou de outra, a ideia da abstração de State para
	 * 		game tem um objetivo: State deve centralizar o contato
	 * 		do jogo com os objetos por ele processados, de forma que
	 * 		com cada loop em Game::Run(), haja apenas as chamadas:
	 * 		State.GetInput(),
	 * 		State.Update(dt) e 
	 * 		State.Render().
	 * 
	 * 	Essas chamadas são o suficiente para Game - State se torna
	 * 		responsável por passar adiante para todos os objetos de
	 * 		jogo as chamadas subsequentes em GameObject.Update(dt)
	 * 		e GameObject.Render(), por exemplo.
	 * 
	 * 	Resta saber qual a melhor forma de se compatibilizar essa
	 * 		funcionalidade com a implementação já feita e funcional
	 * 		dos menus e estados.
	 */

	
	//private	SDL_Window		window;
	//private	SDL_Renderer	renderer;
	/*	Esses dois membros carregam as informações básicas necessárias para
	 * 		que o jogo possa se renderizar e responder como um programa com
	 * 		informações em tela. São para ser substituídos por o que quer
	 * 		que seja a implementação android respectiva
	 */
}
