package com.stormery.herbarium.service;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class SliderService extends Image{

	private HerbImage slider;
	private boolean sliderOpen;
	Herbarium herbarium;
	
	public SliderService(Stage stage, Herbarium herbarium) {
		this.herbarium = herbarium;
		init(stage);
	}

	private void init(Stage stage) {
		slider = new HerbImage("buttons/Slider.png", -190, 200, 0, 0, new IClickCallback() {

			@Override
			public void onClick() {
				System.out.println("wysow");
				slidingImage();

			}

		}, herbarium);
		
		stage.addActor(slider);
		
	}
	
	public void slidingImage() {
		if (!sliderOpen) {

			for (int i = 0; i < 19; i++)
				slider.moveBy(10, 0);
				
			//Action a = Actions.parallel(Actions.moveBy(10, 0, 0.5f));
			//this.addAction
			sliderOpen = true;
		} else {
			for (int i = 0; i < 19; i++)
				slider.moveBy(-10, 0);
			sliderOpen = false;
		}
		
	}
}

