package com.stormery.herbarium.herbs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ayo on 2017-08-28.
 */

public class AlderBuckthorn extends HerbPage {
    static UseButton alderBuckthornButton;
    private ArrayList<String> alderBuckthornDesc;
    private Table tableMain;
    Table tableScroll;

    public AlderBuckthorn(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAlderBuckthorn(final Herbarium herbarium) {
        alderBuckthornButton = new UseButton(EnumHerb.ALDER_BUCKTHORN, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kruszyna PAGE");
                herbarium.setScreen(new AlderBuckthorn(herbarium));
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(alderBuckthornButton).width(320).height(100).padBottom(10f);
        MainScreenTableContainer.tableInnerScrollable.row();
    }

    @Override
    protected void init() {
        initBackgroundTextures();
        alderBuckthornDesc =  new ArrayList<String>();
        initDummyTable();
        readFile("AlderBuckthorn.txt");
        initReturnButton();
    }

    private void initDummyTable() {
        boolean setDebug = false;
        Skin skin = new Skin(Gdx.files.internal("ui/skinTable/VerdanaClassic.json"),
                new TextureAtlas(Gdx.files.internal("ui/skinTable/VerdanaClassic.atlas")));
        skin.getFont("VerdanaClassic").getData().setScale(0.8f);

        tableMain = new Table();
        tableMain.setFillParent(true);
        tableMain.setDebug(setDebug);

        Table tableInner = new Table();
        tableInner.setDebug(setDebug);
        tableInner.top().right();


        tableScroll = new Table(skin);
        tableScroll.setDebug(setDebug);
        tableScroll.top().left();

        ScrollPane scrollPane = new ScrollPane(tableScroll);
        scrollPane.setOverscroll(false, false);
        tableInner.add(scrollPane);


        tableMain.add(tableInner).padLeft(12f);
        stage.addActor(tableMain);
    }

    public void readFile(String filePath) {

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filePath), "cp1250"));
            String textLine = bufferedReader.readLine();
            do {
                System.out.println(textLine);

                tableScroll.add(textLine).left();
                tableScroll.row();
                textLine = bufferedReader.readLine();
            } while(textLine != null);

            bufferedReader.close();

        } catch (IOException ie){

        }

    }


}

