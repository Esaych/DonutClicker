package org.qohs.clicker.world.gameobjects.buttons;

import org.qohs.clicker.Clicker;
import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.io.InputHandler;
import org.qohs.clicker.screens.MenuScreen;
import org.qohs.clicker.util.UpdateRenderObj;
import org.qohs.clicker.world.GameWorld;
import org.qohs.clicker.world.gameobjects.Button;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class ShopButton extends Button implements UpdateRenderObj {

	public ShopButton() {
		super(0, GameWorld.GAMEHEIGHT*4/5, GameWorld.GAMEWIDTH, GameWorld.GAMEHEIGHT*1/5, AssetLoader.table, AssetLoader.table);
		System.out.println("SHOP BUTTON CREATED");
	}

	@Override
	public void onClick() {

		ApplicationListener appListener = Gdx.app.getApplicationListener();
		if (appListener instanceof Clicker) {
			
			Clicker clicker = (Clicker) appListener;
			clicker.setScreen(Clicker.ScreenType.MENU);
			//the input handler is accessible during runtime using: (InputHandler) Gdx.app.getInputProcessor()
			try {
				
				InputHandler.setMenuScreen((MenuScreen) clicker.getScreen());
			}
			catch (ClassCastException e) {
				
				System.err.println("Some-ting wong! (Could not set InputHandler\'s MenuScreen)");
			}
		}
	}
}
