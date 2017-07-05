package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.MainScreen;

public class HerbImage extends Image {

//for not scrolling, multipleclicking
	public HerbImage(String imageName, final IClickCallback callback, final Herbarium herbarium){
		super(new Texture(imageName));

		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				herbarium.getSoundService().playTapSound();
				callback.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});

	}
	//For scrollable, click once
	public HerbImage(String imageName, int xSize, int ySize, final IClickCallback callback, final Herbarium herbarium){
		super(new Texture(imageName));

		if (xSize != 0)
			this.setSize(xSize, ySize);
	this.addListener(new ClickListener() {
		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
			if(MainScreen.isNotDragging) {
				herbarium.getSoundService().playTapSound();
				callback.onClick();
			}
		}
	});
    }

	// Basic Button Implement with no callback
	public HerbImage(String buttonImage, float xPos, float yPos, int xSize, int ySize, Herbarium herbarium) {
		super(new Texture(buttonImage));

		this.setPosition(xPos, yPos);

		if (xSize != 0)
            this.setSize(xSize, ySize);
	}

	// Button init with callback
	public HerbImage(String buttonImage, float xPos, float yPos, int xSize, int ySize, final IClickCallback callback,
			final Herbarium herbarium) {

		super(new Texture(buttonImage));

		this.setPosition(xPos, yPos);

		if (xSize != 0)
			this.setSize(xSize, ySize);


		this.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				herbarium.getSoundService().playTapSound();
				callback.onClick();

				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
