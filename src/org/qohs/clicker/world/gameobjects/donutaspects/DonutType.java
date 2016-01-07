package org.qohs.clicker.world.gameobjects.donutaspects;

import org.qohs.clicker.io.AssetLoader;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum DonutType {
	
	PLAIN,
	GLAZED,
	CRULLER,
	FRIED,
	BLUEBERRY,
	STUFFED_JAM,
	STUFFED_WHIPPED_CREAM,
	STUFFED_CREAM;
	
	public static TextureRegion getTexture(DonutType type) {
		
		switch(type) {
		
		case PLAIN: return AssetLoader.type_plain;
		case GLAZED: return AssetLoader.type_glazed;
		case CRULLER: return AssetLoader.type_cruller;
		case FRIED: return AssetLoader.type_fried;
		case BLUEBERRY: return AssetLoader.type_blueberry;
		case STUFFED_JAM: return AssetLoader.type_stuffedjam;
		case STUFFED_CREAM: return AssetLoader.type_stuffedcream;
		case STUFFED_WHIPPED_CREAM: return AssetLoader.type_stuffedwhippcream;
		
		default: return AssetLoader.type_plain;
		}
	}
	
	
	public static double cps(DonutType type) {
		
		switch(type) {
		
		case PLAIN: return AssetLoader.cpsMap.get(PLAIN);
		case GLAZED: return AssetLoader.cpsMap.get(GLAZED);
		case CRULLER: return AssetLoader.cpsMap.get(CRULLER);
		case FRIED: return AssetLoader.cpsMap.get(FRIED);
		case BLUEBERRY: return AssetLoader.cpsMap.get(BLUEBERRY);
		case STUFFED_JAM: return AssetLoader.cpsMap.get(STUFFED_JAM);
		case STUFFED_CREAM: return AssetLoader.cpsMap.get(STUFFED_CREAM);
		case STUFFED_WHIPPED_CREAM: return AssetLoader.cpsMap.get(STUFFED_WHIPPED_CREAM);
		
		default: return AssetLoader.cpsMap.get(PLAIN);
		}
	}
}
