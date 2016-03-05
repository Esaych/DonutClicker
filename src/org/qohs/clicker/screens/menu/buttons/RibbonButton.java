package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.PaddedDrawable;
import org.qohs.clicker.screens.util.Button;

/**
 * 
 * @author Derek Zhang
 */

public class RibbonButton extends Button {

	public RibbonButton() {
		
		super(GameWorld.GAMEWIDTH / 2, GameWorld.GAMEHEIGHT - GameWorld.GAMEHEIGHT / 5,
				GameWorld.GAMEWIDTH / 2, GameWorld.GAMEHEIGHT / 5,
				new PaddedDrawable(AssetLoader.icon_ribbon, 1, 1),
				new PaddedDrawable(AssetLoader.icon_ribbon, .5f, .5f));
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub

	}

}
