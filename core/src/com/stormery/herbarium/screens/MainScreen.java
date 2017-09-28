package com.stormery.herbarium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.service.EnumLanguage;
import com.stormery.herbarium.ui.MainScreenTableContainer;


public class MainScreen extends HerbPage {
    protected Herbarium herbarium;
    public static boolean isNotDragging = true;
    private static int finishedLoading=0;

    public MainScreen(Herbarium herbarium) {
        super(herbarium);
        this.herbarium = herbarium;
        initialize();
    }

    private void initialize() {
        initBackgroundTextures();
        new MainScreenTableContainer(EnumLanguage.ENGLISH,stage,herbarium);

        //initButtons();
    }

    @Override
    protected void init() {
        // initTable();

    }
    private void initBackgroundTextures() {

        Image background = new Image(new Texture("backgroundImg/Background.png"));
        background.setHeight(700);
        background.setWidth(480);
        Image redBookmark = new Image(new Texture("backgroundImg/bookmark.png"));
        stage.addActor(background);
        stage.addActor(redBookmark);
    }
    /*
* To show a herb after choose a therapeutic propertie
* first in Render - it is checking what herb need to be showed, according to checking list in
* every herb. For example if I click on LAXATIVE it calls "signForPrzeczyszczajace" as TRUE ( MainScreenTable)
* If it is TRUE and only this one is TRUE (it is checking in ALOE.java ) it turns checkIfAloe function to true
* And this function when its true make button for aloe
*/
    public static void countLoading(Enum herbEnum){
        System.out.println(finishedLoading++ + " Loaded asset: "+herbEnum.toString());
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
