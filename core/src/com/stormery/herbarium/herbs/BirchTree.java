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
public class BirchTree extends HerbPage {
    public static boolean isThereAnyBirchTree= false;
    static UseButton birchTreeButton;

    public BirchTree(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initBirchTree() {
        birchTreeButton = new UseButton(EnumHerb.BIRCH_TREE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Brzoza PAGE");
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


    public static boolean checkIfBirchTree() {
        if ( MainScreenTableContainer.isSignForPrzeczyszczajace() ||
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
                        MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
                        MainScreenTableContainer.isSignForWykrztusne() ||
                        MainScreenTableContainer.isSignForPobudzanieTrawienia() ||
                        MainScreenTableContainer.isSignForOslaniajace() ||
                        MainScreenTableContainer.isSignForUspokajajace() ||
                        MainScreenTableContainer.isSignForUspokajajace() ||
                        MainScreenTableContainer.isSignForRozkurczajace() ||
                        isThereAnyBirchTree
                ) return false;

        else   if (MainScreenTableContainer.isSignForMoczopedne()
               ) {
            System.out.println("jest Brzoza ");
            return true;
        }
        return false;
    }

    public static void getBirchTreeButton() {
        if (checkIfBirchTree()) {
            MainScreenTableContainer.tableInnerScrollable.add(birchTreeButton).width(320).height(100).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
        isThereAnyBirchTree = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(birchTreeButton) ? true : false;
    }
}