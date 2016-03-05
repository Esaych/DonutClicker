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

	//the time it takes for the font's alpha to become 0 or completely transparent
	private static final float PRIMARY_FADE_TIME = 2f;
	//the time it takes for the font's shadow
	private static final float SECONDARY_FADE_TIME = PRIMARY_FADE_TIME / 3f;
	
	//the text displayed which represents this "plus number"
	private final String plusString;
	//the x coordinate of the plus number on the screen
	private int x;
	//the y coordinate of the plus number on the screen
	private int y;
	//the color of the font
	private Color white;
	//the color of the font's shadow
	private Color black;
	//fades the "plus number"
	private Actor fader;
	
	public PlusNumber(int x, int y, int addition) {
		
		plusString = "+" + addition;
		this.x = x;
		this.y = y;
		white = new Color(AssetLoader.plus_number_font.getOriginalColor());
		black = new Color(AssetLoader.plus_number_shadow_font.getOriginalColor());
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

		/* math happens, ok maybe that's not a good explanation
		 * this moves the "plus number" up the screen a fourth of the total screen height 
		 * in the time that it takes for this "plus number" to completely fade (PRIMARY_FADE_TIME)
		 * based on frame rate (delta)
		 */
		y -= (GameWorld.GAMEHEIGHT / 4) * delta / PRIMARY_FADE_TIME;
		//remove this object once it's off the screen, or barely visible
		if (y <= 0 || white.a <= 0) {

			RenderObjQueue.removeUpdates(this);
		}
		//does the fading
		fader.act(delta);
	}

	public void render(SpriteBatch batcher, ShapeRenderer renderer) {

		batcher.begin();
		AssetLoader.plus_number_shadow_font.setColor(black);
		AssetLoader.plus_number_shadow_font.draw(batcher, plusString, x+2, y+2);
		AssetLoader.plus_number_font.setColor(white);
		AssetLoader.plus_number_font.draw(batcher, plusString, x, y);
		batcher.end();
	}
}
