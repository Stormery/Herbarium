package com.stormery.herbarium;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.stormery.herbarium.screens.SplashScreen;


public class Herbarium extends Game {
	
	public final static String APP_NAME = "Herbarium";
	
	public final static int WIDHT = 480;
	public final static int HEIGHT = 700;
	
	private Sound soundService;
	
	
	private boolean pause;
	
	@Override
	public void create () {
		init();
	this.setScreen(new SplashScreen(this));
	}

	public void playTapSound(){
		soundService.play();
	}
private void init() {
		soundService = Gdx.audio.newSound(Gdx.files.internal("sound/tap.wav"));
		
	}

	/*
 * 
 * Getters and setters
 * 
 */
	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public Sound getSoundService() {
		return soundService;
	}
}
