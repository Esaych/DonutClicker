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
//I'm sorry, we touched it. @vigilante Derek Zhang

public class Clicker extends Game implements ApplicationListener {
    
    private static GameScreen gameScreen;
    private static MenuScreen menuScreen;
    
    private static Screen currentScreen;
    
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
	            break;
	        case MENU:
	            currentScreen = menuScreen;
	            break;
            default: 
            	currentScreen = gameScreen;
            	break;
        }
        setScreen(currentScreen);
    }
    
    @Override
    public Screen getScreen() {
        return currentScreen;
    }

    public enum ScreenType {
        GAME,
        MENU;
    }
}
