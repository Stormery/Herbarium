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

public class Juniper extends HerbPage {
    static UseButton juniperButton;

    public Juniper(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initJuniper() {
        juniperButton = new UseButton(EnumHerb.JUNIPER, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Jalowca PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(juniperButton).width(320).height(100).padBottom(10f);
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
