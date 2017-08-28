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

public class Chamomile extends HerbPage {
    public static boolean isThereAnyChamomile = false;
    static UseButton chamomileButton;

    public Chamomile(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initChamomile() {
        chamomileButton = new UseButton(EnumHerb.CHAMOMILE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Rumianek PAGE");
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

    private static boolean checkIfChamomile() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
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
                isThereAnyChamomile
                ) return false;

        else  if (MainScreenTableContainer.isSignForPrzeciwzapalne() ||  MainScreenTableContainer.isSignForSciagajace()) {
            System.out.println("jest Rumianek ");
            return true;
        }
        return false;
    }

    public static void getChamomileButton() {
        if (checkIfChamomile()) {
            MainScreenTableContainer.tableInnerScrollable.add(chamomileButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyChamomile = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(chamomileButton) ? true : false;
    }
}