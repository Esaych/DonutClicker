package org.qohs.clicker;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.GameScreen;
import org.qohs.clicker.screens.MenuScreen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Do not touch this code - it's copy pasted from somewhere... it creates a game
 * @author Sam Holmberg
 *
 */

public class Clicker extends Game implements ApplicationListener {
	
	private GameScreen gameScreen;
	private MenuScreen menuScreen;
	
	private Screen currentScreen;
	
    public void create() {
    	AssetLoader.load();
    	gameScreen = new GameScreen();
    	menuScreen = new MenuScreen();
    	setDonutScreen(ScreenType.GAME);
    }
    
    public void setDonutScreen(ScreenType screen) {
    	switch (screen) {
    	case GAME: 
    		currentScreen = gameScreen;
    	case MENU:
    		currentScreen = menuScreen;
    	}
        setScreen(currentScreen);
    }
    
    public Screen getScreen() {
    	return gameScreen;
    }
}

enum ScreenType {
	GAME,
	MENU;
}
