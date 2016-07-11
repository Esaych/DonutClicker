package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.Clicker;
import org.qohs.clicker.Clicker.ScreenType;
import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.Button;
import org.qohs.clicker.screens.util.UpdateRenderObj;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ShopButton extends Button implements UpdateRenderObj{

	public ShopButton(boolean inShop) {
		super(0, (inShop? 0 : GameWorld.GAMEHEIGHT*4/5),
				GameWorld.GAMEWIDTH, GameWorld.GAMEWIDTH*3/4,
				new TextureRegionDrawable(inShop ? AssetLoader.shopreturn : AssetLoader.table), 
				new TextureRegionDrawable(inShop ? AssetLoader.shopreturn_clicked : AssetLoader.table_clicked));
	}

	@Override
	public void onClick() {
		System.out.println("SHOPBUTTON CLICKED");
		if (Clicker.getClickerScreenType().equals(ScreenType.GAME))
			Clicker.setClickerScreen(ScreenType.MENU);
		else if (Clicker.getClickerScreenType().equals(ScreenType.MENU))
			Clicker.setClickerScreen(ScreenType.GAME);
	}
}
