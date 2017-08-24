package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.buttons.UseButton;
import com.stormery.herbarium.herbs.Aloe;
import com.stormery.herbarium.herbs.Angelica;
import com.stormery.herbarium.herbs.Aniseed;
import com.stormery.herbarium.herbs.Cranberry;
import com.stormery.herbarium.herbs.Elder;
import com.stormery.herbarium.herbs.PlantagoOvata;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

import java.util.ArrayList;


public class MainScreen extends HerbPage {

    protected Herbarium herbarium;
    private Image background;
    private Image redBookmark;
    public static boolean isNotDragging = true;


    //TODO z tym zadzialac
    private ArrayList<EnumHerb> herbList;

    public MainScreen(Herbarium herbarium) {
        super(herbarium);
        this.herbarium = herbarium;
        init();
    }

    @Override
    protected void init() {
        herbList = new ArrayList<EnumHerb>();
        initBackgroundTextures();
        initButtons();
        new MainScreenTableContainer(stage);
        // initTable();

    }

    private void initButtons() {
        Aloe.initAloe();
        Angelica.initAngelica();
        Aniseed.initAniseed();
        Cranberry.initCranberry();
        Elder.initElder();
        PlantagoOvata.initPlantagoOvata();
    }

    private void initBackgroundTextures() {

        background = new Image(new Texture("backgroundImg/tlo04.jpg"));
        background.setHeight(700);
        background.setWidth(480);
        stage.addActor(background);
        redBookmark = new Image(new Texture("backgroundImg/bookmark.png"));
        redBookmark.setPosition(5f, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        whatHerbToShow();
        stage.act();

    }
/*
* To show a herb after choose a therapeutic propertie
* first in Render - it is checking what herb need to be showed, according to checking list in
* every herb. For example if I click on LAXATIVE it calls "signForPrzeczyszczajace" as TRUE ( MainScreenTable)
* If it is TRUE and only this one is TRUE (it is checking in ALOE.java ) it turns checkIfAloe function to true
* And this function when its true make button for aloe
*/

    private void whatHerbToShow() {

        //TODO wybor jezyka tu jest na ENG
        Aloe.getAloeButton();
        Angelica.getAngelicaButton();
        Aniseed.getAniseedButton();
        Cranberry.getCranberryButton();
        Elder.getElderButton();
        PlantagoOvata.getPlantagoOvataButton();

    }


    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();

    }

}
