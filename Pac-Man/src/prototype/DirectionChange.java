package prototype;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class DirectionChange implements EventHandler<KeyEvent> {

	private int direction;

	public DirectionChange() {
		direction = 0;
	}

	public void handle(KeyEvent event) {
		switch(event.getCode()) {
		case UP:
			direction = 1; break;
		case DOWN:
			direction = 2; break;
		case LEFT:
			direction = 3; break;
		case RIGHT:
			direction = 4; break;
		default:
			break;
		}
	}

	public int getDirection() {
		return direction;
	}

}
