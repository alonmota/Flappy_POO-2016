package br.com.tapflappy.graphic;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;

public class Animations {

	
	public Bitmap frames[] = new Bitmap[10];
	public static int speed, index;
	private double lastTime, timer;
	
	public Animations(int speed, Bitmap[] frames){
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = SystemClock.uptimeMillis() ;
	}
	
	public void tick(){
		timer += SystemClock.uptimeMillis()  - lastTime;
		lastTime = SystemClock.uptimeMillis();
		
		if(timer > speed){
			index++;
			timer = 0;
			if(index >= frames.length)
				index = 0;
		}
		
		Log.d("index", "atual " + index);
	}
	
	public Bitmap getCurrentFrame(){
		return frames[index];
	}
	
}
