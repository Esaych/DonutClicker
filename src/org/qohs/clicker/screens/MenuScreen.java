package org.qohs.clicker.screens;

import org.qohs.clicker.screens.menu.Menu;

import com.badlogic.gdx.Screen;

public class MenuScreen implements Screen {

	private Menu menu;
	
	public MenuScreen () {
		menu = new Menu();
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void hide() {
		// TODO Auto-generated method stub
		
	}

	public void pause() {
		// TODO Auto-generated method stub
		
	}

    // TODO Change the place holder which shows that shop button works
	public void render(float delta) {
		menu.update(delta);
		menu.render(delta);
	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}

	public void show() {
		// TODO Auto-generated method stub
		
	}

}
