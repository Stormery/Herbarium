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

public class Poplar extends HerbPage {
    public static boolean isThereAnyPoplar = false;
    static UseButton poplarButton;

    public Poplar(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initPoplar() {
       poplarButton = new UseButton(EnumHerb.POPLAR, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Topola PAGE");
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

    private static boolean checkIfPoplar() {
        if (MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForWiatropedne()||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyPoplar
                ) return false;

        else  if ( MainScreenTableContainer.isSignForOslaniajace() || MainScreenTableContainer.isSignForPrzeczyszczajace() ) {
            System.out.println("jest Topola ");
            return true;
        }
        return false;
    }

    public static void getPoplarButton() {
        if (checkIfPoplar()) {
            MainScreenTableContainer.tableInnerScrollable.add(poplarButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyPoplar = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(poplarButton) ? true : false;
    }
}