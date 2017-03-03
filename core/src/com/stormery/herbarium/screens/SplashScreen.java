package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.SplashScreenButton;


//ekran powitalny
public class SplashScreen extends AbstractScreen{

	private Texture logoImg;
	private ImageButton continueButton;
	private SplashScreenButton splashScreenButton;
	
	public SplashScreen(Herbarium herbarium) {
		super(herbarium);
		init();
	}
	
	@Override
	protected void init() {
		
		
		initSplashScreen();
		initContinueButton(herbarium);
	}
	
	private void initSplashScreen() {
		//TODO implement better assets loading when game grows
		// change logoImg to my own one
		logoImg = new Texture("Logo.png");
		
	}

	private void initContinueButton(Herbarium herbarium){
	//TODO get better button texture
		splashScreenButton = new SplashScreenButton(herbarium);
		
		stage.addActor(splashScreenButton);
		
	}
	

	@Override
	public void render(float delta){
		super.render(delta);
		
		
		
		spriteBatch.begin();
		
		stage.draw();
			
		spriteBatch.end();
	}

	
	

}
