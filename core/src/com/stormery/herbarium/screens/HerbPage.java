package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class HerbPage extends AbstractScreen {

	private Image background;

	private HerbImage herbButton, bttBackground, secondButton;

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {

		initBackgroundTexture();
		initHerbButton();
		initSecondButton();

	}

	private void initSecondButton() {

		secondButton = new HerbImage("buttons/SingleButton.png", 200, 100, 150, 75, herbarium);
		stage.addActor(secondButton);

	}

	private void initHerbButton() {

		herbButton = new HerbImage("buttons/SingleButton.png", 50, 300, 150	,75 , herbarium);

		stage.addActor(herbButton);
	}

	private void initBackgroundTexture() {

		background = new Image(new Texture("backgroundImg/HerbPage.png"));

		bttBackground = new HerbImage("backgroundImg/HerbPage.png", 0, -background.getHeight() + 700, 0, 0, herbarium);
		stage.addActor(bttBackground);

	}

	@Override
	public void render(float delta) {
		super.render(delta);

		herbarium.getDraggScreenService().draggScreen(bttBackground, herbButton, secondButton); // Funkcja
																								// scroll

		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}

}
