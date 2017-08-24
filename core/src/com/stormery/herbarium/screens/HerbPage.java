package com.stormery.herbarium.screens;

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

	public void initTableMain(Image background) {

		this.background = background;

		tableMain = new Table();
		tableMain.setFillParent(true);
		tableMain.setDebug(true);

		Table tableScroll = new Table();
		tableScroll.setDebug(true);
		tableScroll.top().left();
		Table tableInner = new Table();
		tableInner.setDebug(true);
		tableInner.top().right();

		Image testImage = new Image(new Texture("buttons/back.png"));

		tableInner.add(new Image(new Texture("backgroundImg/Logo.png"))).height(150).expandX().colspan(2);
		tableInner.row();


		tableInner.add(new HerbImage("buttons/back.png", 100, 300, new IClickCallback() {

			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
			}
		}, herbarium)).padLeft(20f);
		tableInner.add().expandX();
		tableInner.row();
		tableInner.add().colspan(2).expandY();
		tableInner.add();
//		tableInner.row();
//		tableInner.add(testImage).expandY().colspan(3);


//Background scrollable
		tableScroll.setBackground((Drawable) this.background.getDrawable());
		tableScroll.add(tableInner);
		ScrollPane scrollPane = new ScrollPane(tableScroll);
		scrollPane.setOverscroll(false, false);

		tableMain.add(scrollPane);
		stage.addActor(tableMain);

	}
	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}

	

}
