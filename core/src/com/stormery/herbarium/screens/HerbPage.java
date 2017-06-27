package com.stormery.herbarium.screens;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.service.SliderService;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;


/*
 * Herb page to klasa po AbstractScreen ktora zawiera elementy uzywane w kolejnych stronach
 */
public class HerbPage extends AbstractScreen {
	

	protected int windowHeight = 700;
	private HerbImage returnButton;
	
	private SliderService sliderService;

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}	

	@Override
	protected void init() {
		

	}
	
	protected void initReturnButton() {
			returnButton = new HerbImage("buttons/back.png", Herbarium.WIDHT-100, 0, 100, 100, new IClickCallback() {
				@Override
				public void onClick() {
					herbarium.setScreen(new MainScreen(herbarium));

				}
			}, herbarium);

			stage.addActor(returnButton);
	}
	public void initSideSliderSerice() {
		sliderService = new SliderService(stage, herbarium);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}

	

}
