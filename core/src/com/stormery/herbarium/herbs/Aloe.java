package com.stormery.herbarium.herbs;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ayo on 2017-08-22.
 */

public class Aloe extends HerbPage {
    static UseButton aloeButton;

    public Aloe(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAloe(final Herbarium herbarium) {

            aloeButton = new UseButton(EnumHerb.ALOE, new IClickCallback() {
                @Override
                public void onClick() {
                    System.out.println("IDZIE DO ALOES PAGE");
                     herbarium.setScreen(new Aloe(herbarium));

                }
            });
        MainScreenTableContainer.tableInnerScrollable.add(aloeButton).width(320f).height(100f).padBottom(10f);
        MainScreenTableContainer.tableInnerScrollable.row();

    }

    @Override
    protected void init() {
        Image aloeLogo = new Image(new Texture("buttons/herbs/AloeDesc.png"));
        Image aloeDesc = new Image(new Texture("buttons/herbs/AloePageDesc.png"));

        initBackgroundTextures();
        initTableMain(aloeLogo,aloeDesc);
        initReturnButton();
    }




}
