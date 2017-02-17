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
	private OrthographicCamera camera;
	protected SpriteBatch spriteBatch;
	
	
	public AbstractScreen(Herbarium herbarium){
		this.herbarium = herbarium;
		createCamera();
		stage = new Stage(new StretchViewport(Herbarium.WIDHT, Herbarium.HEIGHT));
		spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
		
	}

	private void createCamera() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Herbarium.WIDHT, Herbarium.HEIGHT);
		camera.update();
	}
	@Override
	public void show(){}
	
	@Override
	public void render(float delta){
		clearScreen();
		camera.update();
	}

	private void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
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
	public void dispose(){
		herbarium.dispose();
	}
	@Override
	public void resize(int width, int height){
		
	}
	
	
}
