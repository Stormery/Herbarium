package com.stormery.herbarium.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
    public TherapeuticUseButton(int number, final IClickCallback callback){
        super(prepareButton(number));
        init(callback);
    }


    public TherapeuticUseButton(String buttonUp, String buttonDown, final IClickCallback callback){
        super(prepareButton(buttonUp, buttonDown));
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
    private static ButtonStyle prepareButton(int i) {
        textureAtlas = new TextureAtlas("buttons/therapeuticUseButtons.pack");
        skin = new Skin(textureAtlas);
        buttonStyle = new ButtonStyle();
        switch(i){
            case 1: buttonStyle.up = skin.getDrawable("MoczopedneButton");
                    buttonStyle.down = skin.getDrawable("MoczopedneButtonDown");break;
        }

        return buttonStyle;
    }

    private static ButtonStyle prepareButton(String buttonUp, String buttonDown){
        textureAtlas = new TextureAtlas("buttons/therapeuticUseButtons.pack");
        skin = new Skin(textureAtlas);
        buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable(buttonUp.toString());
        buttonStyle.down = skin.getDrawable(buttonDown.toString());
        return buttonStyle;
    }




}
