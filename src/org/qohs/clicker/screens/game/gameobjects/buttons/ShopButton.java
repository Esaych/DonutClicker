package org.qohs.clicker.screens.game.gameobjects.buttons;

import org.qohs.clicker.Clicker;
import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.io.InputHandler;
import org.qohs.clicker.screens.MenuScreen;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.Button;
import org.qohs.clicker.screens.util.UpdateRenderObj;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class ShopButton extends Button implements UpdateRenderObj {

	public ShopButton() {
		super(0, GameWorld.GAMEHEIGHT*4/5, GameWorld.GAMEWIDTH, GameWorld.GAMEWIDTH*3/4, AssetLoader.table, AssetLoader.table_clicked);
		System.out.println("SHOP BUTTON CREATED");
	}

	@Override
	public void onClick() {

		ApplicationListener appListener = Gdx.app.getApplicationListener();
		if (appListener instanceof Clicker) {
			
			Clicker clicker = (Clicker) appListener;
			clicker.setDonutScreen(Clicker.ScreenType.MENU);
			//the input handler is accessible during runtime using: (InputHandler) Gdx.app.getInputProcessor()
			try {
				
				InputHandler.setMenuScreen((MenuScreen) clicker.getScreen());
			}
			catch (ClassCastException e) {
				
				System.err.println("SOMETHING WRONG! (Could not set InputHandler\'s MenuScreen)");
			}
		}
	}
}
