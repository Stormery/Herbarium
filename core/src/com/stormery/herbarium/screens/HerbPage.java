package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;

public class HerbPage extends AbstractScreen {

	private Image background;
	private Image logo;
	

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
	
		initBackgroundTexture();

	}

	private void initBackgroundTexture() {

		background = new Image(new Texture("backgroundImg/HerbPage.png"));
		background.setPosition(0, -background.getHeight() + 700);
		logo = new Image(new Texture("backgroundImg/Logo.png"));
		logo.setPosition(0, 0);

		stage.addActor(background);
		stage.addActor(logo);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		herbarium.getDraggScreenService().draggScreen(background); // Funkcja scroll
		herbarium.getDraggScreenService().draggScreen(logo); // Funkcja scroll
		
		

		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}


}
