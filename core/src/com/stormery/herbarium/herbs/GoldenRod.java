package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-28.
 */

public class GoldenRod extends HerbPage {
    public static boolean isThereAnyGoldenRod = false;
    static UseButton goldenRodButton;

    public GoldenRod(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initGoldenRod() {
        goldenRodButton = new UseButton(EnumHerb.GOLDEN_ROD, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Nawloc PAGE");
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

    public static boolean checkIfGoldenRod() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForSciagajace() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyGoldenRod
                ) return false;

        else  if (MainScreenTableContainer.isSignForMoczopedne() ) {
            System.out.println("jest Nawloc ");
            return true;
        }
        return false;
    }

    public static void getGoldenRodButton() {
        if (checkIfGoldenRod()) {
            MainScreenTableContainer.tableInnerScrollable.add(goldenRodButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyGoldenRod = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(goldenRodButton) ? true : false;
    }
}

