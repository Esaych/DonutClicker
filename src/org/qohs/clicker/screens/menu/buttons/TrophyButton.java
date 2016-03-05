package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.Button;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * 
 * @author Derek Zhang
 */

public class TrophyButton extends Button {

	public TrophyButton() {
		
		super(0, GameWorld.GAMEHEIGHT - GameWorld.GAMEWIDTH / 2 + GameWorld.GAMEHEIGHT / 10, 
				GameWorld.GAMEWIDTH / 2 - GameWorld.GAMEHEIGHT / 10, GameWorld.GAMEWIDTH / 2 - GameWorld.GAMEHEIGHT / 10,
				new TextureRegionDrawable(AssetLoader.icon_trophy),
				new TextureRegionDrawable(AssetLoader.icon_trophy));
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub

	}

}
