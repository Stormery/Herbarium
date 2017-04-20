package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.Herbarium;

public class HerbImage extends Image {

	private float xPos;
	private float yPos;
	
	private final float xBasePosition;	 // keeping position for starting X position of button
	private final float yBasePosition;  // keeping position for starting Y position of button
	   

	private float balanceView;
	private Vector2 finalPosition = new Vector2(0,0);
	
	
	public HerbImage(int number, String buttonImage, float xPos, float yPos, int xSize, int ySize,
			final IClickCallback callback, final Herbarium herbarium) {
		
		super(new Texture(buttonImage));
		
		yBasePosition = yPos;
		xBasePosition = xPos;
		
		finalPosition.x = xPos; 
		this.setPosition(xPos, yPos);
		
		// Jesli nie chce swojej Size, daje default
		if(xSize==0)this.setSize(75, 35);
		else this.setSize(ySize, xSize);
			
		
		
		this.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				herbarium.getSoundService().playTapSound();
				callback.onClick();

				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
// Basic Button Implement with no callback
	public HerbImage(String buttonImage, float xPos, float yPos, int xSize, int ySize,
			 Herbarium herbarium) {		
		super(new Texture(buttonImage));
		
		yBasePosition = yPos;		
		xBasePosition = xPos;
		finalPosition.x = xPos; 
		this.setPosition(xPos, yPos);
		
		if(xSize!=0)this.setSize(150, 75);
	}
	
	// Button init with callback
	public HerbImage(String buttonImage, float xPos, float yPos, int xSize, int ySize,
			final IClickCallback callback, final Herbarium herbarium) {
		
		super(new Texture(buttonImage));
		
		yBasePosition = yPos;
		xBasePosition = xPos;
		finalPosition.x = xPos; 
		this.setPosition(xPos, yPos);
		
		if(xSize!=0)this.setSize(xSize, ySize);
		
		this.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				herbarium.getSoundService().playTapSound();
				callback.onClick();

				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	// REFACTOR
	//Small buttons with static positions (need refactor imo)
	public HerbImage(int xPosition, final IClickCallback callback, Herbarium herbarium) {
		super(new Texture("buttons/Singlebutton.png"));

		xBasePosition = 0;
		yBasePosition = Herbarium.HEIGHT - this.getHeight() - 150;
		
		setPositions(xPosition, callback, herbarium);

	}

	private void setPositions(int xPosition, final IClickCallback callback, final Herbarium herbarium) {
		this.setSize(150, 75);

		
		whatPosition(xPosition);
		
		this.setPosition(xPos, yPos);

		this.addListener(new ClickListener() {
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

	/*
	 * Getters and Setters
	 * 
	 */
	public float getBasePositionX() {
		return xBasePosition;
	}
	public float getBasePositionY() {
		return yBasePosition;
	}

	/////FinalPosition\\\\\\\\\  After scrolling positions
	public float getFinalPositionX() {
		return finalPosition.x;
	}
	
	public float getFinalPositionY() {
		return finalPosition.y;
	}
	public void setFinalPositionX(float finalPosition) {
		this.finalPosition.x = finalPosition;
	}
	public void setFinalPositionY(float finalPosition) {
		this.finalPosition.y = finalPosition;
	}
	
	///BalanceView\\\
	public float getBalanceView() {
		return balanceView;
	}

	public void setBalanceView(float balanceView) {
		this.balanceView = balanceView;
	}
	public void addToBalanceView(float x){
		this.balanceView += x;
	}


}
