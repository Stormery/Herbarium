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

public class PlantagoOvata extends HerbPage {
    static UseButton plantagoOvataButton;

    public PlantagoOvata(Herbarium herbarium) {
        super(herbarium);
    }

    @Override
    protected void init() {
        initBackgroundTexture();
        initReturnButton();
    }

    private void initBackgroundTexture() {
    }



    public static void initPlantagoOvata() {
        plantagoOvataButton = new UseButton(EnumHerb.PLANTAGO_OVATA, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO babka jajowata PAGE");
            }
        });
        MainScreenTableContainer.tableInnerScrollable.add(plantagoOvataButton).width(herbButtonWidth).height(herbButtonHeight).padBottom(10f);
        MainScreenTableContainer.tableInnerScrollable.row();
    }

}

