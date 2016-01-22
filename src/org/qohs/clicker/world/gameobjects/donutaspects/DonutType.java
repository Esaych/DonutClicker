package org.qohs.clicker.world.gameobjects.donutaspects;

import java.util.HashMap;
import java.util.Map;

import org.qohs.clicker.io.AssetLoader;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum DonutType {
	
	PLAIN,
	GLAZED,
	FRIED,
	STUFFED_JAM,
	STUFFED_WHIPPED_CREAM,
	STUFFED_CREAM;
	
	private static Map<DonutType, TextureRegion> textures = new HashMap<DonutType, TextureRegion>();
	private static Map<DonutType, Float> cpsMap = new HashMap<DonutType, Float>();
	
	public static void setTexture(DonutType type, TextureRegion texture) {
		textures.put(type, texture);
	}
	
	public static TextureRegion getTexture(DonutType type) {
		if (textures.containsKey(type))
			return textures.get(type);
		else
			return null;
	}
	
	public static void setClicksPerSec(DonutType type, Float cps) {
		cpsMap.put(type, cps);
	}
	
	public static float getClicksPerSec(DonutType type) {
		if (cpsMap.containsKey(type))
			return cpsMap.get(type);
		else
			return 0;
	}
}
