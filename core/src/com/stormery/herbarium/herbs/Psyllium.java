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

public class Psyllium extends HerbPage {
    public static boolean isThereAnyPsyllium = false;
    static UseButton psylliumButton;

    public Psyllium(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initPsyllium() {
        psylliumButton = new UseButton(EnumHerb.PSYLLIUM, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Plesznik PAGE");
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

    public static boolean checkIfPsyllium() {
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
                isThereAnyPsyllium
                ) return false;

        else  if (MainScreenTableContainer.isSignForOslaniajace() || MainScreenTableContainer.isSignForPrzeczyszczajace()) {
            System.out.println("jest Plesznik ");
            return true;
        }
        return false;
    }

    public static void getPsylliumButton() {
        if (checkIfPsyllium()) {
            MainScreenTableContainer.tableInnerScrollable.add(psylliumButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyPsyllium = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(psylliumButton) ? true : false;
    }
}