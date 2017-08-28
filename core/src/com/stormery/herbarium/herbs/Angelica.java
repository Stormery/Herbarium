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

public class Angelica extends HerbPage {

    static UseButton angelicaButton;
    public static boolean isThereAnyAngelica = false;

    public Angelica(Herbarium herbarium) {
        super(herbarium);
    }

    public static void initAngelica() {
        angelicaButton = new UseButton(EnumHerb.ANGELICA, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("IDZIE DO Arcydziegiel PAGE");
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


    public static boolean checkIfAngelica() {
        if (MainScreenTableContainer.isSignForPrzeciwbakteryjne() ||
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
                MainScreenTableContainer.isSignForPrzeczyszczajace() ||
                MainScreenTableContainer.isSignForWykrztusne() ||
                MainScreenTableContainer.isSignForOslaniajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForUspokajajace() ||
                MainScreenTableContainer.isSignForRozkurczajace() ||
                isThereAnyAngelica
                ) return false;

        else   if (MainScreenTableContainer.isSignForPobudzanieTrawienia()) {
            System.out.println("jest Arcydziegiel ");
            return true;
        }
        return false;
    }
    public static void getAngelicaButton() {
        if(checkIfAngelica()){
            MainScreenTableContainer.tableInnerScrollable.add(angelicaButton).width(320f).height(100f).padBottom(10f);
            MainScreenTableContainer.tableInnerScrollable.row();
        }
       isThereAnyAngelica = MainScreenTableContainer.tableInnerScrollable.isAscendantOf(angelicaButton)? true:false;
    }

}
