package br.com.tapflappy.engine;

import br.com.tapflappy.elements.Character;
import br.com.tapflappy.elements.Obstacles;

public class CollisionChecker {

	private Character character;
	private Obstacles obstacles;

	public CollisionChecker(Character character, Obstacles obstacles) {
		this.character = character;
		this.obstacles = obstacles;
	}

	public boolean hasCollision() {
		
		return obstacles.hasCollisionWith(character);
	}

}
