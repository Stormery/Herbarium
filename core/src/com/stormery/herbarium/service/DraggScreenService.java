package com.stormery.herbarium.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.ui.HerbImage;

public class DraggScreenService {

	private Vector2 dragOld, dragNew;

	private float dragDistance; // = dragNew.y - dragOld.y
	private int maxAtTopBalance = 0;
	private int maxAtBottomBalance;

	public DraggScreenService() {
		init();
	}

	private void init() {
	
	}

	public void draggScreen(HerbImage background, HerbImage... imgs) {
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
				for (HerbImage dragImg : imgs) {

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

	private void moveBackground(HerbImage background) {
		background.addToBalanceView(dragDistance * 30 * Gdx.graphics.getDeltaTime());

		if (inRange2(background)) {

			background.setFinalPositionY(background.getBasePositionY() - background.getBalanceView());
			moveImagesBy(background);
		}		
	}

	private boolean inRange2(HerbImage dragImg) {
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

	private void moveImagesBy(Image dragImg) {
		// Dla androida musi byc * 30 * delta
		dragImg.moveBy(0, -dragDistance * 30 * Gdx.graphics.getDeltaTime());
	}

}
