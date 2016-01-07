package org.qohs.clicker.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface UpdateRenderObj {
	public void update(float delta);
	public void render(SpriteBatch batcher, ShapeRenderer renderer);
}
