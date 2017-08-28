package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-24.
 */

public class Elder extends HerbPage {
    static UseButton elderButton;
    public static boolean isThereAnyElder = false;

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


    public static boolean checkIfElder() {
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
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyElder
                ) return false;

        if (MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForNapotne()) {
            System.out.println("jest BezCzarny ");

            return true;
        }


        return false;
    }

    public static void initElder() {
        elderButton = new UseButton(EnumHerb.ELDER, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO bez czarny PAGE");
            }
        });
    }

    public static void getElderButton() {
        if (checkIfElder()) {
            MainScreenTableContainer.tableInnerScrollable.add(elderButton).width(herbButtonWidth).height(herbButtonHeight).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyElder = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(elderButton) ? true : false;

    }
}
