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

public class Senna extends HerbPage {
    public static boolean isThereAnySenna = false;
    static UseButton sennaButton;

    public Senna(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initSenna() {
       sennaButton = new UseButton(EnumHerb.SENNA, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Senes PAGE");
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

    private static boolean checkIfSenna() {
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
                isThereAnySenna
                ) return false;

        else  if ( MainScreenTableContainer.isSignForPrzeczyszczajace() ) {
            System.out.println("jest Senes ");
            return true;
        }
        return false;
    }

    public static void getSennaButton() {
        if (checkIfSenna()) {
            MainScreenTableContainer.tableInnerScrollable.add(sennaButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnySenna = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(sennaButton) ? true : false;
    }
}