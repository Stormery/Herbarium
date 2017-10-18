package com.stormery.herbarium.herbs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;
import com.stormery.herbarium.ui.UseButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Stormery on 2017-10-18.
 */

public class TestHerb extends HerbPage {
    static UseButton alderBuckthornButton;
    private ArrayList<String> alderBuckthornDesc;
    private Table tableMain;
    Table tableScroll;

    public TestHerb(Herbarium herbarium) {
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
        readFile("herbDesc/AlderBuckthorn.txt");
        //readingFile("AlderBuckthorn.txt");
        initReturnButton();
    }

    private void initDummyTable() {
        boolean setDebug = false;
        Skin skin = new Skin(Gdx.files.internal("ui/skinTable/Verdana.json"),
                new TextureAtlas(Gdx.files.internal("ui/skinTable/Verdana.atlas")));
        skin.getFont("VerdanaCursive").getData().setScale(0.55f);

        tableMain = new Table();
        tableMain.setFillParent(true);
        tableMain.setDebug(setDebug);
        tableMain.left().padLeft(10f);

        Table tableInner = new Table(skin);
        tableInner.setDebug(setDebug);
        tableInner.top().right();
        //HerbPicture
        tableInner.add(new Image(new Texture("buttons/herbs/Alder/Alder01.jpg"))).width(160f).height(100f);
        //HerbLogo Desc
        tableInner.add("Alder Bucktorn").expandX().height(100f);
        tableInner.row();
        //TODO przyciac troche zloty pasek bo wystaje
        tableInner.add(new Image(new Texture("backgroundImg/ZlotyPasek.png"))).colspan(2).expandX().left();
        tableInner.row();


        tableScroll = new Table(skin);
        tableScroll.setDebug(setDebug);
        tableScroll.top().left();

        ScrollPane scrollPane = new ScrollPane(tableScroll);
        scrollPane.setOverscroll(false, false);
        tableInner.add(scrollPane).colspan(2).left();


        tableMain.add(tableInner);
        stage.addActor(tableMain);
    }

    public void readingFile(String path){
        FileHandle handle = Gdx.files.local(path);
        String text = handle.readString();
        String wordsArray[] = text.split("\\r?\\n");
        for(String word : wordsArray) {
            tableScroll.add(word);
        }
    }
    public void readFile(String filePath) {
        FileHandle file = Gdx.files.internal("herbDesc/AlderBuckthorn.txt");
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(String.valueOf(file)), "cp1250"));
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