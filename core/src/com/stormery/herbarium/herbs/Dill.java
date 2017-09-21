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

public class Dill extends HerbPage {
    static UseButton dillButton;

    public Dill(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initDill() {
        dillButton = new UseButton(EnumHerb.DILL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kopru PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(dillButton).width(320).height(100).padBottom(10f);
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
