package com.stormery.herbarium.buttons.therapeuticButtons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.ui.IClickCallback;


/**
 * Created by Ayo on 2017-08-08.
 */

public class ButtonTherapeuticPrzeciwzapalne extends Button {
    private static TextureAtlas przeciwzapalneButtonAtlas;

    public ButtonTherapeuticPrzeciwzapalne(final IClickCallback callback){
        super(prepareButtonPrzeciwzapalne());
        init(callback);
    }

    private void init(final IClickCallback callback) {

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
    public static ButtonStyle prepareButtonPrzeciwzapalne(){
        //TODO dodac atlas z przyciskami

        przeciwzapalneButtonAtlas = new TextureAtlas("buttons/allButtons.pack");
        Skin skin  = new Skin(przeciwzapalneButtonAtlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("smallButtonMakeTxt");
        buttonStyle.down = skin.getDrawable("smallButtonMakeTxtDown");

        return buttonStyle;
    }
}
