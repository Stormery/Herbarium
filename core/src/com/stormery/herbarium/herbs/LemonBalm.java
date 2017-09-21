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

public class LemonBalm extends HerbPage {
    static UseButton lemonBalmButton;

    public LemonBalm(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initLemonBalm() {
        lemonBalmButton = new UseButton(EnumHerb.LEMON_BALM, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Melisa PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(lemonBalmButton).width(320).height(100).padBottom(10f);
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
