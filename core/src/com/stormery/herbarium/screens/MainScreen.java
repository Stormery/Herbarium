package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.stormery.herbarium.Herbarium;

public class MainScreen	extends AbstractScreen {

	private Texture background;
	private Texture logo;
	
	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();
		
	}

	@Override
	protected void init() {
		//TODO GET better background texture
		initBackgroundTextures();
		
		
	}
	private void initBackgroundTextures() {
		
		background = new Texture("tlo01.png");
		logo = new Texture("Logo.png");
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(background, 0, 0);
		spriteBatch.draw(logo, 0, Herbarium.HEIGHT-logo.getHeight());
		
		spriteBatch.end();
	}

}
