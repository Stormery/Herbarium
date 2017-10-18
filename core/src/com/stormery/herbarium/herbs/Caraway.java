package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-28.
 */

public class Caraway extends HerbPage {
    static UseButton carawayButton;

    public Caraway(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initCarom() {
        carawayButton = new UseButton(EnumHerb.CARAWAY, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kminku PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(carawayButton).width(320).height(100).padBottom(10f);
        MainScreenTableContainer.tableInnerScrollable.row();
    }

    @Override
    protected void init() {
        initBackgroundTexture();
        initReturnButton();
    }

    private void initBackgroundTexture() {
    }

}