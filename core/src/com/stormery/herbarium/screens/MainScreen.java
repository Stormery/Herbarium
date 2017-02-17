package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.stormery.herbarium.Herbarium;

public class MainScreen	extends AbstractScreen {

	private Texture background;
	
	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();
		
	}

	@Override
	protected void init() {
		//TODO GET better background texture
		background = new Texture("tlo01.png");
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(background, 0, 0);
		spriteBatch.end();
	}

}
