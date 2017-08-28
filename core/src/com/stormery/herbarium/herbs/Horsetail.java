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

public class Horsetail extends HerbPage {
    public static boolean isThereAnyHorsetail = false;
    static UseButton horsetailButton;

    public Horsetail(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initHorsetail() {
        horsetailButton = new UseButton(EnumHerb.HORSETAIL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Skrzyp PAGE");
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

    private static boolean checkIfHorsetail() {
        if (MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForWiatropedne()||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyHorsetail
                ) return false;

        else  if ( MainScreenTableContainer.isSignForMoczopedne()  ) {
            System.out.println("jest Skrzyp ");
            return true;
        }
        return false;
    }

    public static void getHorsetailButton() {
        if (checkIfHorsetail()) {
            MainScreenTableContainer.tableInnerScrollable.add(horsetailButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyHorsetail = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(horsetailButton) ? true : false;
    }
}