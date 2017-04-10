package com.stormery.herbarium.herbs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.screens.MainScreen;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class Pokrzywa extends  HerbPage{

	private Image background;
	private HerbImage bttBackground;
	
	
	private HerbImage[] herbButton;
	public Pokrzywa(Herbarium herbarium) {
		super(herbarium);
		
	}

	@Override
	protected void init() {
		super.init();
		initHerbButton(herbarium);
		initReturnButton(true);
		initSliderSerice();
		
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
				herbarium.setScreen(new MainScreen(herbarium));
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
	@Override
	protected void initBackgroundTexture() {
		super.initBackgroundTexture();
		
		background = new Image(new Texture("backgroundImg/HerbPage.png"));

		bttBackground = new HerbImage("backgroundImg/HerbPage.png", 0, -background.getHeight() + windowHeight, 0, 0, herbarium);
		stage.addActor(bttBackground);
	}

	@Override
	public void render(float delta) {
		// TODO do rendera dorzucic dragservice
		super.render(delta);
		draggScreen(bttBackground, herbButton); // Funkcja
		
	}
	
	
}
