package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.stormery.herbarium.Herbarium;

//ekran powitalny
public class SplashScreen extends AbstractScreen{

	private Texture logoImg;
	
	public SplashScreen(Herbarium herbarium) {
		super(herbarium);
		init();
	}

	private void init() {
		//TODO implement better assets loading when game grows
		// change logoImg to my own one
		logoImg = new Texture("Logo.png");
	}

	@Override
	public void render(float delta){
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.draw(logoImg, 0, Herbarium.HEIGHT-logoImg.getHeight()-100); // wysokosc logo skaluje sie od gornej czesci ekranu
		
		spriteBatch.end();
	}
	

}
