package org.qohs.clicker.io;

import org.qohs.clicker.screens.game.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.screens.game.gameobjects.donutaspects.DonutType;
import org.qohs.clicker.screens.util.ColorRetainingBitmapFont;

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
	public static Texture icons, toppings_texture, type_texture, shop, wood, dropdowns;
	
	//Fonts
	public static BitmapFont score_font, score_shadow_font;
	public static ColorRetainingBitmapFont plus_number_font, plus_number_shadow_font;
	
	//ICON REGIONS
	public static TextureRegion icon_trophy, icon_ribbon, icon_settings, icon_menu_toggle;
	
	//INTERFACE REGIONS
	public static TextureRegion awning, sign, table, table_clicked, shopbackground, shopreturn, shopreturn_clicked,
	dropdown, dropdown_clicked, dropdownarrow, dropdownarrow_clicked;

	public static void load() {
		
		//LOADING TEXTURES (individual image files)
		type_texture = new Texture(Gdx.files.internal("assets/donutshoppe/types.png"));
		toppings_texture = new Texture(Gdx.files.internal("assets/donutshoppe/toppings.png"));
		icons = new Texture(Gdx.files.internal("assets/eat.png"));
		shop = new Texture(Gdx.files.internal("assets/donutshoppe/shoppe.png"));
		wood = new Texture(Gdx.files.internal("assets/donutshoppe/wood.png"));
		dropdowns = new Texture(Gdx.files.internal("assets/menu/dropdowns.png"));
		
		//LOADING FONTS
		score_font = new BitmapFont(Gdx.files.internal("assets/snaps-taste-52-white.fnt"), true);
		score_shadow_font = new BitmapFont(Gdx.files.internal("assets/snaps-taste-52-black.fnt"), true);
		plus_number_font = new ColorRetainingBitmapFont(Gdx.files.internal("assets/snaps-taste-52-white.fnt"), true);
		plus_number_font.getData().setScale(.65f);
		plus_number_shadow_font = new ColorRetainingBitmapFont(Gdx.files.internal("assets/snaps-taste-52-black.fnt"), true);
		plus_number_shadow_font.getData().setScale(.65f);
		
		//SHOP SPRITE REGION ASSIGNMENT
		awning = new TextureRegion(shop, 0, 0, 2000, 2000); awning.flip(false, true);
		sign = new TextureRegion(shop, 2000, 0, 2000, 2000); sign.flip(false, true);
		table = new TextureRegion(shop, 0, 2000, 2000, 1500); table.flip(false, true);
		table_clicked = new TextureRegion(shop, 2000, 2000, 2000, 1500); table_clicked.flip(false, true);
		shopbackground = new TextureRegion(wood, 0, 0, 2000, 4000); shopbackground.flip(false, true);
		shopreturn = new TextureRegion(shop, 4000, 2000, 2000, 1500); shopreturn.flip(false, true);
		shopreturn_clicked = new TextureRegion(shop, 6000, 2000, 2000, 1500); shopreturn_clicked.flip(false, true);
		dropdown = new TextureRegion(dropdowns, 0, 0, 1024, 96); dropdown.flip(false, true);
		dropdown_clicked = new TextureRegion(dropdowns, 0, 96, 1024, 96); dropdown_clicked.flip(false, true);
		dropdownarrow = new TextureRegion(dropdowns, 0, 192, 97, 58); dropdownarrow.flip(false, true);
		dropdownarrow_clicked = new TextureRegion(dropdowns, 97, 192, 97, 58); dropdownarrow_clicked.flip(false, true);
		
		
		
		//icon_trophy = new TextureRegion(icons, 779, 77, 563, 653);icon_trophy.flip(false, true);
		icon_trophy = new TextureRegion(icons, 779, 77, 563, 655);icon_trophy.flip(false, true);
		//icon_ribbon = new TextureRegion(icons, 375, 720, 542, 752);icon_ribbon.flip(false, true);
		icon_ribbon = new TextureRegion(icons, 100, 320, 542, 772);icon_ribbon.flip(false, true);
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