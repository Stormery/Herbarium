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

public class Flax extends HerbPage {
    public static boolean isThereAnyFlax = false;
    static UseButton flaxButton;

    public Flax(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initFlax() {
        flaxButton = new UseButton(EnumHerb.FLAX, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Len PAGE");
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

    public static boolean checkIfFlax() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
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
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyFlax
                ) return false;

        if (MainScreenTableContainer.isSignForOslaniajace() || MainScreenTableContainer.isSignForPrzeczyszczajace()) {
            System.out.println("jest Len ");
            return true;
        }
        return false;
    }

    public static void getFlaxButton() {
        if (checkIfFlax()) {
            MainScreenTableContainer.tableInnerScrollable.add(flaxButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyFlax = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(flaxButton) ? true : false;
    }
}

