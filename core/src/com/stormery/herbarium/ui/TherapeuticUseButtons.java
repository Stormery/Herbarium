package com.stormery.herbarium.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.stormery.herbarium.screens.MainScreen;

/**
 * Created by Stormery on 2017-09-24.
 */

public class TherapeuticUseButtons extends ImageTextButton {

    public TherapeuticUseButtons(String text, Skin skin, final IClickCallback callback) {
        super(text, skin);
        init(text,callback);
    }


    private void init (final String text, final IClickCallback callback){
        this.addListener( new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if(MainScreen.isNotDragging) {
                    System.out.println(text + " click");
                    MainScreenTableContainer.tableInnerScrollable.clearChildren();
                    callback.onClick();
                }
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    public static Skin getTherapeuticBttSkin(){
        Skin skin = new Skin(Gdx.files.internal("ui/skinButton/bttTherapeutic.json"),
                new TextureAtlas(Gdx.files.internal("ui/skinButton/bttTherapeutic.atlas")));
        skin.getFont("AntiqueBook").getData().setScale(0.63f,1f);
     return skin;
 }
}






