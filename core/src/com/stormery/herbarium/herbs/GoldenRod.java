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

public class GoldenRod extends HerbPage {
    static UseButton goldenRodButton;

    public GoldenRod(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initGoldenRod() {
        goldenRodButton = new UseButton(EnumHerb.GOLDEN_ROD, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Nawloc PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(goldenRodButton).width(320).height(100).padBottom(10f);
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

