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

public class Coriander extends HerbPage {
    public static boolean isThereAnyCoriander = false;
    static UseButton corianderButton;

    public Coriander(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initCoriander() {
        corianderButton = new UseButton(EnumHerb.CORIANDER, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kolendry PAGE");
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

    public static boolean checkIfCoriander() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
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
                isThereAnyCoriander
                ) return false;

        else  if ( MainScreenTableContainer.isSignForWiatropedne()) {
            System.out.println("jest Kolendra ");
            return true;
        }
        return false;
    }

    public static void getCorianderButton() {
        if (checkIfCoriander()) {
            MainScreenTableContainer.tableInnerScrollable.add(corianderButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyCoriander = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(corianderButton) ? true : false;
    }
}
