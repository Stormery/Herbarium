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

public class AlderBuckthorn extends HerbPage {
    public static boolean isThereAnyAlderBuckthorn = false;
    static UseButton alderBuckthornButton;

    public AlderBuckthorn(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAlderBuckthorn() {
        alderBuckthornButton = new UseButton(EnumHerb.ALDER_BUCKTHORN, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kruszyna PAGE");
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

    public static boolean checkIfAlderBuckthorn() {
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
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyAlderBuckthorn
                ) return false;

        else   if ( MainScreenTableContainer.isSignForPrzeczyszczajace()) {
            System.out.println("jest Kruszyna ");
            return true;
        }
        return false;
    }

    public static void getAlderBuckthornButton() {
        if (checkIfAlderBuckthorn()) {
            MainScreenTableContainer.tableInnerScrollable.add(alderBuckthornButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyAlderBuckthorn = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(alderBuckthornButton) ? true : false;
    }
}

