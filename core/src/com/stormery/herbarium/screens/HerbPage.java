package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;

public class HerbPage extends AbstractScreen{

	
	
	
	private Image background;

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();
		
	}

	@Override
	protected void init() {
		initBackgroundTexture();
		
	}
	
	private void initBackgroundTexture() {

		background = new Image(new Texture("backgroundImg/tlo01.png"));
		stage.addActor(background);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		
		stage.draw();
		
		spriteBatch.end();
		
		
	};

}
