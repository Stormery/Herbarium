package com.stormery.herbarium.buttons;

/**
 * Created by Ayo on 2017-08-09.
 */

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

public  class HerbListButton extends Button {
    private static TextureAtlas textureAtlas;
    private static ButtonStyle buttonStyle;
    private static Skin skin;
    private String buttonUp;
    private String ButtonDown;
    public HerbListButton(String buttonUp, String buttonDown, final IClickCallback callback){
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

    protected static ButtonStyle prepareButton(String buttonUp, String buttonDown){
        textureAtlas = new TextureAtlas("buttons/herbBigButtons.pack");
        skin = new Skin(textureAtlas);
        buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable(java.lang.String.valueOf(buttonUp));
        buttonStyle.down = skin.getDrawable(java.lang.String.valueOf(buttonDown));
        return buttonStyle;
    }




}
