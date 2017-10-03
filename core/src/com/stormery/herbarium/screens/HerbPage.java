package com.stormery.herbarium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.service.SliderService;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;


/*
 * Herb page to klasa po AbstractScreen ktora zawiera elementy uzywane w kolejnych stronach
 */
public class HerbPage extends AbstractScreen {

	public static float herbButtonWidth = 320f;
	public static float herbButtonHeight = 100f;
	private HerbImage returnButton;
	
	private SliderService sliderService;

	private Image background;
	private Table tableMain;

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		

	}
	
	protected void initReturnButton() {
			returnButton = new HerbImage("buttons/back.png", Herbarium.WIDHT-100, 0, 100, 100, new IClickCallback() {
				@Override
				public void onClick() {
					herbarium.setScreen(new MainScreen(herbarium));

				}
			}, herbarium);

			stage.addActor(returnButton);
	}
	public void initSideSliderSerice() {
		sliderService = new SliderService(stage, herbarium);

	}

	public void initTableMain(Image herbLogo, Image herbDesc) {
		boolean setDebug = false;

		tableMain = new Table();
		tableMain.setFillParent(true);
		tableMain.setDebug(setDebug);

		Table tableInner = new Table();
		tableInner.setDebug(setDebug);
		tableInner.top().right();

		Table tableScroll = new Table();
		tableScroll.setDebug(setDebug);
		tableScroll.top().left();


		if(herbLogo==null){
			herbLogo = new Image(new Texture("testButton.png"));
		}

//Top Logo
		tableInner.add(new Image(new Texture("backgroundImg/Logo.png"))).height(80).expandX().colspan(2).top();
		tableInner.row();


		tableInner.add(herbLogo).padLeft(10f).padTop(10f);
		//tableInner.add().expandX(); // Pole na tekst z roznymi nazwami rosliny
		tableInner.row();
		tableInner.add(new Image(new Texture("backgroundImg/ZlotyPasek.png"))).padLeft(5f);
		tableInner.row();

		ScrollPane scrollPane = new ScrollPane(tableScroll);
		scrollPane.setOverscroll(false, false);
		tableInner.add(scrollPane).colspan(2).expandX().height(500f);

		// Opis rosliny

		tableScroll.add(herbDesc).padLeft(10f);
		tableScroll.row();
		tableScroll.add(new Image(new Texture("backgroundImg/ZlotyPasek.png"))).padLeft(5f);

//Background scrollable

		tableMain.add(tableInner).height(Herbarium.HEIGHT).width(460).left().padRight(25f);
		stage.addActor(tableMain);

	}
	@Override
	public void render(float delta) {
		super.render(delta);
		inputControl();
		spriteBatch.begin();
		stage.draw();
		stage.act();

		spriteBatch.end();

	}

	private void inputControl() {
		if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
			herbarium.setScreen(new MainScreen(herbarium));
		}
	}

}
