package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.MainScreenTableContainer;

import java.util.ArrayList;


public class MainScreen extends HerbPage {

	protected Herbarium herbarium;
	private Image background;
	private Image redBookmark;
	public static boolean isNotDragging = true;



	//TODO z tym zadzialac
	private ArrayList<EnumHerb> herbList;
	//List of Herbs
	private boolean isTherePokrzywa=false;
	private boolean isThereRumianek=false;

	



	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		this.herbarium = herbarium;
		init();
	}

	@Override
	protected void init() {
		herbList = new ArrayList<EnumHerb>();
		initBackgroundTextures();
		initButtons();
		new MainScreenTableContainer(stage);
		// initTable();

	}

	private void initButtons() {

	}

	////////////////////Dodaje Scrollowanie przez Scrollview


	private void initHerbs() {
		// Add search engine for adding herbenums
		//System.out.println(herbList.indexOf(enumHerb.POKRZYWA)); // to ma byc numer kolejnosci to daje int
	//TODO Refactor for enabling buttons pokrzyewa etc
		
		//herbList.add(enumHerb.POKRZYWA);
		//herbList.add(enumHerb.RUMIANEK);		
	
		if((herbList.contains(EnumHerb.POKRZYWA) )&& !isTherePokrzywa){
		//	initPokrzywaButton();

			//isTherePokrzywa = true;
		}
		if(herbList.contains(EnumHerb.RUMIANEK) && !isThereRumianek) {
		//	initRumianekButton();
			isThereRumianek = true;

		}
	}
//
//	private void initRumianekButton() {
//	//TODO ALL implementation for herbs
//		tableInnerScrollable.row();
//		tableInnerScrollable.add(new HerbImage( "buttons/herbs/RumianekButton.png", 0, 0, new IClickCallback() {
//
//			@Override
//			public void onClick() {
//				System.out.println("click rumianek");
//				herbarium.setScreen(new Pokrzywa(herbarium));
//			}
//		}, herbarium)).pad(10);
//
//	}
//	private HerbImage pokrzywa = new HerbImage("buttons/herbs/PokrzywaButton.png", 0, 0, new IClickCallback() {
//
//		@Override
//		public void onClick() {
//			System.out.println("click pokrzywa");
//			herbarium.setScreen(new Pokrzywa(herbarium));
//		}
//	}, herbarium);
//
//	private void initPokrzywaButton() {
//
//		tableInnerScrollable.row();
//		tableInnerScrollable.add(pokrzywa).pad(10);
//	}



	private void initBackgroundTextures() {

		background = new Image(new Texture("backgroundImg/tlo03.png"));
		stage.addActor(background);
		redBookmark = new Image(new Texture("backgroundImg/bookmark.png"));
		redBookmark.setPosition(5f, 0);
		stage.addActor(redBookmark);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act();
	}

	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();

	}

}
