package org.qohs.clicker.world.gameobjects.donutaspects;

import org.qohs.clicker.io.AssetLoader;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum DonutTopping {

	NONE,
	BLACK_SPRINKLES, 
	BLUE_SPRINKLES, 
	CHOCO_FROSTING,
	CINNAMON_CRULLER,
	CINNAMON_DONUT,
	CINNAMON_STUFFED,
	POWDER_CRULLER,
	POWDER_DONUT,
	POWDER_STUFFED,
	RED_SPRINKLES,
	STRAWBERRY_FROSTING,
	SUGAR_CRULLER,
	SUGAR_DONUT,
	SUGAR_STUFFED,
	WHITE_FROSTING,
	WHITE_SPRINKLES,
	YELLOW_SPRINKLES;
	
	public static TextureRegion getTexture(DonutTopping topping) {
		
		switch (topping) {
		
		case NONE: return null;
		case BLACK_SPRINKLES: return AssetLoader.topping_blacksprinkles; 
		case BLUE_SPRINKLES: return AssetLoader.topping_bluesprinkles; 
		case CHOCO_FROSTING: return AssetLoader.topping_chocofrosting;
		case CINNAMON_CRULLER: return AssetLoader.topping_cinncruller;
		case CINNAMON_DONUT: return AssetLoader.topping_cinndonut;
		case CINNAMON_STUFFED: return AssetLoader.topping_cinnstuffed;
		case POWDER_CRULLER: return AssetLoader.topping_powdercruller;
		case POWDER_DONUT: return AssetLoader.topping_powderdonut;
		case POWDER_STUFFED: return AssetLoader.topping_powderstuffed;
		case RED_SPRINKLES: return AssetLoader.topping_redsprinkles;
		case STRAWBERRY_FROSTING: return AssetLoader.topping_strawberryfrosting;
		case SUGAR_CRULLER: return AssetLoader.topping_sugarcruller;
		case SUGAR_DONUT: return AssetLoader.topping_sugardonut;
		case SUGAR_STUFFED: return AssetLoader.topping_sugarstuffed;
		case WHITE_FROSTING: return AssetLoader.topping_whitefrosting;
		case WHITE_SPRINKLES: return AssetLoader.topping_whitesprinkles;
		case YELLOW_SPRINKLES: return AssetLoader.topping_yellowsprinkles;
		
		default: return null;
		}
	}
	
	public static float multiplier(DonutTopping topping) {
//		System.out.println(topping.toString());
		return AssetLoader.multiplierMap.get(topping);
	}
}
