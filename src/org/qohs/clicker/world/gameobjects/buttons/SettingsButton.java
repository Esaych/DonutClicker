package org.qohs.clicker.world.gameobjects.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.world.GameWorld;
import org.qohs.clicker.world.gameobjects.Button;

public class SettingsButton extends Button {

	public SettingsButton() {
		super(GameWorld.GAMEWIDTH - (GameWorld.GAMEWIDTH/10+5), 5, GameWorld.GAMEWIDTH*1/10, GameWorld.GAMEHEIGHT*1/15, AssetLoader.icon_settings, AssetLoader.icon_settings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

}
