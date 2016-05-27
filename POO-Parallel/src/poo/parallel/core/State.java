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
 * @author Rafael
 * 
 */


public class State {
		public State(){}
		/*	Construtor Padr�o.
		 * 
		 * 	State seria na verdade uma abstra��o / interface para
		 * 		os estados mais espec�ficos (endState, titleState,
		 * 		stageState) no caso de essa implementa��o se manter.
		 * 
		 * 	Do contr�rio h� de se analizar como compatibilizar a
		 * 		estrutura antiga com esse conceito
		 */

		public void AddObject(GameObject ptr){}
		/*	GameObject � a Interface que os Actors implementam
		 * 		� basicamente uma abstra��o que State necessita
		 * 		para poder chamar Update e Render em todos os
		 * 		objetos do jogo ao mesmo tempo, mesmo sendo
		 * 		diferentes entre si.
		 * 
		 * AddObject() receberia um objeto e o inseriria no vetor
		 * 		para que seja processado junto aos demais
		 * 
		 */

		public abstract void Update(float dt);
		/*	Chama Update em todos os Objects, c�mera, verifica colis�es,
		 * 		notifica colis�es, remove objetos mortos do array etc.
		 */
		public abstract void Render();
		/*	Renderiza o background, mapa, etc.
		 * 	Chama Render em todos os Objects
		 */

		public abstract void Pause ();
		public abstract void Resume ();
		//	N�o implementadas :: Descartar
		 

		public boolean PopRequested(){return popRequested;}
		/*	Fun��o que verifica condi��o de sa�da do estado atual.
		 * 		Game deve cham�-la durante a execu��o do loop, para
		 * 		verificar se deve ou n�o executar Pop na pilha.
		 * 
		 * 	Retorno positivo vem sempre associado a uma chamada de Push()
		 * 		em um novo estado, assim completando a implementa��o
		 * 		da m�quina de estados.
		 */
		
		public boolean QuitRequested(){return quitRequested;}
		/*	M�todo que verifica o input, se houve pedido de encerramento
		 * 		da execu��o. Caso positivo, game deve tratar de encerrar
		 * 		o loop
		 */

		
		
		protected abstract void UpdateArray(float dt);
		protected abstract void RenderArray();
		/*	Abstra��es n�o implementadas, que centralizariam as chamadas
		 * 		de update e render nos objetos, liberando as outras
		 * 		fun��es para lidarem com o car�ter secund�rio dos processos
		 * 		de renderiza��o.
		 */

		protected boolean popRequested;
		protected boolean quitRequested;
		/*	Vari�veis de controle sobre o estado do estado (isso faz sentido?)
		 */
		
		Vector<GameObject>	objectArray;
		/*	Vetor que armazena os objetos em jogo.
		 */
}


class GameObject{
	/*Implementa��o vazia, apenas para supress�o de erros
	 * trata-se da interface que os atores implementar�o
	 */
};
