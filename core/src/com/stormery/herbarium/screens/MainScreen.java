package com.stormery.herbarium.screens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.buttons.TherapeuticUseButton;
import com.stormery.herbarium.herbs.Pokrzywa;
import com.stormery.herbarium.ui.HerbImage;
import com.stormery.herbarium.ui.IClickCallback;

enum enumHerb{
	POKRZYWA, RUMIANEK
	
}

public class MainScreen extends HerbPage {

	protected Herbarium herbarium;
	private Image background;
	private Image redBookmark;
	public static boolean isNotDragging = true;


	private ArrayList<enumHerb> herbList;

	//private int therapeuticUseBttHeigh = 40;
	//private int therapeuticUseBttWidth = 140;

	//Therapeutic Use
	TherapeuticUseButton bttTherapeuticMoczopedne;
	TherapeuticUseButton bttTherapeuticPrzeciwbakt;

	//List of Herbs
	private boolean isTherePokrzywa=false;
	private boolean isThereRumianek=false;

	
	/////Tables
	private Table tableMain;
	private Table tableUsageType;
	private Table tableInnerScrollable;
	private Table tableBookmarkScrollable;
	private boolean tableDebug = false;


	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		this.herbarium = herbarium;
		init();
	}

	@Override
	protected void init() {
		herbList = new ArrayList<enumHerb>();
		initBackgroundTextures();
		initButtons();
		initTable();

	}

	private void initButtons() {
		//TODO Therapeutic properties buttons
		bttTherapeuticMoczopedne = new TherapeuticUseButton(EnumTherapeuticProperties.DIURETIC, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("Moczopedne click");
			}
		});

		bttTherapeuticPrzeciwbakt = new TherapeuticUseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("Przeciwbakt click");
			}
		});
	}

	////////////////////Dodaje Scrollowanie przez Scrollview
	private void initTable() {
		//TODO zmienic skin i Atlas
		Image tableLogo = new Image(new Texture("backgroundImg/Logo.png"));

//InstantiateTables
		tableMain = new Table();
				//tableUsageType = new Table();
//FillParent
		tableMain.setFillParent(true);
//Debug
		tableMain.setDebug(tableDebug);
				//tableUsageType.setDebug(tableDebug);
//Set MainTable position
		tableMain.top().left().padRight(25f).padTop(10f);
//Bookmark scrollable
		tableBookmarkScrollable();

		tableMain.add(tableLogo).colspan(2).height(152f).top(); //LOGO
		tableMain.row();

		//TODO wyszukiwarki nie ma
		tableMain.add().height(30f).colspan(2); // wyszukiwarka

//Instantiate Box with Therapeutic use Buttons
		tableWithTherapeuticUseTypes();
//Instantiate Box with ScrollableButtons
		tableInnerWithScrollableHerbs();
		stage.addActor(tableMain);
	}

	private void tableBookmarkScrollable(){

		tableBookmarkScrollable = new Table();
		tableBookmarkScrollable.setDebug(tableDebug);
		ScrollPane scrollPane = new ScrollPane(tableBookmarkScrollable);
		scrollPane.setOverscroll(false,false);

		tableMain.add(scrollPane).top().left().width(100f).height(590f)
				.padLeft(20f).padRight(20f).padBottom(55f);//bookmark
	}

	private void tableInnerWithScrollableHerbs() {
		tableInnerScrollable = new Table();
		tableInnerScrollable.setDebug(tableDebug);

		ScrollPane scrollPane = new ScrollPane(tableInnerScrollable);
		scrollPane.setOverscroll(false, false);
		
		tableMain.row();
		tableMain.add(scrollPane).colspan(2).top();
		
	}

	private void tableWithTherapeuticUseTypes() {
		//TherapeuticUse
		tableBookmarkScrollable.add(bttTherapeuticMoczopedne).top().left();
		tableBookmarkScrollable.row();
		tableBookmarkScrollable.add(bttTherapeuticPrzeciwbakt).top().left().padTop(20f);
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
		testBookmarkTable();
//	bttPrzeciwbakt = new HerbImage("buttons/TypeOfTherapeuticUse/PrezciwbaktButton.png", new IClickCallback() {
//
//			@Override
//			public void onClick() {
//				System.out.println("rosliny przeciwbakteryjne");
//				//addPrzeciwbakteryjneHerbstoList();
//			}
//		}, herbarium);
//
//		tableUsageType.add(bttPrzeciwbakt).pad(20);
//		/////////////////////////////////
//		bttPrzeciwzap = new HerbImage("buttons/TypeOfTherapeuticUse/PrzeciwZapButtone.png", new IClickCallback() {
//
//			@Override
//			public void onClick() {
//				System.out.println("rosliny przeciwzapalne");
//				//addPrzeciwzapalneHerbsToList();
//				herbList.add(enumHerb.RUMIANEK); //test
//				initHerbs();
//
//			}
//		}, herbarium);
//		tableUsageType.add(bttPrzeciwzap).pad(20);
//		//////////////////////////////////////
//		bttMoczopedne = new HerbImage("buttons/TypeOfTherapeuticUse/MoczopedneButton.png", new IClickCallback() {
//
//			@Override
//			public void onClick() {
//				System.out.println("rosliny Moczopedne");
//				//addMoczopedneHerbsToList();
//				herbList.add(enumHerb.POKRZYWA);//test
//				initHerbs();
//			}
//		}, herbarium);
//		tableUsageType.add(bttMoczopedne).pad(20);
	////////////////////////////////////
		
	}

	private void testBookmarkTable() {
		tableBookmarkScrollable.row();
		tableBookmarkScrollable.add(new TherapeuticUseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
			@Override
			public void onClick() {
				System.out.println("TEST scrollable bookmark");
			}
		})).padTop(10f);
	}

	private void initHerbs() {
		// Add search engine for adding herbenums
		//System.out.println(herbList.indexOf(enumHerb.POKRZYWA)); // to ma byc numer kolejnosci to daje int
		//TODO rozmiar buttonow, kolejnosc buttonow, inaczej zrobic HERBIMAGE[2]
		
		
		//herbList.add(enumHerb.POKRZYWA);
		//herbList.add(enumHerb.RUMIANEK);		
	
		if((herbList.contains(enumHerb.POKRZYWA) )&& !isTherePokrzywa){
			initPokrzywaButton();
			initPokrzywaButton();
			initPokrzywaButton();
			initPokrzywaButton();
			initPokrzywaButton();
			initPokrzywaButton();
			initPokrzywaButton();
			initPokrzywaButton();
			//isTherePokrzywa = true;
		}
		if(herbList.contains(enumHerb.RUMIANEK) && !isThereRumianek) {
			initRumianekButton();
			isThereRumianek = true;

		}
	}

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
	private HerbImage pokrzywa = new HerbImage("buttons/herbs/PokrzywaButton.png", 0, 0, new IClickCallback() {

		@Override
		public void onClick() {
			System.out.println("click pokrzywa");
			herbarium.setScreen(new Pokrzywa(herbarium));
		}
	}, herbarium);

	private void initPokrzywaButton() {

		tableInnerScrollable.row();
		tableInnerScrollable.add(pokrzywa).pad(10);
	}



	private void initBackgroundTextures() {

		background = new Image(new Texture("backgroundImg/tlo03.png"));
		stage.addActor(background);
		redBookmark = new Image(new Texture("backgroundImg/bookmark.png"));
		redBookmark.setPosition(5f, 0);
		stage.addActor(redBookmark);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act();
	}

	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();

	}

}
