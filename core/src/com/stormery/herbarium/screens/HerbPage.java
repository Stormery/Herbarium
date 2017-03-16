package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.HerbButton;
import com.stormery.herbarium.ui.IClickCallback;

public class HerbPage extends AbstractScreen {

	private Image background;
	
	private HerbButton herbButton,bttBackground;

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
	
		initBackgroundTexture();
		initHerbButton();
		
	}


	

	private void initHerbButton() {

		herbButton = new HerbButton("buttons/SingleButton.png", 0, 300, new IClickCallback() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				
			}
		}, herbarium);
		
		stage.addActor(herbButton);
	}

	private void initBackgroundTexture() {

		background = new Image(new Texture("backgroundImg/HerbPage.png"));
		//background.setPosition(0, -background.getHeight() + 700);
		
		bttBackground = new HerbButton("backgroundImg/HerbPage.png", 0, -background.getHeight() + 700, new IClickCallback() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				
			}
		}, herbarium);
		//stage.addActor(background);
		stage.addActor(bttBackground);
		

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		herbarium.getDraggScreenService().draggScreen(bttBackground, herbButton); // Funkcja scroll
		
		
		

		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}


}
