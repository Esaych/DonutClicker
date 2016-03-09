package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.menu.Menu;
import org.qohs.clicker.screens.util.Button;
import org.qohs.clicker.screens.util.PaddedDrawable;

/**
 * 
 * @author Derek Zhang
 */

public class TrophyButton extends Button {

	public TrophyButton() {
		
		super(0, Menu.GAMEHEIGHT - Menu.GAMEHEIGHT / 10, 
				Menu.GAMEWIDTH / 2, Menu.GAMEHEIGHT / 10,
				new PaddedDrawable(AssetLoader.icon_trophy, .75f, .75f),
				new PaddedDrawable(AssetLoader.icon_trophy, .75f, .75f));
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub

	}

}
