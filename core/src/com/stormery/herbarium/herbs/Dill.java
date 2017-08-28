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

public class Dill extends HerbPage {
    public static boolean isThereAnyDill = false;
    static UseButton dillButton;

    public Dill(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initDill() {
        dillButton = new UseButton(EnumHerb.DILL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kopru PAGE");
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

    public static boolean checkIfDill() {
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
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyDill
                ) return false;

        else  if ( MainScreenTableContainer.isSignForWiatropedne() || MainScreenTableContainer.isSignForWykrztusne()) {
            System.out.println("jest Koper ");
            return true;
        }
        return false;
    }

    public static void getDillButton() {
        if (checkIfDill()) {
            MainScreenTableContainer.tableInnerScrollable.add(dillButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyDill = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(dillButton) ? true : false;
    }
}
