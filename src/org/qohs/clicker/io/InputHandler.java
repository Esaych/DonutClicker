package org.qohs.clicker.io;

import org.qohs.clicker.GameScreen;
import org.qohs.clicker.world.Score;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutTopping;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Generic code to process inputs on the screen
 * @author QO Game Development Club
 *
 */

public class InputHandler implements InputProcessor {
	
	public static GameScreen screen;
	
	public InputHandler(GameScreen gamescreen) {
		screen = gamescreen;
	}
	
	public static void setGameScreen(GameScreen gs) {
		screen = gs;
	}

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

	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * Called when click/tap screen
	 * @see com.badlogic.gdx.InputProcessor#touchDown(int, int, int, int)
	 */
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (screen.getWorld().shopButton.collision(x, y))
			screen.getWorld().shopButton.animateClickDown();
		else if (screen.getWorld().settingsButton.collision(x, y))
			screen.getWorld().settingsButton.animateClickDown();
		else //not a button click - must be donut click
			screen.getWorld().donut.animateClickDown();
		return true;
	}

	public boolean touchUp(int x, int y, int pointer, int button) {
		if (screen.getWorld().shopButton.collision(x, y))
			screen.getWorld().shopButton.animateClickUp();
		else if (screen.getWorld().settingsButton.collision(x, y))
			screen.getWorld().settingsButton.animateClickUp();
		else
			Score.addScore(1, DonutTopping.getMultiplier(screen.getWorld().donut.getTopping()));
			screen.getWorld().donut.animateClickUp();
		return true;
	}

	public boolean touchDragged(int x, int y, int pointer) {
		return false;
	}

	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
