package org.poo.projeto.parallel;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.ui.IGameInterface.OnCreateResourcesCallback;

public class PackRecipesActivity {
	
	@Override
	public EngineOptions onCreateOptions(){
		
		// Define our mCamera object
		mCamera = new Camera(0,0,WIDTH,HEIGHT);
		
		// Declare and define our engine options
		// to be applied to our Engine object
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(), mCamera);
		
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
	public void onCreateResources (OnCreateResourcesCallback pOnCreateResourcesCallback) {
		
		// We should notify the 
		// pOnCreateResourcesCallback that we've
		// finished loading all of the
		// necessary resources in our game AFTER
		// they are loaded.
		// onCreateResourcesFinished() should be
		// the last method called.
		pOnCreateResourcesCallback.onCreateResourcesFinished();
		
		
	}
	
	@Override
	public void onCreateScene (onCreateSceneCallback pOnCreateSceneCallback) {
		
		
		
	}

}
