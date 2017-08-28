package com.stormery.herbarium.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.service.EnumLanguage;
import com.stormery.herbarium.ui.LanguageAndHerbShow;
import com.stormery.herbarium.ui.MainScreenTableContainer;
import com.stormery.herbarium.herbs.AlderBuckthorn;
import com.stormery.herbarium.herbs.Aloe;
import com.stormery.herbarium.herbs.Althea;
import com.stormery.herbarium.herbs.Angelica;
import com.stormery.herbarium.herbs.Aniseed;
import com.stormery.herbarium.herbs.Bearberry;
import com.stormery.herbarium.herbs.BirchTree;
import com.stormery.herbarium.herbs.Carom;
import com.stormery.herbarium.herbs.Chamomile;
import com.stormery.herbarium.herbs.CommonHop;
import com.stormery.herbarium.herbs.Coriander;
import com.stormery.herbarium.herbs.Cranberry;
import com.stormery.herbarium.herbs.Dill;
import com.stormery.herbarium.herbs.Elder;
import com.stormery.herbarium.herbs.Flax;
import com.stormery.herbarium.herbs.GoldenRod;
import com.stormery.herbarium.herbs.Hawthorn;
import com.stormery.herbarium.herbs.Helichrysum;
import com.stormery.herbarium.herbs.Horsetail;
import com.stormery.herbarium.herbs.Juniper;
import com.stormery.herbarium.herbs.Knotgrass;
import com.stormery.herbarium.herbs.Lavender;
import com.stormery.herbarium.herbs.LemonBalm;
import com.stormery.herbarium.herbs.Lovage;
import com.stormery.herbarium.herbs.Mallow;
import com.stormery.herbarium.herbs.Peppermint;
import com.stormery.herbarium.herbs.PlantagoOvata;
import com.stormery.herbarium.herbs.Poplar;
import com.stormery.herbarium.herbs.Psyllium;
import com.stormery.herbarium.herbs.Rhubarb;
import com.stormery.herbarium.herbs.Sage;
import com.stormery.herbarium.herbs.Senna;
import com.stormery.herbarium.herbs.StJohnsWort;
import com.stormery.herbarium.herbs.Thyme;
import com.stormery.herbarium.herbs.Tilia;
import com.stormery.herbarium.herbs.Valerian;
import com.stormery.herbarium.herbs.ViolaTricolor;
import com.stormery.herbarium.herbs.Willow;
import com.stormery.herbarium.herbs.Yarrow;
import java.util.ArrayList;


public class MainScreen extends HerbPage {

    protected Herbarium herbarium;
    private Image background;
    private Image redBookmark;
    public static boolean isNotDragging = true;


    //TODO z tym zadzialac
    private ArrayList<com.stormery.herbarium.service.EnumHerb> herbList;

    public MainScreen(Herbarium herbarium) {
        super(herbarium);
        this.herbarium = herbarium;
        init();
    }

    @Override
    protected void init() {
        herbList = new ArrayList<com.stormery.herbarium.service.EnumHerb>();
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
        BirchTree.initBirchTree();
        CommonHop.initCommonHop();
        StJohnsWort.initStJohnsWort();
        ViolaTricolor.initViolaTricolor();
        Hawthorn.initHawthorn();
        Juniper.initJuniper();
        Carom.initCarom();
        Helichrysum.initHelichrysum();
        Coriander.initCoriander();
        Dill.initDill();
        Valerian.initValerian();
        AlderBuckthorn.initAlderBuckthorn();
        Yarrow.initYarrow();
        Lavender.initLavender();
        Flax.initFlax();
        Tilia.initTilia();
        Lovage.initLovage();
        Bearberry.initBearberry();
        LemonBalm.initLemonBalm();
        Peppermint.initPeppermint();
        GoldenRod.initGoldenRod();
        Psyllium.initPsyllium();
        Althea.initAlthea();
        Knotgrass.initKnotgrass();
        Chamomile.initChamomile();
        Rhubarb.initRhubarb();
        Senna.initSenna();
        Horsetail.initHorsetail();
        Mallow.initMallow();
        Sage.initSage();
        Poplar.initPoplar();
        Thyme.initThyme();
        Willow.initWillow();

    }


    private void initBackgroundTextures() {

        background = new Image(new Texture("backgroundImg/tlo04.jpg"));
        background.setHeight(700);
        background.setWidth(480);
        stage.addActor(background);
        redBookmark = new Image(new Texture("backgroundImg/bookmark.png"));
        redBookmark.setPosition(5f, 0);
    }
    /*
* To show a herb after choose a therapeutic propertie
* first in Render - it is checking what herb need to be showed, according to checking list in
* every herb. For example if I click on LAXATIVE it calls "signForPrzeczyszczajace" as TRUE ( MainScreenTable)
* If it is TRUE and only this one is TRUE (it is checking in ALOE.java ) it turns checkIfAloe function to true
* And this function when its true make button for aloe
*/

    @Override
    public void render(float delta) {
        super.render(delta);
        LanguageAndHerbShow.checkLanguageAndInitHerbs(EnumLanguage.POLISH);
        stage.act();

    }



    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();

    }

}
