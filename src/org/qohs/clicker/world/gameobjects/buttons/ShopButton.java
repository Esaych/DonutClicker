package org.qohs.clicker.world.gameobjects.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.util.UpdateRenderObj;
import org.qohs.clicker.world.GameWorld;
import org.qohs.clicker.world.gameobjects.Button;

public class ShopButton extends Button implements UpdateRenderObj {

	public ShopButton() {
		super(0, GameWorld.GAMEHEIGHT*4/5, GameWorld.GAMEWIDTH, GameWorld.GAMEHEIGHT*1/5, AssetLoader.table, AssetLoader.table);
		System.out.println("SHOP BUTTON CREATED");
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
