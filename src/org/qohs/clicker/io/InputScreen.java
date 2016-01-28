package org.qohs.clicker.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;

/** 
 * Base class for screens that want to handle their inputs
 * @author Derek Zhang
 *
 */

public abstract class InputScreen extends InputAdapter implements Screen {

	public boolean keyDown(int keycode) {
		if (keycode == Keys.BACK || keycode == Keys.MENU || keycode == Keys.ESCAPE) {
			Gdx.app.exit();
		} else if (keycode == Keys.UP) {
			
		} else if (keycode == Keys.DOWN) {
			
		} else if (keycode == Keys.LEFT) {
			
		} else if (keycode == Keys.RIGHT) {
			
		}
		return true;
	}

	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP) {

		} else if (keycode == Keys.DOWN) {
			
		} else if (keycode == Keys.LEFT) {
			
		} else if (keycode == Keys.RIGHT) {
			
		}
		return false;
	}
	
	public void render(float delta) {
		Gdx.app.log("InputScreen", "render() called");
	}
	
	public void resize(int width, int height) {
		Gdx.app.log("InputScreen", "DON'T RESIZE THE WINDOW");
	}

	public void show() {
		Gdx.app.log("InputScreen", "show() called");
	}

	public void hide() {
		Gdx.app.log("InputScreen", "hide() called");     
	}

	public void pause() {
		Gdx.app.log("InputScreen", "pause() called");        
	}

	public void resume() {
		Gdx.app.log("InputScreen", "resume() called");       
	}

	public void dispose() {
		Gdx.app.log("InputScreen", "dispose() called - game over");       
	}
}
