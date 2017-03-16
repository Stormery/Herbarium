package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.Herbarium;

public class HerbButton extends Image {

	private float xPos;
	private float yPos;
	
	private final float yBasePosition;
	private float movingPosition;
	
	
	public HerbButton(int xPosition, final IClickCallback callback, Herbarium herbarium) {
		super(new Texture("buttons/Singlebutton.png"));

		yBasePosition = 0;
		init(xPosition, callback, herbarium);

	}

	private void init(int xPosition, final IClickCallback callback, final Herbarium herbarium) {
		this.setSize(150, 75);

		yPos = Herbarium.HEIGHT - this.getHeight() - 150;
		whatPosition(xPosition);
		this.setPosition(xPos, yPos);
		
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				herbarium.getSoundService().playTapSound();
				callback.onClick();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});

	}

	private void whatPosition(int i) {
		int adjust = 30;
		switch (i) {
		case 1:
			this.xPos = 0 + adjust;
			break;
		case 2:
			this.xPos = 130 + adjust;
			break;
		case 3:
			this.xPos = 260 + adjust;
			break;
		}

	}

	// drugi sposob jesli chce ustawic pozycje
	public HerbButton(String buttonImage, float xPos, float yPos, final IClickCallback callback,final Herbarium herbarium) {
		super(new Texture(buttonImage));

		yBasePosition = yPos;
		
		this.setPosition(xPos, yPos);
		//this.setSize(150, 75);
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				//herbarium.getSoundService().playTapSound();
				callback.onClick();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		

	}

	public float getMovingPosition() {
		return movingPosition;
	}

	public void setMovingPosition(float movingPosition) {
		this.movingPosition = movingPosition;
	}

	public float getyBasePosition() {
		return yBasePosition;
	}

	
	

}
