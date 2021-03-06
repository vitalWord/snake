package com.codenjoy.dojo.snake.model;

import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.Joystick;
import com.codenjoy.dojo.snake.model.Snake;
import com.codenjoy.dojo.snake.services.SnakeEvents;

public class SnakeEvented extends Snake implements Joystick {

    private EventListener listener;

    public SnakeEvented(EventListener listener, int x, int y) {
        super(x, y);
        this.listener = listener;
	}

	public void killMe() {
		listener.event(SnakeEvents.KILL.name());
        super.killMe();
	}

	public void grow() {
        listener.event(SnakeEvents.EAT_APPLE.name());
        super.grow();
	}

	public void eatStone() {
        listener.event(SnakeEvents.EAT_STONE.name());
        super.eatStone();
	}	

}
