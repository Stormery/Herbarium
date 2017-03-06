package com.stormery.herbarium.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundService {

	private Sound tapSound;
	public SoundService(){
		init();
	}
	private void init() {

		tapSound = Gdx.audio.newSound(Gdx.files.internal("sound/tap.wav"));
	}
	public void playTapSound(){
		tapSound.play();
	}
}
