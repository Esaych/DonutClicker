package org.qohs.clicker.io;

import org.qohs.clicker.world.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutType;

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
	//Image/Sprite Files
	public static Texture icons;
	public static Texture toppings_texture;
	public static Texture type_texture;
	public static Texture shop;	
	
	//Fonts
	public static BitmapFont score_font;
	public static BitmapFont score_shadow_font;
	
	//ICON REGIONS
	public static TextureRegion icon_trophy, icon_ribbon, icon_settings, icon_menu_toggle;
	
	//INTERFACE REGIONS
	public static TextureRegion awning, sign, table;

	public static void load() {
		
		//LOADING TEXTURES (individual image files)
		type_texture = new Texture(Gdx.files.internal("assets/donutshoppe/types.png"));
		toppings_texture = new Texture(Gdx.files.internal("assets/donutshoppe/toppings.png"));
		icons = new Texture(Gdx.files.internal("assets/eat.png"));
		shop = new Texture(Gdx.files.internal("assets/donutshoppe/shoppe.png"));
		
		//LOADING FONTS
		score_font = new BitmapFont(Gdx.files.internal("assets/snaps-taste-52-white.fnt"), true);
		score_shadow_font = new BitmapFont(Gdx.files.internal("assets/snaps-taste-52-black.fnt"), true);
		
		//SHOP SPRITE REGION ASSIGNMENT
		awning = new TextureRegion(shop, 0, 0, 2000, 2000); awning.flip(false, true);
		sign = new TextureRegion(shop, 2000, 0, 2000, 2000); sign.flip(false, true);
		table = new TextureRegion(shop, 0, 2000, 2000, 1500); table.flip(false, true);
		
		icon_trophy = new TextureRegion(icons, 779, 77, 563, 653);icon_trophy.flip(false, true);
		icon_ribbon = new TextureRegion(icons, 375, 720, 542, 752);icon_ribbon.flip(false, true);
		icon_settings = new TextureRegion(icons, 494, 1178, 558, 538);icon_settings.flip(true, true);
		icon_menu_toggle = new TextureRegion(icons, 800, 890, 530, 205);
		
		//IMPORT TEXTURE MAP OF DONUT TYPES
		FileHandle file = Gdx.files.internal("assets/donutshoppe/types.txt");
		String mapdata = file.readString();
		mapdata = mapdata.replaceAll("\r", "");
		String[] mappings = mapdata.split("\n");
		
		for (String str : mappings) {
			str = str.replaceAll(" =", "");
			String[] coords = str.split(" ");
			TextureRegion temp = new TextureRegion(type_texture, 
					Integer.valueOf(coords[1]), 
					Integer.valueOf(coords[2]),
					Integer.valueOf(coords[3]), 
					Integer.valueOf(coords[4]));
			temp.flip(false, true);
			DonutType.setTexture(DonutType.valueOf(coords[0]), temp);
		}
		
		//IMPORT CPS VALUES OF ALL TEXTURES
		file = Gdx.files.internal("assets/cps_values.txt");
		String cpsText = file.readString();
		cpsText = cpsText.replaceAll("\r", "");
		String[] rows = cpsText.split("\n");
		for (String str : rows) {
			str = str.replaceAll(" ", "");
			String[] pair = str.split("=");
			DonutType.setClicksPerSec(DonutType.valueOf(pair[0]), Float.valueOf(pair[1]));
		}
		
		
		//IMPORT TEXTURE MAP OF DONUT TOPPINGS
		file = Gdx.files.internal("assets/donutshoppe/toppings.txt");
		mapdata = file.readString();
		mapdata = mapdata.replaceAll("\r", "");
		mappings = mapdata.split("\n");
		
		for (String str : mappings) {
			str = str.replaceAll(" =", "");
			String[] coords = str.split(" ");
			System.out.println(str);
			TextureRegion temp = new TextureRegion(toppings_texture, 
					Integer.valueOf(coords[1]), 
					Integer.valueOf(coords[2]),
					Integer.valueOf(coords[3]), 
					Integer.valueOf(coords[3]));
			temp.flip(false, true);
			DonutTopping.setTexture(DonutTopping.valueOf(coords[0]), temp);
			for (String s: coords) {
				System.out.println(s);
			}
		}
		
		//IMPORT MULTIPLIER VALUES OF ALL TOPPINGS
		file = Gdx.files.internal("assets/multiplier_values.txt");
		String multiplierText = file.readString();
		multiplierText = multiplierText.replaceAll("\r", "");
		rows = multiplierText.split("\n");
		for (String str : rows) {
			str = str.replaceAll(" ", "");
			String[] pair = str.split("=");
			DonutTopping.setMultiplier(DonutTopping.valueOf(pair[0]), Float.valueOf(pair[1]));
		}
	}
}