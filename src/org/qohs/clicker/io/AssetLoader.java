package org.qohs.clicker.io;

import java.util.HashMap;
import java.util.Map;

import org.qohs.clicker.world.gameobjects.donutaspects.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * This class loads all textures, fonts, and graphical elements
 * @author QO Game Development Club
 *
 */

public class AssetLoader {
	public static Texture texture;
	public static Texture icons;
	public static Texture toppings_texture;
	public static Texture type_texture;
	public static BitmapFont score_font;
	public static TextureRegion topping_blacksprinkles, 
	topping_bluesprinkles, 
	topping_chocofrosting,
	topping_cinncruller,
	topping_cinndonut,
	topping_cinnstuffed,
	topping_powdercruller,
	topping_powderdonut,
	topping_powderstuffed,
	topping_redsprinkles,
	topping_strawberryfrosting,
	topping_sugarcruller,
	topping_sugardonut,
	topping_sugarstuffed,
	topping_whitefrosting,
	topping_whitesprinkles,
	topping_yellowsprinkles;
	public static TextureRegion type_blueberry,
	type_cruller,
	type_fried,
	type_glazed,
	type_plain,
	type_stuffedcream,
	type_stuffedjam,
	type_stuffedwhippcream;
	public static TextureRegion icon_trophy, icon_ribbon, icon_settings;
	
	public static Map<DonutTopping, Float> multiplierMap = new HashMap<DonutTopping, Float>(); 
	public static Map<DonutType, Float> cpsMap = new HashMap<DonutType, Float>();

	/*

type_blueberry = 0, 0, 1024, 1024
type_cruller = 1024, 0, 1024, 1024
type_fired = 0, 1024, 1024, 1024
type_glazed = 1024, 1024, 1024, 1024
type_plain = 2048, 0, 1024, 1024
type_stuffedcream = 2048, 1024, 1024, 1024s
type_stuffedjam = 3072, 0, 1024, 1024
type_stuffedwhippcream = 3072, 1024, 1024, 1024


	 */

	public static void load() {
		texture = new Texture(Gdx.files.internal("assets/texture.png"));
		icons = new Texture(Gdx.files.internal("assets/eat.png"));
		toppings_texture = new Texture(Gdx.files.internal("assets/donut_topping.png"));
		type_texture = new Texture(Gdx.files.internal("assets/donut_type.png"));
		score_font = new BitmapFont(Gdx.files.internal("assets/snaps-taste-52.fnt"), true);

		topping_blacksprinkles = new TextureRegion(toppings_texture, 0, 0, 1024, 1024);
		topping_bluesprinkles = new TextureRegion(toppings_texture, 1024, 0, 1024, 1024);
		topping_chocofrosting = new TextureRegion(toppings_texture, 0, 1024, 1024, 1024);
		topping_cinncruller = new TextureRegion(toppings_texture, 1024, 1024, 1024, 1024);
		topping_cinndonut = new TextureRegion(toppings_texture, 2048, 0, 1024, 1024);
		topping_cinnstuffed = new TextureRegion(toppings_texture, 2048, 1024, 1024, 1024);
		topping_powdercruller = new TextureRegion(toppings_texture, 3072, 0, 1024, 1024);
		topping_powderdonut = new TextureRegion(toppings_texture, 3072, 1024, 1024, 1024);
		topping_powderstuffed = new TextureRegion(toppings_texture, 0, 2048, 1024, 1024);
		topping_redsprinkles = new TextureRegion(toppings_texture, 1024, 2048, 1024, 1024);
		topping_strawberryfrosting = new TextureRegion(toppings_texture, 2048, 2048, 1024, 1024);
		topping_sugarcruller = new TextureRegion(toppings_texture, 3072, 2048, 1024, 1024);
		topping_sugardonut = new TextureRegion(toppings_texture, 4096, 0, 1024, 1024);
		topping_sugarstuffed = new TextureRegion(toppings_texture, 5120, 0, 1024, 1024);
		topping_whitefrosting = new TextureRegion(toppings_texture, 4096, 1024, 1024, 1024);
		topping_whitesprinkles = new TextureRegion(toppings_texture, 5120, 1024, 1024, 1024);
		topping_yellowsprinkles = new TextureRegion(toppings_texture, 4096, 2048, 1024, 1024);

		type_blueberry = new TextureRegion(type_texture, 0, 0, 1024, 1024);
		type_cruller = new TextureRegion(type_texture, 1024, 0, 1024, 1024);
		type_fried = new TextureRegion(type_texture, 0, 1024, 1024, 1024);
		type_glazed = new TextureRegion(type_texture, 1024, 1024, 1024, 1024);
		type_plain = new TextureRegion(type_texture, 2048, 0, 1024, 1024);
		type_stuffedcream = new TextureRegion(type_texture, 2048, 1024, 1024, 1024);
		type_stuffedjam = new TextureRegion(type_texture, 3072, 0, 1024, 1024);
		type_stuffedwhippcream = new TextureRegion(type_texture, 3072, 1024, 1024, 1024);
		
		icon_trophy = new TextureRegion(icons, 779, 77, 563, 653);
		icon_ribbon = new TextureRegion(icons, 375, 720, 542, 752);
		icon_settings = new TextureRegion(icons, 494, 1178, 558, 538);
		
		FileHandle file = Gdx.files.internal("assets/multiplier_values.txt");
		String multiplierText = file.readString();
		multiplierText.replaceAll("\r", "");
		String[] rows = multiplierText.split("\n");
		for (String str : rows) {
			str.replaceAll(" ", "");
			String[] pair = str.split("=");
			multiplierMap.put(DonutTopping.valueOf(pair[0]), Float.valueOf(pair[1]));
		}
		//System.out.println(multiplierMap.toString());
		file = Gdx.files.internal("assets/cps_values.txt");
		String cpsText = file.readString();
		cpsText.replaceAll("\r", "");
		rows = cpsText.split("\n");
		for (String str : rows) {
			str.replaceAll(" ", "");
			String[] pair = str.split("=");
			cpsMap.put(DonutType.valueOf(pair[0]), Float.valueOf(pair[1]));
		}
	}
}