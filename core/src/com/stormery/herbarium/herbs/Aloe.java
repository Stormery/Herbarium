package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-22.
 */

public class Aloe extends HerbPage {
    public static boolean isThereAnyAloes = false;
    static UseButton aloeButton;

    public Aloe(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAloe() {
        if(!isThereAnyAloes){
            aloeButton = new UseButton(EnumHerb.ALOE, new IClickCallback() {
                @Override
                public void onClick() {
                    System.out.println("IDZIE DO ALOES PAGE");
                }
            });
            isThereAnyAloes = true;
        }

    }

    @Override
    protected void init() {
        initBackgroundTexture();
        initReturnButton();
    }

    private void initBackgroundTexture() {
    }

    public static boolean checkIfAloe() {
        if (
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                        MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                        MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                        MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                        MainScreenTableContainer.isSignForSciagajace() ||
                        MainScreenTableContainer.isSignForNiewydolnoscKrazenia() ||
                        MainScreenTableContainer.isSignForWiatropedne() ||
                        MainScreenTableContainer.isSignForZolciopedne() ||
                        MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                        MainScreenTableContainer.isSignForPrzeciwzapalne() ||
                        MainScreenTableContainer.isSignForNapotne() ||
                        MainScreenTableContainer.isSignForMoczopedne() ||
                        MainScreenTableContainer.isSignForWykrztusne() ||
                        MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                        MainScreenTableContainer.isSignForOslaniajace() ||
                        MainScreenTableContainer.isSignForUspokajajace() ||
                        MainScreenTableContainer.isSignForUspokajajace() ||
                        MainScreenTableContainer.isSignForRozkurczajace() ||
                        isThereAnyAloes
                ) return false;

        else  if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace()) {
            System.out.println("jest aloes ");
            return true;
        }
        return false;
    }

    public static void getAloeButton() {
        if (checkIfAloe()) {
            MainScreenTableContainer.tableInnerScrollable.add(aloeButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyAloes = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(aloeButton) ? true : false;
    }
}
