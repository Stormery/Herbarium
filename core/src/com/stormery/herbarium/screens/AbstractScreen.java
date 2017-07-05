package com.stormery.herbarium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.stormery.herbarium.Herbarium;

public abstract class AbstractScreen implements Screen, GestureListener{
	
	protected Herbarium herbarium;
	
	protected Stage stage;
	protected OrthographicCamera camera;
	protected SpriteBatch spriteBatch;

	public AbstractScreen(Herbarium herbarium){
		this.herbarium = herbarium;
		createCamera();
		stage = new Stage(new StretchViewport(Herbarium.WIDHT, Herbarium.HEIGHT));
		spriteBatch = new SpriteBatch();
		GestureDetector gd = new GestureDetector(this);
		InputMultiplexer im = new InputMultiplexer(gd, stage);
		Gdx.input.setInputProcessor(im);
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
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		MainScreen.isNotDragging = false;
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		MainScreen.isNotDragging = true;
		return false;
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
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public void pinchStop() {

	}
	
}
