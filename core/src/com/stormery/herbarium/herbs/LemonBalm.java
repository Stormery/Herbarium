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

public class LemonBalm extends HerbPage {
    public static boolean isThereAnyLemonBalm = false;
    static UseButton lemonBalmButton;

    public LemonBalm(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initLemonBalm() {
        lemonBalmButton = new UseButton(EnumHerb.LEMON_BALM, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Melisa PAGE");
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

    public static boolean checkIfLemonBalm() {
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
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyLemonBalm
                ) return false;

        else  if ( MainScreenTableContainer.isSignForUspokajajace()) {
            System.out.println("jest Melisa ");
            return true;
        }
        return false;
    }

    public static void getLemonBalmButton() {
        if (checkIfLemonBalm()) {
            MainScreenTableContainer.tableInnerScrollable.add(lemonBalmButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyLemonBalm = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(lemonBalmButton) ? true : false;
    }
}
