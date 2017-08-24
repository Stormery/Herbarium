package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.buttons.UseButton;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-24.
 */

public class StJohnsWort extends HerbPage {
    public static boolean isThereAnyStJohnsWort = false;
    static UseButton stJohnsWortButton;

    public StJohnsWort(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initStJohnsWort() {
        stJohnsWortButton = new UseButton(EnumHerb.ST_JOHNS_WORT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Dziurawiec PAGE");
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

    public static boolean checkIfStJohnsWort() {
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
                        MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                        MainScreenTableContainer.isSignForPrzeczyszczajace()||
                        MainScreenTableContainer.isSignForOslaniajace() ||
                        MainScreenTableContainer.isSignForUspokajajace() ||
                        MainScreenTableContainer.isSignForUspokajajace() ||
                        MainScreenTableContainer.isSignForRozkurczajace() ||
                        isThereAnyStJohnsWort
                ) return false;

        if (MainScreenTableContainer.isSignForPobudzanieTrawienia()) {
            System.out.println("jest Dziurawiec ");
            return true;
        }
        return false;
    }

    public static void getStJohnsWortButton() {
        if (checkIfStJohnsWort()) {
            MainScreenTableContainer.tableInnerScrollable.add(stJohnsWortButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
       isThereAnyStJohnsWort = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(stJohnsWortButton) ? true : false;
    }
}
