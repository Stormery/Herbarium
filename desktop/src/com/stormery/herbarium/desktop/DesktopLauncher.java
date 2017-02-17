package com.stormery.herbarium.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.stormery.herbarium.Herbarium;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = Herbarium.APP_NAME;
		config.width = Herbarium.WIDHT;
		config.height = Herbarium.HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new Herbarium(), config);
	}
}

