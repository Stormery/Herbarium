package com.stormery.herbarium.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.screens.EnumHerb;
import com.stormery.herbarium.screens.EnumTherapeuticProperties;
import com.stormery.herbarium.ui.IClickCallback;
import com.sun.org.apache.xpath.internal.operations.String;

import static com.stormery.herbarium.screens.EnumTherapeuticProperties.ANTIBACTERIAL;
import static com.stormery.herbarium.screens.EnumTherapeuticProperties.DIURETIC;

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
        textureAtlas = new TextureAtlas("buttons/therapeuticUseButtons.pack");
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
            if (enumeratio.equals(EnumTherapeuticProperties.DIURETIC)) {
                buttonStyle.up = skin.getDrawable("MoczopedneButton");
                buttonStyle.checked = skin.getDrawable("MoczopedneButtonDown");
            } else if (enumeratio.equals(EnumTherapeuticProperties.ANTIBACTERIAL)) {
                buttonStyle.up = skin.getDrawable("PrezciwbaktButton");
                buttonStyle.checked = skin.getDrawable("PrezciwbaktButtonDown");
            }
        } // if EnumTherapeuticProperties
    }


}
