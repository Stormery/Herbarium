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

public class Aloe extends HerbPage {
    public static boolean isThereAnyAloes = false;
    static UseButton aloeButton;

    public Aloe(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAloe() {

            aloeButton = new UseButton(EnumHerb.ALOE, new IClickCallback() {
                @Override
                public void onClick() {
                    System.out.println("IDZIE DO ALOES PAGE");
                }
            });
        MainScreenTableContainer.tableInnerScrollable.add(aloeButton).width(320).height(100).padBottom(10f);
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
