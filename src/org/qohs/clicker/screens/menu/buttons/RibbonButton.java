package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.menu.Menu;
import org.qohs.clicker.screens.util.PaddedDrawable;
import org.qohs.clicker.screens.util.Button;

/**
 * 
 * @author Derek Zhang
 */

public class RibbonButton extends Button {

	public RibbonButton() {
		
		super(Menu.GAMEWIDTH / 2, Menu.GAMEHEIGHT - Menu.GAMEHEIGHT / 10,
				Menu.GAMEWIDTH / 2, Menu.GAMEHEIGHT / 10,
				new PaddedDrawable(AssetLoader.icon_ribbon, .75f, .75f),
				new PaddedDrawable(AssetLoader.icon_ribbon, .5f, .5f));
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub

	}

}
