package com.stormery.herbarium.herbs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.HerbPage;

public class Pokrzywa extends  HerbPage{

	protected Image background;
	protected String pokrzywaPicture ="testButton.png";
	
	public Pokrzywa(Herbarium herbarium) {
		super(herbarium);
	}

	@Override
	protected void init() {
		initBackgroundTexture();
		initTableMain(background);



		initSideSliderSerice();

	}

	private void initBackgroundTexture() {
		background = new Image(new Texture("backgroundImg/HerbPage.png"));
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act();
	}

	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();

	}
}
