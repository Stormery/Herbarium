package com.stormery.herbarium.herbs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.screens.MainScreen;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

public class Pokrzywa extends  HerbPage{

	private Image background;
	private Table tableMain;
	

	private HerbImage bttPokrzywa;
	
	public Pokrzywa(Herbarium herbarium) {
		super(herbarium);
	}

	@Override
	protected void init() {
		//initTable
		initTableMain();
		//initBackgroundTexture();
		//initHerbButton(herbarium);
		
		initHerbButton(); //Test
		initReturnButton();
		initSideSliderSerice();
		
		
		
	}

	private void initTableMain() {

		background = new Image(new Texture("backgroundImg/HerbPage.png"));

		tableMain = new Table(MainScreen.skin);
		tableMain.setFillParent(true);
		tableMain.setDebug(true);

		Table tableScroll = new Table();
		tableScroll.setDebug(true);

		Table tableWithStuff = new Table();
		tableWithStuff.setDebug(true);


		tableWithStuff.add(new HerbImage("buttons/herbs/PokrzywaButton.png", 50, 600, 0, 0, new IClickCallback() {

			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium));

		tableScroll.add(background);
		tableScroll.add(tableWithStuff);


		ScrollPane scrollPane = new ScrollPane(tableScroll);
		scrollPane.setOverscroll(false, false);

		tableMain.add(scrollPane);
		stage.addActor(tableMain);

	}

	private void initHerbButton() {
		bttPokrzywa = new HerbImage("buttons/herbs/PokrzywaButton.png", 50, 600, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium);
		
		stage.addActor(bttPokrzywa);
	}


	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act();
	}
	
	
}
