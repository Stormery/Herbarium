package com.stormery.herbarium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.SplashScreenButton;

import static com.stormery.herbarium.ui.UseButton.skin;


//ekran powitalny
public class SplashScreen extends AbstractScreen{

	private SplashScreenButton splashScreenButton;

	private String splashInfo= new String("");
	private Table table;
	private TextField splashText;
	public SplashScreen(Herbarium herbarium) {
		super(herbarium);
		init();
		
	}
	
	@Override
	protected void init() {
		initContinueButton(herbarium);
		initTable();
	}

	private void initTable() {
		table = new Table(new Skin());
		table.setDebug(false);
		table.setFillParent(true);

		Skin bookFont = new Skin(Gdx.files.internal("ui/skin/BookFont.json"),
			new TextureAtlas(Gdx.files.internal("ui/skin/BookFont.atlas")));
		bookFont.getFont("Kingdom").getData().setScale(0.8f);

		splashText = new TextField(splashInfo, bookFont);

		table.add(splashText).width(200f).height(100f).center().padTop(200f).padLeft(20f);


		stage.addActor(table);
	}


	private void initContinueButton(Herbarium herbarium){
	//TODO get better button texture
		splashScreenButton = new SplashScreenButton(herbarium);
		
		stage.addActor(splashScreenButton);
		
	}
	

	@Override
	public void render(float delta){
		super.render(delta);
		
		
		
		spriteBatch.begin();
		
		stage.draw();
			
		spriteBatch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();
	}
}
