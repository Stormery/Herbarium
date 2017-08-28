package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-28.
 */

public class Lavender extends HerbPage {
    public static boolean isThereAnyLavender = false;
    static UseButton lavenderButton;

    public Lavender(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initLavender() {
        lavenderButton = new UseButton(EnumHerb.LAVENDER, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Lawenda PAGE");
            }
        });
    }

    @Override
    protected void init() {
        initBackgroundTexture();
        initReturnButton();
    }

    private void initBackgroundTexture() {
    }

    public static boolean checkIfLavender() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForWiatropedne()||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyLavender
                ) return false;

        if (MainScreenTableContainer.isSignForUspokajajace() ) {
            System.out.println("jest Lawenda ");
            return true;
        }
        return false;
    }

    public static void getLavenderButton() {
        if (checkIfLavender()) {
            MainScreenTableContainer.tableInnerScrollable.add(lavenderButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyLavender = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(lavenderButton) ? true : false;
    }
}

