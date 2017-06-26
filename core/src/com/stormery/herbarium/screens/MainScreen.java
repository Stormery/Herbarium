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
	POKRZYWA, RUMIANEK;
	
}
// TODO
/*
 * Przeniesc cala mechanike do oddzielnej klasy
 * 
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
	private Table table;
	private Table usageTypeTable;
	private Table innerScrollableTable;
	private Skin skin;


	public MainScreen(Herbarium herbarium) {
		super(herbarium);
		init();

	}

	@Override
	protected void init() {
		
		
		herbButton = new ArrayList<HerbImage>();
		
		herbList = new ArrayList<enumHerb>();
		
		initBackgroundTextures();
		initTable();
			
		initTypeOfTherapeuticUseButton();
		
		scrollViewInnerTableTest();
			
		initHerbs();
		
		
		
		
	}
	
	private Image testHerb;
	ScrollPane scrollPane;
	private void scrollViewInnerTableTest() {
		innerScrollableTable = new Table(skin);
		innerScrollableTable.setDebug(false);
		
		
		testHerb = new Image(new Texture("buttons/herbs/AloesButton.png"));
		
		
		innerScrollableTable.add(testHerb).pad(10);

		scrollPane = new ScrollPane(innerScrollableTable, skin);
		scrollPane.setOverscroll(false, false);
		
		table.row();
		table.add(scrollPane).colspan(3);
		//stage.addActor(innerTable); // czy ja tego otrzebuje?
		
		
	}


	////////////////////Dodaje Scrollowanie przez Scrollview
	public Image tableLogo;
	private void initTable() {
		tableLogo = new Image(new Texture("backgroundImg/Logo.png"));
		
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/atlas.pack"));
		table = new Table(skin);
		usageTypeTable = new Table(skin);
		
		table.setFillParent(true);
		
		table.setDebug(true);
		usageTypeTable.setDebug(true);
		
		table.top().left();
		
		table.add(tableLogo).colspan(3).height(152f);
		table.row();
		table.add(usageTypeTable).height(100f);
		
		
		stage.addActor(table);
	}

	private void initTypeOfTherapeuticUseButton() {
		
		bttPrzeciwbakt = new HerbImage("buttons/TypeOfTherapeuticUse/PrezciwbaktButton.png", position01x, position01row, therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny przeciwbakteryjne");
				
				
			}
		}, herbarium);
		
		herbButton.add(bttPrzeciwbakt);
		//stage.addActor(bttPrzeciwbakt);
		usageTypeTable.add(bttPrzeciwbakt).pad(20);
		/////////////////////////////////
		bttPrzeciwzap = new HerbImage("buttons/TypeOfTherapeuticUse/PrzeciwZapButtone.png", position02x, position01row, therapeuticUseBttWidth, therapeuticUseBttHeigh, new IClickCallback() {
			
			@Override
			public void onClick() {
				System.out.println("rosliny przeciwzapalne");
				herbList.add(enumHerb.RUMIANEK);
				initHerbs();
				
			}
		}, herbarium);
		herbButton.add(bttPrzeciwzap);
		//stage.addActor(bttPrzeciwzap);
		usageTypeTable.add(bttPrzeciwzap).pad(20);
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
		//stage.addActor(bttMoczopedne);
		usageTypeTable.add(bttMoczopedne).pad(20);
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
		//stage.addActor(bttRumianek);
		innerScrollableTable.row();
		innerScrollableTable.add(new Image(new Texture("buttons/herbs/AloesButton.png"))).pad(10);
		
		
		
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
		//stage.addActor(bttPokrzywa);
		innerScrollableTable.add(bttPokrzywa);
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
		stage.act();
		//draggScreen(bttBackground, herbButton);
		
	}

}
