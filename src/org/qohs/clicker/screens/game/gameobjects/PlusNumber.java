package org.qohs.clicker.screens.game.gameobjects;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.game.RenderObjQueue;
import org.qohs.clicker.screens.util.UpdateRenderObj;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;

/**
 * a class that does "plus number"
 * @author Derek Zhang
 *
 */

public class PlusNumber implements UpdateRenderObj {

	private static final float PRIMARY_FADE_TIME = 2f;
	private static final float SECONDARY_FADE_TIME = PRIMARY_FADE_TIME / 3f;
	
	private final String plusString;
	private int y;
	private int originalDistance;
	private Color white;
	private Color black;
	private Actor fader;
	
	public PlusNumber(int addition) {
		
		plusString = "+" + addition;
		y = GameWorld.GAMEHEIGHT/2;
		originalDistance = y;
		white = new Color(AssetLoader.plus_number_font.getColor());
		black = new Color(AssetLoader.plus_number_shadow_font.getColor());
		fader = new Actor();
		AlphaAction fadeAction = Actions.fadeOut(PRIMARY_FADE_TIME);
		fadeAction.setColor(white);
		fader.addAction(fadeAction);
		fadeAction = Actions.fadeOut(SECONDARY_FADE_TIME);
		fadeAction.setColor(black);
		fader.addAction(fadeAction);
		RenderObjQueue.registerUpdates(this, true, true);
	}

	public void update(float delta) {

		//math happens
		y -= originalDistance * delta / PRIMARY_FADE_TIME;
		//remove this object once it's off the screen, or barely visible
		if (y <= 0 || white.a <= .3) {

			RenderObjQueue.removeUpdates(this);
		}
		//fading
		fader.act(delta);
	}

	public void render(SpriteBatch batcher, ShapeRenderer renderer) {

		batcher.begin();
		AssetLoader.plus_number_shadow_font.setColor(black);
		AssetLoader.plus_number_shadow_font.draw(batcher, plusString, (GameWorld.GAMEWIDTH )/2+2, y+2);
		AssetLoader.plus_number_font.setColor(white);
		AssetLoader.plus_number_font.draw(batcher, plusString, (GameWorld.GAMEWIDTH )/2, y);
		batcher.end();
		//reset color
		AssetLoader.plus_number_shadow_font.setColor(AssetLoader.plus_number_shadow_font.getOriginalColor());
		AssetLoader.plus_number_font.setColor(AssetLoader.plus_number_font.getOriginalColor());
	}
}
