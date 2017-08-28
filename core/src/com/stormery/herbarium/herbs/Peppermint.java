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

public class Peppermint extends HerbPage {
    public static boolean isThereAnyPeppermint = false;
    static UseButton peppermintButton;

    public Peppermint(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initPeppermint() {
        peppermintButton = new UseButton(EnumHerb.PEPPERMINT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Mieta PAGE");
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

    public static boolean checkIfPeppermint() {
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
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyPeppermint
                ) return false;

        else  if (MainScreenTableContainer.isSignForPobudzanieTrawienia() ) {
            System.out.println("jest Mieta ");
            return true;
        }
        return false;
    }

    public static void getPeppermintButton() {
        if (checkIfPeppermint()) {
            MainScreenTableContainer.tableInnerScrollable.add(peppermintButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyPeppermint = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(peppermintButton) ? true : false;
    }
}

