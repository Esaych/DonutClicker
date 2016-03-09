package org.qohs.clicker.screens.util;

import org.qohs.clicker.io.AssetLoader;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;

/**
 * Provides UI for the multiplier shop button (MSB)
 * Note: may be moved as inner class of MSB
 * @author derekzhang
 *
 */
public class MultiplierShopDrawable extends BaseDrawable {

	private final String name;
	private final String price;
	private final TextureRegion icon;
	
	public MultiplierShopDrawable(String name, String price, TextureRegion icon) {
		
		this.name = name;
		this.price = price;
		this.icon = icon;
	}
	
	public void draw(Batch batch, float x, float y, float width, float height) {
		
		batch.draw(icon, x + width - height, y, height, height);
		AssetLoader.plus_number_font.setColor(AssetLoader.plus_number_font.getOriginalColor());
		AssetLoader.plus_number_shadow_font.draw(batch, name, x+2, y+2);
		AssetLoader.plus_number_shadow_font.setColor(AssetLoader.plus_number_shadow_font.getOriginalColor());
		AssetLoader.plus_number_font.draw(batch, name, x, y);
		GlyphLayout glyphLayout = new GlyphLayout(AssetLoader.plus_number_font, price);
		AssetLoader.plus_number_shadow_font.draw(batch, glyphLayout, x + width - glyphLayout.width + 2, y + height - glyphLayout.height + 2);
		AssetLoader.plus_number_font.draw(batch, glyphLayout, x + width- glyphLayout.width, y + height - glyphLayout.height);
	}
}
