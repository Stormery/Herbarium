package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.buttons.UseButton;
import com.stormery.herbarium.screens.EnumTherapeuticProperties;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.screens.MainScreen;

import sun.applet.Main;

/**
 * Created by Ayo on 2017-08-16.
 */

public class MainScreenTableContainer {
    /////Tables
    private Table tableMain;
    private Table tableUsageType;
    private Table tableInnerScrollable;
    private Table tableBookmarkScrollable;
    private boolean tableDebug = false;

    private Stage stage;

    public MainScreenTableContainer(Stage stage){
        this.stage = stage;
        initTable();
    }

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
        float therapeuticUsePadTop = 20f;
        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwbakt click");
            }
        })).top().left().padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.ANTIPYRETIC, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("przeciwgoraczkowe click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.ANTISPASMODIC, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Przeciwskurczowe  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.ANTITUSSIVE, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Przeciwkaszlowe  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.ASTRINGENTS, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Sciagajace  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.CARDIAC_INSUFFICIENCY, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("NiewydolnoscKrazenia  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.CARMINATIVE, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Wiatropedne  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.CHOLAGOGUES, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Zolciopedne  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.DEMULCENT, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Przeciwzapalne  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.DIAPHORETIC, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Napotne  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.DIURETIC, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Moczopednt click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.EXPECTORANT, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Wykrztusne  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.IMPROVING_DIGESTION, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Pobudzatrawienie  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.LAXATIVE, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Przeczyszczajace  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.PROTECTIVE_SCREENING, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Oslaniajace  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.SEDATIVE, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Uspokajajace  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.SPASMOLYTIC, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Rozkurczajace  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add( new UseButton(EnumTherapeuticProperties.URINARY_TRACT_DISINFECTANT, new IClickCallback(){
            @Override
            public void onClick() {
                System.out.println("Odkazajace drogi moczowe  click");
            }
        } )).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();


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
        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("TEST scrollable bookmark");
            }
        })).padTop(10f);
    }
}
