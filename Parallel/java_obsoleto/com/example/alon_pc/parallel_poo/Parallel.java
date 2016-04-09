package com.example.alon_pc.parallel_poo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.io.IOException;

public class Parallel extends SimpleBaseGameActivity {

    private Camera camera;
    private static final int ANCHO_CAMERA = 800;
    private static final int ALTO_CAMERA = 480;

    @Override
    protected void onCreateResources() throws IOException {
    }

    @Override
    protected Scene onCreateScene() {

        Scene scene = new Scene();
        scene.setBackground(new Background(0,1,0));

        return scene;
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        camera =  new Camera(0,0,ANCHO_CAMERA,ALTO_CAMERA);
        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
                new FillResolutionPolicy(), camera);
        return engineOptions;
    }
}
