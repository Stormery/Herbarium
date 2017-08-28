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

public class Mallow extends HerbPage {
    public static boolean isThereAnyMallow = false;
    static UseButton mallowButton;

    public Mallow(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initMallow() {
        mallowButton = new UseButton(EnumHerb.MALLOW, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Slaz PAGE");
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

    private static boolean checkIfMallow() {
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
                MainScreenTableContainer.isSignForPrzeczyszczajace()||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyMallow
                ) return false;

        else  if ( MainScreenTableContainer.isSignForOslaniajace()  ) {
            System.out.println("jest Slaz ");
            return true;
        }
        return false;
    }

    public static void getMallowButton() {
        if (checkIfMallow()) {
            MainScreenTableContainer.tableInnerScrollable.add(mallowButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyMallow = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(mallowButton) ? true : false;
    }
}