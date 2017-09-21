package com.stormery.herbarium.ui;

import com.stormery.herbarium.herbs.AlderBuckthorn;
import com.stormery.herbarium.herbs.Aloe;
import com.stormery.herbarium.herbs.Althea;
import com.stormery.herbarium.herbs.Angelica;
import com.stormery.herbarium.herbs.Aniseed;
import com.stormery.herbarium.herbs.Bearberry;
import com.stormery.herbarium.herbs.BirchTree;
import com.stormery.herbarium.herbs.Carom;
import com.stormery.herbarium.herbs.Chamomile;
import com.stormery.herbarium.herbs.CommonHop;
import com.stormery.herbarium.herbs.Coriander;
import com.stormery.herbarium.herbs.Cranberry;
import com.stormery.herbarium.herbs.Dill;
import com.stormery.herbarium.herbs.Elder;
import com.stormery.herbarium.herbs.Flax;
import com.stormery.herbarium.herbs.GoldenRod;
import com.stormery.herbarium.herbs.Hawthorn;
import com.stormery.herbarium.herbs.Helichrysum;
import com.stormery.herbarium.herbs.Horsetail;
import com.stormery.herbarium.herbs.Juniper;
import com.stormery.herbarium.herbs.Knotgrass;
import com.stormery.herbarium.herbs.Lavender;
import com.stormery.herbarium.herbs.LemonBalm;
import com.stormery.herbarium.herbs.Lovage;
import com.stormery.herbarium.herbs.Mallow;
import com.stormery.herbarium.herbs.Peppermint;
import com.stormery.herbarium.herbs.PlantagoOvata;
import com.stormery.herbarium.herbs.Poplar;
import com.stormery.herbarium.herbs.Psyllium;
import com.stormery.herbarium.herbs.Rhubarb;
import com.stormery.herbarium.herbs.Sage;
import com.stormery.herbarium.herbs.Senna;
import com.stormery.herbarium.herbs.StJohnsWort;
import com.stormery.herbarium.herbs.Thyme;
import com.stormery.herbarium.herbs.Tilia;
import com.stormery.herbarium.herbs.Valerian;
import com.stormery.herbarium.herbs.ViolaTricolor;
import com.stormery.herbarium.herbs.Willow;
import com.stormery.herbarium.herbs.Yarrow;
import com.stormery.herbarium.service.EnumLanguage;
/**
 * Created by Ayo on 2017-08-28.
 */

public class LanguageAndHerbShow {

    public static void checkLanguageAndInitHerbs(EnumLanguage language) {
        if (language.equals(EnumLanguage.POLISH)){
            whatHerbToShowInPL();
        }else if(language.equals(EnumLanguage.ENGLISH)){

        }
    }
    public static void whatHerbToShowInPL() {
        //TODO wybor jezyka tu jest na POL



    }
}
