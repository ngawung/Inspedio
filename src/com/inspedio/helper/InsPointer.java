package com.inspedio.helper;

import java.util.Vector;

import com.inspedio.helper.primitive.InsPointerEvent;

/**
 * This is the helper class for pointer input<br>
 * Useful for global detection of pointerEvent (Pressed, Released, etc)
 * 
 * @author Hyude
 * @version 1.0
 */
public class InsPointer {
	
	public InsPointerEvent[] pressed;
	public InsPointerEvent[] released;
	public InsPointerEvent[] dragged;
	
	protected Vector pressedEvents;
	protected Vector releasedEvents;
	protected Vector draggedEvents;
	
	
	public InsPointer(){
		super();
		this.pressedEvents = new Vector();
		this.releasedEvents = new Vector();
		this.draggedEvents = new Vector();
		
	}
	
	public void resetEvent(){
		this.pressedEvents.removeAllElements();
		this.releasedEvents.removeAllElements();
		this.draggedEvents.removeAllElements();
		
	}
	
	public void addEvent(InsPointerEvent e){
		if(e.type == InsPointerEvent.PRESSED){
			this.pressedEvents.addElement(e);
		}
		else if(e.type == InsPointerEvent.RELEASED){
			this.releasedEvents.addElement(e);
		}
		else if(e.type == InsPointerEvent.DRAGGED){
			this.draggedEvents.addElement(e);
		}
	}
	
	public void updatePointerState(){
		pressed = new InsPointerEvent[this.pressedEvents.size()];
		for(int i = 0; i < pressed.length; i++){
			pressed[i] = (InsPointerEvent) this.pressedEvents.elementAt(i);
		}
		
		
		released = new InsPointerEvent[this.releasedEvents.size()];
		for(int i = 0; i < released.length; i++){
			released[i] = (InsPointerEvent) this.releasedEvents.elementAt(i);
		}
		
		dragged = new InsPointerEvent[this.draggedEvents.size()];
		for(int i = 0; i < dragged.length; i++){
			dragged[i] = (InsPointerEvent) this.draggedEvents.elementAt(i);
		}
		resetEvent();
	}
	
}
