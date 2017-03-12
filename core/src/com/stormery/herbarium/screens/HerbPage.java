package com.stormery.herbarium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;

public class HerbPage extends AbstractScreen {

	private Image background;

	private Vector2 dragOld, dragNew;
	private int zmienna;
	private float balanceView;
	private int maxAtTop;
	private int maxAtBottom;
	private int zmiennaTla;

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		maxAtBottom = 800;
		maxAtTop = 200;
		
		initBackgroundTexture();

	}

	private void initBackgroundTexture() {

		background = new Image(new Texture("backgroundImg/HerbPage.png"));
		background.setPosition(0, -background.getHeight() + 700);
		zmiennaTla = (int) (-background.getHeight()+700);
		stage.addActor(background);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		update();

		spriteBatch.begin();

		stage.draw();

		spriteBatch.end();

	}

	private void update() {

		draggScreen();
	};

	private void draggScreen() {

		// camera.position.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		if (Gdx.input.justTouched()) {
			System.out.println("Mouse ClickOn: " + Gdx.input.getX() + " " + Gdx.input.getY());
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			dragOld = dragNew;

		}
		if (Gdx.input.isTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());

			if (!dragNew.equals(dragOld) && inRange()) {

				balanceView = dragNew.y - dragOld.y;
				moveImagesBy();
				System.out.println(zmienna += balanceView);

				camera.update();
				dragOld = dragNew; // Drag old becomes drag new.
			}
		}
	}

	private void moveImagesBy() {
		background.moveBy(0, -balanceView);
	}

	private boolean inRange() {
		if (zmienna >= -maxAtBottom) {

			return true;
		} else {
			System.err.println("Camera position: " + camera.position.y);
			stopImageMoving();
			zmienna = -maxAtBottom;
			camera.update();
			return false;

		}
	}

	private void stopImageMoving() {
		background.setPosition(0,zmiennaTla+maxAtBottom);
	}

}
