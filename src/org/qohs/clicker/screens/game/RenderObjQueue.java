package org.qohs.clicker.screens.game;

import java.util.LinkedList;
import java.util.Queue;

import org.qohs.clicker.screens.util.UpdateRenderObj;

public class RenderObjQueue {
	
	public static Queue<UpdateRenderObj> addUpdateObjs = new LinkedList<UpdateRenderObj>();
	public static Queue<UpdateRenderObj> addRenderObjs = new LinkedList<UpdateRenderObj>();
	public static Queue<UpdateRenderObj> removeObjs = new LinkedList<UpdateRenderObj>();

    public static void registerUpdates(UpdateRenderObj objClass, boolean update, boolean render) {
    	if (update)
    		addUpdateObjs.add(objClass);
    	if (render)
    		addRenderObjs.add(objClass);
    }
    
    public static void removeUpdates(UpdateRenderObj objClass) {

    	removeObjs.add(objClass);
    }
}