package com.stormery.herbarium;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.screens.SplashScreen;
import com.stormery.herbarium.service.DraggScreenService;
import com.stormery.herbarium.service.SoundService;

public class Herbarium extends Game {

	public final static String APP_NAME = "Herbarium";

	public final static int WIDHT = 480;
	public final static int HEIGHT = 700;

	private DraggScreenService draggScreenService;


	private SoundService soundService;

	private boolean pause;

	@Override
	public void create() {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init() {
		initSoundService();
		initDragScreenService();
	}
	
	public void initDragScreenService(){
		draggScreenService = new DraggScreenService();
	}
	
	public void initSoundService(){
		soundService = new SoundService();
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

	public SoundService getSoundService() {
		return soundService;
	}
	public DraggScreenService getDraggScreenService() {
		return draggScreenService;
	}

	
}
