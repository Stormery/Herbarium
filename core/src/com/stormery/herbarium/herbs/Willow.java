package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;
import com.stormery.herbarium.ui.UseButton;

/**
 * Created by Ayo on 2017-08-28.
 */

public class Willow extends HerbPage {
    public static boolean isThereAnyWillow = false;
    static UseButton willowButton;

    public Willow(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initWillow() {
        willowButton = new UseButton(EnumHerb.WILLOW, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Wierzba PAGE");
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

    private static boolean checkIfWillow() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyWillow
                ) return false;

        else if (MainScreenTableContainer.isSignForPrzeciwzapalne() || MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe()) {
            System.out.println("jest Wierzba ");
            return true;
        }
        return false;
    }

    public static void getWillowButton() {
        if (checkIfWillow()) {
            MainScreenTableContainer.tableInnerScrollable.add(willowButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyWillow = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(willowButton) ? true : false;
    }
}