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

public class Althea extends HerbPage {
    public static boolean isThereAnyAlthea = false;
    static UseButton altheaButton;

    public Althea(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAlthea() {
       altheaButton = new UseButton(EnumHerb.ALTHEA, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Prawoslaz PAGE");
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

    public static boolean checkIfAlthea() {
        if ( MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
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
                isThereAnyAlthea
                ) return false;

      else  if (MainScreenTableContainer.isSignForOslaniajace() ||MainScreenTableContainer.isSignForPrzeciwkaszlowe()) {
            System.out.println("jest Prawoslaz ");
            return true;
        }
        return false;
    }

    public static void getAltheaButton() {
        if (checkIfAlthea()) {
            MainScreenTableContainer.tableInnerScrollable.add(altheaButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyAlthea = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(altheaButton) ? true : false;
    }
}
