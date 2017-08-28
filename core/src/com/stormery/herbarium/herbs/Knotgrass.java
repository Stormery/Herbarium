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

public class Knotgrass extends HerbPage {
    public static boolean isThereAnyKnotgrass = false;
    static UseButton knotgrassButton;

    public Knotgrass(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initKnotgrass() {
        knotgrassButton = new UseButton(EnumHerb.KNOTGRASS, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Rdest PAGE");
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

    public static boolean checkIfKnotgrass() {
        if ( MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyKnotgrass
                ) return false;

        else  if ( MainScreenTableContainer.isSignForSciagajace() || MainScreenTableContainer.isSignForPrzeciwzapalne()) {
            System.out.println("jest Rdest ");
            return true;
        }
        return false;
    }

    public static void getKnotgrassButton() {
        if (checkIfKnotgrass()) {
            MainScreenTableContainer.tableInnerScrollable.add(knotgrassButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyKnotgrass = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(knotgrassButton) ? true : false;
    }
}
