package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.buttons.UseButton;
import com.stormery.herbarium.herbs.Aloe;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

import java.util.ArrayList;

import sun.applet.Main;


public class MainScreen extends HerbPage {

	protected Herbarium herbarium;
	private Image background;
	private Image redBookmark;
	public static boolean isNotDragging = true;



	//TODO z tym zadzialac
	private ArrayList<EnumHerb> herbList;
	//List of Herbs
	UseButton aloeButton;

	



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
		 aloeButton = new UseButton(EnumHerb.ALOE, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("IDZIE DO ALOES PAGE");
			}});
	}

	////////////////////Dodaje Scrollowanie przez Scrollview



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

		background = new Image(new Texture("backgroundImg/tlo04.jpg"));
		background.setHeight(700);
		background.setWidth(480);
		stage.addActor(background);
		redBookmark = new Image(new Texture("backgroundImg/bookmark.png"));
		redBookmark.setPosition(5f, 0);
		//stage.addActor(redBookmark);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		whatHerbToShow();
		stage.act();

	}
/*
* To show a herb after choose a therapeutic propertie
* first in Render - it is checking what herb need to be showed, according to checking list in
* every herb. For example if I click on LAXATIVE it calls "signForPrzeczyszczajace" as TRUE ( MainScreenTable)
* If it is TRUE and only this one is TRUE (it is checking in ALOE.java ) it turns checkIfAloe function to true
* And this function when its true make button for aloe
*/
	private void whatHerbToShow() {
		if(!MainScreenTableContainer.tableInnerScrollable.isAscendantOf(aloeButton))Aloe.isThereAnyAloes = false;
		if(MainScreenTableContainer.tableInnerScrollable.isAscendantOf(aloeButton))Aloe.isThereAnyAloes = true;

		if(Aloe.checkIfAloe()){
			MainScreenTableContainer.tableInnerScrollable.add(aloeButton).colspan(2).width(450).height(100);
			//Czy tabela zawiera aktora juz
			if(MainScreenTableContainer.tableInnerScrollable.isAscendantOf(aloeButton))Aloe.isThereAnyAloes = true;
		}
	}


	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();

	}

}
