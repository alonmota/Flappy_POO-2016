package poo.parallel.core;

import java.util.Vector;

/**
 * Secao Core
 * 
 * Classe State: 
 * 	Muito importante para a dinamica do jogo, essa classe trata da verificacao geral do estado
 * de cada pormenor do jogo, atualizando constantemente o comportamento.
 * 
 * 	- Possiveis funcionalidades:
 * 		-- Atualizacao generalizada de estado de jogo.
 * 		
 *	- Relacao estrita com:
 *		-- Input;
 *		-- Render;
 *		-- Update;
 *		-- Background;
 *		-- Vetor de Entidades.
 * 
 * :O
 * 
 * @author Rafael, Thales
 * 
 */


public abstract class State {
		public State(){}
		/*	Construtor Padrão.
		 * 
		 * 	State seria na verdade uma abstração / interface para
		 * 		os estados mais específicos (endState, titleState,
		 * 		stageState) no caso de essa implementação se manter.
		 * 
		 * 	Do contrário há de se analizar como compatibilizar a
		 * 		estrutura antiga com esse conceito
		 */

		public void AddObject(GameObject ptr){}
		/*	GameObject é a Interface que os Actors implementam
		 * 		É basicamente uma abstração que State necessita
		 * 		para poder chamar Update e Render em todos os
		 * 		objetos do jogo ao mesmo tempo, mesmo sendo
		 * 		diferentes entre si.
		 * 
		 * AddObject() receberia um objeto e o inseriria no vetor
		 * 		para que seja processado junto aos demais
		 * 
		 */

		public abstract void Update(float dt);
		/*	Chama Update em todos os Objects, câmera, verifica colisões,
		 * 		notifica colisões, remove objetos mortos do array etc.
		 */
		public abstract void Render();
		/*	Renderiza o background, mapa, etc.
		 * 	Chama Render em todos os Objects
		 */

		public abstract void Pause ();
		public abstract void Resume ();
		//	Não implementadas :: Descartar
		 

		public boolean PopRequested(){return popRequested;}
		/*	Função que verifica condição de saída do estado atual.
		 * 		Game deve chamá-la durante a execução do loop, para
		 * 		verificar se deve ou não executar Pop na pilha.
		 * 
		 * 	Retorno positivo vem sempre associado a uma chamada de Push()
		 * 		em um novo estado, assim completando a implementação
		 * 		da máquina de estados.
		 */
		
		public boolean QuitRequested(){return quitRequested;}
		/*	Método que verifica o input, se houve pedido de encerramento
		 * 		da execução. Caso positivo, game deve tratar de encerrar
		 * 		o loop
		 */

		
		
		protected abstract void UpdateArray(float dt);
		protected abstract void RenderArray();
		/*	Abstrações não implementadas, que centralizariam as chamadas
		 * 		de update e render nos objetos, liberando as outras
		 * 		funções para lidarem com o caráter secundário dos processos
		 * 		de renderização.
		 */

		protected boolean popRequested;
		protected boolean quitRequested;
		/*	Variáveis de controle sobre o estado do estado (isso faz sentido?)
		 */
		
		Vector<GameObject>	objectArray;
		/*	Vetor que armazena os objetos em jogo.
		 */
}


class GameObject{
	/*Implementação vazia, apenas para supressão de erros
	 * trata-se da interface que os atores implementarão
	 */
};
