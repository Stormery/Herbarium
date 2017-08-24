package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.buttons.UseButton;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-24.
 */

public class PlantagoOvata extends HerbPage {
    static UseButton plantagoOvataButton;
    public static boolean isThereAnyPlantagoOvata = false;

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


    public static boolean checkIfPlantagoOvata() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyPlantagoOvata
                ) return false;

        if (MainScreenTableContainer.isSignForOslaniajace() || MainScreenTableContainer.isSignForPrzeczyszczajace()) {
            System.out.println("jest Babka jajowata ");

            return true;
        }


        return false;
    }

    public static void initPlantagoOvata() {
        plantagoOvataButton = new UseButton(EnumHerb.PLANTAGO_OVATA, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO babka jajowata PAGE");
            }
        });
    }

    public static void getPlantagoOvataButton() {
        if (PlantagoOvata.checkIfPlantagoOvata()) {
            MainScreenTableContainer.tableInnerScrollable.add(plantagoOvataButton).width(herbButtonWidth).height(herbButtonHeight).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        PlantagoOvata.isThereAnyPlantagoOvata = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(plantagoOvataButton) ? true : false;

    }
}

