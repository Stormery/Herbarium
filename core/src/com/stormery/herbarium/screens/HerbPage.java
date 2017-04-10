package com.stormery.herbarium.screens;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.service.SliderService;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

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
		initBackgroundTexture();
		
		
		

	}
	
	protected void initReturnButton(boolean b) {
		if(b){
			returnButton = new HerbImage("buttons/back.png", Herbarium.WIDHT-100, 0, 100, 100, new IClickCallback() {
				@Override
				public void onClick() {
					herbarium.setScreen(new MainScreen(herbarium));

				}
			}, herbarium);

			stage.addActor(returnButton);
		}
	}
	public void initSliderSerice() {
		sliderService = new SliderService(stage, herbarium);

	}


	// private void initHerbButton() {
	//
	// herbButton = new HerbImage("buttons/Singlebutton.png", 50, 300, 150 ,75 ,
	// herbarium);
	//
	// stage.addActor(herbButton);
	// }

	protected void initBackgroundTexture() {

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}

	

}
