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

public class Valerian extends HerbPage {
    public static boolean isThereAnyValerian = false;
    static UseButton valerianButton;

    public Valerian(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initValerian() {
        valerianButton = new UseButton(EnumHerb.VALERIAN, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Kozlka PAGE");
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

    public static boolean checkIfValerian() {
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
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyValerian
                ) return false;

        else    if (MainScreenTableContainer.isSignForUspokajajace()) {
            System.out.println("jest Kozlek ");
            return true;
        }
        return false;
    }

    public static void getValerianButton() {
        if (checkIfValerian()) {
            MainScreenTableContainer.tableInnerScrollable.add(valerianButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyValerian = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(valerianButton) ? true : false;
    }
}
