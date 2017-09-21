package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;
import com.stormery.herbarium.ui.UseButton;

/**
 * Created by Ayo on 2017-08-28.
 */

public class Senna extends HerbPage {
    static UseButton sennaButton;

    public Senna(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initSenna() {
       sennaButton = new UseButton(EnumHerb.SENNA, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Senes PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(sennaButton).width(320).height(100).padBottom(10f);
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