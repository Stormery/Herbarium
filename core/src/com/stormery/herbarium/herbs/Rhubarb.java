package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;
import com.stormery.herbarium.ui.UseButton;

/**
 * Created by Ayo on 2017-08-28.
 */

public class Rhubarb extends HerbPage {
    public static boolean isThereAnyRhubarb = false;
    static UseButton rhubarbButton;

    public Rhubarb(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initRhubarb() {
        rhubarbButton = new UseButton(EnumHerb.RHUBARB, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Rzewien PAGE");
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

    private static boolean checkIfRhubarb() {
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
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyRhubarb
                ) return false;

        else  if ( MainScreenTableContainer.isSignForPrzeczyszczajace() ) {
            System.out.println("jest Rzewien ");
            return true;
        }
        return false;
    }

    public static void getRhubarbButton() {
        if (checkIfRhubarb()) {
            MainScreenTableContainer.tableInnerScrollable.add(rhubarbButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyRhubarb = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(rhubarbButton) ? true : false;
    }
}