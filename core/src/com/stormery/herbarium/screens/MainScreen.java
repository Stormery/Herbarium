package com.stormery.herbarium.screens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.herbs.Pokrzywa;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

enum enumHerb{
	POKRZYWA, RUMIANEK;
	
}
// TODO
/*
 * Przeniesc cala mechanike do oddzielnej klasy
 * wymyslec cos z Array HerbImage bo wywala nullpointer przy dragowaniu pustych indexow
 */
public class MainScreen extends HerbPage {

	
	private Image background;
	private HerbImage bttBackground;
	
	private ArrayList<enumHerb> herbList;
	//private HerbImage[] herbButton;
	private ArrayList<HerbImage> herbButton;
	
	//TherapeuticUse
	private HerbImage bttPrzeciwbakt;
	private HerbImage bttPrzeciwzap;
	private HerbImage bttMoczopedne;
	
	private int therapeuticUseBttHeigh = 40;
	private int therapeuticUseBttWidth = 140;
	
	private int position01row = 500;
	private int position01x = 30;
	private int position02x = 200;
	private int position02row = 440;
	
	//List of Herbs
	private HerbImage bttPokrzywa;
	private boolean isTherePokrzywa=false;
	
	private HerbImage bttRumianek;
	

	
	/////



	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		
		herbButton = new ArrayList<HerbImage>();
		
		herbList = new ArrayList<enumHerb>();
		
		initBackgroundTextures();
		
		initTypeOfTherapeuticUseButton();
		
		initHerbs();
		
	}
	private void initTypeOfTherapeuticUseButton() {
		
		bttPrzeciwbakt = new HerbImage("buttons/TypeOfTherapeuticUse/PrezciwbaktButton.png", position01x, position01row, therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny przeciwbakteryjne");
				
				
			}
		}, herbarium);
		
		herbButton.add(bttPrzeciwbakt);
		stage.addActor(bttPrzeciwbakt);
		/////////////////////////////////
		bttPrzeciwzap = new HerbImage("buttons/TypeOfTherapeuticUse/PrzeciwZapButtone.png", position02x, position01row, therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny przeciwzapalne");
				
			}
		}, herbarium);
		herbButton.add(bttPrzeciwzap);
		stage.addActor(bttPrzeciwzap);
		//////////////////////////////////////
		bttMoczopedne = new HerbImage("buttons/TypeOfTherapeuticUse/MoczopedneButton.png", position01x, position02row , therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny Moczopedne");
				herbList.add(enumHerb.POKRZYWA);
				initHerbs();
				
			}
		}, herbarium);
		herbButton.add(bttMoczopedne);
		stage.addActor(bttMoczopedne);
	////////////////////////////////////
		
	}

	private void initHerbs() {
		// Add search engine for adding herbenums
		//System.out.println(herbList.indexOf(enumHerb.POKRZYWA)); // to ma byc numer kolejnosci to daje int
		//TODO rozmiar buttonow, kolejnosc buttonow, inaczej zrobic HERBIMAGE[2]
		
		
		//herbList.add(enumHerb.POKRZYWA);
		//herbList.add(enumHerb.RUMIANEK);		
	
		if((herbList.contains(enumHerb.POKRZYWA) )&& !isTherePokrzywa){
			initPokrzywaButton();
			isTherePokrzywa = true;
		}
		if(herbList.contains(enumHerb.RUMIANEK) ){
			initRumianekButton();
		}
	}
	

/*
 * herbButton[1+herbList.indexOf(enumHerb.RUMIANEK)]= bttRumianek;
 * This 1+ is for buttons of therapeutic use, I can use only one Array of HerbButton so I need always 
 * resize by 1+ 2+ 3+ depends of how many therapeuticUse buttons are. And after this is counting for number
 * of needed herbs in array.
 */
	private void initRumianekButton() {
		

	bttRumianek = new HerbImage(herbList.indexOf(enumHerb.RUMIANEK), "buttons/herbs/RumianekButton.png", position02x, position01row, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("click rumianek");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium);
		
		herbButton.add(bttRumianek);
		stage.addActor(bttRumianek);
		
	}

	private void initPokrzywaButton() {
		bttPokrzywa = new HerbImage(herbList.indexOf(enumHerb.POKRZYWA), "buttons/herbs/PokrzywaButton.png", position01x, position01row, 0, 0, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium);
		
		herbButton.add(bttPokrzywa);
		stage.addActor(bttPokrzywa);
	}



	private void initBackgroundTextures() {

		background = new Image(new Texture("backgroundImg/tlo02.png"));
		bttBackground = new HerbImage("backgroundImg/tlo02.png", 0, -background.getHeight() + windowHeight, 0, 0, herbarium);
		stage.addActor(bttBackground);

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		
		draggScreen(bttBackground, herbButton);
		
	}

}
