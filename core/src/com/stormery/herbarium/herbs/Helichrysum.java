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

public class Helichrysum extends HerbPage {
    public static boolean isThereAnyHelichrysum = false;
    static UseButton helichrysumButton;

    public Helichrysum(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initHelichrysum() {
        helichrysumButton = new UseButton(EnumHerb.HELICHRYSUM, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kocanka PAGE");
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

    public static boolean checkIfHelichrysum() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyHelichrysum
                ) return false;

        if ( MainScreenTableContainer.isSignForZolciopedne()) {
            System.out.println("jest Kocanka ");
            return true;
        }
        return false;
    }

    public static void getHelichrysumButton() {
        if (checkIfHelichrysum()) {
            MainScreenTableContainer.tableInnerScrollable.add(helichrysumButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyHelichrysum = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(helichrysumButton) ? true : false;
    }
}
