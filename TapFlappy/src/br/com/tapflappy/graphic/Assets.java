package br.com.tapflappy.graphic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.br.tapflappy.R;

public class Assets {
	
	public static Bitmap bmpObst[] = new Bitmap [3];
	public static Bitmap bmpBackground[][] = new Bitmap [3][2];

	public static Bitmap bmpChar[] = new Bitmap [10];
	
	public static Bitmap bmpItem[] = new Bitmap[3];
	public static Bitmap bmpEffect[] = new Bitmap[6];
	public Context context;

	
	public Assets(Context context){	
		this.context = context;
	}
	
	public static void loadAssets(Context context){
		
		/*
		 * 0 -> Floresta
		 * 1 -> Cidade
		 * 2 -> Deserto
		 */
		
		bmpObst[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.boxempty);
		bmpObst[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.barrel);
		bmpObst[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.crates);
		
		
		bmpBackground[0][0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.florestaa);
		bmpBackground[0][1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.florestab);
		
		bmpBackground[1][0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.cidadeaa);
		bmpBackground[1][1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.cidadebb);
		
		bmpBackground[2][0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.desertoaa);
		bmpBackground[2][1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.desertobb);
		
		bmpChar[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.a);
		bmpChar[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.b);
		bmpChar[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.c);
		bmpChar[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.d);
		bmpChar[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e);
		bmpChar[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.f);
		bmpChar[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.g);
		bmpChar[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.h);
		bmpChar[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.i);
		bmpChar[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.j);
		
		bmpItem[0] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.d1);
		bmpItem[1] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.d2);
		bmpItem[2] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.d3);
		
		bmpEffect[0] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.e1);
		bmpEffect[1] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.e2);
		bmpEffect[2] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.e3);
		bmpEffect[3] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.e4);
		bmpEffect[4] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.e5);
		bmpEffect[5] =  BitmapFactory.decodeResource(context.getResources(), R.drawable.e6);
	}
	
}
