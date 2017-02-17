package com.stormery.herbarium;


import com.badlogic.gdx.Game;


public class Herbarium extends Game {
	
	public final static String APP_NAME = "Herbarium";
	
	public final static int WIDHT = 480;
	public final static int HEIGHT = 700;
	
	public static boolean Pause;
	
	@Override
	public void create () {
	//	this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render () {
	
	}
	
	@Override
	public void dispose () {
		
	}
/*
 * 
 * Getters and setters
 * 
 */
	public static boolean isPause() {
		return Pause;
	}

	public static void setPause(boolean pause) {
		Pause = pause;
	}
}
