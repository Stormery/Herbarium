package com.stormery.herbarium.screens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.herbs.Pokrzywa;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;


enum enumHerb{
	POKRZYWA, RUMIANEK;
	
}

public class MainScreen extends HerbPage {

	
	private Image background;
	private HerbImage bttBackground;
	
	private ArrayList<enumHerb> herbList;
	private HerbImage[] herbButton;
	private HerbImage bttPokrzywa;
	private HerbImage bttRumianek;
	

	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		initBackgroundTextures();		
		initHerbs();
		
	}
	private void initHerbs() {
		// Add search engine for adding herbenums
		//TODO rozmiar buttonow, kolejnosc buttonow, inaczej zrobic HERBIMAGE[2]
		herbButton = new HerbImage[2];
		herbList = new ArrayList<enumHerb>();
		
		herbList.add(enumHerb.POKRZYWA);
		herbList.add(enumHerb.RUMIANEK);
		
		System.out.println(herbList.indexOf(enumHerb.POKRZYWA)); // to ma byc numer kolejnosci to daje int
		
		if(herbList.contains(enumHerb.POKRZYWA) ){
			initPokrzywaButton();
		}
		if(herbList.contains(enumHerb.RUMIANEK) ){
			initRumianekButton();
		}
	}
	

	private void initRumianekButton() {
		

	bttRumianek = new HerbImage(0, "buttons/herbs/RumianekButton.png", 150, 500, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("click rumianek");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium);
		
		herbButton[herbList.indexOf(enumHerb.RUMIANEK)]= bttRumianek;
		stage.addActor(bttRumianek);
		
	}

	private void initPokrzywaButton() {
		bttPokrzywa = new HerbImage(0, "buttons/herbs/PokrzywaButton.png", 50, 500, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium);
		
		herbButton[herbList.indexOf(enumHerb.POKRZYWA)]= bttPokrzywa;
		stage.addActor(bttPokrzywa);
	}



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
