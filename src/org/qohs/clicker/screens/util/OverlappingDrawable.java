package org.qohs.clicker.screens.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class OverlappingDrawable extends TextureRegionDrawable {
	TextureRegion under;
	TextureRegion over;
	int overOffsetX, overOffsetY;
	int overWidth, overHeight;
	
	public OverlappingDrawable (TextureRegion under, TextureRegion over, int x, int y, int width, int height) {
		super(under);
		this.over = over;
		this.under = under;
		overOffsetX = x;
		overOffsetY = y;
		overWidth = width;
		overHeight = height;
	}
	
	@Override
	public void draw(Batch batch, float x, float y, float width, float height) {
		batch.draw(under, x, y, width, height);
		batch.draw(over, x+overOffsetX, y+overOffsetY, overWidth, overHeight);
	}
}
