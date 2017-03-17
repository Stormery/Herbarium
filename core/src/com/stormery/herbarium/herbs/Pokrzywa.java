package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.HerbPage;

public class Pokrzywa extends  HerbPage{

	public Pokrzywa(Herbarium herbarium) {
		super(herbarium);
		init();
	}

	@Override
	protected void init() {
		super.init();
		
		initBackgroundTexture();
		initReturnButton();
	}
	
	initBackgroundTexture(){
		//ToDo add bg texture
		
	}

	@Override
	public void render(float delta) {
		// TODO do rendera dorzucic dragservice
		super.render(delta);
		
		
	}
	
	
}
