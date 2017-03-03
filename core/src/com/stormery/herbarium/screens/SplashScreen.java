package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.stormery.herbarium.Herbarium;


//ekran powitalny
public class SplashScreen extends AbstractScreen{

	private Texture logoImg;
	private ImageButton continueButton;
	
	public SplashScreen(Herbarium herbarium) {
		super(herbarium);
		init();
	}
	
	@Override
	protected void init() {
		
		
		initSplashScreen();
		initContinueButton();
	}
	
	private void initSplashScreen() {
		//TODO implement better assets loading when game grows
		// change logoImg to my own one
		logoImg = new Texture("Logo.png");
		
	}

	private void initContinueButton(){
	//TODO get better button texture
		
		continueButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("continueButton.jpg"))));
		continueButton.setWidth(135);
		continueButton.setHeight(135);
		continueButton.setX(Herbarium.WIDHT/2-continueButton.getWidth()/2);
		continueButton.setY(250);
		continueButton.setDebug(false);
		
		stage.addActor(continueButton);
		
		continueButton.addListener(new ClickListener(){
				
			
	
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			
//TODO jakas grafika wciskania
			
			return super.touchDown(event, x, y, pointer, button);
		}
			
		
		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
			
			herbarium.setScreen(new MainScreen(herbarium));
			super.touchUp(event, x, y, pointer, button);
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
