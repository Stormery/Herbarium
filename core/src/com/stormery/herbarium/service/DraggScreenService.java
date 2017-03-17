package com.stormery.herbarium.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.ui.HerbButton;

public class DraggScreenService {

	private Vector2 dragOld, dragNew;

	private float dragDistance; //= dragNew.y - dragOld.y
	private int maxAtTop = 0;
	private int maxAtBottom;

	public DraggScreenService() {
		init();
	}

	private void init() {
		maxAtBottom = -500;

	}

	public void draggScreen(HerbButton... imgs) {

		if (Gdx.input.justTouched()) {
			// System.out.println("Mouse ClickOn: " + Gdx.input.getX() + " " +
			// Gdx.input.getY());
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			dragOld = dragNew;

		}
		if (Gdx.input.isTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());

			if (!dragNew.equals(dragOld)) {

				dragDistance = dragNew.y - dragOld.y;

				for (HerbButton dragImg : imgs) {

					dragImg.balanceView += dragDistance * 30 * Gdx.graphics.getDeltaTime();

					if (inRange2(dragImg)) {

						dragImg.setFinalPositionY(dragImg.getBasePositionY() - dragImg.balanceView);
						moveImagesBy(dragImg);
					}

					System.err.println("Balance: " + dragImg.balanceView);
				}

				dragOld = dragNew; // Drag old becomes drag new.
			}
		}
	}

	private boolean inRange2(HerbButton dragImg) {
		if ((dragImg.balanceView <= maxAtTop) && dragImg.balanceView >= maxAtBottom) {

			return true;
		}
		if (dragImg.balanceView > maxAtTop) {

			dragImg.balanceView = maxAtTop;
			dragImg.setPosition(0, dragImg.getBasePositionY());
			return false;
		}
		if (dragImg.balanceView < maxAtBottom) {
			dragImg.balanceView = maxAtBottom;
			dragImg.setPosition(0, dragImg.getFinalPositionY());
			return false;
		}
		return false;

	}

	private void moveImagesBy(Image dragImg) {
		// Dla androida musi byc * 30 * delta
		dragImg.moveBy(0, -dragDistance * 30 * Gdx.graphics.getDeltaTime());
	}

}
