package com.stormery.herbarium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.stormery.herbarium.Herbarium;

public abstract class AbstractScreen implements Screen{
	
	protected Herbarium herbarium;
	
	protected Stage stage;
	protected OrthographicCamera camera;
	protected SpriteBatch spriteBatch;
	
	
	public AbstractScreen(Herbarium herbarium){
		this.herbarium = herbarium;
		createCamera();
		stage = new Stage();
		spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
		init();
		
	}

	protected abstract void init();

	private void createCamera() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Herbarium.WIDHT, Herbarium.HEIGHT);
		camera.update();
	}
	
	@Override
	public void render(float delta){
		clearScreen();
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
	}
	
	@Override
	public void show(){}
	

	private void clearScreen() {
		Gdx.gl.glClearColor(1, 1, 1, 0); // Tlo jest biale na 1 1 1 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override
	public void resume(){
		herbarium.setPause(false);
	}

	@Override
	public void pause(){
		herbarium.setPause(true);
	}
	@Override
	public void hide() {}
	
	@Override
	public void dispose(){
		herbarium.dispose();
	}
	@Override
	public void resize(int width, int height){
		
	}
	
	
}
