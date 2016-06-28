package br.com.tapflappy.graphic;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;

public class Animations {

	
	
	private Bitmap originalFrames; // !!
	public Bitmap frames[];
	public int speed, index;
	private double lastTime, timer;
	private int len;
	
	public Animations(int speed, Bitmap[] frames){
		this.speed = speed;
		this.frames = frames;
		
		this.len = frames.length;
		
		index = 0;
		timer = 0;
		lastTime = SystemClock.uptimeMillis() ;
	}
	
	public Animations(int speed, Bitmap original_frame,int nFrames, int dist, int height){
		this.speed = speed;
		this.frames = generateSubFrames(original_frame, nFrames,dist,height);
		
		this.len = frames.length;
		
		
		
		index = 0;
		timer = 0;
		lastTime = SystemClock.uptimeMillis() ;
	}
	
	public void tick(){
		timer += SystemClock.uptimeMillis()  - lastTime;
		lastTime = SystemClock.uptimeMillis();
		
		if(index >= frames.length)
			index = 0;
		
		if(timer > speed){
				index++;
			
				timer = 0;
				if(index >= frames.length)
					index = 0;
			

		}
		
	}
	
	public Bitmap getCurrentFrame(){
		return this.frames[index];
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void drawOnThe(Canvas canvas, int x, int y, int xSize, int ySize){
		canvas.drawBitmap(Bitmap.createScaledBitmap(this.getCurrentFrame(), 
				 (int)xSize, 
				 (int)ySize, 
				 false)
				 , x, 
				 (float) y, 
				 null);
	}
	public Bitmap[] generateSubFrames(Bitmap src, int nFrames, int dist, int height){
		
		Bitmap newFrames[] = new Bitmap[nFrames];
		
		for(int i = 0; i < nFrames; i++)
			newFrames[i] = Bitmap.createBitmap(src, i*dist, 0, dist, height);
		
		return newFrames;
		
	}
}
