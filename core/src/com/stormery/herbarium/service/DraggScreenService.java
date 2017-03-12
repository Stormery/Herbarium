package com.stormery.herbarium.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class DraggScreenService {

	private Vector2 dragOld, dragNew;
	private int balanceView;
	private float zmiennaRuchu;
	private int maxAtTop;
	private int maxAtBottom;
	private int zmiennaTla;
	
	public DraggScreenService(){
		init();
	}

	private void init() {
		maxAtBottom = -500;
		maxAtTop = 0;		
							
	}
	
	public void draggScreen(Image dragImg){
		zmiennaTla = (int) (-dragImg.getHeight() + 700);
		if (Gdx.input.justTouched()) {
	//		System.out.println("Mouse ClickOn: " + Gdx.input.getX() + " " + Gdx.input.getY());
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			dragOld = dragNew;

		}
		if (Gdx.input.isTouched()) {
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());

			if (!dragNew.equals(dragOld)) {

				zmiennaRuchu = dragNew.y - dragOld.y;
				balanceView += zmiennaRuchu* 30 * Gdx.graphics.getDeltaTime();

				if(inRange(dragImg))moveImagesBy(dragImg);
			
				System.out.println("Balance: " + balanceView);				
				dragOld = dragNew; // Drag old becomes drag new.
			}
		}

	}
	
	private void moveImagesBy(Image dragImg) {
		//Dla androida musi byc * 30 * delta
		dragImg.moveBy(0, -zmiennaRuchu * 30 * Gdx.graphics.getDeltaTime());
	}
	
	private boolean inRange(Image dragImg) {
		
		if ((balanceView <= maxAtTop) && balanceView >= maxAtBottom ) {

			return true;
		} else if (balanceView > maxAtTop) {
			//Jesli przesuniecie jest wieksze niz koniec topa, stopuje przesuwanie
			dragImg.setPosition(0, zmiennaTla);
			balanceView = maxAtTop;
			return false;

		} else {
			//Jesli przesuniecie jest wieksze niz koniec bota, stopuje przesuwanie
			dragImg.setPosition(0, zmiennaTla - maxAtBottom);
			balanceView = maxAtBottom;
			return false;
		}

	}
	
}