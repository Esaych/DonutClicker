package org.qohs.clicker.io;

import org.qohs.clicker.screens.GameScreen;
import org.qohs.clicker.screens.MenuScreen;
import org.qohs.clicker.screens.game.gameobjects.Score;
import org.qohs.clicker.screens.game.gameobjects.donutaspects.DonutTopping;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

/**
 * "Generic"(really NOT generic... teehee) code to process inputs on the screen
 * @author QO Game Development Club
 *
 */

public class InputHandler implements InputProcessor {
	
	private static GameScreen gameScreen;
	private static MenuScreen menuScreen;
	private static boolean isGameScreenShowing = true;
	
	public InputHandler(Screen screen) {
		if (screen instanceof GameScreen) {
			gameScreen = (GameScreen) screen;
			isGameScreenShowing = true;
		}
		if (screen instanceof MenuScreen) {
			menuScreen = (MenuScreen) screen;
			isGameScreenShowing = false;
		}
	}
	
	public static void setGameScreen(GameScreen gs) {
		gameScreen = gs;
		isGameScreenShowing = true;
	}
	
	public static void setMenuScreen(MenuScreen ms) {
		menuScreen = ms;
		isGameScreenShowing = false;
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
	
	// TODO Make these dependent on which screen InputHandler is latched on to
	/*
	 * Called when click/tap screen
	 * @see com.badlogic.gdx.InputProcessor#touchDown(int, int, int, int)
	 */
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (isGameScreenShowing) {
			if (gameScreen.getWorld().shopButton.collision(x, y))
				gameScreen.getWorld().shopButton.animateClickDown();
			else if (gameScreen.getWorld().settingsButton.collision(x, y))
				gameScreen.getWorld().settingsButton.animateClickDown();
			else //not a button click - must be donut click
				gameScreen.getWorld().donut.animateClickDown();
		}
		else {

			//do something
		}
		return true;
	}

	public boolean touchUp(int x, int y, int pointer, int button) {
		if (isGameScreenShowing) {
			if (gameScreen.getWorld().shopButton.collision(x, y))
				gameScreen.getWorld().shopButton.animateClickUp();
			else if (gameScreen.getWorld().settingsButton.collision(x, y))
				gameScreen.getWorld().settingsButton.animateClickUp();
			else
				Score.addUserClicks(1);
				//Score.addScore(1, DonutTopping.getMultiplier(gameScreen.getWorld().donut.getTopping()));
			gameScreen.getWorld().donut.animateClickUp();
		}
		else {

			//do something
		}
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
