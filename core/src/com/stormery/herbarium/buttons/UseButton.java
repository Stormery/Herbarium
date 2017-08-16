package com.stormery.herbarium.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.EnumTherapeuticProperties;
import com.stormery.herbarium.ui.IClickCallback;

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
        textureAtlas = new TextureAtlas("buttons/TypeOfTherapeuticUse/therapeuticUseButtons.pack");
        skin = new Skin(textureAtlas);
        buttonStyle = new ButtonStyle();
        ifEnumIsTherapeuticProperties(enumeratio);
        ifEnumIsHerb(enumeratio);

        return buttonStyle;
    }

    private static void ifEnumIsHerb(Enum enumeratio) {
        if(enumeratio instanceof EnumHerb){

        }
    }

    private static void ifEnumIsTherapeuticProperties(Enum enumeratio) {
        if(enumeratio instanceof EnumTherapeuticProperties){
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
