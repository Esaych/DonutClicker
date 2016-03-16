package org.qohs.clicker.screens.util;
/**
 * 
 * @author Samuel
 *
 */
public interface InputObj {
	
	/**
	 * Check visibility before action
	 * @return
	 */
	public boolean isVisible();
	
	public boolean collision(int x, int y);
	
	public void animateClickDown();
	
	public void animateClickUp();
	
	/**
	 * Used to actually run method the button is attached to
	 */
	public void onClick();
	
}
