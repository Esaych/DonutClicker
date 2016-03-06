package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.gameobjects.Score;
import org.qohs.clicker.screens.util.Button;
import org.qohs.clicker.screens.util.MultiplierShopDrawable;

/**
 * this class is also known as MSB
 * this MSB represents a button that can be clicked in
 * order to purchase a multiplier upgrade
 * @author derekzhang
 *
 */
public class MultiplierShopButton extends Button {
	
	private final long price;

	public MultiplierShopButton(int x, int y, int width, int height, long price) {
		
		super(x, y, width, height,
				new MultiplierShopDrawable("Super awesome hack", price + "Donuts", AssetLoader.icon_settings), 
				new MultiplierShopDrawable("Super awesome", price + "Donuts", AssetLoader.icon_settings));
		
		this.price = price;
	}

	@Override
	public void onClick() {
		
		if (Score.getScore() >= price) {//we're screwed because synchronization
			//USER CLICKS DO NOT SYCHRONIZE WITH AUTO SCORE ADDITION
			//but I guess if we stop autoclicks on donut when menu up, then we good :)
			
			throw new IllegalStateException("OVER NINE THOUSAND WHAAAAAT? YOU WIN BRO!");
		}
	}

}
