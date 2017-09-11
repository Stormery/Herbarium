package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.screens.MainScreen;
import com.stormery.herbarium.service.EnumHerb;
import com.stormery.herbarium.service.EnumTherapeuticProperties;

/**
 * Created by Ayo on 2017-08-09.
 */

public  class UseButton extends Button {
    private static TextureAtlas textureAtlas;
    private static ButtonStyle buttonStyle;
    public static Skin skin;


    public UseButton(Enum whichEnum, final IClickCallback callback){
        super(prepareButton(whichEnum));
        init(callback);
    }


    private void init (final IClickCallback callback){
        this.addListener( new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private static ButtonStyle prepareButton(Enum enumeratio) {

        ifEnumIsTherapeuticProperties(enumeratio);
        //TODO dodag grafike najpierw
         ifEnumIsHerb(enumeratio);

        return buttonStyle;
    }

    private static void ifEnumIsHerb(Enum enumeratio) {
        if(enumeratio instanceof EnumHerb){

            textureAtlas = new TextureAtlas("buttons/herbs/herbBigButtons.pack");
            skin = new Skin(textureAtlas);
            buttonStyle = new ButtonStyle();
            if (enumeratio.equals(EnumHerb.ALOE)) {
                buttonStyle.up = skin.getDrawable("AloesButton");
                buttonStyle.down = skin.getDrawable("AloesButtonDown");
                MainScreen.countLoading(EnumHerb.ALOE);

            }else if (enumeratio.equals(EnumHerb.ANISEED)) {
                buttonStyle.up = skin.getDrawable("AnyzButton");
                buttonStyle.down = skin.getDrawable("AnyzButtonDown");
                MainScreen.countLoading(EnumHerb.ANISEED);

            }else if (enumeratio.equals(EnumHerb.ANGELICA)) {
                buttonStyle.up = skin.getDrawable("ArcydziegielButton");
                buttonStyle.down = skin.getDrawable("ArcydziegielButtonDown");
                MainScreen.countLoading(EnumHerb.ANGELICA);

            }else if (enumeratio.equals(EnumHerb.PLANTAGO_OVATA)) {
                buttonStyle.up = skin.getDrawable("BabkaJajowataButton");
                buttonStyle.down = skin.getDrawable("BabkaJajowataButtonDown");
                MainScreen.countLoading(EnumHerb.PLANTAGO_OVATA);

            }else if (enumeratio.equals(EnumHerb.ELDER)) {
                buttonStyle.up = skin.getDrawable("BezCzarnyButton");
                buttonStyle.down = skin.getDrawable("BezCzarnyButtonDown");
                MainScreen.countLoading(EnumHerb.ELDER);

            }else if (enumeratio.equals(EnumHerb.CRANBERRY)) {
                buttonStyle.up = skin.getDrawable("BrusznicaButton");
                buttonStyle.down = skin.getDrawable("BrusznicaButtonDown");
                MainScreen.countLoading(EnumHerb.CRANBERRY);

            }else if (enumeratio.equals(EnumHerb.BIRCH_TREE)) {
                buttonStyle.up = skin.getDrawable("BrzozaButton");
                buttonStyle.down = skin.getDrawable("BrzozaButtonDown");
                MainScreen.countLoading(EnumHerb.BIRCH_TREE);

            }else if (enumeratio.equals(EnumHerb.COMMON_HOP)) {
                buttonStyle.up = skin.getDrawable("ChmielButton");
                buttonStyle.down = skin.getDrawable("ChmielButtonDown");
                MainScreen.countLoading(EnumHerb.COMMON_HOP);

            }else if (enumeratio.equals(EnumHerb.ST_JOHNS_WORT)) {
                buttonStyle.up = skin.getDrawable("DziurawiecButton");
                buttonStyle.down = skin.getDrawable("DziurawiecButtonDown");
                MainScreen.countLoading(EnumHerb.ST_JOHNS_WORT);

            }else if (enumeratio.equals(EnumHerb.VIOLA_TRICOLOR)) {
                buttonStyle.up = skin.getDrawable("FiolekTrojbarwnyButton");
                buttonStyle.down = skin.getDrawable("FiolekTrojbarwnyButtonDown");
                MainScreen.countLoading(EnumHerb.VIOLA_TRICOLOR);

            }else if (enumeratio.equals(EnumHerb.HAWTHORN)) {
                buttonStyle.up = skin.getDrawable("GlogButton");
                buttonStyle.down = skin.getDrawable("GlogButtonDown");
                MainScreen.countLoading(EnumHerb.HAWTHORN);

            }else if (enumeratio.equals(EnumHerb.JUNIPER)) {
                buttonStyle.up = skin.getDrawable("JalowiecButton");
                buttonStyle.down = skin.getDrawable("JalowiecButtonDown");
                MainScreen.countLoading(EnumHerb.JUNIPER);

            }else if (enumeratio.equals(EnumHerb.CAROM)) {
                buttonStyle.up = skin.getDrawable("KminekButton");
                buttonStyle.down = skin.getDrawable("KminekButtonDown");
                MainScreen.countLoading(EnumHerb.CAROM);

            }else if (enumeratio.equals(EnumHerb.HELICHRYSUM)) {
                buttonStyle.up = skin.getDrawable("KocankaButton");
                buttonStyle.down = skin.getDrawable("KocankaButtonDown");
                MainScreen.countLoading(EnumHerb.HELICHRYSUM);

            }else if (enumeratio.equals(EnumHerb.CORIANDER)) {
                buttonStyle.up = skin.getDrawable("KolendraButton");
                buttonStyle.down = skin.getDrawable("KolendraButtonDown");
                MainScreen.countLoading(EnumHerb.CORIANDER);}

            else if (enumeratio.equals(EnumHerb.DILL)) {
                buttonStyle.up = skin.getDrawable("KoperWloskiButton");
                buttonStyle.down = skin.getDrawable("KoperWloskiButtonDown");
                MainScreen.countLoading(EnumHerb.DILL);

            }else if (enumeratio.equals(EnumHerb.VALERIAN)) {
                buttonStyle.up = skin.getDrawable("KozlekButton");
                buttonStyle.down = skin.getDrawable("KozlekButtonDown");
                MainScreen.countLoading(EnumHerb.VALERIAN);

            }else if (enumeratio.equals(EnumHerb.ALDER_BUCKTHORN)) {
                buttonStyle.up = skin.getDrawable("KruszynaButton");
                buttonStyle.down = skin.getDrawable("KruszynaButtonDown");
                MainScreen.countLoading(EnumHerb.ALDER_BUCKTHORN);

            }else if (enumeratio.equals(EnumHerb.YARROW)) {
                buttonStyle.up = skin.getDrawable("KrwawnikButton");
                buttonStyle.down = skin.getDrawable("KrwawnikButtonDown");
                MainScreen.countLoading(EnumHerb.YARROW);

            }else if (enumeratio.equals(EnumHerb.LAVENDER)) {
                buttonStyle.up = skin.getDrawable("LawendaButton");
                buttonStyle.down = skin.getDrawable("LawendaButtonDown");
                MainScreen.countLoading(EnumHerb.LAVENDER);

            }else if (enumeratio.equals(EnumHerb.FLAX)) {
                buttonStyle.up = skin.getDrawable("LenButton");
                buttonStyle.down = skin.getDrawable("LenButtonDown");
                MainScreen.countLoading(EnumHerb.FLAX);

            }else if (enumeratio.equals(EnumHerb.TILIA)) {
                buttonStyle.up = skin.getDrawable("LipaButton");
                buttonStyle.down = skin.getDrawable("LipaButtonDown");
                MainScreen.countLoading(EnumHerb.TILIA);

            }else if (enumeratio.equals(EnumHerb.LOVAGE)) {
                buttonStyle.up = skin.getDrawable("LubczykButton");
                buttonStyle.down = skin.getDrawable("LubczykButtonDown");
                MainScreen.countLoading(EnumHerb.LOVAGE);

            }else if (enumeratio.equals(EnumHerb.BEARBERRY)) {
                buttonStyle.up = skin.getDrawable("MacznicaButton");
                buttonStyle.down = skin.getDrawable("MacznicaButtonDown");
                MainScreen.countLoading(EnumHerb.BEARBERRY);}

            else if (enumeratio.equals(EnumHerb.LEMON_BALM)) {
                buttonStyle.up = skin.getDrawable("MelisaButton");
                buttonStyle.down = skin.getDrawable("MelisaButtonDown");
                MainScreen.countLoading(EnumHerb.LEMON_BALM);

            }else if (enumeratio.equals(EnumHerb.PEPPERMINT)) {
                buttonStyle.up = skin.getDrawable("MietaButton");
                buttonStyle.down = skin.getDrawable("MietaButtonDown");
                MainScreen.countLoading(EnumHerb.PEPPERMINT);

            }else if (enumeratio.equals(EnumHerb.GOLDEN_ROD)) {
                buttonStyle.up = skin.getDrawable("NawloscButton"); // Tu jest blad nawloc
                buttonStyle.down = skin.getDrawable("NawloscButtonDown");
                MainScreen.countLoading(EnumHerb.GOLDEN_ROD);

            }else if (enumeratio.equals(EnumHerb.PSYLLIUM)) {
                buttonStyle.up = skin.getDrawable("PlesznikButton");
                buttonStyle.down = skin.getDrawable("PlesznikButtonDown");
                MainScreen.countLoading(EnumHerb.PSYLLIUM);

            }else if (enumeratio.equals(EnumHerb.ALTHEA)) {
                buttonStyle.up = skin.getDrawable("PrawoslazButton");
                buttonStyle.down = skin.getDrawable("PrawoslazButtonDown");
                MainScreen.countLoading(EnumHerb.ALTHEA);

            }else if (enumeratio.equals(EnumHerb.KNOTGRASS)) {
                buttonStyle.up = skin.getDrawable("RdestPtasiButton");
                buttonStyle.down = skin.getDrawable("RdestPtasiButtonDown");
                MainScreen.countLoading(EnumHerb.KNOTGRASS);

            }else if (enumeratio.equals(EnumHerb.CHAMOMILE)) {
                buttonStyle.up = skin.getDrawable("RumianekButton");
                buttonStyle.down = skin.getDrawable("RumianekButtonDown");
                MainScreen.countLoading(EnumHerb.CHAMOMILE);

            }else if (enumeratio.equals(EnumHerb.RHUBARB)) {
                buttonStyle.up = skin.getDrawable("RzewienButton");
                buttonStyle.down = skin.getDrawable("RzewienButtonDown");
                MainScreen.countLoading(EnumHerb.RHUBARB);

            }else if (enumeratio.equals(EnumHerb.SENNA)) {
                buttonStyle.up = skin.getDrawable("SenesButton");
                buttonStyle.down = skin.getDrawable("SenesButtonDown");
                MainScreen.countLoading(EnumHerb.SENNA);

            }else if (enumeratio.equals(EnumHerb.HORSETAIL)) {
                buttonStyle.up = skin.getDrawable("SkrzypButton");
                buttonStyle.down = skin.getDrawable("SkrzypButtonDown");
                MainScreen.countLoading(EnumHerb.HORSETAIL);

            }else if (enumeratio.equals(EnumHerb.MALLOW)) {
                buttonStyle.up = skin.getDrawable("SlazButton");
                buttonStyle.down = skin.getDrawable("SlazButtonDown");
                MainScreen.countLoading(EnumHerb.MALLOW);

            }else if (enumeratio.equals(EnumHerb.SAGE)) {
                buttonStyle.up = skin.getDrawable("SzalwiaButton");
                buttonStyle.down = skin.getDrawable("SzalwiaButtonDown");
                MainScreen.countLoading(EnumHerb.SAGE);

            }else if (enumeratio.equals(EnumHerb.POPLAR)) {
                buttonStyle.up = skin.getDrawable("TopolaButton");
                buttonStyle.down = skin.getDrawable("TopolaButtonDown");
                MainScreen.countLoading(EnumHerb.POPLAR);

            }else if (enumeratio.equals(EnumHerb.THYME)) {
                buttonStyle.up = skin.getDrawable("TymianekButton");
                buttonStyle.down = skin.getDrawable("TymianekButtonDown");
                MainScreen.countLoading(EnumHerb.THYME);

            }else if (enumeratio.equals(EnumHerb.WILLOW)) {
                buttonStyle.up = skin.getDrawable("WierzbaButton");
                buttonStyle.down = skin.getDrawable("WierzbaButtonDown");
                MainScreen.countLoading(EnumHerb.WILLOW);
            }
        }
    }

    private static void ifEnumIsTherapeuticProperties(Enum enumeratio) {
        if(enumeratio instanceof EnumTherapeuticProperties){
            textureAtlas = new TextureAtlas("buttons/TypeOfTherapeuticUse/therapeuticUseButtons.pack");
            skin = new Skin(textureAtlas);
            buttonStyle = new ButtonStyle();
            if (enumeratio.equals(EnumTherapeuticProperties.ANTIBACTERIAL)) {
                buttonStyle.up = skin.getDrawable("PrezciwbaktButton");
                buttonStyle.checked = skin.getDrawable("PrezciwbaktButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.ANTIPYRETIC)) {
                buttonStyle.up = skin.getDrawable("PrzeciwgoraczkoweButton");
                buttonStyle.checked = skin.getDrawable("PrzeciwgoraczkoweButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.ANTISPASMODIC)) {
                buttonStyle.up = skin.getDrawable("PrzeciwskurczoweButton");
                buttonStyle.checked = skin.getDrawable("PrzeciwskurczoweButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.ANTITUSSIVE)) {
                buttonStyle.up = skin.getDrawable("PrzeciwkaszloweButton");
                buttonStyle.checked = skin.getDrawable("PrzeciwkaszloweButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.ASTRINGENTS)) {
                buttonStyle.up = skin.getDrawable("SciagajaceButton");
                buttonStyle.checked = skin.getDrawable("SciagajaceButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.CARDIAC_INSUFFICIENCY)) {
                buttonStyle.up = skin.getDrawable("NiewydolnoscButton");
                buttonStyle.checked = skin.getDrawable("NiewydolnoscButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.CARMINATIVE)) {
                buttonStyle.up = skin.getDrawable("WiatropedneButton");
                buttonStyle.checked = skin.getDrawable("WiatropedneButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.CHOLAGOGUES)) {
                buttonStyle.up = skin.getDrawable("ZolciopedneButton");
                buttonStyle.checked = skin.getDrawable("ZolciopedneButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.DEMULCENT)) {
                buttonStyle.up = skin.getDrawable("PrzeciwzapalneButton");
                buttonStyle.checked = skin.getDrawable("PrzeciwzapalneButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.DIAPHORETIC)) {
                buttonStyle.up = skin.getDrawable("NapotneButton");
                buttonStyle.checked = skin.getDrawable("NapotneButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.DIURETIC)) {
                buttonStyle.up = skin.getDrawable("MoczopedneButton");
                buttonStyle.checked = skin.getDrawable("MoczopedneButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.EXPECTORANT)) {
                buttonStyle.up = skin.getDrawable("WykrztusneButton");
                buttonStyle.checked = skin.getDrawable("WykrztusneButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.IMPROVING_DIGESTION)) {
                buttonStyle.up = skin.getDrawable("PobudzajaceTrawienieButton");
                buttonStyle.checked = skin.getDrawable("PobudzajaceTrawienieButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.LAXATIVE)) {
                buttonStyle.up = skin.getDrawable("PzeczyszczajaceButton");
                buttonStyle.checked = skin.getDrawable("PzeczyszczajaceButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.PROTECTIVE_SCREENING)) {
                buttonStyle.up = skin.getDrawable("OslaniajaceButton");
                buttonStyle.checked = skin.getDrawable("OslaniajaceButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.SEDATIVE)) {
                buttonStyle.up = skin.getDrawable("UspokajajaceButton");
                buttonStyle.checked = skin.getDrawable("UspokajajaceButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.SPASMOLYTIC)) {
                buttonStyle.up = skin.getDrawable("RozkurczajaceButton");
                buttonStyle.checked = skin.getDrawable("RozkurczajaceButtonDown");
            }else if (enumeratio.equals(EnumTherapeuticProperties.URINARY_TRACT_DISINFECTANT)) {
                buttonStyle.up = skin.getDrawable("DrogiMoczoweButton");
                buttonStyle.checked = skin.getDrawable("DrogiMoczoweButtonDown");
            }

        } // if EnumTherapeuticProperties
    }


}
