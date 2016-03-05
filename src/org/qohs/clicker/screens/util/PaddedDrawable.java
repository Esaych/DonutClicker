package org.qohs.clicker.screens.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * This class overrides the draw method from Drawable interface
 * so that the TextureRegion will be drawn smaller
 * @author derekzhang
 *
 */
public class PaddedDrawable extends TextureRegionDrawable {

	private TextureRegion background;
	private final float xScale;
	private final float yScale;
	
	public PaddedDrawable(TextureRegion textureRegion, float xScale, float yScale) {
		
		this (null, textureRegion, xScale, yScale);
	}
	
	public PaddedDrawable(TextureRegion background, TextureRegion textureRegion, float xScale, float yScale) {

		super(textureRegion);
		
		this.background = background;
		
		if (xScale < 0 || yScale < 0) {
			
			throw new IllegalArgumentException("Scale cannot be negative!");
		}
		else if (xScale > 1 || yScale > 1) {
			
			throw new IllegalArgumentException("Scale cannot be over 1!");
		}
		
		this.xScale = xScale;
		this.yScale = yScale;
	}
	
	@Override
	public void draw(Batch batch, float x, float y, float width, float height) {

		if (background != null) {

			batch.draw(background, x, y, width, height);
		}
		
		TextureRegion textureRegion = getRegion();
		int firstScale = (int) Math.max(textureRegion.getRegionWidth() / width, textureRegion.getRegionHeight() / height);//textureRegion.getRegionWidth() / width
		float newWidth, newHeight;
		if (firstScale > 1) {

			newWidth = textureRegion.getRegionWidth() / firstScale;
			newHeight = textureRegion.getRegionHeight() / firstScale;
		}
		else {
			
			newWidth = textureRegion.getRegionWidth();
			newHeight = textureRegion.getRegionHeight();
		}
		
		newWidth *= xScale;
		newHeight *= yScale;
		
		batch.draw(textureRegion, x + (width - newWidth) / 2, y + (height - newHeight) / 2, newWidth, newHeight);
	}
}
