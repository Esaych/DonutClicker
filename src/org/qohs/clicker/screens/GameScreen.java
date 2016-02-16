package org.qohs.clicker.screens;

import org.qohs.clicker.screens.game.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Screen that attaches to app when run. 
 * Just boring stuff that starts the clicker world
 * @author Sam Holmberg
 *
 */

public class GameScreen implements Screen {

	private GameWorld world;

	public GameScreen() {
		Gdx.app.log("GameScreen", "Attached");
		world = new GameWorld();
	}
	
	public GameWorld getWorld() {
		return world;
	}

	public void render(float delta) {
		world.update(delta);
		world.render(delta);
	}

	public void resize(int width, int height) {
		Gdx.app.log("GameScreen", "DON'T RESIZE THE WINDOW");
	}

	public void show() {
		Gdx.app.log("GameScreen", "show() called");
	}

	public void hide() {
		Gdx.app.log("GameScreen", "hide() called");     
	}

	public void pause() {
		Gdx.app.log("GameScreen", "pause() called");        
	}

	public void resume() {
		Gdx.app.log("GameScreen", "resume() called");       
	}

	public void dispose() {
		Gdx.app.log("GameScreen", "dispose() called - game over");       
	}

}
