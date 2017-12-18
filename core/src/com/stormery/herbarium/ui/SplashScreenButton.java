package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.MainScreen;

public class SplashScreenButton extends Image {
	
	
	public SplashScreenButton(final Herbarium herbarium){
		super(new Texture("backgroundImg/SplashBg.jpg"));
	
		this.setOrigin(Herbarium.WIDHT/2, Herbarium.HEIGHT/2);
		this.setSize(Herbarium.WIDHT, Herbarium.HEIGHT);
		this.setPosition(0, 0);
		this.addCaptureListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				herbarium.getSoundService().playTapSound();
				System.out.println("~Debug Splash przed initialize");
				herbarium.setScreen(new MainScreen(herbarium));
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	
}




