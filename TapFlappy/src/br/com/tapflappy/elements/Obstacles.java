package br.com.tapflappy.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import android.graphics.Canvas;
import br.com.tapflappy.graphic.Screen;

public class Obstacles {
	
	private static final int NUM_OF_OBST = 5;
	private static final int OBST_DIST = 700;
	private Character character;
	
	private final List<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	private Screen screen;
	private Score score;

	public Obstacles(Screen screen, Score score, Character charac) {
		this.screen = screen;
		int position = 275;
		this.score = score;
		
		this.character = charac;
		
		for (int i = 0; i < NUM_OF_OBST; i++) {
			position += OBST_DIST;
			Obstacle obstacle = new Obstacle(screen, position);
			obstacles.add(obstacle);
		}
		
	}

	public void drawOnThe(Canvas canvas) {
		for (Obstacle obstacle : obstacles) {
			obstacle.drawOnThe(canvas);
		}
		
	}

	public void move() {
		ListIterator<Obstacle> iterator = obstacles.listIterator();
		while(iterator.hasNext()){
			Obstacle obstacle = iterator.next();
			obstacle.move();
			if(obstacle.outOfBounds()){
				/*score.aumenta();*/ //aumenta a pontuação quando o cano passa sai da tela
				// gerar novo obstaculo e apagar antigo
				iterator.remove();
				Obstacle auxObstacle = new Obstacle(screen, getMaxPos() + OBST_DIST);
				iterator.add(auxObstacle);
			}
			if(obstacle.getPosition() + obstacle.OBST_WIDTH == character.R_RECT){
				score.aumenta(); //aumenta a pontuação quando o personagem "entra" no cano
			}
		}
	}

	private int getMaxPos() {
		int max = 0;
		for (Obstacle obstacle : obstacles) {
			max = Math.max(obstacle.getPosition(), max);
		}
		return max;
	}

	public boolean hasCollisionWith(Character character) {
		for(Obstacle obstacle : obstacles) {
			if(obstacle.hasHorizontalCollisionWith(character) 
					&& obstacle.hasVerticalCollisionWith(character)){
				return true;
			}
		}
		return false;
	}
	
}
