package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-22.
 */

public class Aniseed extends HerbPage {
    static UseButton aniseedButton;
    public static boolean isThereAnyAniseed = false;

    public Aniseed(Herbarium herbarium) {
        super(herbarium);
    }

    @Override
    protected void init() {
        initBackgroundTexture();
        initReturnButton();
    }

    private void initBackgroundTexture() {
    }

    public static boolean checkIfAniseed() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyAniseed
                ) return false;

        if (MainScreenTableContainer.isSignForWykrztusne()) {
            System.out.println("jest anyz ");
            return true;
        }
        return false;
    }

    public static void initAniseed() {
        aniseedButton = new UseButton(EnumHerb.ANISEED, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO ANYZ PAGE");
            }
        });
    }

    public static void getAniseedButton() {
        if(checkIfAniseed()){
            MainScreenTableContainer.tableInnerScrollable.add(aniseedButton).width(herbButtonWidth).height(herbButtonHeight).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyAniseed = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(aniseedButton)? true:false;

    }
}
