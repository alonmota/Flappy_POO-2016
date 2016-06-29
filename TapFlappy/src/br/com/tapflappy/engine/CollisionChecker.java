package br.com.tapflappy.engine;

import br.com.tapflappy.elements.Character;
import br.com.tapflappy.elements.Coins;
import br.com.tapflappy.elements.Element;
import br.com.tapflappy.elements.Item;
import br.com.tapflappy.elements.Obstacles;

public class CollisionChecker {

	private Character character;
	private Obstacles obstacles;
	private Coins coins;
	private Item item;

	public CollisionChecker(Character character, Element item, Obstacles obstacles, Coins coins) {
		this.character = character;
		this.obstacles = obstacles;
		this.coins = coins;
		this.item = (Item) item;
	}

	public int hasCollision() {
		
		if(obstacles.hasCollisionWith(character))
			return 1;
		else if(item.hasCollisionWith(character))
			return 2;
		else if(coins.hasCollisionWith(character))
			return 3;
		else
			return 0;
		//return (obstacles.hasCollisionWith(character) || item.hasCollisionWith(character));
		
	}

}
