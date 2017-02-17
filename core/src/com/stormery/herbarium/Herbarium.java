package com.stormery.herbarium;


import com.badlogic.gdx.Game;
import com.stormery.herbarium.screens.SplashScreen;


public class Herbarium extends Game {
	
	public final static String APP_NAME = "Herbarium";
	
	public final static int WIDHT = 480;
	public final static int HEIGHT = 700;
	
	private boolean pause;
	
	@Override
	public void create () {
	this.setScreen(new SplashScreen(this));
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
}
