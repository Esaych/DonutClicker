package org.qohs.clicker.screens.menu.buttons;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.gameobjects.Score;
import org.qohs.clicker.screens.util.Button;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;

/**
 * this class is also known as MSB
 * this MSB represents a button that can be clicked in
 * order to purchase a multiplier upgrade
 * @author derekzhang
 *
 */
public class MultiplierShopButton extends Button {

	private boolean buyable;
	private final long price;

	public MultiplierShopButton(int x, int y, int width, int height, long price) {

		super(x, y, width, height,
				new MultiplierShopDrawable("Super awesome hack", price + "Donuts", AssetLoader.icon_settings), 
				new MultiplierShopDrawable("Super awesome", price + "Donuts", AssetLoader.icon_settings));

		this.price = price;
		buyable = Score.getScore() >= price;
	}

	@Override
	public void onClick() {

		if (buyable) {

			throw new IllegalStateException("OVER NINE THOUSAND WHAAAAAT? YOU WIN BRO!");
		}
	}
	
	@Override
	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
		
		AssetLoader.plus_number_shadow_font.setColor(AssetLoader.plus_number_shadow_font.getOriginalColor());
		
		buyable = Score.getScore() >= price;
		if (!buyable) {
			
			renderer.begin(ShapeType.Filled);
			
			renderer.setColor(Color.GRAY);
			renderer.rect(x, y, width, height);
			
			renderer.end();
			
			Color color = batcher.getColor();
			batcher.setColor(Color.GRAY);

			AssetLoader.plus_number_font.setColor(Color.LIGHT_GRAY);
			super.render(batcher, renderer);
			batcher.setColor(color);
		}
		else {
			
			AssetLoader.plus_number_font.setColor(AssetLoader.plus_number_font.getOriginalColor());
			super.render(batcher, renderer);
		}
	}

	/**
	 * Provides UI for the multiplier shop button (MSB)
	 *
	 */
	private static class MultiplierShopDrawable extends BaseDrawable {

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
			
			AssetLoader.plus_number_shadow_font.draw(batch, name, x+2, y+2);
			AssetLoader.plus_number_font.draw(batch, name, x, y);
			
			GlyphLayout glyphLayout = new GlyphLayout(AssetLoader.plus_number_font, price);
			AssetLoader.plus_number_shadow_font.draw(batch, glyphLayout, x + width - glyphLayout.width + 2, y + height - glyphLayout.height + 2);
			AssetLoader.plus_number_font.draw(batch, glyphLayout, x + width- glyphLayout.width, y + height - glyphLayout.height);
		}
	}
}
