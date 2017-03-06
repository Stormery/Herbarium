package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.HerbButton;
import com.stormery.herbarium.ui.IClickCallback;

public class MainScreen	extends AbstractScreen {

	private Image background;
	private Image logo;
	private HerbButton[] herbButton;
	
	
	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();
		
	}

	@Override
	protected void init() {
		//TODO GET better background texture
		initBackgroundTextures();
		initHerbButton();		
		
	}
	
	private void initHerbButton() {
		herbButton = new HerbButton[3];
		
		herbButton[0] = new HerbButton(1, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("1 pozycja");
				
			}
		});
		
		herbButton[1] = new HerbButton(2, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("2 pozycja");
				
			}
		});
		herbButton[2] = new HerbButton(3, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println(" 3 pozycja");
			}
		});
		for(HerbButton herbs : herbButton){
			stage.addActor(herbs);
		}		
	}
	
	private void initBackgroundTextures() {
		
		background = new Image(new Texture("backgroundImg/tlo01.png"));
		stage.addActor(background);
		
		logo = new Image(new Texture("backgroundImg/Logo.png"));
		logo.setPosition(0, Herbarium.HEIGHT-logo.getHeight());
		stage.addActor(logo);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		spriteBatch.begin();
		stage.draw();
		
		spriteBatch.end();
	}

}
