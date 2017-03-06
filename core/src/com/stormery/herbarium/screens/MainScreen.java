package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.HerbButton;

public class MainScreen	extends AbstractScreen {

	private Image background;
	private Image logo;
	private HerbButton herbButton;
	
	
	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();
		
	}

	@Override
	protected void init() {
		//TODO GET better background texture
		initBackgroundTextures();
		initHerbButton();
		
		
	}
	
	private void initHerbButton() {
		
		herbButton = new HerbButton(1);
		stage.addActor(herbButton);
	}
	
	private void initBackgroundTextures() {
		
		background = new Image(new Texture("backgroundImg/tlo01.png"));
		stage.addActor(background);
		
		logo = new Image(new Texture("backgroundImg/Logo.png"));
		logo.setPosition(0, Herbarium.HEIGHT-logo.getHeight());
		stage.addActor(logo);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		spriteBatch.begin();
		stage.draw();
		
		spriteBatch.end();
	}

}
