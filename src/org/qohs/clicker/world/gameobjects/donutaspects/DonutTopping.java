package org.qohs.clicker.world.gameobjects.donutaspects;

import java.util.HashMap;
import java.util.Map;

import org.qohs.clicker.io.AssetLoader;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum DonutTopping {

	NONE,
	CHOCO_FROSTING,
	STRAWBERRY_FROSTING,
	WHITE_FROSTING,
	
	CHOCO_SPRINKLES, 
	BLUE_SPRINKLES, 
	RED_SPRINKLES,
	WHITE_SPRINKLES,
	YELLOW_SPRINKLES,
	RAINBOW_SPRINKLES;
	
	private static Map<DonutTopping, TextureRegion> textures = new HashMap<DonutTopping, TextureRegion>();
	private static Map<DonutTopping, Float> multiplierMap = new HashMap<DonutTopping, Float>(); 
	
	public static void setTexture(DonutTopping topping, TextureRegion texture) {
		textures.put(topping, texture);
	}
	
	public static TextureRegion getTexture(DonutTopping topping) {
		if (textures.containsKey(topping))
			return textures.get(topping);
		else
			return null;
	}
	
	public static void setMultiplier(DonutTopping topping, Float multiplier) {
		multiplierMap.put(topping, multiplier);
	}
	
	public static float getMultiplier(DonutTopping topping) {
		if (multiplierMap.containsKey(topping))
			return multiplierMap.get(topping);
		else
			return 1;
	}
}
