package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.buttons.UseButton;
import com.stormery.herbarium.herbs.Aloe;
import com.stormery.herbarium.herbs.Angelica;
import com.stormery.herbarium.herbs.Aniseed;
import com.stormery.herbarium.herbs.PlantagoOvata;
import com.stormery.herbarium.ui.IClickCallback;
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
	UseButton aloeButton;
	UseButton aniseedButton;
	UseButton angelicaButton;
	UseButton plantagoOvataButton;

	



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
		aniseedButton = new UseButton(EnumHerb.ANISEED, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("IDZIE DO ANYZ PAGE");
			}
		});
		angelicaButton = new UseButton(EnumHerb.ANGELICA, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("IDZIE DO Arcydziegiel PAGE");
			}
		});
		plantagoOvataButton = new UseButton(EnumHerb.PLANTAGO_OVATA, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("IDZIE DO babka jajowata PAGE");
			}
		});
	}

	private void initBackgroundTextures() {

		background = new Image(new Texture("backgroundImg/tlo04.jpg"));
		background.setHeight(700);
		background.setWidth(480);
		stage.addActor(background);
		redBookmark = new Image(new Texture("backgroundImg/bookmark.png"));
		redBookmark.setPosition(5f, 0);

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
		float herbButtonWidth = 320f;
		float herbButtonHeight = 100f;
		//Czy tabela zawiera aktora juz
		Aloe.isThereAnyAloes = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(aloeButton)? true:false;
		Aniseed.isThereAnyAniseed = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(aniseedButton)? true:false;
		Angelica.isThereAnyAngelica = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(angelicaButton)? true:false;
		PlantagoOvata.isThereAnyPlantagoOvata = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(plantagoOvataButton)? true:false;

		if(Aloe.checkIfAloe()) MainScreenTableContainer.tableInnerScrollable.add(aloeButton).width(herbButtonWidth).height(herbButtonHeight);
		if(Aniseed.checkIfAniseed()) MainScreenTableContainer.tableInnerScrollable.add(aniseedButton).width(herbButtonWidth).height(herbButtonHeight);
		if(Angelica.checkIfAngelica()) MainScreenTableContainer.tableInnerScrollable.add(angelicaButton).width(herbButtonWidth).height(herbButtonHeight);
		if(PlantagoOvata.checkIfPlantagoOvata()) MainScreenTableContainer.tableInnerScrollable.add(plantagoOvataButton).width(herbButtonWidth).height(herbButtonHeight);

//TODO dodac row po kazdym
	}


	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();

	}

}
