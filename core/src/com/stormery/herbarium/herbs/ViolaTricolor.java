package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-24.
 */
public class ViolaTricolor extends HerbPage {
    public static boolean isThereAnyViolaTricolor = false;
    static UseButton violaTricolorButton;

    public ViolaTricolor(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initViolaTricolor() {
        violaTricolorButton = new UseButton(EnumHerb.VIOLA_TRICOLOR, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Fiolek PAGE");
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

    public static boolean checkIfViolaTricolor() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                MainScreenTableContainer.isSignForWiatropedne() ||
                MainScreenTableContainer.isSignForZolciopedne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForNapotne() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyViolaTricolor
                ) return false;

        if (MainScreenTableContainer.isSignForMoczopedne() ||
                MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                MainScreenTableContainer.isSignForSciagajace()) {
            System.out.println("jest Fiolek ");
            return true;
        }
        return false;
    }

    public static void getViolaTricolorButton() {
        if (checkIfViolaTricolor()) {
            MainScreenTableContainer.tableInnerScrollable.add(violaTricolorButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyViolaTricolor = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(violaTricolorButton) ? true : false;
    }
}

