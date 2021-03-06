package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-22.
 */

public class Aniseed extends HerbPage {
    static UseButton aniseedButton;

    public Aniseed(Herbarium herbarium) {
        super(herbarium);
    }

    @Override
    protected void init() {
        initBackgroundTexture();
        initReturnButton();
    }

    private void initBackgroundTexture() {
    }

    public static void initAniseed() {
        aniseedButton = new UseButton(EnumHerb.ANISEED, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO ANYZ PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(aniseedButton).width(herbButtonWidth).height(herbButtonHeight).padBottom(10f);
        MainScreenTableContainer.tableInnerScrollable.row();
    }


}
