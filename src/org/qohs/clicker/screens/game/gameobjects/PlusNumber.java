package org.qohs.clicker.screens.game.gameobjects;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.UpdateRenderObj;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * a class that does "plus one"
 * @author Derek Zhang
 *
 */

public class PlusNumber implements UpdateRenderObj {

	private final String plusString;
	private float timePassed;
	private int y;
	private float alpha;
	
	public PlusNumber(int addition) {
		
		plusString = "+" + addition;
		timePassed = 0;
		y = GameWorld.GAMEHEIGHT/2;
		alpha = 255;
		GameWorld.registerUpdates(this, true, true);
	}

	public void update(float delta) {

		timePassed += delta;
			
		if (timePassed >= .1) {
			
			alpha = Math.max(alpha - 50, 0);
			timePassed = 0;
		}
		
		y -= 6;
		if (y <= 0) {
			
			GameWorld.removeUpdates(this);
		}
	}

	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
			
		batcher.begin();
		GlyphLayout glyphLayout = new GlyphLayout();
		glyphLayout.setText(AssetLoader.score_font, plusString);
		float w = glyphLayout.width;
		Color color;
		color = AssetLoader.score_shadow_font.getColor();
		AssetLoader.score_shadow_font.setColor(color.r, color.g, color.b, alpha);
		AssetLoader.score_shadow_font.draw(batcher, glyphLayout, (GameWorld.GAMEWIDTH - w)/2+2, y+2);
		AssetLoader.score_shadow_font.setColor(color);
		color = AssetLoader.score_font.getColor();
		AssetLoader.score_font.setColor(color.r, color.g, color. b, alpha);
		AssetLoader.score_font.draw(batcher, glyphLayout, (GameWorld.GAMEWIDTH - w)/2, y);
		AssetLoader.score_font.setColor(color);
		batcher.end();
	}
}
