package com.stormery.herbarium.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.ui.HerbButton;

public class DraggScreenService {

	private Vector2 dragOld, dragNew;

	private float dragDistance; // = dragNew.y - dragOld.y
	private int maxAtTop = 0;
	private int maxAtBottom;

	public DraggScreenService() {
		init();
	}

	private void init() {
		maxAtBottom = -500;

	}

	public void draggScreen(HerbButton... imgs) {
		/*
		 * If just touched, u get tap position, and if its changed (different
		 * than dragOld) thats mean screen is dragging. dragDistance set how far
		 * its dragged from one drag (dragNew.y - dragOld.y) and for each picture
		 * implemented Balance window is changing from 0 (top edge) to max bottom
		 * edge. FinalPositionY inform how far pictures needs to be moved till
		 * end and at end
		 * 
		 */

		if (Gdx.input.justTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			dragOld = dragNew;

		}
		if (Gdx.input.isTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());

			if (!dragNew.equals(dragOld)) {

				dragDistance = dragNew.y - dragOld.y;

				for (HerbButton dragImg : imgs) {

					dragImg.addToBalanceView(dragDistance * 30 * Gdx.graphics.getDeltaTime());

					if (inRange2(dragImg)) {

						dragImg.setFinalPositionY(dragImg.getBasePositionY() - dragImg.getBalanceView());
						moveImagesBy(dragImg);
					}

					System.err.println("Balance: " + dragImg.getBalanceView());
				}

				dragOld = dragNew; // Drag old becomes drag new.
			}
		}
	}

	private boolean inRange2(HerbButton dragImg) {
		if ((dragImg.getBalanceView() <= maxAtTop) && dragImg.getBalanceView() >= maxAtBottom) {

			return true;
		}
		if (dragImg.getBalanceView() > maxAtTop) {

			dragImg.setBalanceView(maxAtTop);
			dragImg.setPosition(dragImg.getFinalPositionX(), dragImg.getBasePositionY());
			return false;
		}
		if (dragImg.getBalanceView() < maxAtBottom) {
			dragImg.setBalanceView(maxAtBottom);
			dragImg.setPosition(dragImg.getFinalPositionX(), dragImg.getFinalPositionY());
			return false;
		}
		return false;

	}

	private void moveImagesBy(Image dragImg) {
		// Dla androida musi byc * 30 * delta
		dragImg.moveBy(0, -dragDistance * 30 * Gdx.graphics.getDeltaTime());
	}

}
