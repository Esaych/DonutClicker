package org.qohs.clicker.screens.menu.buttons;

import java.util.ArrayList;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.Button;
import org.qohs.clicker.screens.util.OverlappingDrawable;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Dropdown extends Button{
	
	private ArrayList<Button> dropdownMenuItems;
	private String title;
	private boolean toggled;
	
	public Dropdown(int y, String title) {
		super(GameWorld.GAMEWIDTH*1/24, y,
				GameWorld.GAMEWIDTH*11/12, GameWorld.GAMEWIDTH*11/128, //roughly width and height
				new TextureRegionDrawable(AssetLoader.dropdown), 
				new TextureRegionDrawable(AssetLoader.dropdown_clicked));
		
		OverlappingDrawable buttonDrawable = new OverlappingDrawable(AssetLoader.dropdown, AssetLoader.dropdownarrow, 
				GameWorld.GAMEWIDTH*4/5, GameWorld.GAMEWIDTH/40, 
				GameWorld.GAMEWIDTH / 15, GameWorld.GAMEWIDTH/30);
		drawable = buttonDrawable;
		OverlappingDrawable buttonclickDrawable = new OverlappingDrawable(AssetLoader.dropdown_clicked, AssetLoader.dropdownarrow_clicked, 
				GameWorld.GAMEWIDTH*4/5, GameWorld.GAMEWIDTH/40, 
				GameWorld.GAMEWIDTH / 15, GameWorld.GAMEWIDTH/30);
		clickDrawable = buttonclickDrawable;
	}
	
	public void addMenuItem(Button button) {
		dropdownMenuItems.add(button);
	}
	
	@Override
	public void onClick() {
		toggled = !toggled;
		
	}

	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
