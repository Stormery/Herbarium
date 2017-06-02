package com.stormery.herbarium.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.HerbImage;

public abstract class AbstractScreen implements Screen{
	
	protected Herbarium herbarium;
	
	protected Stage stage;
	protected OrthographicCamera camera;
	protected SpriteBatch spriteBatch;
	
	
	private Vector2 dragOld, dragNew;
	private float dragDistance; // = dragNew.y - dragOld.y
	private int maxAtTopBalance = 0;
	private int maxAtBottomBalance;
	
	
	public AbstractScreen(Herbarium herbarium){
		this.herbarium = herbarium;
		createCamera();
		stage = new Stage(new StretchViewport(Herbarium.WIDHT, Herbarium.HEIGHT));
		spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
		init();
		
	}

	//////////////////DragScreen Service
	public void draggScreen(HerbImage background, ArrayList<HerbImage> herbButton) {
		/*
		 * If just touched, u get tap position, and if its changed (different
		 * than dragOld) thats mean screen is dragging. dragDistance set how far
		 * its dragged from one drag (dragNew.y - dragOld.y) and for each picture
		 * implemented Balance window is changing from 0 (top edge) to max bottom
		 * edge. FinalPositionY inform how far pictures needs to be moved till
		 * end and at end.
		 * 
		 */
		
		//maxAtBottomBalance gets bottom edge
		maxAtBottomBalance  = -((int) background.getHeight()-699);

		
		if (Gdx.input.justTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			dragOld = dragNew;

		}
		if (Gdx.input.isTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());

			if (!dragNew.equals(dragOld)) {

				dragDistance = dragNew.y - dragOld.y;
				moveBackground(background);
				for (HerbImage dragImg : herbButton) {

					dragImg.addToBalanceView(dragDistance * 30 * Gdx.graphics.getDeltaTime());

					if (inRange(dragImg)) {

						dragImg.setFinalPositionY(dragImg.getBasePositionY() - dragImg.getBalanceView());
						moveImageBy(dragImg);
					}

					System.err.println("Balance: " + dragImg.getBalanceView());
				}

				dragOld = dragNew; // Drag old becomes drag new.
			}
		}
	}

	private void moveBackground(HerbImage background) {
		background.addToBalanceView(dragDistance * 30 * Gdx.graphics.getDeltaTime());

		if (inRange(background)) {

			background.setFinalPositionY(background.getBasePositionY() - background.getBalanceView());
			moveImageBy(background);
		}		
	}

	private boolean inRange(HerbImage dragImg) {
		if ((dragImg.getBalanceView() <= maxAtTopBalance) && dragImg.getBalanceView() >= maxAtBottomBalance) {

			return true;
		}
		if (dragImg.getBalanceView() > maxAtTopBalance) {

			dragImg.setBalanceView(maxAtTopBalance);
			dragImg.setPosition(dragImg.getFinalPositionX(), dragImg.getBasePositionY());
			return false;
		}
		if (dragImg.getBalanceView() < maxAtBottomBalance) {
			dragImg.setBalanceView(maxAtBottomBalance);
			dragImg.setPosition(dragImg.getFinalPositionX(), dragImg.getFinalPositionY());
			return false;
		}
		return false;

	}

	private void moveImageBy(Image dragImg) {
		// Dla androida musi byc * 30 * delta
		dragImg.moveBy(0, -dragDistance * 30 * Gdx.graphics.getDeltaTime());
	}
	
	///////////////////////////////////////////////////////////////////
	
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
