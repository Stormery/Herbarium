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

public class Sage extends HerbPage {
    public static boolean isThereAnySage = false;
    static UseButton sageButton;

    public Sage(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initSage() {
        sageButton = new UseButton(EnumHerb.SAGE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Szalwia PAGE");
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

    private static boolean checkIfSage() {
        if (
                MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                        MainScreenTableContainer.isSignForPrzeczyszczajace()||
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
                isThereAnySage
                ) return false;

        else  if (MainScreenTableContainer.isSignForPrzeciwzapalne() || MainScreenTableContainer.isSignForSciagajace()  ) {
            System.out.println("jest Szalwia ");
            return true;
        }
        return false;
    }

    public static void getSageButton() {
        if (checkIfSage()) {
            MainScreenTableContainer.tableInnerScrollable.add(sageButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnySage = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(sageButton) ? true : false;
    }
}