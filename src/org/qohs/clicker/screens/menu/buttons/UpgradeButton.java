package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.screens.util.Button;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class UpgradeButton extends Button {

	public UpgradeButton(int x, int y, int width, int height, TextureRegion texture, TextureRegion clickTexture) {
		super(x, y, width, height, new TextureRegionDrawable(texture), new TextureRegionDrawable(clickTexture));
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

}
