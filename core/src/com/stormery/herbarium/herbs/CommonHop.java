package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-24.
 */

public class CommonHop extends HerbPage {
    public static boolean isThereAnyCommonHop = false;
    static UseButton commonHopButton;

    public CommonHop(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initCommonHop() {
        commonHopButton = new UseButton(EnumHerb.COMMON_HOP, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Chmiel PAGE");
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


    public static boolean checkIfCommonHop() {
        if (
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
                        MainScreenTableContainer.isSignForWykrztusne() ||
                        MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                        MainScreenTableContainer.isSignForOslaniajace() ||
                        MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                        MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                        MainScreenTableContainer.isSignForRozkurczajace() ||
                        isThereAnyCommonHop
                ) return false;


        else  if (MainScreenTableContainer.isSignForUspokajajace()) {
            System.out.println("jest Chmiel ");
            return true;
        }
        return false;
    }

    public static void getCommonHopButton() {
        if (checkIfCommonHop()) {
            MainScreenTableContainer.tableInnerScrollable.add(commonHopButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyCommonHop = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(commonHopButton) ? true : false;
    }
}
