package org.qohs.clicker.screens.game.gameobjects;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
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

	private final String plusString;
	private float timePassed;
	private int y;
	private Color white;
	private Color black;
	private Actor fader;
	
	public PlusNumber(int addition) {
		
		plusString = "+" + addition;
		timePassed = 0;
		y = GameWorld.GAMEHEIGHT/2;
		white = new Color(AssetLoader.score_font.getColor());
		black = new Color(AssetLoader.score_shadow_font.getColor());
		fader = new Actor();
		AlphaAction fadeAction = Actions.fadeOut(2);
		fadeAction.setColor(white);
		fader.addAction(fadeAction);
		fadeAction = Actions.fadeOut(2f/3f);
		fadeAction.setColor(black);
		fader.addAction(fadeAction);
		GameWorld.registerUpdates(this, true, true);
	}

	public void update(float delta) {

		timePassed += delta;
		
		if (timePassed >= .018) {

			y -= 5;
			if (y <= 0 || white.a <= 0) {

				GameWorld.removeUpdates(this);
			}
			timePassed = 0;
		}
		
		fader.act(delta);
	}

	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
			
		batcher.begin();
		AssetLoader.score_shadow_font.setColor(black);
		AssetLoader.score_shadow_font.draw(batcher, plusString, (GameWorld.GAMEWIDTH )/2+2, y+2);
		AssetLoader.score_font.setColor(white);
		AssetLoader.score_font.draw(batcher, plusString, (GameWorld.GAMEWIDTH )/2, y);
		batcher.end();
		AssetLoader.score_shadow_font.setColor(AssetLoader.score_shadow_font.getColor());
		AssetLoader.score_font.setColor(AssetLoader.score_font.getColor());
	}
}
