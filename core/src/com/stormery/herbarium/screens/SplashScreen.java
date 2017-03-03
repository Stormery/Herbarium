package com.stormery.herbarium.screens;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.SplashScreenButton;


//ekran powitalny
public class SplashScreen extends AbstractScreen{

	private SplashScreenButton splashScreenButton;
	
	public SplashScreen(Herbarium herbarium) {
		super(herbarium);
		init();
	}
	
	@Override
	protected void init() {
		
		
		initContinueButton(herbarium);
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
