package org.qohs.launcher;

import org.qohs.clicker.Clicker;
import org.qohs.clicker.io.InputHandler;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

//GDC Notes
/*
 * 
IMPORTANT ECLIPSE KEYBOARD SHORTCUTS

Import				CTRL+O
Proper Indents		CTRL+A then CTRL+I


Document everything you can - easier on people who join the team
Type /** and ENTER in every class or object and document!


 */

/**
 * Runs the app from Eclipse
 * @author Sam Holmberg
 *
 */

public class DesktopLauncher {
		public static void main (String[] arg) {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.title = "Donut Clicker";
			config.width = 480;
			config.height = 800;
			Clicker clicker = new Clicker();
			LwjglApplication app = new LwjglApplication(clicker, config);
			app.getInput().setInputProcessor(new InputHandler(clicker.getGameScreen()));
		}
}
