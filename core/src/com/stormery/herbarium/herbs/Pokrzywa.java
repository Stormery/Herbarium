package com.stormery.herbarium.herbs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.HerbImage;

public class Pokrzywa extends  HerbPage{

	private Image background;
	private HerbImage bttBackground;
	
	
	
	public Pokrzywa(Herbarium herbarium) {
		super(herbarium);
		
	}

	@Override
	protected void init() {
		super.init();
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
		herbarium.getDraggScreenService().draggScreen(bttBackground); // Funkcja
		
	}
	
	
}
