package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.Herbarium;


//ekran powitalny
public class SplashScreen extends AbstractScreen{

	private Texture logoImg;
	private Button continueButton;
	
	public SplashScreen(Herbarium herbarium) {
		super(herbarium);
		init();
	}
	
	@Override
	protected void init() {
		//TODO implement better assets loading when game grows
		// change logoImg to my own one
		logoImg = new Texture("Logo.png");
		
		initContinueButton();
	}
	
	private void initContinueButton(){
		continueButton = new Button(new ButtonStyle());
		continueButton.setWidth(200);
		continueButton.setHeight(100);
		continueButton.setX(10);
		continueButton.setY(170);
		continueButton.setDebug(true);
		
		stage.addActor(continueButton);
		
		continueButton.addListener(new ClickListener(){
			
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			
		//go to next page	
			
			return super.touchDown(event, x, y, pointer, button);
		}
			
		});
		
	}
	

	@Override
	public void render(float delta){
		super.render(delta);
		
		
		stage.draw();
		spriteBatch.begin();
		
		spriteBatch.draw(logoImg, 0, Herbarium.HEIGHT-logoImg.getHeight()-100); // wysokosc logo skaluje sie od gornej czesci ekranu
		
		spriteBatch.end();
	}

	
	

}
