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

public class Horsetail extends HerbPage {
    static UseButton horsetailButton;

    public Horsetail(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initHorsetail() {
        horsetailButton = new UseButton(EnumHerb.HORSETAIL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Skrzyp PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(horsetailButton).width(320).height(100).padBottom(10f);
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