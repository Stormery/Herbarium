package com.stormery.herbarium.screens;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class HerbPage extends AbstractScreen {
	
	protected int windowHeight = 700;
	private HerbImage returnButton;
	private HerbImage slider;
	
	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {

		initBackgroundTexture();
		initReturnButton();
		initSlider();
		//initHerbButton();

	}

	private void initSlider() {
		slider = new HerbImage("buttons/Slider.png", -190, 200, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("wysow");
				
			}
		}, herbarium);
		stage.addActor(slider);
	}

	protected void initReturnButton() {
		returnButton = new HerbImage("buttons/back.png", 0, 0, 100, 100, new IClickCallback() {
			
			@Override
			public void onClick() {
				herbarium.setScreen(new MainScreen(herbarium));
				
			}
		}, herbarium);
		
		stage.addActor(returnButton);
		
	}


//	private void initHerbButton() {
//
//		herbButton = new HerbImage("buttons/Singlebutton.png", 50, 300, 150	,75 , herbarium);
//
//		stage.addActor(herbButton);
//	}

	protected void initBackgroundTexture() {

	}

	@Override
	public void render(float delta) {
		super.render(delta);

		
																								// scroll

		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}

}
