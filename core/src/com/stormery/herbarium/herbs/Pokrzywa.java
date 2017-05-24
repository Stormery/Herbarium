package com.stormery.herbarium.herbs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class Pokrzywa extends  HerbPage{

	private Image background;
	private HerbImage bttBackground;
	
	
	private HerbImage[] herbButton;
	private HerbImage bttPokrzywa;
	
	public Pokrzywa(Herbarium herbarium) {
		super(herbarium);
		
	}

	@Override
	protected void init() {
		initBackgroundTexture();
		//initHerbButton(herbarium);
		
		herbButton = new HerbImage[1];
		initHerbButton();
		initReturnButton();
		initSliderSerice();
		
		
		
	}
	private void initHerbButton() {
		bttPokrzywa = new HerbImage(0, "buttons/herbs/PokrzywaButton.png", 50, 600, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium);
		stage.addActor(bttPokrzywa);
		herbButton[0]= bttPokrzywa;
	}

	
	protected void initBackgroundTexture() {
			
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
