package com.stormery.herbarium.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.ui.HerbButton;

public class DraggScreenService {

	private Vector2 dragOld, dragNew;
	private int balanceView;
	private float zmiennaRuchu;
	private int maxAtTop;
	private int maxAtBottom;
	private int zmiennaTla;
	private float holdPositionOn;
	private Vector2 vectorPosition;

	public DraggScreenService() {
		init();
	}

	private void init() {
		maxAtBottom = -500;
		maxAtTop = 0;

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

				zmiennaRuchu = dragNew.y - dragOld.y;
				

				for (HerbButton dragImg : imgs) {
					
					dragImg.balanceView += zmiennaRuchu * 30 * Gdx.graphics.getDeltaTime();
					dragImg.setMovingPosition(dragImg.getyBasePosition());
					
					
					if (inRange2(dragImg)){
						
						dragImg.setMovingPosition(dragImg.getyBasePosition() +dragImg.balanceView);
						dragImg.finalPosition.y = dragImg.getyBasePosition() -dragImg.balanceView;
						System.out.println("->" + dragImg.getMovingPosition());
						System.out.println("@@@@@" + dragImg.finalPosition.y);
					
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
		if(dragImg.balanceView >maxAtTop){
			
			dragImg.balanceView = maxAtTop;
			dragImg.setPosition(0, dragImg.getyBasePosition());
			return false;
		}
		if(dragImg.balanceView < maxAtBottom)
		{
			dragImg.balanceView = maxAtBottom;
			System.out.println("------>" + dragImg.finalPosition.y);
			dragImg.setPosition(0, dragImg.finalPosition.y);
			return false;
		}
		return false;
		
		
		
//		} else if (balanceView > maxAtTop) {
//			// Jesli przesuniecie jest wieksze niz koniec topa, stopuje
//			// przesuwanie
//			System.out.println("posi: "+dragImg.getMovingPosition());
//			dragImg.setPosition(0, dragImg.getyBasePosition() );
//			balanceView = maxAtTop;
//			return false;
//
//		} else if(balanceView < maxAtBottom){
//			// Jesli przesuniecie jest wieksze niz koniec bota, stopuje
//			// przesuwanie
//			dragImg.setPosition(0, dragImg.getMovingPosition());
//			
//			balanceView = maxAtBottom;
//			return false;
//		}
//			else{
//				
//				return false;
//			}
//		
		
		

	}

	public void draggScreen(Image dragImg,int i) {

		if (Gdx.input.justTouched()) {
			// System.out.println("Mouse ClickOn: " + Gdx.input.getX() + " " +
			// Gdx.input.getY());
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			dragOld = dragNew;

		}
		if (Gdx.input.isTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());

			if (!dragNew.equals(dragOld)) {

				zmiennaRuchu = dragNew.y - dragOld.y;
				balanceView += zmiennaRuchu * 30 * Gdx.graphics.getDeltaTime();

				zmiennaTla = (int) (-dragImg.getHeight() + 700);

				if (inRange(dragImg))
					moveImagesBy(dragImg);

				System.out.println("Balance: " + balanceView);
				dragOld = dragNew; // Drag old becomes drag new.
			}
		}

	}

	private void moveImagesBy(Image dragImg) {
		// Dla androida musi byc * 30 * delta
		dragImg.moveBy(0, -zmiennaRuchu * 30 * Gdx.graphics.getDeltaTime());
	}

	private boolean inRange(Image dragImg) {

		if ((balanceView <= maxAtTop) && balanceView >= maxAtBottom) {

			return true;
		} else if (balanceView > maxAtTop) {
			// Jesli przesuniecie jest wieksze niz koniec topa, stopuje
			// przesuwanie
			dragImg.setPosition(0, zmiennaTla);
			balanceView = maxAtTop;
			return false;

		} else {
			// Jesli przesuniecie jest wieksze niz koniec bota, stopuje
			// przesuwanie
			dragImg.setPosition(0, zmiennaTla - maxAtBottom);
			balanceView = maxAtBottom;
			return false;
		}

	}

}
