package br.com.tapflappy.graphic;

import android.graphics.Paint;

public class Colors {
	
	public static Paint getColorOfCharacter() {
		Paint paintChar = new Paint();
		paintChar.setColor(0xFFFFA500); // FF0000 -> Vermelho; FFA500 -> Laranja;
		
		return paintChar;
	}
	
	public static Paint getColorOfObstacle() {
		Paint paintObst = new Paint();
		paintObst.setColor(0xFF10A350); // 10A350 -> Verde musgo;
		
		return paintObst;
	}

}
