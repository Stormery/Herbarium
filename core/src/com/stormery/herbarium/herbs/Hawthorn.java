package com.stormery.herbarium.herbs;

import com.stormery.herbarium.Herbarium;
import com.stormery.herbarium.ui.UseButton;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.HerbPage;
import com.stormery.herbarium.ui.IClickCallback;
import com.stormery.herbarium.ui.MainScreenTableContainer;

/**
 * Created by Ayo on 2017-08-25.
 */

public class Hawthorn extends HerbPage {
    public static boolean isThereAnyHawthorn = false;
    static UseButton hawthornButton;

    public Hawthorn(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initHawthorn() {
        hawthornButton = new UseButton(EnumHerb.HAWTHORN, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Glog PAGE");
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

    public static boolean checkIfHawthorn() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                MainScreenTableContainer.isSignForPrzeczyszczajace()||
                MainScreenTableContainer.isSignForPrzeciwkaszlowe() ||
                        MainScreenTableContainer.isSignForPrzeciwgoraczkowe() ||
                        MainScreenTableContainer.isSignForOdkazajaceDrogiMoczowe() ||
                        MainScreenTableContainer.isSignForPrzeciwskurczowe() ||
                        MainScreenTableContainer.isSignForSciagajace() ||
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
                        isThereAnyHawthorn
                ) return false;

        else  if (MainScreenTableContainer.isSignForNiewydolnoscKrazenia()) {
            System.out.println("jest glog ");
            return true;
        }
        return false;
    }

    public static void getHawthornButton() {
        if (checkIfHawthorn()) {
            MainScreenTableContainer.tableInnerScrollable.add(hawthornButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyHawthorn = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(hawthornButton) ? true : false;
    }
}
