package com.stormery.herbarium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;

public class HerbPage extends AbstractScreen {

	private Image background;

	private Vector2 dragOld, dragNew;
	private int balanceView;
	private float zmiennaRuchu;
	private int maxAtTop;
	private int maxAtBottom;
	private int zmiennaTla;

	public HerbPage(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		maxAtBottom = -500;
		maxAtTop = 0;

		initBackgroundTexture();

	}

	private void initBackgroundTexture() {

		background = new Image(new Texture("backgroundImg/HerbPage.png"));
		background.setPosition(0, -background.getHeight() + 700);
		zmiennaTla = (int) (-background.getHeight() + 700);
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

			if (!dragNew.equals(dragOld)) {

				zmiennaRuchu = dragNew.y - dragOld.y;
				balanceView += zmiennaRuchu* 30 * Gdx.graphics.getDeltaTime();

				if(inRange())moveImagesBy();
			
				System.out.println("Balance: " + balanceView);

				camera.update();
				dragOld = dragNew; // Drag old becomes drag new.
			}
		}

	}

	private void moveImagesBy() {
		//Dla androida musi byc * 30 * delta
		background.moveBy(0, -zmiennaRuchu * 30 * Gdx.graphics.getDeltaTime());
	}

	private boolean inRange() {
		
		if ((balanceView <= maxAtTop) && balanceView >= maxAtBottom ) {

			return true;
		} else if (balanceView > maxAtTop) {
			//Jesli przesuniecie jest wieksze niz koniec topa, stopuje przesuwanie
			background.setPosition(0, zmiennaTla);
			balanceView = maxAtTop;
			camera.update();
			return false;

		} else {
			//Jesli przesuniecie jest wieksze niz koniec bota, stopuje przesuwanie
			background.setPosition(0, zmiennaTla - maxAtBottom);
			balanceView = maxAtBottom;
			camera.update();
			return false;
		}

	}

}
