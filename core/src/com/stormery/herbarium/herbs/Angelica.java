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

public class Angelica extends HerbPage {

    static UseButton angelicaButton;

    public Angelica(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAngelica() {
        angelicaButton = new UseButton(EnumHerb.ANGELICA, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Arcydziegiel PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(angelicaButton).width(320f).height(100f).padBottom(10f);
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
