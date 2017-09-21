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

public class Yarrow extends HerbPage {
    public static boolean isThereAnyYarrow = false;
    static UseButton yarrowButton;

    public Yarrow(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initYarrow() {
        yarrowButton = new UseButton(EnumHerb.YARROW, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Krwawnika PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(yarrowButton).width(320).height(100).padBottom(10f);
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
