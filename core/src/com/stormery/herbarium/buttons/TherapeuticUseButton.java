package com.stormery.herbarium.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.screens.EnumTherapeuticProperties;
import com.stormery.herbarium.ui.IClickCallback;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by Ayo on 2017-08-09.
 */

public  class TherapeuticUseButton extends Button {
    private static TextureAtlas textureAtlas;
    private static ButtonStyle buttonStyle;
    public static Skin skin;
    private String buttonUp;
    private String ButtonDown;
    //TODO passby enum not number
    public TherapeuticUseButton(EnumTherapeuticProperties number, final IClickCallback callback){
        super(prepareButton(number));
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

    private static ButtonStyle prepareButton(EnumTherapeuticProperties enumTherapeuticProperties) {
        textureAtlas = new TextureAtlas("buttons/therapeuticUseButtons.pack");
        skin = new Skin(textureAtlas);
        buttonStyle = new ButtonStyle();
        switch(enumTherapeuticProperties){
            case DIURETIC: buttonStyle.up = skin.getDrawable("MoczopedneButton");
                buttonStyle.checked = skin.getDrawable("MoczopedneButtonDown");break;
            case ANTIBACTERIAL: buttonStyle.up = skin.getDrawable("PrezciwbaktButton");
                buttonStyle.checked = skin.getDrawable("PrezciwbaktButtonDown");
        }

        return buttonStyle;
    }

}
