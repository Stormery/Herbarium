package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.herbs.Pokrzywa;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class MainScreen extends HerbPage {

	
	private Image background;
	private HerbImage bttBackground;
	private HerbImage herbButton;
	private HerbImage bttPokrzywa;

	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		// TODO GET better background texture		
		initBackgroundTextures();
		//initHerbButton(herbarium);
		initHerbButton();
		
	}
	
	private void initHerbButton() {
		bttPokrzywa = new HerbImage(0, "buttons/herbs/PokrzywaButton.png", 50, 600, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium);
		stage.addActor(bttPokrzywa);
	}

//	private void initHerbButton(final Herbarium herbarium) {
//		herbButton = new HerbImage[3];
//
//		herbButton[0] = new HerbImage(1, new IClickCallback() {
//			@Override
//			public void onClick() {
//				System.out.println("1 pozycja");
//
//				herbarium.setScreen(new Pokrzywa(herbarium));
//				
//			}
//		}, herbarium);
//
//		herbButton[1] = new HerbImage(2, new IClickCallback() {
//			@Override
//			public void onClick() {
//				System.out.println("2 pozycja");
//
//			}
//		}, herbarium);
//		herbButton[2] = new HerbImage(3, new IClickCallback() {
//			@Override
//			public void onClick() {
//				System.out.println(" 3 pozycja");
//			}
//		}, herbarium);
//		
//		for (HerbImage herbs : herbButton) {
//			stage.addActor(herbs);
//		}
//	}

	private void initBackgroundTextures() {

		background = new Image(new Texture("backgroundImg/tlo02.png"));
		bttBackground = new HerbImage("backgroundImg/tlo02.png", 0, -background.getHeight() + windowHeight, 0, 0, herbarium);
		stage.addActor(bttBackground);

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		
		draggScreen(bttBackground, herbButton);
		
	}

}
