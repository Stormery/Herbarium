package com.stormery.herbarium.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.herbs.Pokrzywa;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

enum enumHerb{
	POKRZYWA, RUMIANEK
	
}
// TODO
/*
 * Przeniesc cala mechanike do oddzielnej klasy
 * 
 */
public class MainScreen extends HerbPage {

	
	private Image background;

	
	private ArrayList<enumHerb> herbList;


	private int therapeuticUseBttHeigh = 40;
	private int therapeuticUseBttWidth = 140;

	//List of Herbs
	private boolean isTherePokrzywa=false;
	private boolean isThereRumianek=false;

	
	/////
	private Table tableMain;
	private Table tableUsageType;
	private Table tableInnerScrollable;
	public static Skin skin;


	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {

		herbList = new ArrayList<enumHerb>();
		initBackgroundTextures();

		initTable();

		//initHerbs();
	}
	////////////////////Dodaje Scrollowanie przez Scrollview
	private void initTable() {
		//TODO zmienic skin i Atlas
		Image tableLogo = new Image(new Texture("backgroundImg/Logo.png"));

		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/atlas.pack"));
//InstantiateTables
		tableMain = new Table(skin);
		tableUsageType = new Table(skin);
//FillParent
		tableMain.setFillParent(true);
//Debug
		tableMain.setDebug(false);
		tableUsageType.setDebug(false);
//Set MainTable position
		tableMain.top().left();

		tableMain.add(tableLogo).colspan(3).height(152f);
		tableMain.row();
		tableMain.add(tableUsageType).height(100f);

//Instantiate Box with Therapeutic use Buttons
		tableWithTherapeuticUseTypes();
//Instantiate Box with ScrollableButtons
		tableInnerWithScrollableHerbs();
		stage.addActor(tableMain);
	}

	private void tableInnerWithScrollableHerbs() {
		tableInnerScrollable = new Table(skin);
		tableInnerScrollable.setDebug(false);

//		Image testHerb = new Image(new Texture("buttons/herbs/AloesButton.png"));
//		tableInnerScrollable.add(testHerb).pad(10);

		ScrollPane scrollPane = new ScrollPane(tableInnerScrollable);
		scrollPane.setOverscroll(false, false);
		
		tableMain.row();
		tableMain.add(scrollPane).colspan(3);
		
	}

	private void tableWithTherapeuticUseTypes() {
		//TherapeuticUse
		 HerbImage bttPrzeciwbakt;
		 HerbImage bttPrzeciwzap;
		 HerbImage bttMoczopedne;



		bttPrzeciwbakt = new HerbImage("buttons/TypeOfTherapeuticUse/PrezciwbaktButton.png", therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny przeciwbakteryjne");
				//addPrzeciwbakteryjneHerbstoList();
				
			}
		}, herbarium);
		
		tableUsageType.add(bttPrzeciwbakt).pad(20);
		/////////////////////////////////
		bttPrzeciwzap = new HerbImage("buttons/TypeOfTherapeuticUse/PrzeciwZapButtone.png",therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny przeciwzapalne");
				//addPrzeciwzapalneHerbsToList();
				herbList.add(enumHerb.RUMIANEK); //test
				initHerbs();
				
			}
		}, herbarium);
		tableUsageType.add(bttPrzeciwzap).pad(20);
		//////////////////////////////////////
		bttMoczopedne = new HerbImage("buttons/TypeOfTherapeuticUse/MoczopedneButton.png", therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny Moczopedne");
				//addMoczopedneHerbsToList();
				herbList.add(enumHerb.POKRZYWA);//test
				initHerbs();
				
			}
		}, herbarium);
		tableUsageType.add(bttMoczopedne).pad(20);
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
			//isTherePokrzywa = true;
		}
		if(herbList.contains(enumHerb.RUMIANEK) && !isThereRumianek) {
			initRumianekButton();
			isThereRumianek = true;

		}
	}
	

/*
 * herbButton[1+herbList.indexOf(enumHerb.RUMIANEK)]= bttRumianek;
 * This 1+ is for buttons of therapeutic use, I can use only one Array of HerbButton so I need always 
 * resize by 1+ 2+ 3+ depends of how many therapeuticUse buttons are. And after this is counting for number
 * of needed herbs in array.
 */
	private void initRumianekButton() {

		tableInnerScrollable.row();
		tableInnerScrollable.add(new HerbImage( "buttons/herbs/RumianekButton.png", 0, 0, new IClickCallback() {

			@Override
			public void onClick() {
				System.out.println("click rumianek");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium)).pad(10);
		
		
		
	}

	private void initPokrzywaButton() {

		tableInnerScrollable.row();
		tableInnerScrollable.add(new HerbImage("buttons/herbs/PokrzywaButton.png", 0, 0, new IClickCallback() {

			@Override
			public void onClick() {
				System.out.println("click pokrzywa");
				herbarium.setScreen(new Pokrzywa(herbarium));
			}
		}, herbarium)).pad(10);
	}



	private void initBackgroundTextures() {

		background = new Image(new Texture("backgroundImg/tlo02.png"));
		stage.addActor(background);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act();

	}

}
