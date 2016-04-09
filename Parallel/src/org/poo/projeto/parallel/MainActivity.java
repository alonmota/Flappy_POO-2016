package org.poo.projeto.parallel;

/* Projeto Parallel - Main
 * 
 * @author RafaelBatista
 * 
 */

import java.io.IOException;
import java.io.InputStream;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.IResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.IBackground;
import org.andengine.entity.scene.background.modifier.ColorBackgroundModifier;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.ui.IGameInterface.OnCreateResourcesCallback;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.entity.sprite.Sprite;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends SimpleBaseGameActivity {

	// Camera Fields
	private static final float HEIGHT = 480;
	private static final float WIDTH = 800;
	private Camera mCamera;
	
	// Scene Fields
	private Scene scene;
	private ITextureRegion mBackgroundTextureRegion;
	
	// Os 3 m�todos logo abaixo foram definidos
	// automaticamente na gera��o de um projeto
	// Android aqui no Eclipse.
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// AndEngine for Android Game Development Cookbook
	
//	public class MainActivity extends BaseGameActivity
	
	// 4 main methods
	// Exatamente como definidos no livro
	
//	@Override
//	public void onCreateResources (OnCreateResourcesCallback pOnCreateResourcesCallback) {
//		
//		// We should notify the 
//		// pOnCreateResourcesCallback that we've
//		// finished loading all of the
//		// necessary resources in our game AFTER
//		// they are loaded.
//		// onCreateResourcesFinished() should be
//		// the last method called.
//		pOnCreateResourcesCallback.onCreateResourcesFinished();
//		
//		
//	}
//	
//	@Override
//	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) {
//		
//		// Create the Scene object
//		mScene = new Scene();
//		
//		// Notify the callback that we're finished
//		// creating the scene returning mScene to
//		// the mEngine object (handled automatically)
//		// mScene to the mEngine object (handled
//		// automatically)
//		pOnCreateSceneCallback.onCreateSceneFinished(mScene);
//		
//	}
//	
//	@Override
//	public void onPopulateScene (Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) {
//		
//		// onPopulateSceneFinished(), similar to the
//		// resource and scene callback methods,
//		// should be called once we are finished
//		// populating the scene.
//		pOnPopulateSceneCallback.onPopulateSceneFinished();
//		
//	}

	// Seriam ent�o os 3 m�todos acima + o que vem logo abaixo...
	
	// AndEngine for Android Game Development Cookbook
	
	@Override
	public EngineOptions onCreateEngineOptions() {
				
				// Define our mCamera object
				this.mCamera = new Camera(0,0,WIDTH,HEIGHT);
				
				// Declare and define our engine options
				// to be applied to our Engine object
				EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, (IResolutionPolicy) new RatioResolutionPolicy(WIDTH, HEIGHT), this.mCamera);
				
				// It is necessary in a lot of apps to
				// define the following wake lock
				// options in order to disable the
				// device's display from turning off
				// during gameplay due to inactivity
				engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
				
				// Return the engineOptions object,
				// passing it to the engine
				return engineOptions;
				
	}

	@Override
	protected void onCreateResources() {
		try{
			//1 - Set up bitmap textures
			 ITexture backgroundTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
			        @Override
			        public InputStream open() throws IOException {
			            return getAssets().open("menu/backgroundInicial.png");
			        }
			    });
			//2 - Load bitmap textures into VRAM
			backgroundTexture.load();	
			
			//3 - Set up the texture regions
			this.mBackgroundTextureRegion = TextureRegionFactory.extractFromTexture(backgroundTexture);
			
		} catch (IOException e) {
			Debug.e(e);
		}
		
	}

	@Override
	protected Scene onCreateScene() {
		scene = new Scene();
		Sprite backgroundSprite = new Sprite(0, 0, this.mBackgroundTextureRegion, getVertexBufferObjectManager());
		scene.attachChild(backgroundSprite);
		return scene;
		
//		scene = new Scene();
//		scene.setBackground((IBackground) new ColorBackgroundModifier(225,225,225, 0, 0, 0, 0));
//		return scene;
	}
}