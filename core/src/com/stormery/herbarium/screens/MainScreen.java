package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.herbs.Pokrzywa;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class MainScreen extends AbstractScreen {

	private Image background;
	private Image logo;
	private HerbImage[] herbButton;

	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		// TODO GET better background texture
		initBackgroundTextures();
		initHerbButton(herbarium);

	}

	private void initHerbButton(final Herbarium herbarium) {
		herbButton = new HerbImage[3];

		herbButton[0] = new HerbImage(1, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("1 pozycja");

				herbarium.setScreen(new Pokrzywa(herbarium));
				
			}
		}, herbarium);

		herbButton[1] = new HerbImage(2, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("2 pozycja");

			}
		}, herbarium);
		herbButton[2] = new HerbImage(3, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println(" 3 pozycja");
			}
		}, herbarium);
		
		for (HerbImage herbs : herbButton) {
			stage.addActor(herbs);
		}
	}

	private void initBackgroundTextures() {

		background = new Image(new Texture("backgroundImg/tlo01.png"));
		stage.addActor(background);

		logo = new Image(new Texture("backgroundImg/Logo.png"));
		logo.setPosition(0, Herbarium.HEIGHT - logo.getHeight());
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
