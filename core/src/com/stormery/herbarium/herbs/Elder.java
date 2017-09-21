package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-24.
 */

public class Elder extends HerbPage {
    static UseButton elderButton;

    public Elder(Herbarium herbarium) {
        super(herbarium);
    }

    @Override
    protected void init() {
        initBackgroundTexture();
        initReturnButton();
    }

    private void initBackgroundTexture() {
    }




    public static void initElder() {
        elderButton = new UseButton(EnumHerb.ELDER, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO bez czarny PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(elderButton).width(herbButtonWidth).height(herbButtonHeight).padBottom(10f);
        MainScreenTableContainer.tableInnerScrollable.row();
    }

}
